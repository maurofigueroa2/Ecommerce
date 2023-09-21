package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Pago;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class PagoDAO implements DAO<Pago>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public PagoDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Pago pago) {
            entityManager.getTransaction().begin();
            entityManager.persist(pago);
            entityManager.getTransaction().commit();
        }

        public Pago getOneById(Long id) {
            return entityManager.find(Pago.class, id);
        }

        public List<Pago> getAll() {
            return entityManager.createQuery("SELECT e FROM Pago e", Pago.class).getResultList();
        }

        public void update(Pago pago) {
            entityManager.getTransaction().begin();
            entityManager.merge(pago);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
            Pago Pago = entityManager.find(Pago.class, id);
            if (Pago != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Pago);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


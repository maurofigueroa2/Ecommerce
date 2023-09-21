package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Tienda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class TiendaDAO implements DAO<Tienda>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public TiendaDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Tienda tienda) {
            entityManager.getTransaction().begin();
            entityManager.persist(tienda);
            entityManager.getTransaction().commit();
        }

        public Tienda getOneById(Long id) {
            return entityManager.find(Tienda.class, id);
        }

        public List<Tienda> getAll() {
            return entityManager.createQuery("SELECT e FROM Tienda e", Tienda.class).getResultList();
        }

        public void update(Tienda tienda) {
            entityManager.getTransaction().begin();
            entityManager.merge(tienda);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
            Tienda Tienda = entityManager.find(Tienda.class, id);
            if (Tienda != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Tienda);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


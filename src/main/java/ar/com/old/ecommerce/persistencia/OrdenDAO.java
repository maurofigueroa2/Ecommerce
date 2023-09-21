package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Orden;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OrdenDAO implements DAO<Orden>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public OrdenDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Orden orden) {
            entityManager.getTransaction().begin();
            entityManager.persist(orden);
            entityManager.getTransaction().commit();
        }

        public Orden getOneById(Long id) {
            return entityManager.find(Orden.class, id);
        }

        public List<Orden> getAll() {
            return entityManager.createQuery("SELECT e FROM Orden e", Orden.class).getResultList();
        }

        public void update(Orden orden) {
            entityManager.getTransaction().begin();
            entityManager.merge(orden);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
            Orden Orden = entityManager.find(Orden.class, id);
            if (Orden != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Orden);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


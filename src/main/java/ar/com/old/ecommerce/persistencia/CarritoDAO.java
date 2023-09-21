package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Carrito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarritoDAO implements DAO<Carrito>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public CarritoDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Carrito carrito) {
            entityManager.getTransaction().begin();
            entityManager.persist(carrito);
            entityManager.getTransaction().commit();
        }

        public Carrito getOneById(Long id) {
            return entityManager.find(Carrito.class, id);
        }

        public List<Carrito> getAll() {
            return entityManager.createQuery("SELECT e FROM Carrito e", Carrito.class).getResultList();
        }

        public void update(Carrito carrito) {
            entityManager.getTransaction().begin();
            entityManager.merge(carrito);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
            Carrito Carrito = entityManager.find(Carrito.class, id);
            if (Carrito != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Carrito);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


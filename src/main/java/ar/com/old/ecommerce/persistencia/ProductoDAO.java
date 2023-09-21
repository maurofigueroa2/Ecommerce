package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class ProductoDAO implements DAO<Producto>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public ProductoDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Producto producto) {
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
        }

        public Producto getOneById(Long id) {
            return entityManager.find(Producto.class, id);
        }

        public List<Producto> getAll() {
            return entityManager.createQuery("SELECT e FROM Producto e", Producto.class).getResultList();
        }

        public void update(Producto producto) {
            entityManager.getTransaction().begin();
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
            Producto Producto = entityManager.find(Producto.class, id);
            if (Producto != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Producto);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


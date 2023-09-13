package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class ProductoManager {
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public ProductoManager() {
            entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void createProducto(Producto producto) {
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
        }

        public Producto getProducto(Long id) {
            return entityManager.find(Producto.class, id);
        }

        public List<Producto> getAllProductos() {
            return entityManager.createQuery("SELECT e FROM Producto e", Producto.class).getResultList();
        }

        public void updateProducto(Producto producto) {
            entityManager.getTransaction().begin();
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
        }

        public void deleteProducto(Long id) {
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


package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Carrito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarritoManager {
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public CarritoManager() {
            entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void createCarrito(Carrito carrito) {
            entityManager.getTransaction().begin();
            entityManager.persist(carrito);
            entityManager.getTransaction().commit();
        }

        public Carrito getCarrito(Long id) {
            return entityManager.find(Carrito.class, id);
        }

        public List<Carrito> getAllCarritos() {
            return entityManager.createQuery("SELECT e FROM Carrito e", Carrito.class).getResultList();
        }

        public void updateCarrito(Carrito carrito) {
            entityManager.getTransaction().begin();
            entityManager.merge(carrito);
            entityManager.getTransaction().commit();
        }

        public void deleteCarrito(Long id) {
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


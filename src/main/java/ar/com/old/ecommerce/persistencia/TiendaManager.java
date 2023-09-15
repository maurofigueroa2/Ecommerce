package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Tienda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class TiendaManager {
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public TiendaManager() {
            entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void createTienda(Tienda tienda) {
            entityManager.getTransaction().begin();
            entityManager.persist(tienda);
            entityManager.getTransaction().commit();
        }

        public Tienda getTienda(Long id) {
            return entityManager.find(Tienda.class, id);
        }

        public List<Tienda> getAllTiendas() {
            return entityManager.createQuery("SELECT e FROM Tienda e", Tienda.class).getResultList();
        }

        public void updateTienda(Tienda tienda) {
            entityManager.getTransaction().begin();
            entityManager.merge(tienda);
            entityManager.getTransaction().commit();
        }

        public void deleteTienda(Long id) {
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


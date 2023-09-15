package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Publicacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class PublicacionManager {
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public PublicacionManager() {
            entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void createPublicacion(Publicacion publicacion) {
            entityManager.getTransaction().begin();
            entityManager.persist(publicacion);
            entityManager.getTransaction().commit();
        }

        public Publicacion getPublicacion(Long id) {
            return entityManager.find(Publicacion.class, id);
        }

        public List<Publicacion> getAllPublicacions() {
            return entityManager.createQuery("SELECT e FROM Publicacion e", Publicacion.class).getResultList();
        }

        public void updatePublicacion(Publicacion publicacion) {
            entityManager.getTransaction().begin();
            entityManager.merge(publicacion);
            entityManager.getTransaction().commit();
        }

        public void deletePublicacion(Long id) {
            Publicacion Publicacion = entityManager.find(Publicacion.class, id);
            if (Publicacion != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Publicacion);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


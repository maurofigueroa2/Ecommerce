package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Publicacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class PublicacionDAO implements DAO<Publicacion>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public PublicacionDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Publicacion publicacion) {
            entityManager.getTransaction().begin();
            entityManager.persist(publicacion);
            entityManager.getTransaction().commit();
        }

        public Publicacion getOneById(Long id) {
            return entityManager.find(Publicacion.class, id);
        }

        public List<Publicacion> getAll() {
            return entityManager.createQuery("SELECT e FROM Publicacion e", Publicacion.class).getResultList();
        }

        public void update(Publicacion publicacion) {
            entityManager.getTransaction().begin();
            entityManager.merge(publicacion);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
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


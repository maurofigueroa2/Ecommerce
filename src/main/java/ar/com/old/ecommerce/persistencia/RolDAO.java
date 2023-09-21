package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Rol;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class RolDAO implements DAO<Rol>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public RolDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Rol rol) {
            entityManager.getTransaction().begin();
            entityManager.persist(rol);
            entityManager.getTransaction().commit();
        }

        public Rol getOneById(Long id) {
            return entityManager.find(Rol.class, id);
        }

        public List<Rol> getAll() {
            return entityManager.createQuery("SELECT e FROM Rol e", Rol.class).getResultList();
        }

        public void update(Rol rol) {
            entityManager.getTransaction().begin();
            entityManager.merge(rol);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
            Rol Rol = entityManager.find(Rol.class, id);
            if (Rol != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Rol);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


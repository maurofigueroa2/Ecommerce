package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class UsuarioDAO implements DAO<Usuario>{
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public UsuarioDAO() {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql-persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void create(Usuario usuario) {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        }

        public Usuario getOneById(Long id) {
            return entityManager.find(Usuario.class, id);
        }

        public List<Usuario> getAll() {
            return entityManager.createQuery("SELECT e FROM Usuario e", Usuario.class).getResultList();
        }

        public void update(Usuario Usuario) {
            entityManager.getTransaction().begin();
            entityManager.merge(Usuario);
            entityManager.getTransaction().commit();
        }

        public void deleteById(Long id) {
            Usuario Usuario = entityManager.find(Usuario.class, id);
            if (Usuario != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(Usuario);
                entityManager.getTransaction().commit();
            }
        }

        public void close() {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


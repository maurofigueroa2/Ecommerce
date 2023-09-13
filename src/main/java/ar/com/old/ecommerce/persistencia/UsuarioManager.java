package ar.com.old.ecommerce.persistencia;
import ar.com.old.ecommerce.entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class UsuarioManager {
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;

        public UsuarioManager() {
            entityManagerFactory = Persistence.createEntityManagerFactory("myJPAUnit");
            entityManager = entityManagerFactory.createEntityManager();
        }

        public void createUsuario(Usuario usuario) {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        }

        public Usuario getUsuario(Long id) {
            return entityManager.find(Usuario.class, id);
        }

        public List<Usuario> getAllUsuarios() {
            return entityManager.createQuery("SELECT e FROM Usuario e", Usuario.class).getResultList();
        }

        public void updateUsuario(Usuario Usuario) {
            entityManager.getTransaction().begin();
            entityManager.merge(Usuario);
            entityManager.getTransaction().commit();
        }

        public void deleteUsuario(Long id) {
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


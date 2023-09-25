package entidades;

import ar.com.old.ecommerce.entidades.Publicacion;
import ar.com.old.ecommerce.entidades.Tienda;
import ar.com.old.ecommerce.entidades.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;


public class TiendaTest {
    Tienda tienda;
    Publicacion publicacion;
    Usuario usuario;

    @BeforeEach
    void init(){
        tienda = new Tienda();
        tienda.setId(1L);
        publicacion = new Publicacion();
        usuario = new Usuario();

    }

    @Test
    void agregaPublicaciones(){
        Assertions.assertTrue(tienda.agregarPublicacion(publicacion));
    }

    @Test
    void agrega2Publicaciones(){
        tienda.agregarPublicacion(publicacion);
        tienda.agregarPublicacion(publicacion);
        Assertions.assertEquals(2,tienda.getPublicaciones().size());
    }

    @Test
    void eliminaPublicacion(){
        Assertions.assertFalse(tienda.eliminarPublicacion(publicacion));
        tienda.agregarPublicacion(publicacion);
        Assertions.assertTrue(tienda.eliminarPublicacion(publicacion));
    }

    @Test
    void tieneUsuario(){
        Assertions.assertNull(tienda.getUsuario());
        tienda.setUsuario(usuario);
        Assertions.assertNotNull(tienda.getUsuario());
    }

    @Test
    void equalsAndHashCode(){
        Tienda tienda2 = new Tienda();
        tienda2.setId(1L);
        Assertions.assertEquals(tienda, tienda2);
        Assertions.assertEquals(tienda.hashCode(),tienda2.hashCode());
        Assertions.assertNotEquals(null,tienda);
    }
}

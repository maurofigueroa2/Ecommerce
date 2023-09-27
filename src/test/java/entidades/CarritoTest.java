package entidades;

import ar.com.old.ecommerce.entidades.Carrito;
import ar.com.old.ecommerce.entidades.Publicacion;
import ar.com.old.ecommerce.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarritoTest {

    Carrito carrito;
    Usuario usuario;
    Publicacion publicacion;
    Publicacion publicacion2;

    @BeforeEach
    void init(){
        carrito =  new Carrito();
        carrito.setId(1L);
        usuario = new Usuario();
        publicacion = new Publicacion();
        publicacion2 = new Publicacion();

        carrito.setUsuario(usuario);
    }

    @Test
    void puedeAgregarPublicaciones(){
        carrito.agregarPublicacion(publicacion);
        Assertions.assertNotNull(carrito.getPublicaciones());
        Assertions.assertEquals(publicacion,carrito.getPublicaciones().get(0));
    }

    @Test
    void puedeAgregar2Publicaciones(){
        Assertions.assertTrue(carrito.agregarPublicacion(publicacion));
        Assertions.assertTrue(carrito.agregarPublicacion(publicacion2));
        Assertions.assertEquals(2,carrito.getPublicaciones().size());
    }

    @Test
    void puedeElimnarPublicacion(){
        carrito.agregarPublicacion(publicacion);
        Assertions.assertNotNull(carrito.getPublicaciones());
        Assertions.assertTrue(carrito.eliminarPublicacion(publicacion));
    }

    @Test
    void getterAndSetters(){
        carrito = new Carrito();
        carrito.setId(2L);
        carrito.setUsuario(usuario);
        carrito.agregarPublicacion(publicacion);
        Assertions.assertEquals(2,carrito.getId());
        Assertions.assertEquals(usuario,carrito.getUsuario());
        Assertions.assertEquals(publicacion, carrito.getPublicaciones().get(0));
    }

    @Test
    void equalsAndHashCode(){
        Carrito carrito2 = new Carrito();
        carrito2.setId(1L);
        Assertions.assertEquals(carrito, carrito2);
        Assertions.assertEquals(carrito.hashCode(),carrito2.hashCode());
        Assertions.assertNotEquals(null, carrito);
    }
}

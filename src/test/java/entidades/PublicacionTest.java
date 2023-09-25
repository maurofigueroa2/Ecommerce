package entidades;

import ar.com.old.ecommerce.entidades.Producto;
import ar.com.old.ecommerce.entidades.Publicacion;
import ar.com.old.ecommerce.entidades.Rol;
import ar.com.old.ecommerce.entidades.Tienda;
import ar.com.old.ecommerce.entidades.enums.Estado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PublicacionTest {
    Publicacion publicacion;
    Producto producto;
    Tienda tienda;
    Estado estado;

    @BeforeEach
    void init(){
        publicacion = new Publicacion();
        publicacion.setId(1L);

        producto = new Producto();
        tienda = new Tienda();
        estado = Estado.PUBLICADO;
    }

    @Test
    void tieneTienda(){
        publicacion.setTienda(tienda);
        Assertions.assertNotNull(publicacion.getTienda());
    }

    @Test
    void agregaProducto(){
        Assertions.assertTrue(publicacion.agregarProductos(producto));
    }

    @Test
    void noAgregaProductoNulo() {
        Assertions.assertFalse(publicacion.agregarProductos(null));
    }

    @Test
    void eliminaProducto(){
        publicacion.agregarProductos(producto);
        Assertions.assertNotNull(publicacion.eliminarProducto(producto));
    }

    @Test
    void noEliminaProductoNulo(){
        Assertions.assertFalse(publicacion.eliminarProducto(null));
    }

    @Test
    void getterAndSetters(){
        publicacion = new Publicacion();
        publicacion.setId(1L);
        publicacion.setEstado(estado);
        publicacion.setTienda(tienda);
        publicacion.agregarProductos(producto);
        Assertions.assertNotNull(publicacion.getId());
        Assertions.assertNotNull(publicacion.getEstado());
        Assertions.assertNotNull(publicacion.getTienda());
        Assertions.assertNotNull(publicacion.getProductos());
        Assertions.assertNotNull(publicacion.getFechaPublicacion());
    }

    @Test
    void equalsAndHashCode(){
        Publicacion publicacion2 = new Publicacion();
        publicacion2.setId(1L);
        Assertions.assertEquals(publicacion,publicacion2);
        Assertions.assertEquals(publicacion.hashCode(),publicacion2.hashCode());
        Assertions.assertNotEquals(null,publicacion);
    }
}

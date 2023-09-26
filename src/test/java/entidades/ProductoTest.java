package entidades;

import ar.com.old.ecommerce.entidades.Producto;
import ar.com.old.ecommerce.entidades.Usuario;
import ar.com.old.ecommerce.entidades.enums.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {
    Producto producto;
    Categoria categoria;

    @BeforeEach
    void init(){
        producto = new Producto();
        producto.setId(1L);
        producto.setPrecio(100);
        producto.setCantidad(4);
        producto.setNombre("prueba");
        categoria = Categoria.AUTOMOTOR;
    }

    @Test
    void agregaCategoria(){
        Assertions.assertTrue(producto.agregarCategoria(categoria));
    }

    @Test
    void noPuedeAgregarCategoriaNula(){
        Assertions.assertFalse(producto.agregarCategoria(null));
    }

    @Test
    void eliminaCategoria() {
        producto.agregarCategoria(categoria);
        Assertions.assertTrue(producto.eliminarCategoria(categoria));
    }

    @Test
    void puedeCalcularElTotalSinIVA(){
        Assertions.assertEquals(400, producto.calcularPrecioSinIVA());
    }

    @Test
    void puedeCalcularElTotalsConIVA(){
        Assertions.assertEquals(484, producto.calcularPrecioConIVA());
    }

    @Test
    void getterAndSetters(){
        Producto producto2 = new Producto();
        producto2.setNombre("p2");
        producto2.setDescripcion("descripción p2");
        producto2.setId(1L);
        producto2.setCantidad(4);
        producto2.setPrecio(299);
        producto2.agregarCategoria(Categoria.INMUEBLES);
        Assertions.assertEquals("p2", producto2.getNombre());
        Assertions.assertEquals(1L,producto2.getId());
        Assertions.assertEquals("descripción p2", producto2.getDescripcion());
        Assertions.assertEquals(4,producto2.getCantidad());
        Assertions.assertEquals(299, producto2.getPrecio());
        Assertions.assertTrue(producto2.getCategorias().contains(Categoria.INMUEBLES));
    }

    @Test
    void equalsAndHashCode(){
        Producto producto2 = new Producto();
        producto2.setId(1L);
        Assertions.assertEquals(producto, producto2);
        Assertions.assertEquals(producto.hashCode(),producto2.hashCode());
        Assertions.assertNotEquals(null, producto);
    }
}

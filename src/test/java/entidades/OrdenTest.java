package entidades;

import ar.com.old.ecommerce.entidades.*;
import ar.com.old.ecommerce.entidades.enums.MetodoPago;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdenTest {

    Orden orden;
    Usuario usuario;
    Tienda tienda;
    Carrito carrito;
    Pago pago;

    @BeforeEach
    void init(){
        orden = new Orden();
        orden.setId(4L);

        tienda = new Tienda();

        usuario = new Usuario();
        usuario.setTienda(tienda);

        carrito = new Carrito();
        carrito.setUsuario(usuario);

        pago = new Pago();
        pago.setCarrito(carrito);
        pago.setMetodoPago(MetodoPago.CREDITO);
    }

    @Test
    void generarOrdenCompletaLosAtributos(){
        orden.generarOrden(pago);
        Assertions.assertEquals(usuario,orden.getComprador());
        Assertions.assertEquals(pago,orden.getPago());
    }

    @Test
    void getters(){
        orden.generarOrden(pago);
        Assertions.assertEquals(4,orden.getId());
        Assertions.assertEquals(usuario,orden.getComprador());
        Assertions.assertEquals(pago, orden.getPago());
        Assertions.assertNotNull(orden.getFecha());
    }

    @Test
    void equalsAndHashCode(){
        Orden orden2 = new Orden();
        orden2.setId(4L);
        Assertions.assertEquals(orden,orden2);
        Assertions.assertEquals(orden.hashCode(),orden2.hashCode());
        Assertions.assertNotEquals(null,orden);
    }
}

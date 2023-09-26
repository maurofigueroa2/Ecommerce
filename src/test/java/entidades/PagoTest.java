package entidades;

import ar.com.old.ecommerce.entidades.*;
import ar.com.old.ecommerce.entidades.enums.MetodoPago;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PagoTest {
    Pago pago;
    MetodoPago metodoPago;
    Carrito carrito;
    Usuario usuario;

    @BeforeEach
    void init() {
        pago = new Pago();
        pago.setId(1L);
        metodoPago = MetodoPago.CREDITO;

        usuario = new Usuario();
        usuario.setNombre("123");

        carrito = new Carrito();
        carrito.setUsuario(usuario);
        carrito.setId(1L);
        carrito.setPago(pago);
    }

    @Test
    void tieneCarrito(){
        pago.setCarrito(carrito);
        Assertions.assertEquals(carrito,pago.getCarrito());
    }

    @Test
    void generaOrdenAlRealizarPago(){
        pago.setCarrito(carrito);
        Assertions.assertNull(pago.getOrden());
        pago.pagar();
        Assertions.assertNotNull(pago.getOrden());
        Assertions.assertEquals("123",pago.getOrden().getUsuario().getNombre());
    }

    @Test
    void getterAndSetters(){
        Pago pago2 = new Pago();
        pago2.setId(2L);
        pago2.setOrden(new Orden());
        pago2.setMetodoPago(metodoPago);
        pago2.setCarrito(carrito);
        Assertions.assertEquals(2, pago2.getId());
        Assertions.assertNotNull(pago2.getOrden());
        Assertions.assertEquals(MetodoPago.CREDITO,pago2.getMetodoPago());
        Assertions.assertEquals(carrito,pago2.getCarrito());
    }

    @Test
    void equalsAndHashCode(){
        Pago pago2 = new Pago();
        pago2.setId(1L);
        Assertions.assertEquals(pago,pago2);
        Assertions.assertEquals(pago.hashCode(),pago2.hashCode());
        Assertions.assertNotEquals(null,pago);
    }
}

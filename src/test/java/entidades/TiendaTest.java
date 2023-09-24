package entidades;

import ar.com.old.ecommerce.entidades.Tienda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static entidades.Tester.*;
public class TiendaTest {
    Tienda tienda;

    @BeforeEach
    void init(){
        tienda = getTienda();
        tienda.setUsuario(getUsuario());
    }

    @Test
    void tienePublicaciones(){
        Assertions.assertTrue(tienda.getPublicaciones().isEmpty());
        tienda.agregarPublicacion(getPublicacion());
        Assertions.assertFalse(tienda.getPublicaciones().isEmpty());
    }

    @Test
    void tieneUsuario(){
        Assertions.assertTrue(tienda.getUsuario() != null);
    }
}

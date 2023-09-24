package entidades;

import ar.com.old.ecommerce.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static entidades.Tester.*;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    Usuario usuario;

    @BeforeEach
     void init(){
        usuario = getUsuario();
        usuario.setRol(getRol());
        usuario.setTienda(getTienda());
        usuario.setCarrito(getCarrito());
    }

    @Test
    void tieneRolAdministrador(){
        Assertions.assertEquals("Administrador", usuario.getRol().getNombre());
    }

    @Test
    void tieneTienda(){
        Assertions.assertEquals(3,usuario.getTienda().getId());
    }

    @Test
    void tieneCarrito(){
        Assertions.assertTrue(usuario.getCarrito() != null);
    }

}

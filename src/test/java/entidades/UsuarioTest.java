package entidades;

import ar.com.old.ecommerce.entidades.Carrito;
import ar.com.old.ecommerce.entidades.Rol;
import ar.com.old.ecommerce.entidades.Tienda;
import ar.com.old.ecommerce.entidades.Usuario;
import ar.com.old.ecommerce.entidades.enums.Permisos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    Usuario usuario;
    Rol rol;
    Tienda tienda;
    Carrito carrito;

    @BeforeEach
     void init(){
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("prueba");
        usuario.setApellido("1234");
        usuario.setNombreUsuario("user1");
        usuario.setContrasenia("123123123");
        usuario.setTelefono("1122334422");

        rol = new Rol();
        rol.setNombre("Admin");

        tienda = new Tienda();

        carrito = new Carrito();

    }

    @Test
    void puedeAgregarRol(){
        usuario.setRol(rol);
        Assertions.assertEquals("Admin", usuario.getRol().getNombre());
    }

    @Test
    void  puedeAgregarTienda(){
        Assertions.assertNull(usuario.getTienda());
        usuario.setTienda(tienda);
        Assertions.assertNotNull(usuario.getTienda());
    }

    @Test
    void puedeAgregarCarrito(){
        Assertions.assertNull(usuario.getCarrito());
        usuario.setCarrito(carrito);
        Assertions.assertNotNull(usuario.getCarrito());

    }

    @Test
    void tienePermisoDeAgregarProductos(){
        rol.agregarPermisos(Permisos.AGREGAR_PRODUCTOS);
        usuario.setRol(rol);
        Assertions.assertTrue(usuario.tienePermiso(Permisos.AGREGAR_PRODUCTOS));
    }

    @Test
    void noTienePermisoDeEliminarProductos(){
        usuario.setRol(rol);
        Assertions.assertFalse(usuario.tienePermiso(Permisos.ELIMINAR_PRODUCTOS));
    }

    @Test
    void equalsAndHashCode(){
        Usuario usuario2 = new Usuario();
        usuario2.setId(1L);
        Assertions.assertEquals(usuario, usuario2);
        Assertions.assertEquals(usuario.hashCode(),usuario2.hashCode());
        Assertions.assertNotEquals(null, usuario);
    }

    @Test
    void getterAndSetter  (){
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("prueba");
        usuario.setApellido("apellido");
        usuario.setNombreUsuario("user1");
        usuario.setContrasenia("1234");
        usuario.setTelefono("1234444123");
        usuario.setRol(rol);
        usuario.setTienda(tienda);
        usuario.setCarrito(carrito);
        Assertions.assertNotNull(usuario.getId());
        Assertions.assertNotNull(usuario.getNombre());
        Assertions.assertNotNull(usuario.getApellido());
        Assertions.assertNotNull(usuario.getNombreUsuario());
        Assertions.assertNotNull(usuario.getContrasenia());
        Assertions.assertNotNull(usuario.getTelefono());
        Assertions.assertNotNull(usuario.getRol());
        Assertions.assertNotNull(usuario.getCarrito());
        Assertions.assertNotNull(usuario.getTienda());

    }
}

package entidades;

import ar.com.old.ecommerce.entidades.Rol;
import ar.com.old.ecommerce.entidades.enums.Permisos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RolTest {
    Rol rol;


    @BeforeEach
    void init(){
        rol =   Tester.getRol();
        rol.agregarPermisos(Permisos.AGREGAR_PRODUCTOS,Permisos.MODIFICAR_PRODUCTOS);
    }

    @Test
    void tienePermisoDeAgregarProductos(){
        Assertions.assertTrue(rol.getPermisos().contains(Permisos.AGREGAR_PRODUCTOS));
    }

    @Test
    void noTienePermisoDeBorrarProductos(){
        Assertions.assertFalse(rol.tienePermiso(Permisos.ELIMINAR_PRODUCTOS));
    }

    @Test
    void agregaPermisoEliminarProductos(){
        Assertions.assertFalse(rol.tienePermiso(Permisos.ELIMINAR_PRODUCTOS));
        rol.agregarPermisos(Permisos.ELIMINAR_PRODUCTOS);
        Assertions.assertTrue(rol.tienePermiso(Permisos.ELIMINAR_PRODUCTOS
        ));
    }
}

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
        rol =   new Rol();
        rol.setId(1L);
        rol.setNombre("prueba");
    }

    @Test
    void agregaPermisos(){
        Assertions.assertTrue(rol.agregarPermisos(Permisos.AGREGAR_PRODUCTOS));
        Assertions.assertEquals(1,rol.getPermisos().size());
    }

    @Test
    void noAgregaPermisoNulo(){
        Assertions.assertFalse(rol.agregarPermisos(null));
    }

    @Test
    void eliminaPermisos(){
        rol.agregarPermisos(Permisos.AGREGAR_PRODUCTOS);
        Assertions.assertTrue(rol.eliminarPermiso(Permisos.AGREGAR_PRODUCTOS));
    }

    @Test
    void noEliminaPermisosInexistentes(){
        Assertions.assertFalse(rol.eliminarPermiso(Permisos.MODIFICAR_PRODUCTOS));
    }

    @Test
    void noEliminaPermisosNulos(){
        Assertions.assertFalse(rol.eliminarPermiso(null));
    }



    @Test
    void equalsAndHashCode(){
        Rol rol2 = new Rol();
        rol2.setId(1L);
        Assertions.assertEquals(rol,rol2);
        Assertions.assertEquals(rol.hashCode(),rol2.hashCode());
        Assertions.assertNotEquals(null,rol);
    }

    @Test
    void getterAndSetters(){
        rol = new Rol();
        rol.setId(2L);
        rol.setNombre("prueba");
        rol.agregarPermisos(Permisos.AGREGAR_PRODUCTOS);
        Assertions.assertNotNull(rol.getId());
        Assertions.assertNotNull(rol.getNombre());
        Assertions.assertNotNull(rol.getPermisos());
    }

}

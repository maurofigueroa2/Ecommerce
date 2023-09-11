package ar.com.old.ecommerce.entidades;

import java.util.Set;

public interface Rol {
    Set<Permisos> obtenerPermisos();
}

package entidades;

import ar.com.old.ecommerce.entidades.*;
import ar.com.old.ecommerce.entidades.enums.Categoria;
import ar.com.old.ecommerce.entidades.enums.Estado;
import ar.com.old.ecommerce.entidades.enums.MetodoPago;
import ar.com.old.ecommerce.entidades.enums.Permisos;

import java.time.LocalDate;

public class Tester {



    static Producto getProducto(){
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Remera Blanca");
        producto.setDescripcion("remera de algodón");
        producto.setCantidad(11);
        producto.agregarCategoria(Categoria.AUTOMOTOR);
        return producto;
    }
    static Publicacion getPublicacion(){
        Publicacion publicacion = new Publicacion();
        publicacion.setId(1L);
        publicacion.setEstado(Estado.PUBLICADO);
        publicacion.setFechaPublicacion(LocalDate.now());
        return publicacion;
    }

    static Rol getRol(){
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("Administrador");
        return rol;
    }

    static Pago getPago(){
        Pago pago = new Pago();
        pago.setId(1L);
        pago.setMetodoPago(MetodoPago.CREDITO);
        return pago;
    }

    static Carrito getCarrito(){
        Carrito carrito = new Carrito();
        carrito.setId(1L);
        return carrito;
    }

    static Tienda getTienda(){
        Tienda tienda = new Tienda();
        tienda.setId(3L);
        return tienda;
    }

    static Usuario getUsuario(){
        Usuario usuario =  new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Mauro");
        usuario.setApellido("Figueroa");
        usuario.setNombreUsuario("Prueba");
        usuario.setContrasenia("1234");
        usuario.setTelefono("1122334455");
        return usuario;
    }

    static Orden getOrden(){
        Orden orden = new Orden();
        orden.setId(1L);
        orden.setFecha(LocalDate.now());
        return orden;
    }
}

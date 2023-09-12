package ar.com.old.ecommerce.entidades;

import java.util.List;

public class Carrito {
    private List<Publicacion> publicaciones;

    public Carrito() {

    }

    public void agregarProducto(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
}

package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.List;
@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Publicacion> publicaciones;

    public Carrito() {

    }

    public void agregarPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }
    public void eliminarPublicacion(Publicacion publicacion){
        this.publicaciones.remove(publicacion);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

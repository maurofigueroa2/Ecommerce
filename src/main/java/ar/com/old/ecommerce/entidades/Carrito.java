package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario;

    @ManyToMany
    private List<Publicacion> publicaciones;

    public Carrito() {
        this.publicaciones = new ArrayList<>();
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

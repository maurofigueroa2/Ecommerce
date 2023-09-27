package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario comprador;

    @ManyToMany
    @JoinTable(name = "rel_car_publ",
            joinColumns = {
            @JoinColumn(name = "fk_carrito")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "fk_publicacion")
    })
    private List<Publicacion> publicaciones;

    public Carrito() {
        this.publicaciones = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return comprador;
    }

    public void setUsuario(Usuario usuario) {
        this.comprador = usuario;
    }


    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public boolean agregarPublicacion(Publicacion publicacion){
        return this.publicaciones.add(publicacion);
    }
    public boolean eliminarPublicacion(Publicacion publicacion){
        return this.publicaciones.remove(publicacion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return Objects.equals(getId(), carrito.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

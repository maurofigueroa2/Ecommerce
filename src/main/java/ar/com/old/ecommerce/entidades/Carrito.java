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
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "rel_car_publ",
            joinColumns = {
            @JoinColumn(name = "fk_carrito")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "fk_publicacion")
    })
    private List<Publicacion> publicaciones;

    @OneToOne(mappedBy = "carrito")
    private Pago pago;

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
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void agregarPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }
    public void eliminarPublicacion(Publicacion publicacion){
        this.publicaciones.remove(publicacion);
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

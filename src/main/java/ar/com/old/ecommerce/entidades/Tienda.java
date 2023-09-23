package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "tienda")
    private List<Publicacion> publicaciones;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id",nullable = false,updatable = false)
    private Usuario usuario;

    public Tienda() {
        publicaciones = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion publicacion){
        publicacion.setTienda(this);
        this.publicaciones.add(publicacion);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tienda tienda = (Tienda) o;
        return Objects.equals(getId(), tienda.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

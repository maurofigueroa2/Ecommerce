package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    private List<Producto> productos;

    @Enumerated
    private Estado estado;

    public Publicacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

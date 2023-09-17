package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @Column(name = "productos")
    private List<Producto> productos;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
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

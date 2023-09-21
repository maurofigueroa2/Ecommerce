package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable(name = "rel_publi_prod",
            joinColumns = {@JoinColumn(name = "fk_publicacion")},
            inverseJoinColumns = {@JoinColumn(name = "fk_productos")}
    )
    private List<Producto> productos;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;


    @ManyToOne
    @JoinColumn(name = "fk_tienda", referencedColumnName = "id")
    private Tienda tienda;

    public Publicacion() {
        this.productos = new ArrayList<>();
    }

    public void agregarProductos(Producto producto){
        productos.add(producto);
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

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

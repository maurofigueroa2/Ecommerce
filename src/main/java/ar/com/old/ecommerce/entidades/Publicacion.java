package ar.com.old.ecommerce.entidades;

import ar.com.old.ecommerce.entidades.enums.Estado;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

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

    @Column(name = "fecha_publicacion",nullable = false,updatable = false)
    private LocalDate fechaPublicacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "fk_tienda", referencedColumnName = "id", nullable = false)
    private Tienda tienda;

    public Publicacion() {
        this.productos = new ArrayList<>();
        this.fechaPublicacion = LocalDate.now();
        this.estado = Estado.PUBLICADO;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProductos(Producto ... producto){
        Collections.addAll(productos ,producto);
    }

    public double generarPrecioTotal(){
       return this.productos.stream().map(producto -> producto.getPrecio()).reduce((a,b) -> a + b).get();

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

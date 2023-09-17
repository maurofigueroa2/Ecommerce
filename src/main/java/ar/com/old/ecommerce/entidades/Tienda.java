package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany
    private List<Publicacion> publicaciones;

    @OneToOne(mappedBy = "tienda")
    private Usuario usuario;

    public Tienda() {
    }

    public void agregarPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

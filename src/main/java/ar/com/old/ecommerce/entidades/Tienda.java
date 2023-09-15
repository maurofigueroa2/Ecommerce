package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Publicacion> publicaciones;

    public Tienda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @ElementCollection
    private Set<Permisos> permisos;
}

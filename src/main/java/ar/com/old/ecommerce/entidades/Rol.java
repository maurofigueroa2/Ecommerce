package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private Set<Permisos> permisos;
    @Enumerated
    private Roles tipoRol;
}

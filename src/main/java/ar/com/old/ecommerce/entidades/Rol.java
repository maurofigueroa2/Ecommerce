package ar.com.old.ecommerce.entidades;

import ar.com.old.ecommerce.entidades.enums.Permisos;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @ElementCollection(targetClass = Permisos.class)
    @JoinTable(name = "rel_rol_permisos", joinColumns = @JoinColumn(name = "fk_rol"))
    @Enumerated(EnumType.STRING)
    @Column(name = "permiso", nullable = false, length = 30)
    private Set<Permisos> permisos;;

    public Rol() {
        this.permisos = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean tienePermiso(Permisos permiso){
        return permisos.stream().anyMatch(permisoActual -> permisos.contains(permiso));
    }

    void agregarPermisos(Permisos ... permisos){
        Collections.addAll(this.permisos, permisos );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(getId(), rol.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

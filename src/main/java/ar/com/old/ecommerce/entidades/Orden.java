package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "fk_pago",referencedColumnName = "id",nullable = false)
    private Pago pago;

    @OneToOne
    @JoinColumn(name = "fk_comprador",referencedColumnName = "id",nullable = false)
    private Usuario comprador;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Orden (){
    }

    public void generarOrden(Pago pago) {
        this.pago = pago;
        pago.setOrden(this);
        this.fecha = LocalDate.now();
        this.comprador = pago.getCarrito().getUsuario();
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Usuario getComprador() {
        return comprador;
    }


    public Pago getPago() {
        return pago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orden orden = (Orden) o;
        return Objects.equals(getId(), orden.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

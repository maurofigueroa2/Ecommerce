package ar.com.old.ecommerce.entidades;

import ar.com.old.ecommerce.entidades.enums.MetodoPago;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago",nullable = false)
    private MetodoPago metodoPago;
    @OneToOne
    @JoinColumn(name = "fk_carrito", referencedColumnName = "id")
    private Carrito carrito;

    @OneToOne(mappedBy = "pago")
    private Orden orden;

    public void pagar(){
        //TODO enviar pago
        Orden orden = new Orden();
        this.orden = orden;
        orden.generarOrden(this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pago pago = (Pago) o;
        return Objects.equals(getId(), pago.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

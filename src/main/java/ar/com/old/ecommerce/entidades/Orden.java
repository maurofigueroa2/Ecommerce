package ar.com.old.ecommerce.entidades;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "fk_pago",referencedColumnName = "id")
    private Pago pago;

    @OneToOne
    @JoinColumn(name = "fk_tienda",referencedColumnName = "id")
    private Tienda tienda;

    @OneToOne
    @JoinColumn(name = "fk_usuario",referencedColumnName = "id")
    private Usuario usuario;

    private LocalDate fecha;

    public Orden() {
        this.fecha = LocalDate.now();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

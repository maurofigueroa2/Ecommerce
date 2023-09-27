package ar.com.old.ecommerce.entidades;

import ar.com.old.ecommerce.entidades.enums.Categoria;
import ar.com.old.ecommerce.utilidades.CalculadorDePrecios;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "cantidad" , nullable = false)
    private Integer cantidad;

    @ElementCollection(targetClass = Categoria.class)
    @JoinTable(name = "rel_categorias_productos",joinColumns = @JoinColumn(name = "fk_producto"))
    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Set<Categoria> categorias;

    public Producto() {
        categorias = new HashSet<>();
    }


    public boolean agregarCategoria(Categoria categoria){
        if (categoria != null) {
            return this.categorias.add(categoria);
        }return false;
    }
    public boolean eliminarCategoria(Categoria categoria){
        return this.categorias.remove(categoria);
    }

    public double calcularPrecioSinIVA(){
        return CalculadorDePrecios.calcularPrecioSinIVA(this.precio,this.cantidad);
    }

    public double calcularPrecioConIVA(){
        return CalculadorDePrecios.calcularPrecioConIVA(this.precio,this.cantidad);
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(getId(), producto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

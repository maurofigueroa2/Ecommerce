import ar.com.old.ecommerce.entidades.Categoria;
import ar.com.old.ecommerce.entidades.Producto;
import ar.com.old.ecommerce.persistencia.ProductoManager;

public class testMain {
    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.agregarCategoria(Categoria.AUTOMOTOR);
        producto.setDescripcion("Puerta de ferrari");
        producto.setNombre("Puerta de ferrari");
        producto.setPrecio(5000);

        ProductoManager pm = new ProductoManager();
        pm.createProducto(producto);
        pm.close();


    }

}

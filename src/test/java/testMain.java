import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testMain {
    public static void main(String[] args) {
//        Producto producto = new Producto();
//        producto.agregarCategoria(Categoria.AUTOMOTOR);
//        producto.setDescripcion("Puerta de ferrari");
//        producto.setNombre("Puerta de ferrari");
//        producto.setPrecio(5000);
//
//        ProductoManager pm = new ProductoManager();
//        pm.createProducto(producto);
//        pm.close();
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

    }

}

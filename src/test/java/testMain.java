import ar.com.old.ecommerce.entidades.*;

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

        Producto p1 = new Producto();
        p1.setPrecio(100);

        Producto p2 = new Producto();
        p2.setPrecio(200);

        Producto p3 = new Producto();
        p3.setPrecio(300);


        Publicacion publicacion = new Publicacion();
        publicacion.agregarProductos(p1,p2,p3);

        System.out.println(publicacion.generarPrecioTotal());

        for (Producto producto : publicacion.getProductos()){
            System.out.println(producto.getPrecio());
        }



//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-persistence");
//        EntityManager em = emf.createEntityManager();

    }

}

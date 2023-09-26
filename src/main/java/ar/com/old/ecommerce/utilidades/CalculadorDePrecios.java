package ar.com.old.ecommerce.utilidades;

public class CalculadorDePrecios {

    public static double calcularPrecioSinIVA(double precio, int cantidad){
        return precio * cantidad;
    }

    public static double calcularPrecioConIVA(double precio, int cantidad){
        return precio * 1.21 * cantidad;
    }
}

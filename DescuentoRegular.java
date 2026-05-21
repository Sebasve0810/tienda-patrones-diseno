package tienda.descuento;

public class DescuentoRegular implements DescuentoStrategy {
    @Override public double calcularDescuento(double monto) {
        return 0.0;
    }
}

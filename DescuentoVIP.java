package tienda.descuento;

public class DescuentoVIP implements DescuentoStrategy {
    @Override public double calcularDescuento(double monto) {
        if (monto <= 10000) return 0.0;
        double d = 0.20 * monto;
        return Math.max(5000.0, d);
    }
}

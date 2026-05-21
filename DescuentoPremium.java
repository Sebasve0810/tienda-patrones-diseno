package tienda.descuento;

public class DescuentoPremium implements DescuentoStrategy {
    @Override public double calcularDescuento(double monto) {
        return (monto > 10000) ? (0.10 * monto) : 0.0;
    }
}

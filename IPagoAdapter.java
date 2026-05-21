package tienda.pago;

public interface IPagoAdapter {
    boolean pagar(double total, String moneda);
}

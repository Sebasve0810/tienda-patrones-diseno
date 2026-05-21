package tienda.pago;

import tienda.pago.apis.PayUAPI;

public class PayUAdapter implements IPagoAdapter {
    private final PayUAPI api = new PayUAPI();
    private final String numeroTarjeta;
    public PayUAdapter(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }
    @Override public boolean pagar(double total, String moneda) {
        return api.cobrar(total, moneda, numeroTarjeta);
    }
}

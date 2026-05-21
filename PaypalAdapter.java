package tienda.pago;

import tienda.pago.apis.PaypalAPI;

public class PaypalAdapter implements IPagoAdapter {
    private final PaypalAPI api = new PaypalAPI();
    private final String moneda;
    public PaypalAdapter(String moneda) { this.moneda = moneda; }
    @Override public boolean pagar(double total, String monedaPedido) {
        return api.cobro(total, monedaPedido);
    }
}

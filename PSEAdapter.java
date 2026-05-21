package tienda.pago;

import tienda.pago.apis.PSEAPI;

public class PSEAdapter implements IPagoAdapter {
    private final PSEAPI api = new PSEAPI();
    @Override public boolean pagar(double total, String moneda) {
        return api.debitar(total);
    }
}

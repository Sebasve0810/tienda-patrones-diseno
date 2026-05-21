package tienda.pago;

import tienda.pago.apis.TransferenciaAPI;

public class TransferenciaAdapter implements IPagoAdapter {
    private final TransferenciaAPI api = new TransferenciaAPI();
    private final String cuentaOrigen;
    public TransferenciaAdapter(String cuentaOrigen) { this.cuentaOrigen = cuentaOrigen; }
    @Override public boolean pagar(double total, String moneda) {
        return api.transferir(total, moneda, cuentaOrigen);
    }
}

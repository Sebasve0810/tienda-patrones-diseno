package tienda.pago.apis;

public class TransferenciaAPI {
    public boolean transferir(double monto, String currency, String cuentaOrigen) {
        System.out.println("[TRANSFERENCIA] " + monto + " " + currency + " desde " + cuentaOrigen);
        return true;
    }
}

package tienda.pago.apis;

public class PayUAPI {
    public boolean cobrar(double monto, String currency, String tarjeta) {
        System.out.println("[PAYU] " + monto + " " + currency + " con tarjeta " + tarjeta);
        return true;
    }
}

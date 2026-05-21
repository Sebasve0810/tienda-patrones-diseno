package tienda.pago.apis;

public class PaypalAPI {
    public boolean cobro(double total, String currency) {
        System.out.println("[PAYPAL] cobrando " + total + " " + currency);
        return true;
    }
}

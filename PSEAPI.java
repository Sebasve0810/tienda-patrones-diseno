package tienda.pago.apis;

public class PSEAPI {
    public boolean debitar(double monto) {
        System.out.println("[PSE] debitando " + monto);
        return true;
    }
}

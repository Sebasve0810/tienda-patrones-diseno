package tienda.notificacion;

public class NotificacionSMS implements Observador {
    private final String numero;
    public NotificacionSMS(String numero) { this.numero = numero; }
    @Override public void actualizar(String pedidoId, String mensaje) {
        System.out.println("[SMS] a " + numero + " | Pedido " + pedidoId + " -> " + mensaje);
    }
}

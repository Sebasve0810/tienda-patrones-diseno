package tienda.notificacion;

public class NotificacionEmail implements Observador {
    private final String correo;
    public NotificacionEmail(String correo) { this.correo = correo; }
    @Override public void actualizar(String pedidoId, String mensaje) {
        System.out.println("[EMAIL] a " + correo + " | Pedido " + pedidoId + " -> " + mensaje);
    }
}

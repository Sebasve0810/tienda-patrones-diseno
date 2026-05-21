package tienda.notificacion;

public interface Observador {
    void actualizar(String pedidoId, String mensaje);
}

package tienda.command;

import tienda.core.Pedido;

public class OperacionCancelarPedido implements Operacion {
    private final Pedido pedido;
    private boolean ejecutado = false;

    public OperacionCancelarPedido(Pedido p) { this.pedido = p; }

    @Override public void ejecutar() {
        System.out.println("[CMD] Cancelar pedido " + pedido.getId());
        ejecutado = true;
    }

    @Override public void deshacer() {
        if (ejecutado) {
            System.out.println("[CMD] Revertir cancelación " + pedido.getId());
            ejecutado = false;
        }
    }
}

package tienda.command;

import tienda.core.Pedido;

public class OperacionCrearPedido implements Operacion {
    private final Pedido pedido;
    private boolean ejecutado = false;

    public OperacionCrearPedido(Pedido p) { this.pedido = p; }

    @Override public void ejecutar() {
        System.out.println("[CMD] Crear pedido " + pedido.getId());
        ejecutado = true;
    }

    @Override public void deshacer() {
        if (ejecutado) {
            System.out.println("[CMD] Deshacer creación " + pedido.getId());
            ejecutado = false;
        }
    }
}

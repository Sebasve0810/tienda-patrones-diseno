package tienda.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class Historial {
    private final Deque<Operacion> pila = new ArrayDeque<>();

    public void ejecutarYGuardar(Operacion op) {
        op.ejecutar();
        pila.push(op);
    }

    public void deshacerUltima() {
        if (!pila.isEmpty()) {
            Operacion op = pila.pop();
            op.deshacer();
        } else {
            System.out.println("[CMD] No hay operaciones para deshacer");
        }
    }
}

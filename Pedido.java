package tienda.core;

import java.util.*;
import tienda.producto.Producto;
import tienda.descuento.DescuentoStrategy;
import tienda.pago.IPagoAdapter;
import tienda.notificacion.Observador;
import tienda.config.ConfiguracionTienda;

public class Pedido {
    private final String id = UUID.randomUUID().toString().substring(0, 8);
    private final List<Producto> productos = new ArrayList<>();
    private final List<Observador> observadores = new ArrayList<>();
    private DescuentoStrategy estrategia;
    private IPagoAdapter pagoAdapter;

    public void setEstrategia(DescuentoStrategy d) { this.estrategia = d; }
    public void setPagoAdapter(IPagoAdapter p) { this.pagoAdapter = p; }

    public void agregarProducto(Producto p) { productos.add(p); }
    public void registrar(Observador obs) { observadores.add(obs); }
    public void quitar(Observador obs) { observadores.remove(obs); }
    private void notificar(String msg) {
        for (Observador o : observadores) o.actualizar(id, msg);
    }

    public double totalBruto() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
    public double totalImpuestos() {
        return productos.stream().mapToDouble(Producto::calcularIVA).sum();
    }
    public double totalEnvio() {
        return productos.stream().mapToDouble(Producto::calcularEnvio).sum();
    }
    public double totalConDescuento() {
        double subtotal = totalBruto() + totalImpuestos() + totalEnvio();
        double d = (estrategia == null) ? 0.0 : estrategia.calcularDescuento(totalBruto());
        return Math.max(0, subtotal - d);
    }

    public boolean procesarPago() {
        String moneda = ConfiguracionTienda.getInstancia().getMoneda();
        double total = totalConDescuento();
        boolean ok = pagoAdapter != null && pagoAdapter.pagar(total, moneda);
        if (ok) notificar("Pago aprobado por " + total + " " + moneda);
        else notificar("Pago rechazado");
        return ok;
    }

    public String getId() { return id; }
    public List<Producto> getProductos() { return Collections.unmodifiableList(productos); }
}

import tienda.config.ConfiguracionTienda;
import tienda.producto.*;
import tienda.descuento.*;
import tienda.pago.*;
import tienda.notificacion.*;
import tienda.core.Pedido;
import tienda.command.*;

public class MainDemo {
    public static void main(String[] args) {
        ConfiguracionTienda cfg = ConfiguracionTienda.getInstancia();
        cfg.setIVA(0.19);
        cfg.setEnvioBase(8000);
        cfg.setMoneda("COP");
        cfg.setDatosTienda("MiTienda", "Calle 123", "3001234567");

        Producto p1 = ProductoFactory.crearProducto("electronico", "Audífonos", 120000);
        Producto p2 = ProductoFactory.crearProducto("ropa", "Camiseta", 45000);
        Producto p3 = ProductoFactory.crearProducto("libro", "Patrones de diseño", 90000);

        Pedido pedido = new Pedido();
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);

        pedido.registrar(new NotificacionEmail("cliente@correo.com"));
        pedido.registrar(new NotificacionSMS("+57 3000000000"));

        pedido.setEstrategia(new DescuentoVIP());
        pedido.setPagoAdapter(new PaypalAdapter(cfg.getMoneda()));

        Historial historial = new Historial();
        Operacion crear = new OperacionCrearPedido(pedido);
        historial.ejecutarYGuardar(crear);

        System.out.println("Bruto: " + pedido.totalBruto());
        System.out.println("Impuestos: " + pedido.totalImpuestos());
        System.out.println("Envío: " + pedido.totalEnvio());
        System.out.println("Total con descuento: " + pedido.totalConDescuento());

        boolean ok = pedido.procesarPago();
        if (!ok) System.out.println("Pago fallido");

        historial.deshacerUltima();
    }
}

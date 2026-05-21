package tienda.producto;

import tienda.config.ConfiguracionTienda;

public class ProductoLibro extends Producto {
    public ProductoLibro(String nombre, double precio) {
        super(nombre, precio);
    }
    @Override
    public double calcularIVA() {
        double iva = Math.max(0, ConfiguracionTienda.getInstancia().getIVA() - 0.03);
        return precio * iva;
    }
    @Override
    public double calcularEnvio() {
        return 0.5 * ConfiguracionTienda.getInstancia().getEnvioBase();
    }
}

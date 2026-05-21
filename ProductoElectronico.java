package tienda.producto;

import tienda.config.ConfiguracionTienda;

public class ProductoElectronico extends Producto {
    public ProductoElectronico(String nombre, double precio) {
        super(nombre, precio);
    }
    @Override
    public double calcularIVA() {
        double iva = ConfiguracionTienda.getInstancia().getIVA() + 0.05;
        return precio * iva;
    }
    @Override
    public double calcularEnvio() {
        double base = ConfiguracionTienda.getInstancia().getEnvioBase();
        return 1.5 * base;
    }
}

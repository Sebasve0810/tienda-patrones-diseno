package tienda.producto;

import tienda.config.ConfiguracionTienda;

public class ProductoRopa extends Producto {
    public ProductoRopa(String nombre, double precio) {
        super(nombre, precio);
    }
    @Override
    public double calcularIVA() {
        double iva = ConfiguracionTienda.getInstancia().getIVA();
        return precio * iva;
    }
    @Override
    public double calcularEnvio() {
        return ConfiguracionTienda.getInstancia().getEnvioBase();
    }
}

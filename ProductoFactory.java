package tienda.producto;

public class ProductoFactory {
    public static Producto crearProducto(String tipo, String nombre, double precio) {
        switch (tipo.toLowerCase()) {
            case "electronico": return new ProductoElectronico(nombre, precio);
            case "ropa": return new ProductoRopa(nombre, precio);
            case "libro": return new ProductoLibro(nombre, precio);
            default: throw new IllegalArgumentException("Tipo de producto no soportado: " + tipo);
        }
    }
}

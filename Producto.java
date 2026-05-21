package tienda.producto;

public abstract class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre; this.precio = precio;
    }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public abstract double calcularIVA();
    public abstract double calcularEnvio();
}

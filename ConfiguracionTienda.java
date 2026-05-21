package tienda.config;

public class ConfiguracionTienda {
    private static ConfiguracionTienda instancia;

    private double ivaBase;
    private double envioBase;
    private String moneda;
    private String nombre;
    private String direccion;
    private String telefono;

    private ConfiguracionTienda() {}

    public static ConfiguracionTienda getInstancia() {
        if (instancia == null) instancia = new ConfiguracionTienda();
        return instancia;
    }

    public void setIVA(double iva) { this.ivaBase = iva; }
    public void setEnvioBase(double costo) { this.envioBase = costo; }
    public void setMoneda(String m) { this.moneda = m; }
    public void setDatosTienda(String nombre, String dir, String tel) {
        this.nombre = nombre; this.direccion = dir; this.telefono = tel;
    }

    public double getIVA() { return ivaBase; }
    public double getEnvioBase() { return envioBase; }
    public String getMoneda() { return moneda; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
}

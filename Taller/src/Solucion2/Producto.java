package Solucion2;

public class Producto {
    private String codigo;
    private String nombre;
    private String tipo; // Perecedero / No perecedero
    private double precio;
    private int stock;
    private int cantidadVendida;

    public Producto(String codigo, String nombre, String tipo, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
        this.cantidadVendida = 0;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void sumarVenta(int cantidad) {
        this.cantidadVendida += cantidad;
    }

    // Resumen de los datos principales del producto
    public String resumen() {
        return "Tipo   : " + tipo +
                "\nCódigo : " + codigo +
                "\nNombre : " + nombre +
                "\nPrecio : " + precio +
                "\nStock  : " + stock;
    }
}

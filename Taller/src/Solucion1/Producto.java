package Solucion1;

public class Producto {
        String Codigo;
        String Nombre;
        double Precio;
        int stock;
        int cantidadVendida;

    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, int stock, int cantidadVendida) {
        Codigo = codigo;
        Nombre = nombre;
        Precio = precio;
        this.stock = stock;
        this.cantidadVendida = cantidadVendida;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}

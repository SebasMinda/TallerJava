package Solucion2;

public class ProductoPerecedero extends Producto {
    private String fechaCaducidad;
    private String Lote;


    public ProductoPerecedero(String codigo, String nombre, String tipo, double precio, int stock, String fechaCaducidad, String lote) {
        super(codigo, nombre, tipo, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
        Lote = lote;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        this.Lote = lote;
    }
}

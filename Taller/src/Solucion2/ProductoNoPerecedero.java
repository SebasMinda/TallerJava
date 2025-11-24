package Solucion2;

public class ProductoNoPerecedero extends Producto {
    private int mesesConservacion;

    public ProductoNoPerecedero(String codigo, String nombre, String tipo, double precio, int stock) {
        super(codigo, nombre, tipo, precio, stock);
    }

    public ProductoNoPerecedero(String codigo, String nombre, String tipo, double precio, int stock, int mesesConservacion) {
        super(codigo, nombre, tipo, precio, stock);
        this.mesesConservacion = mesesConservacion;
    }

    public int getMesesConservacion() {
        return mesesConservacion;
    }

    public void setMesesConservacion(int mesesConservacion) {
        this.mesesConservacion = mesesConservacion;
    }
    public String resumenNP() {
        return super.resumen()
                + "\nMeses de conservación  : " + getMesesConservacion();
    }
}

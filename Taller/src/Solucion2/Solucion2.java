package Solucion2;

import javax.swing.*;
import java.util.ArrayList;

public class Solucion2 {
    private static ArrayList<Producto> listaProductos = new ArrayList<>();

    public static void main(String[] args) {

        int opc = -1;

        do {
            String menu =
                    "\n==============================\n"
                            + "         MENU TIENDA          \n"
                            + "==============================\n"
                            + "1. Agregar producto perecedero\n"
                            + "2. Agregar producto no perecedero\n"
                            + "3. Mostrar inventario\n"
                            + "4. Buscar producto por código\n"
                            + "5. Reabastecimiento de stock\n"
                            + "6. Registrar venta\n"
                            + "7. Mostrar alertas de stock bajo\n"
                            + "8. Mostrar total de ventas\n"
                            + "0. Salir\n\n"
                            + "Elige una opción:";

            String entrada = JOptionPane.showInputDialog(null, menu, "Menú Tienda",
                    JOptionPane.QUESTION_MESSAGE);

            if (entrada == null) {
                // Usuario cerró la ventana -> salir
                opc = 0;
            } else {
                try {
                    opc = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    opc = -1;
                }
            }

            switch (opc) {
                case 1 -> agregarProducto(true);   // perecedero
                case 2 -> agregarProducto(false);  // no perecedero
                case 3 -> mostrarInventario();
                case 4 -> buscarProductoPorCodigo();
                case 5 -> reabastecerStock();
                case 6 -> registrarVenta();
                case 7 -> mostrarAlertasStockBajo();
                case 8 -> mostrarTotalVentas();
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }

        } while (opc != 0);
    }

    // ================== OPCIÓN 1 y 2 ==================
    private static void agregarProducto(boolean esPerecedero) {

        String tipoTexto = esPerecedero ? "PERECEDERO" : "NO PERECEDERO";

        String codigo = JOptionPane.showInputDialog(null,
                "Ingrese el CÓDIGO del producto " + tipoTexto + ":",
                "Agregar producto", JOptionPane.QUESTION_MESSAGE);
        if (codigo == null) return;

        String nombre = JOptionPane.showInputDialog(null,
                "Ingrese el NOMBRE del producto:",
                "Agregar producto", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null) return;

        String strPrecio = JOptionPane.showInputDialog(null,
                "Ingrese el PRECIO del producto:",
                "Agregar producto", JOptionPane.QUESTION_MESSAGE);
        if (strPrecio == null) return;

        String strStock = JOptionPane.showInputDialog(null,
                "Ingrese el STOCK inicial del producto:",
                "Agregar producto", JOptionPane.QUESTION_MESSAGE);
        if (strStock == null) return;

        double precio;
        int stock;

        try {
            precio = Double.parseDouble(strPrecio);
            stock = Integer.parseInt(strStock);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: precio o stock no válidos.");
            return;
        }

        Producto p = new Producto(codigo, nombre, esPerecedero ? "Perecedero" : "No perecedero",
                precio, stock);

        listaProductos.add(p);

        JOptionPane.showMessageDialog(null,
                "Producto agregado correctamente:\n\n" + p.resumen(),
                "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
    }

    // ================== OPCIÓN 3 ==================
    private static void mostrarInventario() {
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el inventario.");
            return;
        }

        StringBuilder sb = new StringBuilder("--- Inventario de Productos ---\n\n");
        int num = 1;
        for (Producto p : listaProductos) {
            sb.append("Producto No: ").append(num++).append("\n");
            sb.append(p.resumen()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // ================== OPCIÓN 4 ==================
    private static void buscarProductoPorCodigo() {
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String codigoBuscado = JOptionPane.showInputDialog(null,
                "Ingrese el código del producto a buscar:",
                "Buscar producto", JOptionPane.QUESTION_MESSAGE);
        if (codigoBuscado == null) return;

        Producto encontrado = null;
        for (Producto p : listaProductos) {
            if (p.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un producto con ese código.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Producto encontrado:\n\n" + encontrado.resumen());
        }
    }

    // ================== OPCIÓN 5 ==================
    private static void reabastecerStock() {
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String codigo = JOptionPane.showInputDialog(null,
                "Ingrese el código del producto para reabastecer:",
                "Reabastecer stock", JOptionPane.QUESTION_MESSAGE);
        if (codigo == null) return;

        String strCantidad = JOptionPane.showInputDialog(null,
                "Ingrese la cantidad a reabastecer:",
                "Reabastecer stock", JOptionPane.QUESTION_MESSAGE);
        if (strCantidad == null) return;

        int cantidad;
        try {
            cantidad = Integer.parseInt(strCantidad);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            return;
        }

        Producto encontrado = null;
        for (Producto p : listaProductos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        } else {
            encontrado.setStock(encontrado.getStock() + cantidad);
            JOptionPane.showMessageDialog(null,
                    "Stock actualizado.\nNuevo stock de " + encontrado.getNombre() + ": "
                            + encontrado.getStock());
        }
    }

    // ================== OPCIÓN 6 ==================
    private static void registrarVenta() {
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String codigo = JOptionPane.showInputDialog(null,
                "Ingrese el código del producto para registrar la venta:",
                "Registrar venta", JOptionPane.QUESTION_MESSAGE);
        if (codigo == null) return;

        String strCantidad = JOptionPane.showInputDialog(null,
                "Ingrese la cantidad vendida:",
                "Registrar venta", JOptionPane.QUESTION_MESSAGE);
        if (strCantidad == null) return;

        int cantidad;
        try {
            cantidad = Integer.parseInt(strCantidad);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            return;
        }

        Producto encontrado = null;
        for (Producto p : listaProductos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        } else {
            if (encontrado.getStock() >= cantidad) {
                encontrado.setStock(encontrado.getStock() - cantidad);
                encontrado.sumarVenta(cantidad);

                double totalVenta = cantidad * encontrado.getPrecio();

                JOptionPane.showMessageDialog(null,
                        "Venta registrada.\n\n" +
                                "Producto: " + encontrado.getNombre() + "\n" +
                                "Cantidad vendida: " + cantidad + "\n" +
                                "Total de la venta: " + totalVenta + "\n" +
                                "Nuevo stock: " + encontrado.getStock());
            } else {
                JOptionPane.showMessageDialog(null,
                        "Stock insuficiente para completar la venta.\n" +
                                "Stock actual: " + encontrado.getStock());
            }
        }
    }

    // ================== OPCIÓN 7 ==================
    private static void mostrarAlertasStockBajo() {
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder("--- Alertas de stock bajo (< 2) ---\n\n");
        boolean hayAlertas = false;

        for (Producto p : listaProductos) {
            if (p.getStock() < 2) {
                hayAlertas = true;
                sb.append("Código: ").append(p.getCodigo())
                        .append(" | Nombre: ").append(p.getNombre())
                        .append(" | Stock: ").append(p.getStock())
                        .append("\n");
            }
        }

        if (!hayAlertas) {
            JOptionPane.showMessageDialog(null, "No hay productos con stock bajo.");
        } else {
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // ================== OPCIÓN 8 ==================
    private static void mostrarTotalVentas() {
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder("--- Total de Ventas por Producto ---\n\n");
        double sumaGanancias = 0;

        for (Producto p : listaProductos) {
            double totalProducto = p.getCantidadVendida() * p.getPrecio();
            sb.append("Código: ").append(p.getCodigo())
                    .append(" | Nombre: ").append(p.getNombre())
                    .append(" | Cantidad vendida: ").append(p.getCantidadVendida())
                    .append(" | Total: ").append(totalProducto)
                    .append("\n");
            sumaGanancias += totalProducto;
        }

        sb.append("\nGanancias totales: ").append(sumaGanancias);

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}

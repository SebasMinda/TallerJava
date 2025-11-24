package Solucion2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Solucion2 {
    private static List<ProductoNoPerecedero> ListaProductoNoPerecedero = new ArrayList<>();
    private static List<ProductoPerecedero> ListaProductoPerecedero = new ArrayList<>();

    public static void main(String[] args) {
        String codigo, nombre, tipo, fechaCaducidad, lote;
        double precio;
        int stock, mesesConservacion;

        int opcion = -1;
        String menu = "\n==============================\n"
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
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:

                    codigo = (JOptionPane.showInputDialog("Ingrese el código del producto:"));
                    nombre = (JOptionPane.showInputDialog("Ingrese el nombre del producto:"));
                    tipo = ("Perecedero");
                    precio = (Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:")));
                    stock = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:")));
                    fechaCaducidad = (JOptionPane.showInputDialog("Ingrese la fecha de caducidad del producto (DD/MM/AAAA):"));
                    lote = (JOptionPane.showInputDialog("Ingrese el lote del producto:"));
                    ProductoPerecedero producto = new ProductoPerecedero(codigo, nombre, tipo, precio, stock, fechaCaducidad, lote);
                    ListaProductoPerecedero.add(producto);
                    break;

                case 2:
                    codigo = (JOptionPane.showInputDialog("Ingrese el código del producto:"));
                    nombre = (JOptionPane.showInputDialog("Ingrese el nombre del producto:"));
                    tipo = ("No Perecedero");
                    precio = (Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:")));
                    stock = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:")));
                    mesesConservacion = Integer.parseInt((JOptionPane.showInputDialog("Ingrese los meses que se conserva el producto: ")));
                    ProductoNoPerecedero productonp = new ProductoNoPerecedero(codigo, nombre, tipo, precio, stock, mesesConservacion);
                    ListaProductoNoPerecedero.add(productonp);
                    break;
                case 3:
                    mostrarinventario();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación. ¡Hasta pronto!");
            }
        } while (opcion != 0);
    }

    private static void mostrarinventario() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n=== Inventario de Productos Perecederos ===\n");
        if (ListaProductoPerecedero.isEmpty()) {
            sb.append("No hay productos perecederos registrados.\n");
        } else {
            for (ProductoPerecedero producto : ListaProductoPerecedero) {
                sb.append(producto.resumenP()).append("\n-------------------------\n");
            }
        }

        sb.append("\n=== Inventario de Productos No Perecederos ===\n");
        if (ListaProductoNoPerecedero.isEmpty()) {
            sb.append("No hay productos no perecederos registrados.\n");
        } else {
            for (ProductoNoPerecedero productonp : ListaProductoNoPerecedero) {
                sb.append(productonp.resumenNP()).append("\n-------------------------\n");
            }
        }

        // Mostrar en un JTextArea dentro de un JScrollPane para mantener legibilidad
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "Inventario", JOptionPane.INFORMATION_MESSAGE);
    }
}
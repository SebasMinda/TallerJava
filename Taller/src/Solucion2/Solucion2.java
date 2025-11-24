package Solucion2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solucion2 {
    private static List<ProductoNoPerecedero> ListaProductoNoPerecedero = new ArrayList<>();
    private static List<ProductoPerecedero> ListaProductoPerecedero = new ArrayList<>();
    private static double totalVentas = 0.0;

    public static void main(String[] args) {
        String codigo, nombre, tipo, fechaCaducidad, lote;
        double precio;
        int stock, mesesConservacion;
        Scanner sc = new Scanner(System.in);
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
                + "0. Salir\n";

        do {
            System.out.println(menu);
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el código del producto: ");
                    codigo = sc.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    nombre = sc.nextLine();
                    tipo = "Perecedero";
                    System.out.print("Ingrese el precio del producto: ");
                    precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Ingrese el stock del producto: ");
                    stock = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese la fecha de caducidad del producto (DD/MM/AAAA): ");
                    fechaCaducidad = sc.nextLine();
                    System.out.print("Ingrese el lote del producto: ");
                    lote = sc.nextLine();

                    ProductoPerecedero producto = new ProductoPerecedero(
                            codigo, nombre, tipo, precio, stock, fechaCaducidad, lote
                    );
                    ListaProductoPerecedero.add(producto);
                    System.out.println("Producto perecedero agregado correctamente.\n");
                    break;

                case 2:
                    System.out.print("Ingrese el código del producto: ");
                    codigo = sc.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    nombre = sc.nextLine();
                    tipo = "No Perecedero";
                    System.out.print("Ingrese el precio del producto: ");
                    precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Ingrese el stock del producto: ");
                    stock = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese los meses que se conserva el producto: ");
                    mesesConservacion = Integer.parseInt(sc.nextLine());

                    ProductoNoPerecedero productonp = new ProductoNoPerecedero(
                            codigo, nombre, tipo, precio, stock, mesesConservacion
                    );
                    ListaProductoNoPerecedero.add(productonp);
                    System.out.println("Producto no perecedero agregado correctamente.\n");
                    break;

                case 3:
                    System.out.println("\n--- Inventario de Productos Perecederos ---\n");
                    for (ProductoPerecedero p : ListaProductoPerecedero) {
                        System.out.println("Código: " + p.getCodigo()
                                + ", Nombre: " + p.getNombre()
                                + ", Tipo: " + p.getTipo()
                                + ", Precio: " + p.getPrecio()
                                + ", Stock: " + p.getStock()
                                + ", Fecha de Caducidad: " + p.getFechaCaducidad()
                                + ", Lote: " + p.getLote());
                    }

                    System.out.println("\n--- Inventario de Productos No Perecederos ---\n");
                    for (ProductoNoPerecedero np : ListaProductoNoPerecedero) {
                        System.out.println("Código: " + np.getCodigo()
                                + ", Nombre: " + np.getNombre()
                                + ", Tipo: " + np.getTipo()
                                + ", Precio: " + np.getPrecio()
                                + ", Stock: " + np.getStock()
                                + ", Meses de Conservación: " + np.getMesesConservacion());
                    }
                    break;

                case 4:
                    System.out.println("\n--- Buscar Producto por Código ---\n");
                    System.out.print("Ingrese el código del producto a buscar: ");
                    String codigoBuscar = sc.nextLine();

                    for (int i = 0; i < ListaProductoPerecedero.size(); i++) {
                        ProductoPerecedero p = ListaProductoPerecedero.get(i);

                        if (ListaProductoPerecedero.get(i).getCodigo().equals(codigoBuscar)) {
                            System.out.println("Código: " + p.getCodigo()
                                    + ", Nombre: " + p.getNombre()
                                    + ", Tipo: " + p.getTipo()
                                    + ", Precio: " + p.getPrecio()
                                    + ", Stock: " + p.getStock()
                                    + ", Fecha de Caducidad: " + p.getFechaCaducidad()
                                    + ", Lote: " + p.getLote());
                        } else if (ListaProductoNoPerecedero.get(i).getCodigo().equals(codigoBuscar)) {
                            ProductoNoPerecedero np = ListaProductoNoPerecedero.get(i);
                            System.out.println("Código: " + np.getCodigo()
                                    + ", Nombre: " + np.getNombre()
                                    + ", Tipo: " + np.getTipo()
                                    + ", Precio: " + np.getPrecio()
                                    + ", Stock: " + np.getStock()
                                    + ", Meses de Conservación: " + np.getMesesConservacion());
                        } else {
                            System.out.println("Producto con código " + codigoBuscar + " no encontrado.\n");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n--- Reabastecimiento de Stock ---\n");
                    System.out.print("Ingrese el código del producto para reabastecer: ");
                    String codigoReabastecer = sc.nextLine();
                    System.out.print("Ingrese la cantidad a reabastecer: ");
                    int cantidadReabastecer = Integer.parseInt(sc.nextLine());

                    for (ProductoPerecedero p1 : ListaProductoPerecedero) {
                        if (p1.getCodigo().equals(codigoReabastecer)) {
                            p1.setStock(p1.getStock() + cantidadReabastecer);
                            System.out.println("Stock actualizado. Nuevo stock de "
                                    + p1.getNombre() + ": " + p1.getStock() + "\n");
                            break;
                        } else {
                            System.out.println("Producto con código "
                                    + codigoReabastecer + " no encontrado.\n");
                            break;
                        }
                    }

                case 6:
                    System.out.println("\n--- Registrar venta ---\n");
                    System.out.print("Ingrese el código del producto para la venta: ");
                    String codigoVenta = sc.nextLine();
                    System.out.print("Ingrese la cantidad vendida: ");
                    int cantidadVendida = Integer.parseInt(sc.nextLine());

                    for (ProductoPerecedero p1 : ListaProductoPerecedero) {
                        if (p1.getCodigo().equals(codigoVenta)) {
                            if (p1.getStock() >= cantidadVendida) {
                                p1.setStock(p1.getStock() - cantidadVendida);
                                p1.sumarVenta(cantidadVendida);
                                double total = cantidadVendida * p1.getPrecio();
                                totalVentas += total;
                                System.out.println("Venta registrada. Total: " + total
                                        + ". Nuevo stock de " + p1.getNombre()
                                        + ": " + p1.getStock() + "\n");
                                break;
                            } else {
                                System.out.println("Stock insuficiente. Stock actual: "
                                        + p1.getStock() + "\n");
                                break;
                            }
                        }
                    }

                    for (ProductoNoPerecedero np5 : ListaProductoNoPerecedero) {
                        if (np5.getCodigo().equals(codigoVenta)) {
                            if (np5.getStock() >= cantidadVendida) {
                                np5.setStock(np5.getStock() - cantidadVendida);
                                np5.sumarVenta(cantidadVendida);
                                double total = cantidadVendida * np5.getPrecio();
                                totalVentas += total;
                                System.out.println("Venta registrada. Total: " + total
                                        + ". Nuevo stock de " + np5.getNombre()
                                        + ": " + np5.getStock() + "\n");
                            } else {
                                System.out.println("Stock insuficiente. Stock actual: "
                                        + np5.getStock() + "\n");
                            }
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("\n--- Alertas de stock bajo  ---\n");
                    boolean hayAlertas = false;

                    for (ProductoPerecedero p : ListaProductoPerecedero) {
                        if (p.getStock() < 2) {
                            System.out.println("ALERTA: " + p.getNombre()
                                    + " (Código: " + p.getCodigo()
                                    + ") tiene stock bajo: " + p.getStock());
                            hayAlertas = true;
                        }
                    }

                    for (ProductoNoPerecedero np6 : ListaProductoNoPerecedero) {
                        if (np6.getStock() < 2) {
                            System.out.println("ALERTA: " + np6.getNombre()
                                    + " (Código: " + np6.getCodigo()
                                    + ") tiene stock bajo: " + np6.getStock());
                            hayAlertas = true;
                        }
                    }

                    if (!hayAlertas) {
                        System.out.println("No hay productos con stock bajo.\n");
                        break;
                    } else {
                        System.out.println();
                        break;
                    }

                case 8:
                    System.out.println("\n--- Total de ventas ---\n");
                    System.out.println(String.format(
                            "Ganancias Totales de la Tienda: %.2f", totalVentas
                    ));
                    break;

                case 0:
                    System.out.println("Saliendo de la aplicación. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no reconocida, intenta de nuevo.\n");
            }
        } while (opcion != 0);
    }
}

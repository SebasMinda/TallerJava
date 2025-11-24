package Solucion1;
import java.util.Scanner;

public class Solucion1 {
    public static void main(String[] args) {
        int i=0;
        String[] listaproductos=new String[100];
        String[] listaproductoscodigo=new String[100];
        String[] listaproductosnombre=new String[100];
        double[] listaproductosprecio=new double[100];
        int[] listaproductosstock=new int[100];
        String[] listaproductostipo=new String[100];
        int[] cantidadventasproducto= new int[100];
        Scanner sca=new Scanner(System.in);
        int opc=-1;

        do{System.out.println("\n==============================");
            System.out.println("       MENU TIENDA");
            System.out.println("==============================");
            System.out.println("1. Agregar producto perecedero");
            System.out.println("2. Agregar producto no perecedero");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Buscar producto por código");
            System.out.println("5. Reabastecetimiento de stock");
            System.out.println("6. Registrar venta");
            System.out.println("7. Mostrar alertas de stock bajo");
            System.out.println("8. Mostrar total de ventas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opc=sca.nextInt();
            switch(opc){
                case 1:
                    Producto producto =new Producto();
                    System.out.println("\nIngrese los datos del producto perecedero");
                    System.out.println("Codigo: ");
                    sca.nextLine();
                    producto.Codigo=sca.nextLine();
                    System.out.println("Nombre: ");
                    producto.Nombre=sca.nextLine();
                    System.out.println("Precio: ");
                    producto.Precio= Double.parseDouble(sca.nextLine());
                    System.out.println("Stock: ");
                    producto.stock= Integer.parseInt(sca.nextLine());
                    listaproductos[i]="\nProducto No:"+(i+1)+"\nTipo: Producto perecedero"+"\nCodigo:"+ producto.Codigo+"\nNombre:"+ producto.Nombre
                            +"\nPrecio:"+ producto.Precio+"\nStock:"+ producto.stock;
                    listaproductoscodigo[i]=producto.Codigo;
                    listaproductosnombre[i]=producto.Nombre;
                    listaproductosprecio[i]=producto.Precio;
                    listaproductosstock[i]=producto.stock;
                    listaproductostipo[i]="Perecedero";
                    cantidadventasproducto[i]=0;
                    i++;
                    break;
                case 2:
                    Producto producto1 =new Producto();
                    System.out.println("\nIngrese los datos del producto no perecedero");
                    System.out.printf("Codigo: ");
                    sca.nextLine();
                    producto1.Codigo= sca.nextLine();
                    System.out.printf("Nombre: ");
                    producto1.Nombre=sca.nextLine();
                    System.out.printf("Precio: ");
                    producto1.Precio= Double.parseDouble(sca.nextLine());
                    System.out.printf("Stock: ");
                    producto1.stock= Integer.parseInt(sca.nextLine());
                    listaproductos[i]="\nProducto No:"+(i+1)+"\nTipo: Producto no perecedero"+"\nCodigo:"+ producto1.Codigo+"\nNombre:"+ producto1.Nombre
                                +"\nPrecio:"+ producto1.Precio+"\nStock:"+ producto1.stock;
                    listaproductoscodigo[i]=producto1.Codigo;
                    listaproductosnombre[i]=producto1.Nombre;
                    listaproductosprecio[i]=producto1.Precio;
                    listaproductosstock[i]=producto1.stock;
                    listaproductostipo[i]="Perecedero";
                    cantidadventasproducto[i]=0;
                    i++;
                    break;
                case 3:
                    System.out.println("\n--- Inventario de Productos ---");
                    for (int j = 0; j < i; j++) {
                        System.out.println(listaproductos[j]);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el código del producto a buscar: ");
                    sca.nextLine();
                    String codigoBuscado = sca.nextLine();
                    for(int j=0; j<i; j++){
                        if(listaproductoscodigo[j].equals(codigoBuscado)){
                            System.out.println("Producto encontrado:");
                            System.out.println(listaproductos[j]);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el código del producto para reabastecer: ");
                    sca.nextLine();
                    String codigoReabastecer = sca.nextLine();
                    System.out.print("Ingrese la cantidad a reabastecer: ");
                    int cantidadReabastecer = Integer.parseInt(sca.nextLine());
                    for(int j=0; j<i; j++){
                        if(listaproductoscodigo[j].equals(codigoReabastecer)){
                            listaproductosstock[j] += cantidadReabastecer;
                            System.out.println("Stock actualizado. Nuevo stock de " + listaproductosnombre[j] + ": " + listaproductosstock[j]);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el código del producto para registrar la venta: ");
                    sca.nextLine();
                    String codigoVenta = sca.nextLine();
                    System.out.print("Ingrese la cantidad vendida: ");
                    int cantidadVendida = Integer.parseInt(sca.nextLine());
                    for(int j=0; j<i; j++){
                        if(listaproductoscodigo[j].equals(codigoVenta)){
                            if(listaproductosstock[j] >= cantidadVendida){
                                listaproductosstock[j] -= cantidadVendida;
                                System.out.println(String.format("Total de la venta: %.2f", (listaproductosprecio[j] * cantidadVendida)));
                                System.out.println("Venta registrada. Nuevo stock de " + listaproductosnombre[j] + ": " + listaproductosstock[j]);
                                cantidadventasproducto[j] += cantidadVendida;
                            } else {
                                System.out.println("Stock insuficiente para completar la venta.");
                            }
                        }
                    }

                    break;
                case 7:
                    for (int j = 0; j < i; j++) {
                        if (listaproductosstock[j]<2) {
                            System.out.println(" ALERTA: El producto1 con código " + listaproductoscodigo[j]
                                    + " y nombre " + listaproductosnombre[j]
                                    + " tiene un stock bajo de " + listaproductosstock[j] + " unidades.");
                        }
                    }
                    break;
                case 8:
                    System.out.println("\n--- Total de Ventas por Producto ---");
                    double sumaGanancias=0;
                    for (int j = 0; j < i; j++) {
                        System.out.println("Producto Código: " + listaproductoscodigo[j]
                                + ", Nombre: " + listaproductosnombre[j]
                                + ", Cantidad Vendida: " + cantidadventasproducto[j]
                                + ", Total Ganancias: " + (cantidadventasproducto[j] * listaproductosprecio[j]));
                        sumaGanancias+=cantidadventasproducto[j] * listaproductosprecio[j];
                    }
                    System.out.println(String.format("Ganancias Totales de la Tienda: %.2f", sumaGanancias));
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }while (opc!=0);
    }
}

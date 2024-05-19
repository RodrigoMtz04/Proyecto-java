import java.util.*;

public class Proyecto {
    public static void main(String[] args) {
        ArrayList<producto> productos = new ArrayList<>();
        ArrayList<empleado> empleados = new ArrayList<>();
        ArrayList<cliente> clientes = new ArrayList<>();
        creadorArchivos archivos = new creadorArchivos();
        Scanner scanner = new Scanner(System.in);
        creadorArchivos creador = new creadorArchivos();
        producto tempProducto = null;
        empleado tempEmpleado = null;
        cliente tempCliente = null;
        int opc, opc2;
        String id, rfc;
        String nom, resp;
        String descripccion;
        String dirreccion;
        String num, contraseña;
        double precio;
        int cantidad;
        int caja;

        do {
            System.out.println("Menu principal");
            System.out.println("1) Menu de cajeros");
            System.out.println("2) Menu productos");
            System.out.println("3) Ventas");
            System.out.println("4) Salir");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Menu de cajeros");
                    System.out.println("1) reguistro");
                    System.out.println("2) modificacion");
                    System.out.println("3) consulta general");
                    System.out.println("4) consulta por id");
                    System.out.println("5) eliminar");
                    System.out.println("6) salir");
                    opc2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (opc2) {
                        case 1:
                            for (;;) {
                                System.out.println("Reguistro");
                                System.out.println("ingrese el nombre");
                                nom = scanner.nextLine();
                                System.out.println("ingrese el id");
                                id = scanner.nextLine();
                                System.out.println("Ingrese el rfc");
                                rfc = scanner.nextLine();
                                System.out.println("ingrese la contaseña de caja");
                                contraseña = scanner.nextLine();
                                System.out.println("Ingrese la direccion");
                                dirreccion = scanner.nextLine();
                                System.out.println("ingrese su numero de celular");
                                num = scanner.nextLine();
                                tempEmpleado= new empleado(nom, dirreccion, num, rfc, id, contraseña);
                                empleados.add(tempEmpleado);
                                archivos.escribirArchivoEmpleados(empleados);
                                System.out.println("quiere ingresar mas si/no");
                                resp = scanner.nextLine();
                                if (resp.equals("no")) {
                                    break;
                                }
                            }

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;

                        default:
                            break;
                    }

                    break;
                case 2:
                    System.out.println("Menu de cajeros");
                    System.out.println("1) reguistro");
                    System.out.println("2) modificacion");
                    System.out.println("3) consulta general");
                    System.out.println("4) consulta por id");
                    System.out.println("5) eliminar");
                    System.out.println("6) salir");
                    opc2 = scanner.nextInt();
                    switch (opc2) {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;

                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Menu ventas");
                    System.out.println("1) Caja");
                    System.out.println("2) Ventas del dia");
                    System.out.println("3) Salir");
                    opc2 = scanner.nextInt();
                    switch (opc2) {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;

                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }

        } while (opc != 4);
        scanner.close();
    }
}
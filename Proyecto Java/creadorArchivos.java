import java.io.*;
import java.util.*;

public class creadorArchivos {
    public void crearArchivoProductos() {
        File Alumnos = new File("productos.txt");
        try {
            Alumnos.createNewFile();
            System.out.println("Archivo Productos creado");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo ");
        }
    }

    public void crearArchivoEmpleados() {
        File Alumnos = new File("Empleados.txt");
        try {
            Alumnos.createNewFile();
            System.out.println("Archivo Empleados creado");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo ");
        }
    }

    public void crearArchivoVentas() {
        File Ventas = new File("Ventas.txt");
        try {
            Ventas.createNewFile();
            System.out.println("Archivo Ventas creado");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo ");
        }
    }

    public void escribirArchivoProuctos(ArrayList<producto> productos) {
        try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("productos.txt"))) {
            escribir.writeObject(productos);
            escribir.close();
            System.out.println("Datos guardados correctamente");

        } catch (IOException e) {
            System.out.println("Error al guardar los datos");
        }

    }

    public void escribirArchivoEmpleados(ArrayList<empleado> empleados) {
        try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Empleados.txt"))) {
            escribir.writeObject(empleados);
            escribir.close();
            System.out.println("Datos guardados correctamente");

        } catch (IOException e) {
            System.out.println("Error al guardar los datos");
        }

    }

    public void escribirArchivoVentas(ArrayList<ventas> venta) {
        try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Empleados.txt"))) {
            escribir.writeObject(venta);
            escribir.close();
            System.out.println("Datos guardados correctamente");

        } catch (IOException e) {
            System.out.println("Error al guardar los datos");
        }

    }

    @SuppressWarnings("unchecked")
    public static ArrayList<producto> leerArchivoProductos() {
        ArrayList<producto> productos = new ArrayList<>();
        File archivo = new File("productos.txt");
        if (archivo.length() != 0) {
            try {
                FileInputStream leer = new FileInputStream("productos.txt");
                ObjectInputStream lector = new ObjectInputStream(leer);
                productos = (ArrayList<producto>) lector.readObject();
                lector.close();
                System.out.println("Archivo leido correctamente");

            } catch (Exception e) {
                System.out.println("Error al leer el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo esta vacio");
        }

        return productos;

    }

    @SuppressWarnings("unchecked")
    public static ArrayList<empleado> leerArchivoEmpleados() {
        ArrayList<empleado> empleados = new ArrayList<>();
        File archivo = new File("Empleados.txt");
        if (archivo.length() != 0) {
            try {
                FileInputStream leer = new FileInputStream("Empleados.txt");
                ObjectInputStream lector = new ObjectInputStream(leer);
                empleados = (ArrayList<empleado>) lector.readObject();
                lector.close();
                System.out.println("Archivo leido correctamente");

            } catch (Exception e) {
                System.out.println("Error al leer el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo esta vacio");
        }

        return empleados;

    }

    @SuppressWarnings("unchecked")
    public static ArrayList<ventas> leerArchivoVenats() {
        ArrayList<ventas> venta = new ArrayList<>();
        File archivo = new File("Ventas.txt");
        if (archivo.length() != 0) {
            try {
                FileInputStream leer = new FileInputStream("Ventas.txt");
                ObjectInputStream lector = new ObjectInputStream(leer);

                venta = (ArrayList<ventas>) lector.readObject();
                lector.close();
                System.out.println("Archivo leido correctamente");

            } catch (Exception e) {
                System.out.println("Error al leer el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo esta vacio");
        }

        return venta;

    }

}
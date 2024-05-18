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
        File Alumnos = new File("Ventas.txt");
        try {
            Alumnos.createNewFile();
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

    public static ArrayList<producto> leerArchivoProductos() {
        ArrayList<producto> productos = new ArrayList<>();
        try {
            FileInputStream leer = new FileInputStream("Alumnos.txt");
            ObjectInputStream lector = new ObjectInputStream(leer);
            productos = (ArrayList<producto>) lector.readObject();
            lector.close();
            System.out.println("Archivo leido correctamente");

        } catch (Exception e) {
            System.out.println("Errir al leer el archivo");
            e.printStackTrace();
        }
        return productos;

    }

    public static ArrayList<empleado> leerArchivoEmpleados() {
        ArrayList<empleado> empleados = new ArrayList<>();
        try {
            FileInputStream leer = new FileInputStream("Alumnos.txt");
            ObjectInputStream lector = new ObjectInputStream(leer);
            empleados = (ArrayList<empleado>) lector.readObject();
            lector.close();
            System.out.println("Archivo leido correctamente");

        } catch (Exception e) {
            System.out.println("Errir al leer el archivo");
            e.printStackTrace();
        }
        return empleados;

    }

    public static ArrayList<ventas> leerArchivoVenats() {
        ArrayList<ventas> venta = new ArrayList<>();
        try {
            FileInputStream leer = new FileInputStream("Alumnos.txt");
            ObjectInputStream lector = new ObjectInputStream(leer);
            venta = (ArrayList<ventas>) lector.readObject();
            lector.close();
            System.out.println("Archivo leido correctamente");

        } catch (Exception e) {
            System.out.println("Errir al leer el archivo");
            e.printStackTrace();
        }
        return venta;

    }

}

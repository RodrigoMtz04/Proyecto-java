import java.io.*;

public class producto implements Serializable {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion;
    
    public producto(String id,String nombre, double precio, int cantidad, String desc) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = desc;
    }

    public void setCantidad(int venta) {
        this.cantidad = cantidad - venta;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
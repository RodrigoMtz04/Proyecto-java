import java.io.*;

public class producto implements Serializable {
    private String id;
    private double precio;
    private int cantidad;
    private String descripcion;

    public producto(String id, double precio, int cantidad, String desc) {
        this.id = id;
        this.precio = precio;
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

    public double precio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
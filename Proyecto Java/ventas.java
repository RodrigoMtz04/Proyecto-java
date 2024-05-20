import java.io.*;

public class ventas implements Serializable {
    String productos;
    double venta;
    int caja;

    public ventas(String productos, double venta, int caja) {
        this.caja = caja;
        this.productos = productos;
        this.venta = venta;
    }

    public double getVentas() {
        return venta;
    }
}
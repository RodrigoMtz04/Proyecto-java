import java.io.*;

public class ventas implements Serializable {
    double venta;
    String caja;
    String nombreCliente;
    String tipoFrecuencia;

    public ventas(double venta, String caja, String nombreCliente, String tipoFrecuencia) {
        this.caja = caja;
        this.venta = venta;
        this.nombreCliente = nombreCliente;
        this.tipoFrecuencia = tipoFrecuencia;
    }

    public double getVentas() {
        return venta;
    }

    public String getCaja() {
        return caja;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTipoFrecuencia() {
        return tipoFrecuencia;
    }


}
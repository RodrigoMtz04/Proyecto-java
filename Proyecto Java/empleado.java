import java.io.*;

public class empleado extends persona implements Serializable {

    String rfc;
    String id;
    String contaseñaCaja;

    public empleado(String nombre, String direccion, String numCelular, String rfc, String id, String contaseña) {
        super(nombre, direccion, numCelular);
        this.id = id;
        this.rfc = rfc;
        this.contaseñaCaja = contaseña;
    }

    public String getId() {
        return id;
    }

    public String getRfc() {
        return rfc;
    }

    public String getContraseña() {
        return contaseñaCaja;
    }
}
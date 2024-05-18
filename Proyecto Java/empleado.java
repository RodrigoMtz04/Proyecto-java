public class empleado extends persona {
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
}

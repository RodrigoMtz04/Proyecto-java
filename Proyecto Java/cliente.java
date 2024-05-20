import java.io.*;

public class cliente extends persona implements Serializable {
    String tipo;
    String id;

    public cliente(String nom, String dir, String num, String tipo, String id) {
        super(nom, dir, num);
        this.tipo = tipo;
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }

}
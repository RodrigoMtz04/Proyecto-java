
public class persona {
    String nombre;
    String direccion;
    String numCelular;

    public persona(String nom, String dir, String num) {
        this.nombre = nom;
        this.direccion = dir;
        this.numCelular = num;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumero(String num) {
        this.numCelular = num;
    }

    public String getNom() {
        return nombre;
    }

    public String getDir() {
        return direccion;

    }

    public String getNum() {
        return numCelular;
    }

}

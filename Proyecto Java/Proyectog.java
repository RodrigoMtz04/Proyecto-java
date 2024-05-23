import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Proyectog {
    private JFrame frame, frameEreguistro;
    private JTextField nombre, id, rfc, direccion, num, contraseña, tipo;
    private DefaultTableModel productosT, empleadosT;
    private ArrayList<empleado> empleados;
    private ArrayList<producto> productos;
    private ArrayList<cliente> clienhjtes;
    private ArrayList<ventas> venta;
    private creadorArchivos archivos;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Proyectog().crearVentana());
    }

    public void crearVentana() {
        archivos = new creadorArchivos();
        archivos.crearArchivoEmpleados();
        archivos.crearArchivoProductos();
        archivos.crearArchivoVentas();
        archivos.crearArchivoClientes();
        archivos.crearArchivoPersona();
        empleados = archivos.leerArchivoEmpleados();
        productos = archivos.leerArchivoProductos();
        clientes = archivos.leerArchivoClientes();
        venta = archivos.leerArchivoVenats();

        frame = new JFrame("Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        frameEreguistro = new JFrame("Reguistro empleados");
        frameEreguistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEreguistro.setSize(600, 400);
        frameEreguistro.setLayout(null);

        // Menu principal
        JMenuBar menuPrincipal = new JMenuBar();

        JMenu fileMenu = new JMenu("Menu empleados");
        JMenuItem emp1 = new JMenuItem("Agregar");
        JMenuItem emp2 = new JMenuItem("Modificar");
        JMenuItem emp3 = new JMenuItem("Consulta general");
        JMenuItem emp4 = new JMenuItem("Consulta por id");
        JMenuItem emp5 = new JMenuItem("Eliminar");

        JMenu Mproductos = new JMenu("Menu prductos");
        JMenuItem pr1 = new JMenuItem("Agreagar");
        JMenuItem pr2 = new JMenuItem("Modificar");
        JMenuItem pr3 = new JMenuItem("Consulta por id");
        JMenuItem pr4 = new JMenuItem("Consulta general");
        JMenuItem pr5 = new JMenuItem("Eliminar");

        JMenu Mventas = new JMenu("Menu ventas");
        JMenuItem v1 = new JMenuItem("Caja");
        JMenuItem v2 = new JMenuItem("ventas del dia");

        fileMenu.add(emp1);
        fileMenu.add(emp2);
        fileMenu.add(emp3);
        fileMenu.add(emp4);
        fileMenu.add(emp5);

        Mproductos.add(pr1);
        Mproductos.add(pr2);
        Mproductos.add(pr3);
        Mproductos.add(pr4);
        Mproductos.add(pr5);

        Mventas.add(v1);
        Mventas.add(v2);

        menuPrincipal.add(fileMenu);
        menuPrincipal.add(Mproductos);
        menuPrincipal.add(Mventas);
        // pestaña reguistro empleados
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 20, 80, 25);
        frameEreguistro.add(nombreLabel);

        nombre = new JTextField(20);
        nombre.setBounds(100, 20, 165, 25);
        frameEreguistro.add(nombre);

        JLabel idLabel = new JLabel("Id:");
        idLabel.setBounds(10, 50, 80, 25);
        frameEreguistro.add(idLabel);

        id = new JTextField(20);
        id.setBounds(100, 50, 165, 25);
        frameEreguistro.add(id);

        JLabel rfcJLabel = new JLabel("Rfc:");
        rfcJLabel.setBounds(10, 80, 80, 25);
        frameEreguistro.add(rfcJLabel);

        rfc = new JTextField(20);
        rfc.setBounds(100, 80, 165, 25);
        frameEreguistro.add(rfc);

        JLabel dirreccionJLabel = new JLabel("Direccion:");
        dirreccionJLabel.setBounds(10, 110, 80, 25);
        frameEreguistro.add(dirreccionJLabel);

        direccion = new JTextField(20);
        direccion.setBounds(100, 110, 165, 25);
        frameEreguistro.add(direccion);

        JLabel numJLabel = new JLabel("Numero:");
        numJLabel.setBounds(10, 140, 80, 25);
        frameEreguistro.add(numJLabel);

        num = new JTextField(20);
        num.setBounds(100, 140, 165, 25);
        frameEreguistro.add(num);

        JLabel contrLabel = new JLabel("Contraseña:");
        contrLabel.setBounds(10, 170, 80, 25);
        frameEreguistro.add(contrLabel);

        // Acciones menu empleados
        emp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameEreguistro.setVisible(true);

            }
        });

        frame.setJMenuBar(menuPrincipal);

        frame.setVisible(true);
        frame.add(frameEreguistro);

    }

}
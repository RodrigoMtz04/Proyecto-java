import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Proyectog extends JFrame {
    private JPanel pRegistroEmpleado;
    private JPanel pConsultaEmpleados;
    private JPanel pRegistroProducto;
    private JPanel pConsultaProductos;
    private JPanel pVentaCaja;
    private JPanel pVentaCorte;
    private JTextField nombre, id, rfc, direccion, num, textContraseña, tipo;
    private ArrayList<empleado> listaEmpleados;
    private ArrayList<producto> listaProductos;
    private ArrayList<cliente> listaClientes;
    private ArrayList<ventas> listaVentas;
    private creadorArchivos archivos;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Proyectog());
    }

    public Proyectog() {
        setTitle("Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);
        crearVentana();
    }

    public void crearVentana() {
        archivos = new creadorArchivos();
        archivos.crearArchivoEmpleados();
        archivos.crearArchivoProductos();
        archivos.crearArchivoVentas();
        archivos.crearArchivoClientes();
        // archivos.crearArchivoPersona(); Creo que este no se ocupaba
        listaEmpleados = archivos.leerArchivoEmpleados();
        listaProductos = archivos.leerArchivoProductos();
        listaClientes = archivos.leerArchivoClientes();
        listaVentas = archivos.leerArchivoVenats();

        pRegistroEmpleado = new JPanel();
        pRegistroEmpleado.setSize(600, 400);
        pRegistroEmpleado.setLayout(null);

        pRegistroProducto = new JPanel();
        pRegistroProducto.setSize(600, 400);
        pRegistroProducto.setLayout(null);

        pConsultaEmpleados = new JPanel();
        pConsultaEmpleados.setSize(600, 400);
        pConsultaEmpleados.setLayout(null);

        pConsultaProductos = new JPanel();
        pConsultaProductos.setSize(600, 400);
        pConsultaProductos.setLayout(null);

        pVentaCaja = new JPanel();
        pVentaCaja.setSize(600, 400);
        pVentaCaja.setLayout(null);

        pVentaCorte = new JPanel();
        pVentaCorte.setSize(600, 400);
        pVentaCorte.setLayout(null);

        // MENU SUPERIOR
        // Creando items
        JMenuBar menuPrincipal = new JMenuBar();

        JMenu Mempleados = new JMenu("Empleados");
        JMenuItem emp1_Agregar = new JMenuItem("Agregar");
        JMenuItem emp2_Modificar = new JMenuItem("Modificar");
        JMenuItem emp3_ConsultaGen = new JMenuItem("Consulta general");
        JMenuItem emp4_ConsultaID = new JMenuItem("Consulta por ID");
        JMenuItem emp5_Eliminar = new JMenuItem("Eliminar");

        JMenu Mproductos = new JMenu("Productos");
        JMenuItem pr1_Agregar = new JMenuItem("Agregar");
        JMenuItem pr2_Modificar = new JMenuItem("Modificar");
        JMenuItem pr3_ConsultaGen = new JMenuItem("Consulta general");
        JMenuItem pr4_ConsultaID = new JMenuItem("Consulta por ID");
        JMenuItem pr5_Eliminar = new JMenuItem("Eliminar");

        JMenu Mventas = new JMenu("Ventas");
        JMenuItem v1_Caja = new JMenuItem("Caja");
        JMenuItem v2_VentasDia = new JMenuItem("Ventas del dia");
        // Añadiendo menu superior
        Mempleados.add(emp1_Agregar);
        Mempleados.add(emp2_Modificar);
        Mempleados.add(emp3_ConsultaGen);
        Mempleados.add(emp4_ConsultaID);
        Mempleados.add(emp5_Eliminar);

        Mproductos.add(pr1_Agregar);
        Mproductos.add(pr2_Modificar);
        Mproductos.add(pr3_ConsultaGen);
        Mproductos.add(pr4_ConsultaID);
        Mproductos.add(pr5_Eliminar);

        Mventas.add(v1_Caja);
        Mventas.add(v2_VentasDia);

        menuPrincipal.add(Mempleados);
        menuPrincipal.add(Mproductos);
        menuPrincipal.add(Mventas);

        // TODAS LOS PANELES
        /////////////////////// Registro de empleados
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(10, 20, 80, 25);
        pRegistroEmpleado.add(idLabel);

        id = new JTextField(20);
        id.setBounds(100, 20, 165, 25);
        pRegistroEmpleado.add(id);

        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(10, 50, 80, 25);
        pRegistroEmpleado.add(nombreLabel);

        nombre = new JTextField(20);
        nombre.setBounds(100, 50, 165, 25);
        pRegistroEmpleado.add(nombre);

        JLabel rfcJLabel = new JLabel("Rfc:");
        rfcJLabel.setBounds(10, 80, 80, 25);
        pRegistroEmpleado.add(rfcJLabel);

        rfc = new JTextField(20);
        rfc.setBounds(100, 80, 165, 25);
        pRegistroEmpleado.add(rfc);

        JLabel dirreccionJLabel = new JLabel("Direccion:");
        dirreccionJLabel.setBounds(10, 110, 80, 25);
        pRegistroEmpleado.add(dirreccionJLabel);

        direccion = new JTextField(20);
        direccion.setBounds(100, 110, 165, 25);
        pRegistroEmpleado.add(direccion);

        JLabel numJLabel = new JLabel("Numero:");
        numJLabel.setBounds(10, 140, 80, 25);
        pRegistroEmpleado.add(numJLabel);

        num = new JTextField(20);
        num.setBounds(100, 140, 165, 25);
        pRegistroEmpleado.add(num);

        JLabel contrLabel = new JLabel("Contraseña:");
        contrLabel.setBounds(10, 170, 80, 25);
        pRegistroEmpleado.add(contrLabel);

        textContraseña = new JTextField(20);
        textContraseña.setBounds(100, 170, 165, 25);
        pRegistroEmpleado.add(textContraseña);

        JButton botonAgregarEmp = new JButton("Agregar");
        botonAgregarEmp.setBounds(10, 200, 80, 25);
        pRegistroEmpleado.add(botonAgregarEmp);

        JButton botonModificarEmp = new JButton("Modificar");
        botonModificarEmp.setBounds(10, 200, 80, 25);
        pRegistroEmpleado.add(botonModificarEmp);

        JButton botonEliminarEmp = new JButton("Eliminar");
        botonEliminarEmp.setBounds(10, 50, 80, 25);
        pRegistroEmpleado.add(botonEliminarEmp);

        /////////////////////// Consulta de empleados
        // Encabezado
        JLabel topConsultaEmpleado = new JLabel("Empleados");
        topConsultaEmpleado.setBounds(10, 10, 80, 20);

        // Centro
        // Crea un modelo de tabla con su cabecera y matriz
        DefaultTableModel templateEmpleados = new DefaultTableModel();
        templateEmpleados.addColumn("ID");
        templateEmpleados.addColumn("NOMBRE");
        templateEmpleados.addColumn("DIRECCION");
        templateEmpleados.addColumn("TELEFONO");
        templateEmpleados.addColumn("RFC");
        templateEmpleados.addColumn("CONTRASEÑA");
        JTable tablaEmpleados = new JTable(templateEmpleados);
        JScrollPane scrollEmpleados = new JScrollPane(tablaEmpleados);
        scrollEmpleados.setBounds(50, 35, 500, 260);

        // Footer
        JLabel bottomConsultaEmpleado = new JLabel("Empleado:");
        bottomConsultaEmpleado.setBounds(10, 308, 80, 20);
        pConsultaEmpleados.add(bottomConsultaEmpleado);

        JTextField consultaID = new JTextField(10);
        consultaID.setBounds(90, 310, 300, 20);

        JButton botonConsultaID = new JButton("Buscar");
        botonConsultaID.setBounds(400, 310, 80, 20);

        // Agregandolo
        pConsultaEmpleados.add(topConsultaEmpleado);
        pConsultaEmpleados.add(scrollEmpleados);
        pConsultaEmpleados.add(bottomConsultaEmpleado);
        pConsultaEmpleados.add(consultaID);
        pConsultaEmpleados.add(botonConsultaID);

        /////////////////////// Registro de Productos
        JLabel labelProductoId = new JLabel("ID");
        labelProductoId.setBounds(10, 20, 80, 25);
        pRegistroProducto.add(labelProductoId);

        JTextField fieldProductoID = new JTextField(20);
        fieldProductoID.setBounds(100, 20, 165, 25);
        pRegistroProducto.add(fieldProductoID);

        JLabel labelProductoNombre = new JLabel("Nombre");
        labelProductoNombre.setBounds(10, 50, 80, 25);
        pRegistroProducto.add(labelProductoNombre);

        JTextField fieldProductoNombre = new JTextField(20);
        fieldProductoNombre.setBounds(100, 50, 165, 25);
        pRegistroProducto.add(fieldProductoNombre);

        JLabel labelProductoPrecio = new JLabel("Precio");
        labelProductoPrecio.setBounds(10, 80, 80, 25);
        pRegistroProducto.add(labelProductoPrecio);

        JTextField fieldProductoPrecio = new JTextField(20);
        fieldProductoPrecio.setBounds(100, 80, 165, 25);
        pRegistroProducto.add(fieldProductoPrecio);

        JLabel labelProductoCantidad = new JLabel("Cantidad");
        labelProductoCantidad.setBounds(10, 110, 80, 25);
        pRegistroProducto.add(labelProductoCantidad);

        JTextField fieldProductoCantidad = new JTextField(20);
        fieldProductoCantidad.setBounds(100, 110, 165, 25);
        pRegistroProducto.add(fieldProductoCantidad);

        JLabel labelProductoDescripcion = new JLabel("Descripción");
        labelProductoDescripcion.setBounds(10, 140, 80, 25);
        pRegistroProducto.add(labelProductoDescripcion);

        JTextField fieldProductoDescripcion = new JTextField(20);
        fieldProductoDescripcion.setBounds(100, 140, 165, 25);
        pRegistroProducto.add(fieldProductoDescripcion);

        JButton botonAgregarProducto = new JButton("Agregar");
        botonAgregarProducto.setBounds(10, 200, 80, 25);
        pRegistroProducto.add(botonAgregarProducto);

        JButton botonModificarProducto = new JButton("Modificar");
        botonModificarProducto.setBounds(10, 200, 80, 25);
        pRegistroProducto.add(botonModificarProducto);

        JButton botonEliminarProducto = new JButton("Eliminar");
        botonEliminarProducto.setBounds(10, 50, 80, 25);
        pRegistroProducto.add(botonEliminarProducto);

        /////////////////////// Consulta de Productos
        // Encabezado
        JLabel topConsultaProductos = new JLabel("Productos");
        topConsultaProductos.setBounds(10, 10, 80, 20);

        // Centro
        // Crea un modelo de tabla con su cabecera y matriz
        DefaultTableModel templateProductos = new DefaultTableModel();
        templateProductos.addColumn("ID");
        templateProductos.addColumn("NOMBRE");
        templateProductos.addColumn("PRECIO");
        templateProductos.addColumn("CANTIDAD");
        templateProductos.addColumn("DESCRIPCIÓN");
        JTable tablaProductos = new JTable(templateProductos);
        JScrollPane scrollProductos = new JScrollPane(tablaProductos);
        scrollProductos.setBounds(50, 35, 500, 260);

        // Footer
        JLabel bottomConsultaProductos = new JLabel("Producto:");
        bottomConsultaProductos.setBounds(10, 308, 80, 20);
        pConsultaEmpleados.add(bottomConsultaProductos);

        JTextField consultaProductoID = new JTextField(10);
        consultaProductoID.setBounds(90, 310, 300, 20);

        JButton botonConsultaProductoID = new JButton("Buscar");
        botonConsultaProductoID.setBounds(400, 310, 80, 20);

        // Agregandolo
        pConsultaProductos.add(topConsultaProductos);
        pConsultaProductos.add(scrollProductos);
        pConsultaProductos.add(bottomConsultaProductos);
        pConsultaProductos.add(consultaProductoID);
        pConsultaProductos.add(botonConsultaProductoID);

        /////////////////////// Ventas - CAJA
        JLabel labelVentaID = new JLabel("ID:");
        labelVentaID.setBounds(50, 18, 40, 25);
        pVentaCaja.add(labelVentaID);

        JTextField fieldVentaID = new JTextField(20);
        fieldVentaID.setBounds(80, 20, 50, 25);
        pVentaCaja.add(fieldVentaID);

        JLabel labelVentaCantidad = new JLabel("Cantidad:");
        labelVentaCantidad.setBounds(140, 18, 80, 25);
        pVentaCaja.add(labelVentaCantidad);

        JTextField fieldVentaCantidad = new JTextField(20);
        fieldVentaCantidad.setBounds(210, 20, 50, 25);
        pVentaCaja.add(fieldVentaCantidad);

        JLabel labelVentaCaja = new JLabel("Caja:");
        labelVentaCaja.setBounds(270, 18, 80, 25);
        pVentaCaja.add(labelVentaCaja);

        JTextField fieldVentaCaja = new JTextField(20);
        fieldVentaCaja.setBounds(310, 20, 50, 25);
        pVentaCaja.add(fieldVentaCaja);

        JButton botonAgregarArticulo = new JButton("Agregar");
        botonAgregarArticulo.setBounds(430, 20, 80, 20);
        pVentaCaja.add(botonAgregarArticulo);
        // Crea un modelo de tabla con su cabecera y matriz
        DefaultTableModel templateVentas = new DefaultTableModel();
        templateVentas.addColumn("ID");
        templateVentas.addColumn("NOMBRE");
        templateVentas.addColumn("PRECIO");
        templateVentas.addColumn("CANTIDAD");
        templateVentas.addColumn("DESCRIPCIÓN");
        templateVentas.addColumn("TOTAL");
        JTable tablaVentas = new JTable(templateVentas);
        JScrollPane scrollVentas = new JScrollPane(tablaVentas);
        scrollVentas.setBounds(50, 50, 500, 260);

        // Footer
        JLabel bottomConsultaVentas = new JLabel("Total: $");
        bottomConsultaVentas.setBounds(380, 315, 80, 20);
        pVentaCaja.add(bottomConsultaVentas);

        JLabel bottomConsultaVentasTotal = new JLabel("0");
        bottomConsultaVentasTotal.setBounds(430, 315, 80, 20);
        pVentaCaja.add(bottomConsultaVentasTotal);

        JButton botonVender = new JButton("Vender");
        botonVender.setBounds(280, 315, 80, 20);
        pVentaCaja.add(botonVender);
        // Agregandolo
        pVentaCaja.add(scrollVentas);

        /////////////////////// Ventas - Corte
        // Encabezado
        JLabel topVentaCorte = new JLabel("Productos");
        topVentaCorte.setBounds(10, 10, 80, 20);
        pVentaCorte.add(topVentaCorte);

        // Centro
        // Crea un modelo de tabla con su cabecera y matriz
        DefaultTableModel templateVentaCorte = new DefaultTableModel();
        templateVentaCorte.addColumn("NO. VENTA");
        templateVentaCorte.addColumn("CAJA");
        templateVentaCorte.addColumn("TOTAL DE LA VENTA");
        JTable tablaVentaCorte = new JTable(templateVentaCorte);
        JScrollPane scrollVentaCorte = new JScrollPane(tablaVentaCorte);
        scrollVentaCorte.setBounds(50, 35, 500, 260);

        // Panel de advertencias

        pVentaCorte.add(scrollVentaCorte);
        ////////////////////////////////////// ACIONES MENU SUPERIOR
        emp1_Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rfcJLabel.setVisible(true);
                rfc.setVisible(true);
                dirreccionJLabel.setVisible(true);
                direccion.setVisible(true);
                numJLabel.setVisible(true);
                num.setVisible(true);
                contrLabel.setVisible(true);
                textContraseña.setVisible(true);
                nombreLabel.setVisible(true);
                nombre.setVisible(true);

                botonAgregarEmp.setVisible(true);
                botonModificarEmp.setVisible(false);
                botonEliminarEmp.setVisible(false);
                pRegistroEmpleado.setVisible(true);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
            }
        });

        emp2_Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rfcJLabel.setVisible(true);
                rfc.setVisible(true);
                dirreccionJLabel.setVisible(true);
                direccion.setVisible(true);
                numJLabel.setVisible(true);
                num.setVisible(true);
                contrLabel.setVisible(true);
                textContraseña.setVisible(true);
                nombreLabel.setVisible(true);
                nombre.setVisible(true);

                botonAgregarEmp.setVisible(false);
                botonModificarEmp.setVisible(true);
                botonEliminarEmp.setVisible(false);
                pRegistroEmpleado.setVisible(true);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
            }
        });

        emp3_ConsultaGen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(true);
                botonConsultaID.setVisible(false);
                consultaID.setVisible(false);
                bottomConsultaEmpleado.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);

                templateEmpleados.setRowCount(0);
                for (empleado tempEmpleado : listaEmpleados) {
                    templateEmpleados
                            .addRow(new Object[] { tempEmpleado.getId(), tempEmpleado.getNom(), tempEmpleado.getDir(),
                                    tempEmpleado.getNum(), tempEmpleado.getRfc(), tempEmpleado.getContraseña() });
                }
            }
        });

        emp4_ConsultaID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(true);
                botonConsultaID.setVisible(true);
                consultaID.setVisible(true);
                bottomConsultaEmpleado.setVisible(true);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);

                templateEmpleados.setRowCount(0);
            }
        });

        emp5_Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rfcJLabel.setVisible(false);
                rfc.setVisible(false);
                dirreccionJLabel.setVisible(false);
                direccion.setVisible(false);
                numJLabel.setVisible(false);
                num.setVisible(false);
                contrLabel.setVisible(false);
                textContraseña.setVisible(false);
                nombreLabel.setVisible(false);
                nombre.setVisible(false);

                botonAgregarEmp.setVisible(false);
                botonModificarEmp.setVisible(false);
                botonEliminarEmp.setVisible(true);
                pRegistroEmpleado.setVisible(true);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
            }
        });

        pr1_Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelProductoCantidad.setVisible(true);
                labelProductoDescripcion.setVisible(true);
                labelProductoPrecio.setVisible(true);
                labelProductoNombre.setVisible(true);
                fieldProductoCantidad.setVisible(true);
                fieldProductoDescripcion.setVisible(true);
                fieldProductoPrecio.setVisible(true);
                fieldProductoNombre.setVisible(true);

                botonAgregarProducto.setVisible(true);
                botonModificarProducto.setVisible(false);
                botonEliminarProducto.setVisible(false);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(true);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
            }
        });

        pr2_Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelProductoCantidad.setVisible(true);
                labelProductoDescripcion.setVisible(true);
                labelProductoPrecio.setVisible(true);
                labelProductoNombre.setVisible(true);
                fieldProductoCantidad.setVisible(true);
                fieldProductoDescripcion.setVisible(true);
                fieldProductoPrecio.setVisible(true);
                fieldProductoNombre.setVisible(true);

                botonAgregarProducto.setVisible(false);
                botonModificarProducto.setVisible(true);
                botonEliminarProducto.setVisible(false);
                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(true);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);

            }
        });

        pr3_ConsultaGen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomConsultaProductos.setVisible(false);
                consultaProductoID.setVisible(false);
                botonConsultaProductoID.setVisible(false);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(true);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);

                templateProductos.setRowCount(0);
                for (producto tempProducto : listaProductos) {
                    templateProductos
                            .addRow(new Object[] { tempProducto.getId(), tempProducto.getNombre(),
                                    tempProducto.getPrecio(), tempProducto.getCantidad(),
                                    tempProducto.getDescripcion() });

                }
            }
        });

        pr4_ConsultaID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomConsultaProductos.setVisible(true);
                consultaProductoID.setVisible(true);
                botonConsultaProductoID.setVisible(true);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(true);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);

                templateProductos.setRowCount(0);
            }
        });

        pr5_Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelProductoCantidad.setVisible(false);
                labelProductoDescripcion.setVisible(false);
                labelProductoPrecio.setVisible(false);
                labelProductoNombre.setVisible(false);
                fieldProductoCantidad.setVisible(false);
                fieldProductoDescripcion.setVisible(false);
                fieldProductoPrecio.setVisible(false);
                fieldProductoNombre.setVisible(false);

                botonAgregarProducto.setVisible(false);
                botonModificarProducto.setVisible(false);
                botonEliminarProducto.setVisible(true);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(true);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
            }
        });

        v1_Caja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(true);
                pVentaCorte.setVisible(false);
            }
        });

        v2_VentasDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCorte.setVisible(true);
            }
        });
        ////////////////////////////////////// ACIONES DE BOTONES
        botonAgregarEmp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        try {
            String nombreEmpleado = nombre.getText();
            String direccionEmpleado = direccion.getText();
            String numeroEmpleado = num.getText();
            String rfcEmpleado = rfc.getText();
            String idEmpleado = id.getText();
            String contraseñaEmpleado = textContraseña.getText();

            if (nombreEmpleado.isEmpty() || direccionEmpleado.isEmpty() || numeroEmpleado.isEmpty() ||
                    rfcEmpleado.isEmpty() || idEmpleado.isEmpty() || contraseñaEmpleado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            for (empleado tempEmpleado : listaEmpleados) {
                if (tempEmpleado.getId().equals(idEmpleado)) {
                    JOptionPane.showMessageDialog(null, "El ID del empleado ya existe.", "Empleado repetido", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            listaEmpleados.add(new empleado(nombreEmpleado, direccionEmpleado, numeroEmpleado, rfcEmpleado, idEmpleado, contraseñaEmpleado));
            archivos.escribirArchivoEmpleados(listaEmpleados);

            JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            nombre.setText("");
            direccion.setText("");
            num.setText("");
            rfc.setText("");
            id.setText("");
            textContraseña.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar agregar el empleado. Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

        botonModificarEmp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String comparado = id.getText();
        boolean encontrado = false;

        try {
            for (empleado tempEmpleado : listaEmpleados) {
                if (tempEmpleado.getId().equals(comparado)) {
                    encontrado = true;
                    tempEmpleado.setDireccion(direccion.getText());
                    tempEmpleado.setNombre(nombre.getText());
                    tempEmpleado.setNumero(num.getText());
                    tempEmpleado.setContaseñaCaja(textContraseña.getText());
                    tempEmpleado.setRfc(rfc.getText());

                    System.out.println(tempEmpleado.getId());
                    break;
                }
            }

            if (encontrado) {
                archivos.escribirArchivoEmpleados(listaEmpleados);
                JOptionPane.showMessageDialog(null, "Empleado modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Empleado no encontrado", JOptionPane.WARNING_MESSAGE);
            }

            nombre.setText("");
            direccion.setText("");
            num.setText("");
            rfc.setText("");
            id.setText("");
            textContraseña.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});


        botonEliminarEmp.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String comparado = id.getText();
        boolean encontrado = false;
        int posicion = -1;

        try {
            for (empleado tempEmpleado : listaEmpleados) {
                if (tempEmpleado.getId().equals(comparado)) {
                    encontrado = true;
                    posicion = listaEmpleados.indexOf(tempEmpleado);
                    break;
                }
            }

            if (encontrado) {
                listaEmpleados.remove(posicion);
                archivos.escribirArchivoEmpleados(listaEmpleados);
                JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Empleado no encontrado", JOptionPane.WARNING_MESSAGE);
            }

            id.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

        botonConsultaID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                templateEmpleados.setRowCount(0);
                for (empleado tempEmpleado : listaEmpleados) {
                    if (tempEmpleado.getId().equals(consultaID.getText())) {
                        templateEmpleados
                                .addRow(new Object[] { tempEmpleado.getId(), tempEmpleado.getNom(),
                                        tempEmpleado.getDir(),
                                        tempEmpleado.getNum(), tempEmpleado.getRfc(), tempEmpleado.getContraseña() });
                    }
                }
                // TODO
            }
        });

        botonAgregarProducto.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String comparado = fieldProductoID.getText();
        boolean repetido = false;

        for (producto tempProducto : listaProductos) {
            if (tempProducto.getId().equals(comparado)) {
                repetido = true;
                break;
            }
        }

        if (!repetido) {
            try {
                String id = fieldProductoID.getText();
                String nombre = fieldProductoNombre.getText();
                double precio = Double.parseDouble(fieldProductoPrecio.getText());
                int cantidad = Integer.parseInt(fieldProductoCantidad.getText());
                String descripcion = fieldProductoDescripcion.getText();

                listaProductos.add(new producto(id, nombre, precio, cantidad, descripcion));

                archivos.escribirArchivoProuctos(listaProductos);

                JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error en los datos de entrada. Verifique los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Producto repetido, por favor ingrese otro.", "Error", JOptionPane.WARNING_MESSAGE);
        }

        fieldProductoID.setText("");
        fieldProductoNombre.setText("");
        fieldProductoPrecio.setText("");
        fieldProductoCantidad.setText("");
        fieldProductoDescripcion.setText("");
    }
});

        botonModificarProducto.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String comparado = fieldProductoID.getText();
        boolean repetido = false;
        for (producto tempProducto : listaProductos) {
            if (tempProducto.getId().equals(comparado)) {
                repetido = true;
                try {
                    tempProducto.setCantidad(Integer.parseInt(fieldProductoCantidad.getText()));
                    tempProducto.setDescripcion(fieldProductoDescripcion.getText());
                    tempProducto.setNombre(fieldProductoNombre.getText());
                    tempProducto.setPrecio(Double.parseDouble(fieldProductoPrecio.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos de entrada. Verifique los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                System.out.println(tempProducto.getId());
                break;
            }
        }

        if (repetido) {
            archivos.escribirArchivoProuctos(listaProductos);
            JOptionPane.showMessageDialog(null, "Producto modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("REPETIDO");
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado, por favor ingrese otro.", "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
        }

        fieldProductoID.setText("");
        fieldProductoNombre.setText("");
        fieldProductoPrecio.setText("");
        fieldProductoCantidad.setText("");
        fieldProductoDescripcion.setText("");
    }
});

        botonEliminarProducto.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String comparado = fieldProductoID.getText();
        boolean encontrado = false;
        int posicion = -1;

        try {
            for (producto tempProducto : listaProductos) {
                if (tempProducto.getId().equals(comparado)) {
                    encontrado = true;
                    posicion = listaProductos.indexOf(tempProducto);
                    break;
                }
            }

            if (encontrado) {
                listaProductos.remove(posicion);
                archivos.escribirArchivoProuctos(listaProductos);
                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado, por favor ingrese otro.", "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
                System.out.println("NO SE ELIMINO NADA");
            }

            fieldProductoID.setText("");
            fieldProductoNombre.setText("");
            fieldProductoPrecio.setText("");
            fieldProductoCantidad.setText("");
            fieldProductoDescripcion.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el producto. Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

        botonConsultaProductoID.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        templateProductos.setRowCount(0);

        try {
            String idConsulta = consultaProductoID.getText();
            for (producto tempProducto : listaProductos) {
                if (tempProducto.getId().equals(idConsulta)) {
                    templateProductos.addRow(new Object[] { tempProducto.getId(), tempProducto.getNombre(),
                            tempProducto.getPrecio(), tempProducto.getCantidad(), tempProducto.getDescripcion() });
                }
            }
            if (templateProductos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron productos con el ID especificado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar consultar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

        botonAgregarArticulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });

        botonVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });

        // TODO: botonAgregarEmp
        // TODO: botonModificarEmp
        // TODO: botonEliminarEmp
        // TODO: botonConsultaID
        // TODO: botonAgregarArticulo
        // TODO: botonVender

        // PRINCIPAL
        setJMenuBar(menuPrincipal);
        setVisible(true);
        add(pRegistroEmpleado);
        add(pConsultaEmpleados);
        add(pRegistroProducto);
        add(pConsultaProductos);
        add(pVentaCaja);
        add(pVentaCorte);

        // INVISIBLES
        pRegistroEmpleado.setVisible(false);
        pConsultaEmpleados.setVisible(false);
        pRegistroProducto.setVisible(false);
        pConsultaProductos.setVisible(false);
        pConsultaProductos.setVisible(false);
        pVentaCaja.setVisible(false);
        pVentaCorte.setVisible(false);

    }
}

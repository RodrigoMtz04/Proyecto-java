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
    private JPanel pReguistroClientes;
    private JPanel pConsultaClientes;
    private JPanel pVentaCaja;
    private JPanel pVentaCorte;
    private JTextField nombre, id, rfc, direccion, num, textContraseña, tipo;
    private ArrayList<empleado> listaEmpleados;
    private ArrayList<producto> listaProductos;
    private ArrayList<cliente> listaClientes;
    private ArrayList<ventas> listaVentas;
    private creadorArchivos archivos;
    double totalVenta = 0;

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

        pReguistroClientes = new JPanel();
        pReguistroClientes.setSize(600, 400);
        pReguistroClientes.setLayout(null);

        pConsultaClientes = new JPanel();
        pConsultaClientes.setSize(600, 400);
        pConsultaClientes.setLayout(null);

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

        JMenu Mclientes = new JMenu("Clientes");
        JMenuItem c1_Agregar = new JMenuItem("Agregar");
        JMenuItem c2_Modificar = new JMenuItem("Modificar");
        JMenuItem c3_ConsultaGen = new JMenuItem("Consulta general");
        JMenuItem c4_ConsultaID = new JMenuItem("Consulta por ID");
        JMenuItem c5_Eliminar = new JMenuItem("Eliminar");
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

        Mclientes.add(c1_Agregar);
        Mclientes.add(c2_Modificar);
        Mclientes.add(c3_ConsultaGen);
        Mclientes.add(c4_ConsultaID);
        Mclientes.add(c5_Eliminar);

        Mventas.add(v1_Caja);
        Mventas.add(v2_VentasDia);

        menuPrincipal.add(Mclientes);
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

        /////////////////////// Registro de Clientes
        JLabel labelClienteId = new JLabel("ID");
        labelClienteId.setBounds(10, 20, 80, 25);
        pReguistroClientes.add(labelClienteId);

        JTextField fieldClienteID = new JTextField(20);
        fieldClienteID.setBounds(100, 20, 165, 25);
        pReguistroClientes.add(fieldClienteID);

        JLabel labelClienteNombre = new JLabel("Nombre");
        labelClienteNombre.setBounds(10, 50, 80, 25);
        pReguistroClientes.add(labelClienteNombre);

        JTextField fieldClienteNombre = new JTextField(20);
        fieldClienteNombre.setBounds(100, 50, 165, 25);
        pReguistroClientes.add(fieldClienteNombre);

        JLabel labelClienteTipo = new JLabel("Tipo");
        labelClienteTipo.setBounds(10, 80, 80, 25);
        pReguistroClientes.add(labelClienteTipo);

        JLabel tipoJLabel = new JLabel("Tipo:");
        numJLabel.setBounds(10, 140, 80, 25);
        pReguistroClientes.add(tipoJLabel);

        tipo = new JTextField(20);
        tipo.setBounds(100, 140, 165, 25);
        pReguistroClientes.add(tipo);

        JTextField fieldClienteTipo = new JTextField(20);
        fieldClienteTipo.setBounds(100, 80, 165, 25);
        pReguistroClientes.add(fieldClienteTipo);

        JLabel labelClienteDireccion = new JLabel("Direccion");
        labelClienteDireccion.setBounds(10, 110, 80, 25);
        pReguistroClientes.add(labelClienteDireccion);

        JTextField fieldClienteDireccion = new JTextField(20);
        fieldClienteDireccion.setBounds(100, 110, 165, 25);
        pReguistroClientes.add(fieldClienteDireccion);

        JLabel labelClienteTelefono = new JLabel("Telefono");
        labelClienteTelefono.setBounds(10, 140, 80, 25);
        pReguistroClientes.add(labelClienteTelefono);

        JTextField fieldClienteTelefono = new JTextField(20);
        fieldClienteTelefono.setBounds(100, 140, 165, 25);
        pReguistroClientes.add(fieldClienteTelefono);

        JButton botonAgregarCliente = new JButton("Agregar");
        botonAgregarCliente.setBounds(10, 200, 80, 25);
        pReguistroClientes.add(botonAgregarCliente);

        JButton botonModificarCliente = new JButton("Modificar");
        botonModificarCliente.setBounds(10, 200, 80, 25);
        pReguistroClientes.add(botonModificarCliente);

        JButton botonConsultaClientes = new JButton("Consultar");
        botonConsultaClientes.setBounds(10, 200, 80, 25);
        pReguistroClientes.add(botonConsultaClientes);

        JButton botonEliminarCliente = new JButton("Eliminar");
        botonEliminarCliente.setBounds(10, 50, 80, 25);
        pReguistroClientes.add(botonEliminarCliente);

        /////////////////////// Consulta de Clientes
        // Encabezado
        JLabel topConsultaClientes = new JLabel("Clientes");
        topConsultaClientes.setBounds(10, 10, 80, 20);

        DefaultTableModel templateClientes = new DefaultTableModel();
        templateClientes.addColumn("ID");
        templateClientes.addColumn("NOMBRE");
        templateClientes.addColumn("TIPO");
        templateClientes.addColumn("DIRECCION");
        templateClientes.addColumn("TELEFONO");
        JTable tablaClientes = new JTable(templateClientes);
        JScrollPane scrollClientes = new JScrollPane(tablaClientes);
        scrollClientes.setBounds(50, 35, 500, 260);

        // Footer
        JLabel bottomConsultaClientes = new JLabel("Cliente:");
        bottomConsultaClientes.setBounds(10, 308, 80, 20);
        pReguistroClientes.add(bottomConsultaClientes);

        JTextField consultaClienteID = new JTextField(10);
        consultaClienteID.setBounds(90, 310, 300, 20);

        JButton botonConsultaClienteID = new JButton("Buscar");
        botonConsultaClienteID.setBounds(400, 310, 80, 20);

        // Agregandolo
        pConsultaClientes.add(topConsultaClientes);
        pConsultaClientes.add(scrollClientes);
        pConsultaClientes.add(bottomConsultaClientes);
        pConsultaClientes.add(consultaClienteID);
        pConsultaClientes.add(botonConsultaClienteID);

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
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(true);
            }
        });

        c1_Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelClienteDireccion.setVisible(true);
                labelClienteId.setVisible(true);
                labelClienteNombre.setVisible(true);
                labelClienteTelefono.setVisible(true);
                labelClienteTipo.setVisible(true);
                fieldClienteDireccion.setVisible(true);
                fieldClienteID.setVisible(true);
                fieldClienteNombre.setVisible(true);
                fieldClienteTelefono.setVisible(true);
                fieldClienteTipo.setVisible(true);

                botonAgregarCliente.setVisible(true);
                botonModificarCliente.setVisible(false);
                botonEliminarCliente.setVisible(false);
                botonConsultaClientes.setVisible(false);
                bottomConsultaClientes.setVisible(false);
                consultaClienteID.setVisible(false);
                botonConsultaClienteID.setVisible(false);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
                pReguistroClientes.setVisible(true);
                pConsultaClientes.setVisible(false);
            }
        });

        c2_Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelClienteDireccion.setVisible(true);
                labelClienteId.setVisible(true);
                labelClienteNombre.setVisible(true);
                labelClienteTelefono.setVisible(true);
                labelClienteTipo.setVisible(true);
                fieldClienteDireccion.setVisible(true);
                fieldClienteID.setVisible(true);
                fieldClienteNombre.setVisible(true);
                fieldClienteTelefono.setVisible(true);
                fieldClienteTipo.setVisible(true);

                botonAgregarCliente.setVisible(false);
                botonModificarCliente.setVisible(true);
                botonEliminarCliente.setVisible(false);
                botonConsultaClientes.setVisible(false);
                bottomConsultaClientes.setVisible(false);
                consultaClienteID.setVisible(false);
                botonConsultaClienteID.setVisible(false);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
                pReguistroClientes.setVisible(true);
                pConsultaClientes.setVisible(false);
            }
        });
//TODO: piche tabla
        c3_ConsultaGen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonConsultaClientes.setVisible(false);
                bottomConsultaClientes.setVisible(false);
                consultaClienteID.setVisible(false);
                botonConsultaClienteID.setVisible(false);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
                pReguistroClientes.setVisible(false);
                pConsultaClientes.setVisible(true);

                templateClientes.setRowCount(0);
                for (cliente tempCliente : listaClientes) {
                    templateClientes
                            .addRow(new Object[] { tempCliente.getId(), tempCliente.getNom(), tempCliente.getTipo(),
                                    tempCliente.getDir(), tempCliente.getNum() });
                }
            }
        });

        c4_ConsultaID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonConsultaClientes.setVisible(true);
                bottomConsultaClientes.setVisible(true);
                consultaClienteID.setVisible(true);
                botonConsultaClienteID.setVisible(true);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
                pReguistroClientes.setVisible(false);
                pConsultaClientes.setVisible(true);

                templateClientes.setRowCount(0);
            }
        });

        c5_Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelClienteDireccion.setVisible(false);
                labelClienteId.setVisible(false);
                labelClienteNombre.setVisible(false);
                labelClienteTelefono.setVisible(false);
                labelClienteTipo.setVisible(false);
                fieldClienteDireccion.setVisible(false);
                fieldClienteID.setVisible(false);
                fieldClienteNombre.setVisible(false);
                fieldClienteTelefono.setVisible(false);
                fieldClienteTipo.setVisible(false);

                botonAgregarCliente.setVisible(false);
                botonModificarCliente.setVisible(false);
                botonEliminarCliente.setVisible(true);
                botonConsultaClientes.setVisible(false);
                bottomConsultaClientes.setVisible(false);
                consultaClienteID.setVisible(false);
                botonConsultaClienteID.setVisible(false);

                pRegistroEmpleado.setVisible(false);
                pConsultaEmpleados.setVisible(false);
                pRegistroProducto.setVisible(false);
                pConsultaProductos.setVisible(false);
                pVentaCaja.setVisible(false);
                pVentaCorte.setVisible(false);
                pReguistroClientes.setVisible(true);
                pConsultaClientes.setVisible(false);
            }
        });

        ////////////////////////////////////// ACIONES DE BOTONES
        botonAgregarEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String comparado = id.getText();
                boolean repetido = false;
                for (empleado tempEmpleado : listaEmpleados) {
                    if (tempEmpleado.getId().equals(comparado)) {
                        repetido = true;
                        break;
                    }
                }
                if (!repetido) {
                    listaEmpleados.add(new empleado(nombre.getText(), direccion.getText(), num.getText(), rfc.getText(),
                            id.getText(), textContraseña.getText()));
                    archivos.escribirArchivoEmpleados(listaEmpleados);
                    JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.",
                            "Empleado agregado", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Ya hay un empleado con este ID.",
                            "ID repetido", JOptionPane.ERROR_MESSAGE);
                }
                nombre.setText("");
                direccion.setText("");
                num.setText("");
                rfc.setText("");
                id.setText("");
                textContraseña.setText("");
            }
        });

        botonModificarEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String comparado = id.getText();
                boolean repetido = false;
                for (empleado tempEmpleado : listaEmpleados) {
                    if (tempEmpleado.getId().equals(comparado)) {
                        repetido = true;
                        tempEmpleado.setDireccion(direccion.getText());
                        tempEmpleado.setNombre(nombre.getText());
                        tempEmpleado.setNumero(num.getText());
                        tempEmpleado.setContaseñaCaja(textContraseña.getText());
                        tempEmpleado.setRfc(rfc.getText());

                        System.out.println(tempEmpleado.getId());
                        break;
                    }
                }
                if (repetido) {
                    archivos.escribirArchivoEmpleados(listaEmpleados);
                    JOptionPane.showMessageDialog(null, "Empleado modificado correctamente.",
                            "Modificacion empleado", JOptionPane.WARNING_MESSAGE);
                }
                nombre.setText("");
                direccion.setText("");
                num.setText("");
                rfc.setText("");
                id.setText("");
                textContraseña.setText("");
            }
        });

        botonEliminarEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String comparado = id.getText();
                boolean repetido = false;
                int posicion = -1;

                for (empleado tempEmpleado : listaEmpleados) {
                    if (tempEmpleado.getId().equals(comparado)) {
                        repetido = true;
                        posicion = listaEmpleados.indexOf(tempEmpleado);
                        break;
                    }
                }
                if (repetido) {
                    listaEmpleados.remove(posicion);
                    archivos.escribirArchivoEmpleados(listaEmpleados);
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.",
                            "Empleado eliminado", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro a un empleado con este ID.",
                            "Eliminacion fallida", JOptionPane.ERROR_MESSAGE);
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
                    listaProductos.add(new producto(fieldProductoID.getText(), fieldProductoNombre.getText(),
                            Double.parseDouble(fieldProductoPrecio.getText()),
                            Integer.parseInt(fieldProductoCantidad.getText()), fieldProductoDescripcion.getText()));
                    archivos.escribirArchivoProuctos(listaProductos);
                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente.",
                            "Producto agregado", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Ya hay un producto con este ID.",
                            "ID repetido", JOptionPane.ERROR_MESSAGE);
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
                            JOptionPane.showMessageDialog(null,
                                    "Error en los datos de entrada. Verifique los campos numéricos.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        System.out.println(tempProducto.getId());
                        break;
                    }
                }

                if (repetido) {
                    archivos.escribirArchivoProuctos(listaProductos);
                    JOptionPane.showMessageDialog(null, "Producto modificado exitosamente.", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("REPETIDO");
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado, por favor ingrese otro.",
                            "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
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
                boolean repetido = false;
                int posicion = -1;

                for (producto tempProducto : listaProductos) {
                    if (tempProducto.getId().equals(comparado)) {
                        repetido = true;
                        posicion = listaProductos.indexOf(tempProducto);
                        break;
                    }
                }
                if (repetido) {
                    listaProductos.remove(posicion);
                    archivos.escribirArchivoProuctos(listaProductos);
                    JOptionPane.showMessageDialog(null, "Producto elimindo correctamente",
                            "Producto eliminado", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro a un producto con este ID",
                            "Eliminacion fallida", JOptionPane.WARNING_MESSAGE);
                }
                fieldProductoID.setText("");
            }
        });

        botonConsultaProductoID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                templateProductos.setRowCount(0);
                boolean repetido = false;
                for (producto tempProducto : listaProductos) {
                    if (tempProducto.getId().equals(consultaProductoID.getText())) {
                        repetido = true;
                        templateProductos
                                .addRow(new Object[] { tempProducto.getId(), tempProducto.getNombre(),
                                        tempProducto.getPrecio(), tempProducto.getCantidad(),
                                        tempProducto.getDescripcion() });
                    }
                }
                if (repetido) {

                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado, por favor ingrese otro.",
                            "Producto no encontrado", JOptionPane.WARNING_MESSAGE);

                }

            }
        });

        botonAgregarArticulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean encontrado = false;
                for (producto tempProducto : listaProductos) {
                    if (tempProducto.getId().equals(fieldVentaID.getText())) {
                        if (tempProducto.getCantidad() > Integer.parseInt(fieldVentaCantidad.getText())) {

                            templateVentas
                                    .addRow(new Object[] { tempProducto.getId(), tempProducto.getNombre(),
                                            tempProducto.getPrecio(), fieldVentaCantidad.getText(),
                                            tempProducto.getDescripcion() });
                            totalVenta = totalVenta + tempProducto.getPrecio();
                            System.out.println(totalVenta);
                            bottomConsultaVentasTotal.setText(String.format("%.2f", totalVenta));
                        } else {
                            JOptionPane.showMessageDialog(null, "Cantidad del producto superior a la actual.",
                                    "No stock", JOptionPane.WARNING_MESSAGE);
                        }
                        encontrado = true;
                    }

                }

                if (encontrado) {

                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado, por favor ingrese otro.",
                            "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
                }
                fieldVentaCaja.setText("");
                fieldVentaCantidad.setText("");
                fieldVentaID.setText("");
                // TODO
            }
        });

        botonVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // TODO

            }
        });

        // TODO: botonAgregarCliente
        botonAgregarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String comparado = fieldClienteID.getText();
                boolean repetido = false;
                for (cliente tempCliente : listaClientes) {
                    if (tempCliente.getId().equals(comparado)) {
                        repetido = true;
                        break;
                    }
                }
                if (!repetido) {
                    listaClientes.add(new cliente(fieldClienteNombre.getText(), fieldClienteDireccion.getText(), fieldClienteTelefono.getText(), tipo.getText(), fieldClienteID.getText()));
                    archivos.escribirArchivoClientes(listaClientes);
                    JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.",
                            "Cliente agregado", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Ya hay un cliente con este ID.",
                            "ID repetido", JOptionPane.ERROR_MESSAGE);
                }
                fieldClienteNombre.setText("");
                fieldClienteDireccion.setText("");
                fieldClienteTelefono.setText("");
                fieldClienteTipo.setText("");
                fieldClienteID.setText("");
            }
        });

        // TODO: botonModificarCliente
        botonModificarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for modifying an existing client
            }
        });

        // TODO: botonEliminarCliente
        botonEliminarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for deleting an existing client
            }
        });

        // TODO: botonConsultaClientes
        botonConsultaClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for querying clients
            }
        });

        // TODO: botonAgregarEmp
        // TODO: botonModificarEmp
        // TODO: botonEliminarEmp
        // TODO: botonConsultaID
        // TODO: botonAgregarProducto
        // TODO: botonModificarProducto
        // TODO: botonEliminarProducto
        // TODO: botonConsultaProductoID
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
        add(pReguistroClientes);
        add(pConsultaClientes);

        // INVISIBLES
        pRegistroEmpleado.setVisible(false);
        pConsultaEmpleados.setVisible(false);
        pRegistroProducto.setVisible(false);
        pConsultaProductos.setVisible(false);
        pConsultaProductos.setVisible(false);
        pVentaCaja.setVisible(false);
        pVentaCorte.setVisible(false);
        pReguistroClientes.setVisible(false);
        pConsultaClientes.setVisible(false);

    }
}

package interfaz;

import clases.Administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazAdministrador extends JFrame implements ActionListener {
    private JButton btn_salir;
    JButton botonActualizarDoctor, botonRegistroDoctor, botonEliminarDoctor, botonRegistroPaciente, botonActualizarPaciente, botonEliminarPaciente, botonCrearProducto, botonActualizarProducto, botonEliminarProducto;
    public InterfazAdministrador(int pestaña) {

        initComponents();
        JTabbedPane tabbedPane = (JTabbedPane) getContentPane().getComponent(0);
        tabbedPane.setSelectedIndex(pestaña);
    }

    private void initComponents() {
        // Crear un objeto JTabbedPane para gestionar pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);



        //Crear tres panales para las pestañas
        JPanel pest1 = new JPanel(null); //Se coloca null para tener control en la posicion de los elemntos en la pestaña
        JPanel pest2 = new JPanel(null);
        JPanel pest3 = new JPanel(null);

        // Agregar los paneles a las pestañas del JTabbedPane
        tabbedPane.addTab("Doctores", pest1);
        tabbedPane.addTab("Pacientes", pest2);
        tabbedPane.addTab("Productos", pest3);

        // Establecer color de fondo para la primera pestaña (Doctores)
        //tabbedPane.setBackgroundAt(0,new Color(222, 144, 53 ));

        // Establecer color de fondo para la segunda pestaña (Pacientes)
        //tabbedPane.setBackgroundAt(1, new Color(222, 144, 53 ));

        // Establecer color de fondo para la tercera pestaña (Productos)
        //tabbedPane.setBackgroundAt(2, new Color(222, 144, 53 ));


        //====================Color de Fondo para cada pestaña====================
        pest1.setBackground(new Color(237, 238, 123));
        pest2.setBackground(new Color(237, 238, 123));
        pest3.setBackground(new Color(237, 238, 123));


        //===========================Creacion de Botones Doctor============================
        botonRegistroDoctor = new JButton("Crear");
        botonRegistroDoctor.setBounds(800, 25, 180, 50);
        botonRegistroDoctor.setVisible(true);
        botonRegistroDoctor.setEnabled(true);
        botonRegistroDoctor.addActionListener(this);
        pest1.add(botonRegistroDoctor);


        botonActualizarDoctor = new JButton("Actualizar Doctor");
        botonActualizarDoctor.setBounds(1000, 25, 180, 50);
        botonActualizarDoctor.setVisible(true);
        botonActualizarDoctor.addActionListener(this);
        pest1.add(botonActualizarDoctor);

        botonEliminarDoctor = new JButton("Eliminar Doctor");
        botonEliminarDoctor.setBounds(900, 85, 180, 50);
        botonEliminarDoctor.setVisible(true);
        botonEliminarDoctor.addActionListener(this);
        pest1.add(botonEliminarDoctor);


        //=======================Creacion de Botones Paciente============================

        botonRegistroPaciente = new JButton("Crear Paciente");
        botonRegistroPaciente.setBounds(800, 25, 180, 50);
        botonRegistroPaciente.setVisible(true);
        botonRegistroPaciente.setEnabled(true);
        botonRegistroPaciente.addActionListener(this);
        pest2.add(botonRegistroPaciente);


        botonActualizarPaciente = new JButton("Actualizar Paciente");
        botonActualizarPaciente.setBounds(1000, 25, 180, 50);
        botonActualizarPaciente.setVisible(true);
        botonActualizarPaciente.addActionListener(this);
        pest2.add(botonActualizarPaciente);

        botonEliminarPaciente = new JButton("Eliminar Paciente");
        botonEliminarPaciente.setBounds(900, 85, 180, 50);
        botonEliminarPaciente.setVisible(true);
        botonEliminarPaciente.addActionListener(this);
        pest2.add(botonEliminarPaciente);

        //=======================Creacion de Botones Productos============================

        botonCrearProducto = new JButton("Crear Producto");
        botonCrearProducto.setBounds(800, 25, 180, 50);
        botonCrearProducto.setVisible(true);
        botonCrearProducto.setEnabled(true);
        botonCrearProducto.addActionListener(this);
        pest3.add(botonCrearProducto);


        botonActualizarProducto = new JButton("Actualizar Producto");
        botonActualizarProducto.setBounds(1000, 25, 180, 50);
        botonActualizarProducto.setVisible(true);
        botonActualizarProducto.addActionListener(this);
        pest3.add(botonActualizarProducto);

        botonEliminarProducto = new JButton("Eliminar Producto");
        botonEliminarProducto.setBounds(900, 85, 180, 50);
        botonEliminarProducto.setVisible(true);
        botonEliminarProducto.addActionListener(this);
        pest3.add(botonEliminarProducto);


        //===========================Pestaña 1============================
        // Titulo
        // Crear un nuevo JLabel con el texto "Listado Oficial"
        JLabel lbl1 = new JLabel("Listado de doctores");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl1.setBounds(25, 25, 750, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como Amarillo Claro
        lbl1.setBackground(new Color(237, 238, 123));
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl1.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl1.setFont(new Font(lbl1.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl1.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        pest1.add(lbl1);

        //Tabla
        // Crear un modelo de tabla y agregar datos de ejemplo
        String[] columnsNames = {"Codigo", "Nombre", "Apellido", "Género", "Edad", "Especialidad", "Teléfono"};
        // Crear una instancia de JTable con los datos y nombres de columna
        JTable tablaDoctores = new JTable(Administrador.datosDoctoresTabla(), columnsNames);

        // Crear un JScrollPane para la tabla (permite desplazarse por la tabla si es necesario)
        JScrollPane scrollPane = new JScrollPane(tablaDoctores);

        scrollPane.setBounds(25, 80, 750, 570);

        pest1.add(scrollPane);

        //===========================Pestaña 2============================
        // Titulo
        // Crear un nuevo JLabel con el texto "Listado Oficial"
        JLabel lbl2 = new JLabel("Lista de Pacientes");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl2.setBounds(25, 25, 750, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como Amarillo Claro
        lbl2.setBackground(new Color(237, 238, 123));
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl2.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl2.setVerticalAlignment(SwingConstants.CENTER);
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl2.setFont(new Font(lbl2.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl2.setVisible(true);
        pest2.add(lbl2);

        String[] columnsNames1 = {"Codigo", "Nombre", "Apellido", "Edad", "Genero"};
        // Crear una instancia de JTable con los datos y nombres de columna
        JTable table_Pacientes = new JTable(Administrador.datosPacientesTabla(), columnsNames1);

        // Crear un JScrollPane para la tabla (permite desplazarse por la tabla si es necesario)
        JScrollPane scrollPane1 = new JScrollPane(table_Pacientes);

        scrollPane1.setBounds(25, 80, 750, 570);

        pest2.add(scrollPane1);


        //===========================Pestaña 3============================

        // Titulo
        // Crear un nuevo JLabel con el texto "Listado Oficial"
        JLabel lbl3 = new JLabel("Lista de Productos");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl3.setBounds(25, 25, 750, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como Amarillo Claro
        lbl3.setBackground(new Color(237, 238, 123));
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl3.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl3.setVerticalAlignment(SwingConstants.CENTER);
        lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl3.setFont(new Font(lbl3.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl3.setVisible(true);
        pest3.add(lbl3);

        String[] columnsNames2 = {"Codigo", "Nombre", "Cantidad", "Descripción", "Precio"};
        // Crear una instancia de JTable con los datos y nombres de columna
        JTable table_Productos = new JTable(Administrador.datosProductosTabla(), columnsNames2);

        // Crear un JScrollPane para la tabla (permite desplazarse por la tabla si es necesario)
        JScrollPane scrollPane2 = new JScrollPane(table_Productos);

        scrollPane2.setBounds(25, 80, 750, 570);

        pest3.add(scrollPane2);



        //==================================================================================0
        // Agregar el JTabbedPane al contenido del JFrame
        getContentPane().add(tabbedPane);


        //------------Creando JFrame------------------
        this.setExtendedState(MAXIMIZED_BOTH);  // Hacer que la ventana se abra maximizada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        this.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño de la ventana
        this.setVisible(true); // Hacer la ventana visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonActualizarDoctor){
            JOptionPane.showMessageDialog(this, "Actualizar Doctor");
        }
        else if (e.getSource() == botonRegistroDoctor){
            InterfazRegistroDoctor interfazRegistroDoctor = new InterfazRegistroDoctor();
            this.dispose();
        }
        else if (e.getSource() == botonEliminarDoctor){
            JOptionPane.showMessageDialog(this, "Eliminar Doctor");
        }
        else if (e.getSource() == botonRegistroPaciente){
            InterfazRegistroPaciente interfazRegistroPaciente = new InterfazRegistroPaciente();
            this.dispose();
        }
        else if (e.getSource() == botonActualizarPaciente){
            JOptionPane.showMessageDialog(this, "Actualizar Paciente");
        }
        else if (e.getSource() == botonEliminarPaciente){
            JOptionPane.showMessageDialog(this, "Eliminar Paciente");
        }
        else if (e.getSource()== botonCrearProducto) {
            InterfazRegistroProductos interfazCrearProductos = new InterfazRegistroProductos();
            this.dispose();
        }


    }
}
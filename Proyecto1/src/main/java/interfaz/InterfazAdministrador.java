package interfaz;

import org.example.Main;

import javax.swing.*;
import java.awt.*;

public class InterfazAdministrador extends JFrame {
    private JTabbedPane tabbedPane;
    private JButton btn_salir, btnRegistro;

    public InterfazAdministrador() {
        initComponents();
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

        //===========================Pestaña Doctores============================00
        //Botones
        //Registro
        btnRegistro = new JButton("Crear");
        btnRegistro.setBounds(800, 25, 180, 50);
        btnRegistro.setVisible(true);
        btnRegistro.setEnabled(true);
        pest1.add(btnRegistro);
        btnRegistro.addActionListener(e -> {
            if (e.getSource() == btnRegistro){
                //JOptionPane.showMessageDialog(this, "Inicio de Sesión Correcto");
                InterfazRegistroDoctor nuevoDoctor = new InterfazRegistroDoctor();


            }
            else {

            }


        });


        //Salir
        btn_salir = new JButton("Salir");
        btn_salir.setBounds(1000, 25, 180, 50);
        btn_salir.setVisible(true);
        pest1.add(btn_salir);
        btn_salir.addActionListener(e -> {
            if (e.getSource() == btn_salir){
                this.dispose();
                Login regresarLogin = new Login();

            }
        });


        // Titulo
        // Crear un nuevo JLabel con el texto "Listado Oficial"
        JLabel lbl4 = new JLabel("Listado de doctores");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl4.setBounds(25, 25, 750, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como GRIS CLARO
        lbl4.setBackground(Color.LIGHT_GRAY);
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl4.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl4.setVerticalAlignment(SwingConstants.CENTER);
        lbl4.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl4.setFont(new Font(lbl4.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl4.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        pest1.add(lbl4);

        //Tabla
        // Crear un modelo de tabla y agregar datos de ejemplo
        String[] columnsNames = {"Codigo", "Nombre", "Apellido", "Género", "Edad", "Especialidad", "Teléfono"};
        // Crear una instancia de JTable con los datos y nombres de columna
        JTable tablaDoctores = new JTable(Main.datosDoctoresTabla(), columnsNames);

        // Crear un JScrollPane para la tabla (permite desplazarse por la tabla si es necesario)
        JScrollPane scrollPane = new JScrollPane(tablaDoctores);

        scrollPane.setBounds(25, 80, 750, 570);

        pest1.add(scrollPane);

        //===========================Pestaña 2============================
        JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 100, 30);
        pest2.add(titleLabel);

        //==================================================================================0
        // Agregar el JTabbedPane al contenido del JFrame
        getContentPane().add(tabbedPane);


        //------------Creando JFrame------------------
        this.setExtendedState(MAXIMIZED_BOTH);  // Hacer que la ventana se abra maximizada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        this.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño de la ventana
        this.setVisible(true); // Hacer la ventana visible

    }
}

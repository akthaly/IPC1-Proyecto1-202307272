package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazModuloDoctor extends JFrame implements ActionListener{
    JButton botonEditarPerfil, botonMostrarDoctores, botonMostrarHorarios, boton;
    JComboBox<String> listaEspecialidad, listaDoctor, listaFecha, listaHora;

    public InterfazModuloDoctor(int pestaña) {

        initComponents();
        JTabbedPane tabbedPane = (JTabbedPane) getContentPane().getComponent(0);
        tabbedPane.setSelectedIndex(pestaña);
    }

    public void initComponents(){
        // Crear un objeto JTabbedPane para gestionar pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);



        //Crear tres panales para las pestañas
        JPanel pest1 = new JPanel(null); //Se coloca null para tener control en la posicion de los elemntos en la pestaña
        JPanel pest2 = new JPanel(null);


        // Agregar los paneles a las pestañas del JTabbedPane
        tabbedPane.addTab("Citas", pest1);
        tabbedPane.addTab("Asignar horario", pest2);


        //====================Color de Fondo para cada pestaña====================
        pest1.setBackground(new Color(96, 229, 142));
        pest2.setBackground(new Color(96, 229, 142));



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
        // Estable el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl1.setFont(new Font(lbl1.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl1.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        pest1.add(lbl1);

        //=====================================FALTAN PESTAÑAS=================================0

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

    }
}

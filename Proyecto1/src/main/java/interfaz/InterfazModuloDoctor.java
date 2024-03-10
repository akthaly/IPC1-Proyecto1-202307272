package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazModuloDoctor extends JFrame implements ActionListener{
    JButton botonCerrarSesion1, botonCerrarSesion2,botonEditarPerfil, botonMostrarDoctores, botonMostrarHorarios, boton;

    public InterfazModuloDoctor(int pestaña) {

        initComponents();
        JTabbedPane tabbedPane = (JTabbedPane) getContentPane().getComponent(0);
        tabbedPane.setSelectedIndex(pestaña);
    }

    public void initComponents() {
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

        //=======================Creacion de Botones Cerrar Sesión======================
        botonCerrarSesion1 = new JButton("Cerrar Sesion");
        botonCerrarSesion1.setBounds(1125, 600, 150, 30);
        botonCerrarSesion1.setVisible(true);
        botonCerrarSesion1.setEnabled(true);
        botonCerrarSesion1.addActionListener(this);
        pest1.add(botonCerrarSesion1);

        botonCerrarSesion2 = new JButton("Cerrar Sesion");
        botonCerrarSesion2.setBounds(1125, 600, 150, 30);
        botonCerrarSesion2.setVisible(true);
        botonCerrarSesion2.setEnabled(true);
        botonCerrarSesion2.addActionListener(this);
        pest2.add(botonCerrarSesion2);



        //===========================Pestaña 1============================
        JLabel lbl1 = new JLabel("Listado de doctores");

        lbl1.setBounds(25, 25, 750, 50);
        lbl1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        lbl1.setBackground(new Color(237, 238, 123));
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font(lbl1.getFont().getFontName(), Font.BOLD, 24));
        lbl1.setVisible(true);
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
        if (e.getSource()==botonCerrarSesion1 || e.getSource()==botonCerrarSesion2){
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }

    }
}

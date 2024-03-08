package interfaz;

import clases.Administrador;
import clases.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazRegistrarNuevoPaciente extends JFrame implements ActionListener {
    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField contrasenaField;
    private JTextField edadField;
    private JComboBox<String> generoComboBox;

    JButton botonRegistroAdministrador;

    public InterfazRegistrarNuevoPaciente(){

        initComponents();
    }

    public void initComponents(){

        this.setTitle("Registro");
        this.setBounds(50, 400, 400, 350);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(53, 214, 222 ));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Registrarse");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(140, 10, 120, 30);
        this.add(titleLabel);

        JLabel nombresLabel = new JLabel("Nombres:");
        nombresLabel.setBounds(35, 50, 80, 25);
        nombresLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.add(nombresLabel);

        nombresField = new JTextField();
        nombresField.setBounds(130, 50, 170, 25);
        this.add(nombresField);

        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosLabel.setBounds(35, 90, 80, 25);
        apellidosLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.add(apellidosLabel);

        apellidosField = new JTextField();
        apellidosField.setBounds(130, 90, 170, 25);
        this.add(apellidosField);

        JLabel contraseñaLabel = new JLabel("Contraseña:");
        contraseñaLabel.setBounds(35, 130, 85, 25);
        contraseñaLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.add(contraseñaLabel);

        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(130, 130, 170, 25);
        this.add(contrasenaField);

        JLabel generosLabel = new JLabel("Genero:");
        generosLabel.setBounds(35, 170, 80, 25);
        generosLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.add(generosLabel);

        String[] generos = {"Masculino", "Femenino"};
        generoComboBox = new JComboBox<>(generos);
        generoComboBox.setBounds(130, 170, 170, 25);
        this.add(generoComboBox);

        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(35, 210, 80, 25);
        edadLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.add(edadLabel);

        edadField = new JTextField();
        edadField.setBounds(130, 210, 170, 25);
        this.add(edadField);

        botonRegistroAdministrador = new JButton("Registrar");
        botonRegistroAdministrador.setBounds(130, 250, 115, 25);
        botonRegistroAdministrador.setForeground(Color.BLACK);
        botonRegistroAdministrador.setFont(new Font("MV Boli", Font.PLAIN, 15));
        botonRegistroAdministrador.setBackground(new Color(147, 255, 183));
        this.add(botonRegistroAdministrador);
        botonRegistroAdministrador.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistroAdministrador){
            String nombres = nombresField.getText();
            String apellidos = apellidosField.getText();
            String contrasena = contrasenaField.getText();
            String edad = edadField.getText();
            String genero = (String) generoComboBox.getSelectedItem();
            String codigoPaciente = Usuario.codigoGeneral;
            Administrador.agregarPacientes(Usuario.codigoGeneral, contrasena, nombres, apellidos, edad, genero);
            int codigoEntero= Integer.parseInt(Usuario.codigoGeneral);
            codigoEntero++;
            Usuario.codigoGeneral=String.format("%04d", codigoEntero);
            this.dispose();
            InterfazCodigoPacienteLogin interfazCodigoPacienteLogin = new InterfazCodigoPacienteLogin(codigoPaciente);

    }
}
}

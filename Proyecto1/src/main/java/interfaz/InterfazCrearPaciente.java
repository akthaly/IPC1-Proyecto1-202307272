package interfaz;

import clases.Administrador;
import clases.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearPaciente extends JFrame implements ActionListener {

    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField contrasenaField;
    private JTextField edadField;
    private JComboBox<String> genderComboBox;

    JButton botonRegistro;

    public InterfazCrearPaciente(){

        initComponents();
    }
    public void initComponents(){

        this.setTitle("Registro de Pacientes");
        this.setBounds(650, 400, 400, 350);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(237, 238, 123));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Registro de Pacientes");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(100, 10, 300, 30);
        this.add(titleLabel);

        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(45, 50, 80, 25);
        this.add(firstNameLabel);

        nombresField = new JTextField();
        nombresField.setBounds(125, 50, 150, 25);
        this.add(nombresField);

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(45, 90, 80, 25);
        this.add(lastNameLabel);

        apellidosField = new JTextField();
        apellidosField.setBounds(125, 90, 150, 25);
        this.add(apellidosField);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(45, 130, 80, 25);
        this.add(contrasenaLabel);

        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(125, 130, 150, 25);
        this.add(contrasenaField);

        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(45, 170, 80, 25);
        this.add(edadLabel);

        edadField = new JTextField();
        edadField.setBounds(125, 170, 150, 25);
        this.add(edadField);

        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(45, 210, 80, 25);
        this.add(genderLabel);

        String[] genderos = {"Masculino", "Femenino"};
        genderComboBox = new JComboBox<>(genderos);
        genderComboBox.setBounds(125, 210, 150, 25);
        this.add(genderComboBox);

        botonRegistro = new JButton("Registrar");
        botonRegistro.setBounds(125, 250, 150, 25);
        botonRegistro.setForeground(Color.BLACK);
        botonRegistro.setFont(new Font("MV Boli", Font.PLAIN, 18));
        botonRegistro.setBackground(new Color(147, 255, 183));
        this.add(botonRegistro);
        botonRegistro.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistro){
            String nombres = nombresField.getText();
            String apellidos = apellidosField.getText();
            String contrasena = contrasenaField.getText();
            String edad = edadField.getText();
            String genero = (String) genderComboBox.getSelectedItem();
            String codigoPaciente = Usuario.codigoGeneral;
            Administrador.agregarPacientes(Usuario.codigoGeneral, contrasena, nombres, apellidos, edad, genero);
            int codigoEntero= Integer.parseInt(Usuario.codigoGeneral);
            codigoEntero++;
            Usuario.codigoGeneral=String.format("%04d", codigoEntero);
            InterfazCodigoPaciente interfazCodigo = new InterfazCodigoPaciente(codigoPaciente);
            this.dispose();
        }
    }
}

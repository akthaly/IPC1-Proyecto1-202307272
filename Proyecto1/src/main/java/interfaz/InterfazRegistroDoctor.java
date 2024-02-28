package interfaz;

import clases.Administrador;
import clases.Doctor;

import javax.swing.*;
import java.awt.*;

public class InterfazRegistroDoctor extends JFrame{

    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField contrasenaField;
    private JTextField especialidadField;
    private JTextField telefonoField;
    private JTextField edadField;
    private JComboBox<String> genderComboBox;

    JButton registerButton;

    public InterfazRegistroDoctor(){

        initComponents();
    }
    public void initComponents(){

        this.setTitle("Registro de Doctores");
        this.setBounds(650, 400, 650, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Registro de Doctores");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 300, 30);
        this.add(titleLabel);

        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(70, 50, 80, 25);
        this.add(firstNameLabel);

        nombresField = new JTextField();
        nombresField.setBounds(130, 50, 170, 25);
        this.add(nombresField);

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(70, 90, 80, 25);
        this.add(lastNameLabel);

        apellidosField = new JTextField();
        apellidosField.setBounds(130, 90, 170, 25);
        this.add(apellidosField);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(50, 130, 80, 25);
        this.add(contrasenaLabel);

        contrasenaField = new JTextField();
        contrasenaField.setBounds(130, 130, 170, 25);
        this.add(contrasenaField);


        JLabel especialidadLabel = new JLabel("Especialidad:");
        especialidadLabel.setBounds(350, 50, 80, 25);
        this.add(especialidadLabel);

        especialidadField = new JTextField();
        especialidadField.setBounds(430, 50, 170, 25);
        this.add(especialidadField);

        JLabel telefonoLabel = new JLabel("Telefono:");
        telefonoLabel.setBounds(370, 90, 80, 25);
        this.add(telefonoLabel);

        telefonoField = new JTextField();
        telefonoField.setBounds(430, 90, 170, 25);
        this.add(telefonoField);

        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(390, 130, 80, 25);
        this.add(edadLabel);

        edadField = new JTextField();
        edadField.setBounds(430, 130, 170, 25);
        this.add(edadField);

        JLabel codigoLabel = new JLabel("Codigo:");
        codigoLabel.setBounds(390, 170, 80, 25);
        this.add(codigoLabel);

        /*codigoField = new JTextField();
        codigoField.setBounds(430, 170, 170, 25);
        this.add(codigoField);*/

        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(80, 170, 80, 25);
        this.add(genderLabel);

        String[] genders = {"Masculino", "Femenino"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(130, 170, 150, 25);
        this.add(genderComboBox);



        registerButton = new JButton("Registrar");
        registerButton.setBounds(180, 220, 150, 25);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(214, 225, 50));
        this.add(registerButton);
        registerButton.addActionListener(e -> {

            if (e.getSource() == registerButton){
                String nombres = nombresField.getText();
                String apellidos = apellidosField.getText();
                String contrasena = contrasenaField.getText();
                String especialidad = especialidadField.getText();
                String telefono = telefonoField.getText();
                String edad = edadField.getText();
                String genero = (String) genderComboBox.getSelectedItem();
                Administrador.agregarDoctores(Doctor.codigo, contrasena, nombres, apellidos, especialidad, genero, telefono, edad);
                int codigoEntero= Integer.parseInt(Doctor.codigo);
                codigoEntero++;
                Doctor.codigo=String.format("%04d", codigoEntero);
                this.dispose();

                InterfazAdministrador ventanaAdministrador = new InterfazAdministrador();



            }
            else{
                System.out.println("no se pudo registrar");
            }
        });


    }

}

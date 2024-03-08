package interfaz;

import clases.Administrador;
import clases.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazActualizarDoctor extends JFrame implements ActionListener {

        public JTextField nombresField;
        public JTextField apellidosField;
        public JTextField contrasenaField;
        public JTextField especialidadField;
        public JTextField telefonoField;
        public JTextField edadField;
        public JComboBox<String> genderComboBox;

        JButton botonActualizar;

        private Doctor doctor;



    public InterfazActualizarDoctor(Doctor doctor){
        this.doctor = doctor;
        initComponents();
        }

    public void initComponents(){

        this.setTitle("Actualizar Doctor");
        this.setBounds(650, 400, 650, 300);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(237, 238, 123));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Actualizar Doctor");
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

        contrasenaField = new JPasswordField();
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

        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(80, 170, 80, 25);
        this.add(genderLabel);

        String[] genders = {"Masculino", "Femenino"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(130, 170, 150, 25);
        this.add(genderComboBox);

        botonActualizar = new JButton("Actualizar");
        botonActualizar.setBounds(450, 190, 130, 25);
        botonActualizar.setForeground(Color.BLACK);
        botonActualizar.setFont(new Font("MV Boli", Font.PLAIN, 18));
        botonActualizar.setBackground(new Color(147, 255, 183));
        this.add(botonActualizar);
        botonActualizar.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonActualizar) {
            // Obtener los nuevos datos del doctor desde los campos de texto
            String nuevosNombres = nombresField.getText();
            String nuevosApellidos = apellidosField.getText();
            String nuevaContrasena = contrasenaField.getText();
            String nuevaEspecialidad = especialidadField.getText();
            String nuevoTelefono = telefonoField.getText();
            String nuevaEdad = edadField.getText();
            String nuevoGenero = (String) genderComboBox.getSelectedItem();

            // Actualizar los datos del doctor
            doctor.setNombres(nuevosNombres);
            doctor.setApellidos(nuevosApellidos);
            doctor.setContrasena(nuevaContrasena);
            doctor.setEspecialidad(nuevaEspecialidad);
            doctor.setTelefono(nuevoTelefono);
            doctor.setEdad(nuevaEdad);
            doctor.setGenero(nuevoGenero);

            // Actualizar la lista de doctores en la clase Administrador
            boolean actualizacionExitosa = Administrador.actualizarDoctor(doctor);

            if (actualizacionExitosa) {
                JOptionPane.showMessageDialog(this, "Doctor actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                InterfazModuloAdministrador interfazModuloAdministrador = new InterfazModuloAdministrador(0);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el doctor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            InterfazModuloAdministrador interfazModuloAdministrador = new InterfazModuloAdministrador(0);
            this.dispose();
        }
    }
}


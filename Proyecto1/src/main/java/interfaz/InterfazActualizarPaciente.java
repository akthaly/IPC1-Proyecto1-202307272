package interfaz;

import clases.Administrador;
import clases.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazActualizarPaciente extends JFrame implements ActionListener {

    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField contrasenaField;
    private JTextField edadField;
    private JComboBox<String> genderComboBox;

    private Paciente paciente;
    JButton botonActualizar;

    public InterfazActualizarPaciente(Paciente paciente){
        this.paciente = paciente;
        initComponents();
    }

    public void initComponents(){

        this.setTitle("Actualizar Paciente");
        this.setBounds(650, 400, 650, 300);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(237, 238, 123));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Actualizar Paciente");
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
        if (e.getSource() == botonActualizar){
            // Obtener los nuevos datos del paciente desde los campos de texto
            String nuevosNombres = nombresField.getText();
            String nuevosApellidos = apellidosField.getText();
            String nuevaContrasena = contrasenaField.getText();
            String nuevaEdad = edadField.getText();
            String nuevoGenero = (String) genderComboBox.getSelectedItem();

            // Actualizar los datos del paciente
            paciente.setNombre(nuevosNombres);
            paciente.setApellido(nuevosApellidos);
            paciente.setContrasena(nuevaContrasena);
            paciente.setEdad(nuevaEdad);
            paciente.setGenero(nuevoGenero);

            // Actualizar la lista de pacientes en la clase Administrador
            boolean actualizacionExitosa = Administrador.actualizarPaciente(paciente);

            if (actualizacionExitosa) {
                JOptionPane.showMessageDialog(this, "Paciente actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                InterfazModuloAdministrador interfazModuloAdministrador = new InterfazModuloAdministrador(1);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el paciente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            InterfazModuloAdministrador interfazModuloAdministrador = new InterfazModuloAdministrador(1);
            this.dispose();
        }
        }

    }

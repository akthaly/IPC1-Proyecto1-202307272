package interfaz;

import clases.Administrador;
import org.example.Main;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Administrador administrador = Main.administrador;

    public Login (){
        initComponents();

    }

    public void initComponents() {

        setTitle("Inicio de Sesion");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel codigoLabel = new JLabel("Codigo");
        codigoLabel.setBounds(100, 140, 200, 25);
        add(codigoLabel);

        JTextField codigoField = new JTextField();
        codigoField.setBounds(150, 140, 200, 25);
        add(codigoField);

        JLabel contrasenaLabel = new JLabel("Password");
        contrasenaLabel.setBounds(80, 180, 200, 25);
        add(contrasenaLabel);

        JPasswordField contrasenaField = new JPasswordField();
        contrasenaField.setBounds(150, 180, 200, 25);
        add(contrasenaField);

        JButton registroButton = new JButton("Registrate");
        registroButton.setBounds(150, 220, 115, 25);
        registroButton.setBackground(new Color(214, 225, 50));
        add(registroButton);

        registroButton.addActionListener(e ->{

            System.out.println("Aqui es el Registro");
        });


        JButton iniciarSesionButton = new JButton("Login");
        iniciarSesionButton.setBounds(275, 220, 75, 25); //Ajuste de posición
        iniciarSesionButton.setForeground(Color.WHITE); // Ajuste de color de letra
        iniciarSesionButton.setBackground(new Color(43, 191, 19)); // Ajuste de color de boton, con color en RGB
        add(iniciarSesionButton);

        iniciarSesionButton.addActionListener(e -> {
            String codigo = codigoField.getText();
            String contrasena = new String(contrasenaField.getPassword());

            if (administrador.autenticar(codigo, contrasena)) {
                //JOptionPane.showMessageDialog(this, "Inicio de Sesión Correcto");
                SwingUtilities.invokeLater(() -> {
                    InterfazAdministrador interfazAdministrador = new InterfazAdministrador();
                    interfazAdministrador.setVisible(true);
                });
            }
            else {
                JOptionPane.showMessageDialog(this, "Inicio de Sesión Incorrecto");
            }


        });
    }

}

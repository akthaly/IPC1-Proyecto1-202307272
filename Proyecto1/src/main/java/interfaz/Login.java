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
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(98, 247, 220 ));

        setLayout(null);
        setResizable(false);

        //colocar imagen
        ImageIcon imagenicono = new ImageIcon("src/main/java/imgs/login.png");
        Image imagenDimension = imagenicono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imagenAjustada = new ImageIcon(imagenDimension);
        setIconImage(imagenAjustada.getImage());
        JLabel icono = new JLabel(imagenAjustada);
        icono.setBounds(165, 20, 120, 100);
        this.add(icono);

        JLabel codigoLabel = new JLabel("Codigo");
        codigoLabel.setBounds(75, 140, 200, 25);
        codigoLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.add(codigoLabel);

        JTextField codigoField = new JTextField();
        codigoField.setBounds(130, 140, 200, 25);
        this.add(codigoField);

        JLabel contrasenaLabel = new JLabel("Password");
        contrasenaLabel.setBounds(55, 180, 200, 25);
        contrasenaLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.add(contrasenaLabel);

        JPasswordField contrasenaField = new JPasswordField();
        contrasenaField.setBounds(130, 180, 200, 25);
        this.add(contrasenaField);

        JButton registroButton = new JButton("Registrate");
        registroButton.setBounds(130, 220, 115, 25);
        registroButton.setForeground(Color.black);
        registroButton.setBackground(new Color(98, 247, 220 ));
        registroButton.setFont(new Font("MV Boli", Font.PLAIN, 15));
        this.add(registroButton);

        registroButton.addActionListener(e ->{
            SwingUtilities.invokeLater(() -> {
                InterfazRegistrarNuevoPaciente interfazNuevoAdministrador = new InterfazRegistrarNuevoPaciente();
                interfazNuevoAdministrador.setVisible(true);
            });
            this.dispose();
            System.out.println("Aqui es el Registro");
        });


        JButton iniciarSesionButton = new JButton("Login");
        iniciarSesionButton.setBounds(255, 220, 75, 25); //Ajuste de posición
        iniciarSesionButton.setForeground(Color.BLACK); // Ajuste de color de letra
        iniciarSesionButton.setFont(new Font("MV Boli", Font.PLAIN, 15));
        iniciarSesionButton.setBackground(new Color(147, 255, 183)); // Ajuste de color de boton, con color en RGB
        add(iniciarSesionButton);

        iniciarSesionButton.addActionListener(e -> {
            String codigo = codigoField.getText();
            String contrasena = new String(contrasenaField.getPassword());

            if (administrador.autenticar(codigo, contrasena)) {
                //JOptionPane.showMessageDialog(this, "Inicio de Sesión Correcto");
                SwingUtilities.invokeLater(() -> {
                    InterfazModuloAdministrador interfazAdministrador = new InterfazModuloAdministrador(0);
                    interfazAdministrador.setVisible(true);
                });
                this.dispose();
            }
            else {

                JOptionPane.showMessageDialog(this, "Inicio de Sesión Incorrecto");
            }


        });
    }

}

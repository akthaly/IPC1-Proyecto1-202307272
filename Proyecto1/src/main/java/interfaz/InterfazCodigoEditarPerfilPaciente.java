package interfaz;

import clases.Administrador;
import clases.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCodigoEditarPerfilPaciente extends JFrame implements ActionListener {

    JButton botonAceptar, botonCancelar;
    JTextField codigo;

    public InterfazCodigoEditarPerfilPaciente(){

        initComponents();
    }
    public void initComponents(){

        this.setTitle("Editar Perfil");
        this.setBounds(650, 400, 350, 200);
        this.setLayout(null);
        getContentPane().setBackground(new Color(255, 248, 107));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel aviso = new JLabel("Ingrese su código");
        aviso.setFont(new Font("Century Gothic", Font.BOLD, 13));
        aviso.setBounds(115, 10, 150, 50);
        this.add(aviso);

        JLabel aviso1 = new JLabel("(Código de inicio de sesión)");
        aviso1.setFont(new Font("Century Gothic", Font.BOLD, 11));
        aviso1.setBounds(100, 30, 180, 50);
        this.add(aviso1);

        codigo = new JTextField();
        codigo.setBounds(125, 75, 100, 25);
        this.add(codigo);

        botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        botonAceptar.setBackground(new Color(118, 242, 87));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setBounds(170, 120, 85, 25);
        botonAceptar.addActionListener(this);
        this.add(botonAceptar);

        botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        botonCancelar.setBackground(new Color(247, 54, 32));
        botonCancelar.setForeground(Color.WHITE);
        botonCancelar.setBounds(80, 120, 85, 25);
        botonCancelar.addActionListener(this);
        this.add(botonCancelar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonAceptar) {
            String codigoPaciente = codigo.getText();
            Paciente pacienteEncontrado = Administrador.buscarPaciente(codigoPaciente);

            if (pacienteEncontrado != null) {
                InterfazEditarPerfilPaciente interfazEditarPerfilPaciente = new InterfazEditarPerfilPaciente(pacienteEncontrado);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == botonCancelar) {
            // Cerrar la ventana actual
            this.dispose();
        }
    }
}

package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfazCodigoDoctor extends JFrame implements ActionListener {
    JButton botonAceptar;
    public InterfazCodigoDoctor(String codigo){

        initComponents(codigo);
    }
    public void initComponents(String codigo){

        this.setTitle("Codigo Doctor");
        this.setBounds(650, 400, 300, 200);
        this.setLayout(null);
        getContentPane().setBackground(new Color(255, 248, 107));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel aviso = new JLabel("Su codigo de");
        JLabel aviso1 = new JLabel("Inicio de Sesión");
        JLabel aviso2 = new JLabel("es:");

        JLabel codigoLabel = new JLabel(codigo);
        codigoLabel.setBounds(120, 80, 100, 50);
        codigoLabel.setFont(new Font("Century Gothic", Font.BOLD, 17));
        aviso.setFont(new Font("Century Gothic", Font.BOLD, 13));
        aviso1.setFont(new Font("Century Gothic", Font.BOLD, 13));
        aviso2.setFont(new Font("Century Gothic", Font.BOLD, 13));
        aviso.setBounds(105, 10, 105, 50);
        aviso1.setBounds(95, 30, 110, 50);
        aviso2.setBounds(135, 50, 105, 50);
        this.add(aviso);
        this.add(aviso1);
        this.add(aviso2);
        this.add(codigoLabel);

        botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        botonAceptar.setBackground(new Color(118, 242, 87));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setBounds(190, 120, 85, 25);
        botonAceptar.addActionListener(this);
        this.add(botonAceptar);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAceptar) {
            InterfazModuloAdministrador ventanaAdministrador = new InterfazModuloAdministrador(0);
            this.dispose();
        }

    }
}

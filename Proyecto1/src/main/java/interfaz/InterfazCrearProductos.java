package interfaz;

import clases.Administrador;
import clases.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearProductos extends JFrame implements ActionListener {
    private JTextField nombreProducto;
    private JTextField precioProducto;
    private JTextField descripcionProducto;
    private JTextField cantidadProducto;

    JButton botonCrear;

    public InterfazCrearProductos(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Crear Productos");
        this.setBounds(650, 400, 650, 300);
        this.setLayout(null);
        getContentPane().setBackground(new Color(237, 238, 123));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Crear Productos");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 300, 30);
        this.add(titleLabel);

        JLabel nombreProductoLabel = new JLabel("Nombre");
        nombreProductoLabel.setBounds(70, 50, 80, 25);
        this.add(nombreProductoLabel);

        nombreProducto = new JTextField();
        nombreProducto.setBounds(130, 50, 170, 25);
        this.add(nombreProducto);

        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setBounds(70, 90, 80, 25);
        this.add(precioLabel);

        precioProducto = new JTextField();
        precioProducto.setBounds(130, 90, 170, 25);
        this.add(precioProducto);

        JLabel descripcionLabel = new JLabel("Descripcion");
        descripcionLabel.setBounds(350, 50, 80, 25);
        this.add(descripcionLabel);

        descripcionProducto = new JTextField();
        descripcionProducto.setBounds(430, 50, 170, 25);
        this.add(descripcionProducto);

        JLabel cantidadLabel = new JLabel("Cantidad");
        cantidadLabel.setBounds(370, 90, 80, 25);
        this.add(cantidadLabel);

        cantidadProducto = new JTextField();
        cantidadProducto.setBounds(430, 90, 170, 25);
        this.add(cantidadProducto);

        botonCrear = new JButton("Crear");
        botonCrear.setBounds(450, 190, 130, 25);
        botonCrear.setForeground(Color.BLACK);
        botonCrear.setFont(new Font("MV Boli", Font.PLAIN, 18));
        botonCrear.setBackground(new Color(147, 255, 183));
        this.add(botonCrear);
        botonCrear.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonCrear){
            String nombre = nombreProducto.getText();
            String precio = precioProducto.getText();
            String descripcion = descripcionProducto.getText();
            String cantidad = cantidadProducto.getText();
            Administrador.agregarProductos(Productos.codigoProducto, nombre, precio, descripcion, cantidad );
            int codigoEntero= Integer.parseInt(Productos.codigoProducto);
            codigoEntero++;
            Productos.codigoProducto=String.format("%04d", codigoEntero);
            InterfazModuloAdministrador ventanaAdministrador = new InterfazModuloAdministrador(2);
            this.dispose();
        }

    }
}

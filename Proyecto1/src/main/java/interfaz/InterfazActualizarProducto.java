package interfaz;

import clases.Administrador;
import clases.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazActualizarProducto extends JFrame implements ActionListener {
    private JTextField nombreProducto;
    private JTextField precioProducto;
    private JTextField descripcionProducto;
    private JTextField cantidadProducto;

    private Productos producto;

    JButton botonActualizar;

    public InterfazActualizarProducto(Productos producto){
        this.producto = producto;
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
            String nuevosNombres = nombreProducto.getText();
            String nuevosPrecios = precioProducto.getText();
            String nuevaDescripcion = descripcionProducto.getText();
            String nuevaCantidad = cantidadProducto.getText();

            // Actualizar los datos del paciente
            producto.setNombre(nuevosNombres);
            producto.setPrecio(nuevosPrecios);
            producto.setDescripcion(nuevaDescripcion);
            producto.setCantidad(nuevaCantidad);

            // Actualizar la lista de pacientes en la clase Administrador
            boolean actualizacionExitosa = Administrador.actualizarProducto(producto);

            if (actualizacionExitosa) {
                JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                InterfazModuloAdministrador interfazModuloAdministrador = new InterfazModuloAdministrador(2);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            InterfazModuloAdministrador interfazModuloAdministrador = new InterfazModuloAdministrador(2);
            this.dispose();
        }
    }
}

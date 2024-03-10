package interfaz;

import clases.Administrador;
import clases.Doctor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;
public class InterfazModuloAdministrador extends JFrame implements ActionListener {
    JButton botonCerrarSesion, botonCerrarSesion1, botonCerrarSesion2, botonActualizarDoctor, botonRegistroDoctor, botonEliminarDoctor, botonRegistroPaciente, botonActualizarPaciente, botonEliminarPaciente, botonCrearProducto, botonActualizarProducto, botonEliminarProducto;
    public InterfazModuloAdministrador(int pestaña) {

        initComponents();
        JTabbedPane tabbedPane = (JTabbedPane) getContentPane().getComponent(0);
        tabbedPane.setSelectedIndex(pestaña);
    }

    private void initComponents() {
        // Crear un objeto JTabbedPane para gestionar pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);



        //Crear tres panales para las pestañas
        JPanel pest1 = new JPanel(null); //Se coloca null para tener control en la posicion de los elemntos en la pestaña
        JPanel pest2 = new JPanel(null);
        JPanel pest3 = new JPanel(null);

        // Agregar los paneles a las pestañas del JTabbedPane
        tabbedPane.addTab("Doctores", pest1);
        tabbedPane.addTab("Pacientes", pest2);
        tabbedPane.addTab("Productos", pest3);


        //====================Color de Fondo para cada pestaña====================
        pest1.setBackground(new Color(237, 238, 123));
        pest2.setBackground(new Color(237, 238, 123));
        pest3.setBackground(new Color(237, 238, 123));

        //===========================Creacion de Boton Cerrar Sesion============================
        botonCerrarSesion = new JButton("Cerrar Sesion");
        botonCerrarSesion.setBounds(1100, 610, 150, 30);
        botonCerrarSesion.setVisible(true);
        botonCerrarSesion.setEnabled(true);
        botonCerrarSesion.addActionListener(this);
        pest1.add(botonCerrarSesion);

        botonCerrarSesion1 = new JButton("Cerrar Sesion");
        botonCerrarSesion1.setBounds(1100, 610, 150, 30);
        botonCerrarSesion1.setVisible(true);
        botonCerrarSesion1.setEnabled(true);
        botonCerrarSesion1.addActionListener(this);
        pest2.add(botonCerrarSesion1);

        botonCerrarSesion2 = new JButton("Cerrar Sesion");
        botonCerrarSesion2.setBounds(1100, 610, 150, 30);
        botonCerrarSesion2.setVisible(true);
        botonCerrarSesion2.setEnabled(true);
        botonCerrarSesion2.addActionListener(this);
        pest3.add(botonCerrarSesion2);


        //===========================Creacion de Botones Doctor============================
        botonRegistroDoctor = new JButton("Crear Doctor");
        botonRegistroDoctor.setBounds(800, 25, 180, 50);
        botonRegistroDoctor.setVisible(true);
        botonRegistroDoctor.setEnabled(true);
        botonRegistroDoctor.addActionListener(this);
        pest1.add(botonRegistroDoctor);


        botonActualizarDoctor = new JButton("Actualizar Doctor");
        botonActualizarDoctor.setBounds(1000, 25, 180, 50);
        botonActualizarDoctor.setVisible(true);
        botonActualizarDoctor.addActionListener(this);
        pest1.add(botonActualizarDoctor);

        botonEliminarDoctor = new JButton("Eliminar Doctor");
        botonEliminarDoctor.setBounds(900, 85, 180, 50);
        botonEliminarDoctor.setVisible(true);
        botonEliminarDoctor.addActionListener(this);
        pest1.add(botonEliminarDoctor);


        //=======================Creacion de Botones Paciente============================

        botonRegistroPaciente = new JButton("Crear Paciente");
        botonRegistroPaciente.setBounds(800, 25, 180, 50);
        botonRegistroPaciente.setVisible(true);
        botonRegistroPaciente.setEnabled(true);
        botonRegistroPaciente.addActionListener(this);
        pest2.add(botonRegistroPaciente);


        botonActualizarPaciente = new JButton("Actualizar Paciente");
        botonActualizarPaciente.setBounds(1000, 25, 180, 50);
        botonActualizarPaciente.setVisible(true);
        botonActualizarPaciente.addActionListener(this);
        pest2.add(botonActualizarPaciente);

        botonEliminarPaciente = new JButton("Eliminar Paciente");
        botonEliminarPaciente.setBounds(900, 85, 180, 50);
        botonEliminarPaciente.setVisible(true);
        botonEliminarPaciente.addActionListener(this);
        pest2.add(botonEliminarPaciente);

        //=======================Creacion de Botones Productos============================

        botonCrearProducto = new JButton("Crear Producto");
        botonCrearProducto.setBounds(800, 25, 180, 50);
        botonCrearProducto.setVisible(true);
        botonCrearProducto.setEnabled(true);
        botonCrearProducto.addActionListener(this);
        pest3.add(botonCrearProducto);


        botonActualizarProducto = new JButton("Actualizar Producto");
        botonActualizarProducto.setBounds(1000, 25, 180, 50);
        botonActualizarProducto.setVisible(true);
        botonActualizarProducto.addActionListener(this);
        pest3.add(botonActualizarProducto);

        botonEliminarProducto = new JButton("Eliminar Producto");
        botonEliminarProducto.setBounds(900, 85, 180, 50);
        botonEliminarProducto.setVisible(true);
        botonEliminarProducto.addActionListener(this);
        pest3.add(botonEliminarProducto);


        //===========================Pestaña 1============================
        JLabel lbl1 = new JLabel("Listado de doctores");
        lbl1.setBounds(25, 25, 750, 50);
        lbl1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        lbl1.setBackground(new Color(237, 238, 123));
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font(lbl1.getFont().getFontName(), Font.BOLD, 24));
        lbl1.setVisible(true);
        pest1.add(lbl1);


        String[] columnsNames = {"Codigo", "Nombre", "Apellido", "Género", "Edad", "Especialidad", "Teléfono"};
        JTable tablaDoctores = new JTable(Administrador.datosDoctoresTabla(), columnsNames);
        JScrollPane scrollPane = new JScrollPane(tablaDoctores);
        scrollPane.setBounds(25, 80, 750, 570);
        pest1.add(scrollPane);

        //===========================Pestaña 2============================

        JLabel lbl2 = new JLabel("Lista de Pacientes");
        lbl2.setBounds(25, 25, 750, 50);
        lbl2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        lbl2.setBackground(new Color(237, 238, 123));
        lbl2.setVerticalAlignment(SwingConstants.CENTER);
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font(lbl2.getFont().getFontName(), Font.BOLD, 24));
        lbl2.setVisible(true);
        pest2.add(lbl2);

        String[] columnsNames1 = {"Codigo", "Nombre", "Apellido", "Edad", "Genero"};
        JTable table_Pacientes = new JTable(Administrador.datosPacientesTabla(), columnsNames1);
        JScrollPane scrollPane1 = new JScrollPane(table_Pacientes);
        scrollPane1.setBounds(25, 80, 750, 570);
        pest2.add(scrollPane1);


        //===========================Pestaña 3============================

        JLabel lbl3 = new JLabel("Lista de Productos");
        lbl3.setBounds(25, 25, 750, 50);
        lbl3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        lbl3.setBackground(new Color(237, 238, 123));
        lbl3.setVerticalAlignment(SwingConstants.CENTER);
        lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl3.setFont(new Font(lbl3.getFont().getFontName(), Font.BOLD, 24));
        lbl3.setVisible(true);
        pest3.add(lbl3);

        String[] columnsNames2 = {"Codigo", "Nombre", "Cantidad", "Descripción", "Precio"};
        JTable table_Productos = new JTable(Administrador.datosProductosTabla(), columnsNames2);
        JScrollPane scrollPane2 = new JScrollPane(table_Productos);
        scrollPane2.setBounds(25, 80, 750, 570);
        pest3.add(scrollPane2);


        //==================================================================================0

        // Agregar el JTabbedPane al contenido del JFrame
        getContentPane().add(tabbedPane);

        //--------------GRAFICA PARA DOCTORES------------
        DefaultCategoryDataset datos_Especialidad = new DefaultCategoryDataset();

        Map<String, Integer> especialidades = new HashMap();
        for (Doctor doctores : Administrador.listaDoctores) {
            String espec = doctores.getEspecialidad();

            if (especialidades.containsKey(espec)) {
                // Incrementar el contador si la especialidad ya está en el mapa
                especialidades.put(espec, especialidades.get(espec) + 1);
            } else {
                // Agregar la especialidad al mapa con contador 1 si no existe
                especialidades.put(espec, 1);
            }
        }

        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(especialidades.entrySet());
        Collections.sort(listaOrdenada, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        int contador = 0;
        for (Map.Entry<String, Integer> dato_mapa : listaOrdenada) {
            contador++;
            // (valor que va a tener en la grafica)
            datos_Especialidad.addValue(dato_mapa.getValue(), dato_mapa.getKey(), dato_mapa.getKey());

            if (contador == 5) {
                break;
            }

        }

        JFreeChart graficaEspecialidades = ChartFactory.createBarChart("Top 5 Especialidades", "Especialidad", "Cantidad", datos_Especialidad);

        CategoryPlot grafica = graficaEspecialidades.getCategoryPlot();
        CategoryAxis xAxis = grafica.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        ChartPanel chartPanel = new ChartPanel(graficaEspecialidades);
        chartPanel.setBounds(810, 200, 400, 400);
        pest1.add(chartPanel);


        //------------Creando JFrame------------------
        this.setExtendedState(MAXIMIZED_BOTH);  // Hacer que la ventana se abra maximizada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        this.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño de la ventana
        this.setVisible(true); // Hacer la ventana visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCerrarSesion || e.getSource() == botonCerrarSesion1 || e.getSource() == botonCerrarSesion2){
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
        else if (e.getSource() == botonActualizarDoctor){
            InterfazCodigoActualizarDoctor interfazCodigoActualizarDoctor = new InterfazCodigoActualizarDoctor();
            this.dispose();
        }
        else if (e.getSource() == botonRegistroDoctor){
            InterfazCrearDoctor interfazRegistroDoctor = new InterfazCrearDoctor();
            this.dispose();
        }
        else if (e.getSource() == botonEliminarDoctor){
            JOptionPane.showMessageDialog(this, "Eliminar Doctor");
        }
        else if (e.getSource() == botonRegistroPaciente){
            InterfazCrearPaciente interfazRegistroPaciente = new InterfazCrearPaciente();
            this.dispose();
        }
        else if (e.getSource() == botonActualizarPaciente){
            InterfazCodigoActualizarPaciente interfazCodigoActualizarPaciente = new InterfazCodigoActualizarPaciente();
            this.dispose();
            //JOptionPane.showMessageDialog(this, "Actualizar Paciente");
        }
        else if (e.getSource() == botonEliminarPaciente){
            JOptionPane.showMessageDialog(this, "Eliminar Paciente");
        }
        else if (e.getSource()== botonCrearProducto) {
            InterfazCrearProductos interfazCrearProductos = new InterfazCrearProductos();
            this.dispose();
        }
        else if (e.getSource() == botonActualizarProducto) {
            InterfazCodigoActualizarProducto interfazCodigoActualizarProducto = new InterfazCodigoActualizarProducto();
            this.dispose();
        }
        else if (e.getSource() == botonEliminarProducto) {
            JOptionPane.showMessageDialog(this, "Eliminar Producto");
        }
    }
}
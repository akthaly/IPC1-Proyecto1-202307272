package interfaz;

import clases.Administrador;
import clases.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InterfazModuloPaciente extends JFrame implements ActionListener {
    JButton botonCerrarSesion1, botonCerrarSesion2, botonEditarPerfil1, botonEditarPerfil2,botonCrearCita;
    JComboBox<String> listaEspecialidad, listaDoctor, listaHorarios, listaFechas;
    JLabel motivoDeLaCitaLabel,historialDeCitas, especialidadLabel, doctorLabel, horariosLabel, fechasLabel, horariosDisponibles;
    JTextField motivoDeLaCita;
    int contador = 0;
    public static ArrayList<String> listaLogsCitas = new ArrayList<>();


    public InterfazModuloPaciente(int pestaña) {

        initComponents();
    }

    public void initComponents() {
        // Crear un objeto JTabbedPane para gestionar pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);


        //Crear tres panales para las pestañas
        JPanel pest1 = new JPanel(null); //Se coloca null para tener control en la posicion de los elemntos en la pestaña
        JPanel pest2 = new JPanel(null);
        JPanel pest3 = new JPanel(null);

        // Agregar los paneles a las pestañas del JTabbedPane
        tabbedPane.addTab("Solicitar Cita", pest1);
        tabbedPane.addTab("Ver Estado de Cita", pest2);
        tabbedPane.addTab("Farmacia", pest3);
        this.add(tabbedPane);

        //====================Color de Fondo para cada pestaña====================
        pest1.setBackground(new Color(53, 214, 222));
        pest2.setBackground(new Color(53, 214, 222));
        pest3.setBackground(new Color(53, 214, 222));

        //==================BOTONES EDITAR PERFIL=============================

        botonEditarPerfil1 = new JButton("Editar Pefil");
        botonEditarPerfil1.setBounds(1125, 50, 150, 30);
        botonEditarPerfil1.setVisible(true);
        botonEditarPerfil1.setEnabled(true);
        botonEditarPerfil1.addActionListener(this);
        pest1.add(botonEditarPerfil1);

        botonEditarPerfil2 = new JButton("Editar Pefil");
        botonEditarPerfil2.setBounds(1125, 50, 150, 30);
        botonEditarPerfil2.setVisible(true);
        botonEditarPerfil2.setEnabled(true);
        botonEditarPerfil2.addActionListener(this);
        pest3.add(botonEditarPerfil2);


        //=======================Creacion de Botones Cerrar Sesión======================
        botonCerrarSesion1 = new JButton("Cerrar Sesion");
        botonCerrarSesion1.setBounds(1125, 600, 150, 30);
        botonCerrarSesion1.setVisible(true);
        botonCerrarSesion1.setEnabled(true);
        botonCerrarSesion1.addActionListener(this);
        pest1.add(botonCerrarSesion1);

        botonCerrarSesion2 = new JButton("Cerrar Sesion");
        botonCerrarSesion2.setBounds(1125, 600, 150, 30);
        botonCerrarSesion2.setVisible(true);
        botonCerrarSesion2.setEnabled(true);
        botonCerrarSesion2.addActionListener(this);
        pest3.add(botonCerrarSesion2);

        //===========================BOTON CREAR CITA=============================
        botonCrearCita = new JButton("Generar Cita");
        botonCrearCita.setVisible(true);
        botonCrearCita.setBounds(1125, 550, 150, 30);
        botonCrearCita.addActionListener(this);
        pest1.add(botonCrearCita);


        //===========================Pestaña 1============================

        //=============================MOTIVO DE LA CITA=================================

        motivoDeLaCitaLabel = new JLabel("Motivo de la cita:");
        motivoDeLaCitaLabel.setBounds(75, 50, 450, 50);
        motivoDeLaCitaLabel.setBackground(new Color(53, 214, 222));
        motivoDeLaCitaLabel.setFont(new Font("Consolas", Font.BOLD, 45));
        motivoDeLaCitaLabel.setVisible(true);
        pest1.add(motivoDeLaCitaLabel);


        motivoDeLaCita = new JTextField();
        motivoDeLaCita.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        motivoDeLaCita.setBounds(75, 100, 1200, 200);
        pest1.add(motivoDeLaCita);


        //==========================LISTA ESPECIALIDADES===============================

        ArrayList<String> especialidadDoctor = listadoEspecialidades();
        String[] especialidad = null;
        if (especialidadDoctor != null) {
            especialidad = obtenerEspecialidad(especialidadDoctor);
        }

        if (especialidad != null || especialidad.length != 0) {
            listaEspecialidad = new JComboBox<>(especialidad);
        } else {
            String[] noespecilidad = {"Sin Datos"};
            listaEspecialidad = new JComboBox<>();
        }


        especialidadLabel = new JLabel("Especialidad:");
        especialidadLabel.setBounds(110, 325, 150, 25);
        especialidadLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        especialidadLabel.setVisible(true);
        pest1.add(especialidadLabel);

        listaEspecialidad.setEnabled(true);
        listaEspecialidad.setVisible(true);
        listaEspecialidad.setBounds(270, 325, 200, 25);
        pest1.add(listaEspecialidad);


        //==========================LISTA DOCTORES===============================

        doctorLabel = new JLabel("Doctor:");
        doctorLabel.setBounds(110, 375, 150, 25);
        doctorLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        doctorLabel.setVisible(true);
        pest1.add(doctorLabel);


        listaDoctor = new JComboBox<>(obtenerDoctor(listadoDoctores((String) listaEspecialidad.getSelectedItem())));
        listaDoctor.setVisible(true);
        listaDoctor.setBounds(270, 375, 200, 25);
        pest1.add(listaDoctor);

        listaEspecialidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> doctores = listadoDoctores(listaEspecialidad.getSelectedItem().toString());
                String[] doc = null;
                if (doctores != null) {
                    doc = obtenerDoctor(doctores);
                }

                if (doc != null || doc.length != 0) {
                    listaDoctor.setModel(new DefaultComboBoxModel<>(doc));
                } else {
                    String[] noespecilidad = {"Sin especialidades"};
                    listaDoctor.setModel(new DefaultComboBoxModel<>(noespecilidad));
                }
            }

        });

        //===========================LISTA HORARIOS Y FECHAS DISPONIBLES==============================

        horariosDisponibles = new JLabel("Horario de citas disponibles");
        horariosDisponibles.setBounds(75, 475, 450, 35);
        horariosDisponibles.setFont(new Font("Consolas", Font.BOLD, 25));
        horariosDisponibles.setVisible(true);
        pest1.add(horariosDisponibles);

        fechasLabel = new JLabel("Fecha:");
        fechasLabel.setBounds(150, 530, 100, 25);
        fechasLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        fechasLabel.setVisible(true);
        pest1.add(fechasLabel);

        String[] fechas = {"01/01/2024", "02/01/2024", "03/01/2024", "04/01/2024", "05/01/2024", "06/01/2024", "07/01/2024", "08/01/2024", "09/01/2024", "10/01/2024", "11/01/2024", "12/01/2024", "13/01/2024", "14/01/2024", "15/01/2024"};
        listaFechas = new JComboBox<>(fechas);
        listaFechas.setBounds(240, 525, 150, 25);
        listaFechas.setVisible(true);
        pest1.add(listaFechas);

        horariosLabel = new JLabel("Hora:");
        horariosLabel.setBounds(425, 530, 100, 25);
        horariosLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        horariosLabel.setVisible(true);
        pest1.add(horariosLabel);

        String[] horarios = {"8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm"};
        listaHorarios = new JComboBox<>(horarios);
        listaHorarios.setBounds(500, 525, 150, 25);
        listaHorarios.setVisible(true);
        pest1.add(listaHorarios);


        //===========================Pestaña 3============================

        getContentPane().add(tabbedPane);

        //================================================================================================

        this.setExtendedState(MAXIMIZED_BOTH);  // Hacer que la ventana se abra maximizada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        this.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño de la ventana
        this.setVisible(true); // Hacer la ventana visible
    }
    public Object[][] crearCita() {
        // Obtiene los valores seleccionados por el usuario
        String especialidad = (String) listaEspecialidad.getSelectedItem();
        String doctor = (String) listaDoctor.getSelectedItem();
        String horario = (String) listaHorarios.getSelectedItem();
        String fechas = (String) listaFechas.getSelectedItem();
        String motivo = motivoDeLaCita.getText();

        // Realiza las validaciones necesarias y agrega la cita
        if (especialidad != null && doctor != null && horario != null && motivo != null && !motivo.isEmpty()) {
            // Agrega la cita al listado de logs de citas con estado pendiente
            String cita = contador +
                    ", Pendiente" +
                    ", " + fechas +
                    ", " + horario ;
            // Agrega la cita al listado de logs de citas
            listaLogsCitas.add(cita);
            JOptionPane.showMessageDialog(this, "Cita creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        }  if (listaLogsCitas.size() > 0) {
            JTable tablaCitas = crearTablaCitas();

            // Agregar la tabla a un JScrollPane para que tenga barras de desplazamiento si es necesario
            JScrollPane scrollPane = new JScrollPane(tablaCitas);
            scrollPane.setBounds(500, 100, 300, 500);

            // Obtener la pestaña correspondiente (en este caso, la pestaña 2)
            JPanel pest2 = (JPanel) ((JTabbedPane) this.getContentPane().getComponent(0)).getComponentAt(1);

            // Limpiar el contenido de la pestaña antes de agregar la nueva tabla
            pest2.removeAll();

            // Agregar la tabla al panel
            pest2.add(scrollPane);

            // Actualizar la interfaz
            pest2.revalidate();
            pest2.repaint();

            historialDeCitas = new JLabel("Historial de citas");
            historialDeCitas.setBounds(75, 50, 450, 50);
            historialDeCitas.setBackground(new Color(53, 214, 222));
            historialDeCitas.setFont(new Font("Consolas", Font.BOLD, 45));
            historialDeCitas.setVisible(true);
            pest2.add(historialDeCitas);
        }
        else {
            JOptionPane.showMessageDialog(this, "Complete todos los campos antes de crear la cita", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public JTable crearTablaCitas() {
        // Definir las columnas de la tabla
        String[] columnNames = {"No.", "Estado", "Fecha", "Hora"};

        // Crear un modelo de tabla con las columnas definidas
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Agregar las citas al modelo de la tabla
        for (String cita : listaLogsCitas) {
            String[] citaData = cita.split(", ");
            model.addRow(citaData);
        }

        // Crear la tabla con el modelo
        JTable tablaCitas = new JTable(model);

        // Devolver la tabla creada
        return tablaCitas;
    }

    public static ArrayList<String> listadoEspecialidades() {
        ArrayList<String> lista = new ArrayList();
        for (Doctor doctor : Administrador.listaDoctores) {
            lista.add(doctor.getEspecialidad());
        }
        return lista;
    }

    public static String[] obtenerEspecialidad(ArrayList<String> Especialidad) {
        Set<String> especialidad = new HashSet();
        for (String esp : Especialidad) {
            especialidad.add(esp);
        }
        return especialidad.toArray(new String[0]);
    }

    public static ArrayList<String> listadoDoctores(String especialidad) {
        ArrayList<String> lista = new ArrayList();
        for (Doctor doctor : Administrador.listaDoctores) {
            if (doctor.getEspecialidad().equals(especialidad)) {
                lista.add(doctor.getNombres());
            }
        }
        return lista;
    }

    public static String[] obtenerDoctor(ArrayList<String> Especialidad) {
        String[] nombreDoctor = new String[Especialidad.size()];
        for (int i = 0; i < Especialidad.size(); i++) {
            nombreDoctor[i] = Especialidad.get(i);
        }
        return nombreDoctor;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonEditarPerfil1 || e.getSource() == botonEditarPerfil2){
            InterfazCodigoEditarPerfilPaciente interfazCodigoEditarPerfilPaciente = new InterfazCodigoEditarPerfilPaciente();
            this.dispose();

            }else if (e.getSource() == botonCrearCita) {
                contador++;
                // Implementa la lógica para agregar la cita
                crearCita();
            }
            else if (e.getSource() == botonCerrarSesion1 || e.getSource() == botonCerrarSesion2){
                Login login = new Login();
                login.setVisible(true);
                this.dispose();
            }  else {
                JOptionPane.showMessageDialog(this, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }


    }

}


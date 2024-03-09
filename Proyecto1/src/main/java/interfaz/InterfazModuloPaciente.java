package interfaz;

import clases.Administrador;
import clases.Doctor;
import clases.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InterfazModuloPaciente extends JFrame implements ActionListener {
    JButton botonCerrarSesion, botonEditarPerfil, botonMostrarDoctores, botonMostrarHorarios, botonCrearCita;
    JComboBox<String> listaEspecialidad, listaDoctor, listaHorarios;
    JLabel lbl1, especialidadLabel, doctorLabel, horariosLabel;
    JTextField motivoDeLaCita;
    private ArrayList<String> listaLogsCitas = new ArrayList<>();
    private JTable tablaCitas; // Variable de instancia


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
        tabbedPane.addTab("Ver Estado Cita", pest2);
        tabbedPane.addTab("Farmacia", pest3);

        //====================Color de Fondo para cada pestaña====================
        pest1.setBackground(new Color(53, 214, 222));
        pest2.setBackground(new Color(53, 214, 222));
        pest3.setBackground(new Color(53, 214, 222));


        //===========================Pestaña 1============================
        // Titulo
        // Crear un nuevo JLabel con el texto "Listado Oficial"
        lbl1 = new JLabel("Motivo de la cita:");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl1.setBounds(25, 25, 250, 50);
        // Establecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl1.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        // Establecer el color de fondo del JLabel como Amarillo Claro
        lbl1.setBackground(new Color(255, 255, 255));
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl1.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        // Establer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl1.setFont(new Font(lbl1.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl1.setVisible(true);
        pest1.add(lbl1);

        botonEditarPerfil = new JButton("Editar Pefil");
        botonEditarPerfil.setBounds(950, 25, 250, 50);
        botonEditarPerfil.setVisible(true);
        botonEditarPerfil.setEnabled(true);
        botonEditarPerfil.addActionListener(this);
        pest1.add(botonEditarPerfil);


        motivoDeLaCita = new JTextField();
        motivoDeLaCita.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        motivoDeLaCita.setBounds(25, 110, 1300, 150);
        pest1.add(motivoDeLaCita);

        //===========================Creacion de Boton Cerrar Sesion============================
        botonCerrarSesion = new JButton("Cerrar Sesion");
        botonCerrarSesion.setBounds(850, 600, 180, 50);
        botonCerrarSesion.setVisible(true);
        botonCerrarSesion.setEnabled(true);
        botonCerrarSesion.addActionListener(this);
        pest1.add(botonCerrarSesion);

        //============================CREAR CITA==========================0
        //==========================LISTA ESPECIALIDADES===============================
        listaEspecialidad = new JComboBox<>(obtenerEspecialidad(listadoEspecialidades()));
        listaEspecialidad.setEnabled(true);
        listaEspecialidad.setVisible(true);
        listaEspecialidad.setBounds(250, 300, 250, 50);
        pest1.add(listaEspecialidad);

        especialidadLabel = new JLabel("Especialidad:");
        especialidadLabel.setBounds(100, 300, 150, 50);
        especialidadLabel.setFont(new Font("Arial", Font.BOLD, 20));
        especialidadLabel.setVisible(true);
        pest1.add(especialidadLabel);

        //==========================LISTA DOCTORES===============================
        listaDoctor = new JComboBox<>(obtenerDoctor(listadoDoctores((String) listaEspecialidad.getSelectedItem())));
        listaDoctor.setVisible(true);
        listaDoctor.setBounds(250, 400, 250, 50);
        pest1.add(listaDoctor);

        doctorLabel = new JLabel("Doctor:");
        doctorLabel.setBounds(100, 400, 150, 50);
        doctorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        doctorLabel.setVisible(true);
        pest1.add(doctorLabel);

        //===========================LISTA HORARIOS==============================
        String[] horarios = {"8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 pm", "10:00 pm"};
        listaHorarios = new JComboBox<>(horarios);
        listaHorarios.setBounds(250, 600, 250, 50);
        listaHorarios.setVisible(true);
        pest1.add(listaHorarios);


        //===========================BOTON CREAR CITA=============================
        botonCrearCita = new JButton("Generar Cita");
        botonCrearCita.setVisible(true);
        botonCrearCita.setBounds(1100, 600, 150, 50);
        botonCrearCita.addActionListener(this);
        pest1.add(botonCrearCita);



        // Agregar el JLabel al JPanel llamado pest1
        pest1.add(lbl1);

        //=====================================FALTAN PESTAÑAS=================================0

//        // Agregar la tabla a un JScrollPane para que tenga barras de desplazamiento si es necesario
//        JScrollPane scrollPane = new JScrollPane(tablaCitas);
//        scrollPane.setBounds(25, 25, 1300, 550);

//        pest2.add(scrollPane);


        //------------Creando JFrame------------------
        this.add(tabbedPane);
        this.setExtendedState(MAXIMIZED_BOTH);  // Hacer que la ventana se abra maximizada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        this.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño de la ventana
        this.setVisible(true); // Hacer la ventana visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String codigoPaciente = Administrador.codigoGeneral;
            Paciente pacienteEncontrado = Administrador.buscarPaciente(codigoPaciente);

            if (pacienteEncontrado != null) {
                InterfazActualizarPaciente interfazActualizarPaciente = new InterfazActualizarPaciente(pacienteEncontrado);
                this.dispose();
            }
            else if (e.getSource() == botonCrearCita) {
                // Implementa la lógica para agregar la cita y bloquear la opción de crear cita
                crearCita();
            }
            else if (e.getSource() == botonCerrarSesion){
                Login login = new Login();
                login.setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }


    }
    private void crearCita() {
        // Obtiene los valores seleccionados por el usuario
        String especialidad = (String) listaEspecialidad.getSelectedItem();
        String doctor = (String) listaDoctor.getSelectedItem();
        String horario = (String) listaHorarios.getSelectedItem();
        String motivo = motivoDeLaCita.getText();

        // Realiza las validaciones necesarias y agrega la cita
        if (especialidad != null && doctor != null && horario != null && motivo != null && !motivo.isEmpty()) {
            // Agrega la cita al listado de logs de citas con estado pendiente
            String cita = "Especialidad: " + especialidad +
                    ", Doctor: " + doctor +
                    ", Horario: " + horario +
                    ", Motivo: " + motivo +
                    ", Estado: Pendiente";
            // Agrega la cita al listado de logs de citas (puedes tener una lista o archivo para almacenarlas)
            listaLogsCitas.add(cita);
            // Bloquea la opción de crear cita
            //botonCrearCita.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Cita creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Complete todos los campos antes de crear la cita", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
}


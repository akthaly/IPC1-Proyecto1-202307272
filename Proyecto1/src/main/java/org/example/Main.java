package org.example;

import clases.Administrador;
import clases.Doctor;
import interfaz.Login;
import javax.swing.SwingUtilities;
import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Administrador administrador = new Administrador("admin", "admin", "admin");
    public static ArrayList<Doctor> listaDoctores = new ArrayList<>();
    public static int contador = 1;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });

    }

    public static Object[][] datosDoctoresTabla(){
        int filas = listaDoctores.size();
        Object[][] tabla = new Object[filas][8];

        for (int i = 0; i < filas; i++){
            Doctor tempDoctor= listaDoctores.get(i);

            tabla[i][0] = tempDoctor.getCodigo();
            tabla[i][1] = tempDoctor.getNombres();
            tabla[i][2] = tempDoctor.getApellidos();
            tabla[i][3] = tempDoctor.getGenero();
            tabla[i][4] = tempDoctor.getEdad();
            tabla[i][5] = tempDoctor.getEspecialidad();
            tabla[i][6] = tempDoctor.getTelefono();

        }

        return tabla;

    }

    public static void  agregarDoctores(String codigo, String contrasena, String nombres, String apellidos, String especialidad, String genero, String telefono, String edad){

        listaDoctores.add(new Doctor(codigo, contrasena, nombres, apellidos, especialidad, genero, telefono, edad));
    }
}
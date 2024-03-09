package org.example;

import clases.Administrador;
import interfaz.Login;

import javax.swing.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Administrador administrador = new Administrador("admin", "admin", "admin");
    //public static Doctor doctor = new Doctor( "doctor", "doctor", "doctor");
    //public static Paciente paciente = new Paciente("0001", "paciente", "paciente");
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });

    }
}
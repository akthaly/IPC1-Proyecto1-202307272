package org.example;

import clases.Administrador;
import interfaz.Login;

import javax.swing.*;

public class Main {

    public static Administrador administrador = new Administrador("admin", "admin", "admin");

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });

    }
}
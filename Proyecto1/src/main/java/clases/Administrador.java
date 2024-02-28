package clases;

import java.util.ArrayList;

public class Administrador extends Usuario{
    public static ArrayList<Doctor> listaDoctores = new ArrayList<>();
    private String nombre;
    public Administrador(java.lang.String codigo, java.lang.String contrasena, java.lang.String nombre) {
        super(codigo, contrasena);
        this.nombre = nombre;

    }
    public static Object[][] datosDoctoresTabla(){
        int filas = listaDoctores.size();
        Object[][] tabla = new Object[filas][7];

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

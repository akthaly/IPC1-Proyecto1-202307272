package clases;

import java.util.ArrayList;

public class Administrador extends Usuario{
    public static ArrayList<Doctor> listaDoctores = new ArrayList<>();
    private String nombre;
    public Administrador(java.lang.String codigo, java.lang.String contrasena, java.lang.String nombre) {
        super(codigo, contrasena);

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

    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public static Object[][] datosPacientesTabla(){
        int filas = listaPacientes.size();
        Object[][] tabla = new Object[filas][5];

        for (int i = 0; i < filas; i++){
            Paciente tempPaciente= listaPacientes.get(i);

            tabla[i][0] = tempPaciente.getCodigo();
            tabla[i][1] = tempPaciente.getNombre();
            tabla[i][2] = tempPaciente.getApellido();
            tabla[i][3] = tempPaciente.getEdad();
            tabla[i][4] = tempPaciente.getGenero();

        }

        return tabla;

    }
public static void agregarPacientes(String codigo,String contraseña, String nombre, String apellido, String edad, String genero){
        listaPacientes.add(new Paciente(codigo, contraseña, nombre, apellido, edad, genero));
}

    public static ArrayList<Productos> listaProductos = new ArrayList<>();
    public static Object[][] datosProductosTabla(){
        int filas = listaProductos.size();
        Object[][] tabla = new Object[filas][5];

        for (int i = 0; i < filas; i++){
            Productos tempProducto= listaProductos.get(i);

            tabla[i][0] = tempProducto.getCodigo();
            tabla[i][1] = tempProducto.getNombre();
            tabla[i][2] = tempProducto.getPrecio();
            tabla[i][3] = tempProducto.getDescripcion();
            tabla[i][4] = tempProducto.getCantidad();

        }

        return tabla;

    }
        public static void agregarProductos(String codigo, String nombre, String precio, String descripcion, String cantidad){
            listaProductos.add(new Productos(codigo, nombre, precio, descripcion, cantidad));
        }

}

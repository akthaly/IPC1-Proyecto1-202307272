package clases;

import interfaz.InterfazModuloPaciente;

import java.util.ArrayList;

public class Administrador extends Usuario{
    public static ArrayList<Doctor> listaDoctores = new ArrayList<>();
    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public static ArrayList<Productos> listaProductos = new ArrayList<>();
    public static ArrayList<InterfazModuloPaciente> listaCitas = new ArrayList<>();
    private String nombre;
    public Administrador(String codigo, String contrasena, String nombre) {
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


    public static Object[][] datosProductosTabla(){
        int filas = listaProductos.size();
        Object[][] tabla = new Object[filas][5];

        for (int i = 0; i < filas; i++){
            Productos tempProducto= listaProductos.get(i);

            tabla[i][0] = tempProducto.getCodigo();
            tabla[i][1] = tempProducto.getNombre();
            tabla[i][2] = tempProducto.getCantidad();
            tabla[i][3] = tempProducto.getDescripcion();
            tabla[i][4] = tempProducto.getPrecio();

        }

        return tabla;

    }
    public static void agregarProductos(String codigo, String nombre, String precio, String descripcion, String cantidad){
        listaProductos.add(new Productos(codigo, nombre, precio, descripcion, cantidad));
    }

    // Busca un doctor en la lista de pacientes por su codigo, si lo encuentra lo devuelve
    public static Doctor buscarDoctor(String codigo) {
        for (Doctor doctor : listaDoctores) {
            if (doctor.getCodigo().equals(codigo)) {
                return doctor;
            }
        }
        return null;
    }

    // Busca un doctor por su codigo, cuando lo encuentre entonces reemplaza por los nuevos datos
    public static boolean actualizarDoctor(Doctor doctorActualizado) {
        for (int i = 0; i < listaDoctores.size(); i++) {
            Doctor doctor = listaDoctores.get(i);
            if (doctor.getCodigo().equals(doctorActualizado.getCodigo())) {
                listaDoctores.set(i, doctorActualizado);
                return true;
            }
        }
        return false;
    }

    // Busca un paciente en la lista de pacientes por su codigo, si lo encuentra lo devuelve
    public static Paciente buscarPaciente(String codigo) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getCodigo().equals(codigo)) {
                return paciente;
            }
        }
        return null;
    }

    // Busca un paciente por su codigo, cuando lo encuentre entonces reemplaza por los nuevos datos

    public static boolean actualizarPaciente(Paciente pacienteActualizado) {
        for (int i = 0; i < listaPacientes.size(); i++) {
            Paciente paciente = listaPacientes.get(i);
            if (paciente.getCodigo().equals(pacienteActualizado.getCodigo())) {
                listaPacientes.set(i, pacienteActualizado);
                return true;
            }
        }
        return false;
    }

    // Busca un producto en la lista de pacientes por su codigo, si lo encuentra lo devuelve
    public static Productos buscarProducto(String codigo) {
        for (Productos productos : listaProductos) {
            if (productos.getCodigo().equals(codigo)) {
                return productos;
            }
        }
        return null;
    }

    // Busca un producto por su codigo, cuando lo encuentre entonces reemplaza por los nuevos datos

    public static boolean actualizarProducto(Productos productoActualizado) {
        for (int i = 0; i < listaProductos.size(); i++) {
            Productos producto = listaProductos.get(i);
            if (producto.getCodigo().equals(productoActualizado.getCodigo())) {
                listaProductos.set(i, productoActualizado);
                return true;
            }
        }
        return false;
    }

}




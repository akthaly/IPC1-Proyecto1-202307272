package clases;

public class Paciente extends Usuario{

    private String nombre;
    private String apellido;
    private String edad;
    private String genero;

    public Paciente(String codigo, String contrasena, String nombre, String apellido, String edad, String genero) {
        super(codigo, contrasena);
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }
    public Paciente(String codigo, String contrasena, String nombre){
        super(codigo, contrasena);
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

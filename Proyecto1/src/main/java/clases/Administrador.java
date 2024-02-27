package clases;

public class Administrador extends Usuario{
    private String nombre;
    public Administrador(java.lang.String codigo, java.lang.String contrasena, java.lang.String nombre) {
        super(codigo, contrasena);
        this.nombre = nombre;

    }

}

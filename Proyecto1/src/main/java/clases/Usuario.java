package clases;

public class Usuario {
    protected String codigo;
    protected String contrasena;

    public Usuario(java.lang.String codigo, java.lang.String contrasena) {
        this.codigo = codigo;
        this.contrasena = contrasena;
    }

    public boolean autenticar(String codigo, String contrasena){
        return this.codigo.equals(codigo) && this.contrasena.equals(contrasena);

    }

    public java.lang.String getCodigo() {
        return codigo;
    }

    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }

    public java.lang.String getContrasena() {
        return contrasena;
    }

    public void setContrasena(java.lang.String contrasena) {
        this.contrasena = contrasena;
    }
}

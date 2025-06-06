
package src.model;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String dni;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}

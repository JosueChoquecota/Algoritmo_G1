/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

/**
 *
 * @author ASUS
 */
public class Administrador {
    private int adminID;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String especialidad;
    private String telefono;
    private String direccion;
    private String codAdmin;
    private java.time.LocalDate fechaNacimiento;
    private String estado;
    private java.time.LocalDate fechaRegistro;

    public Administrador() {
    }


    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodAdmin() {
        return codAdmin;
    }

    public void setCodAdmin(String codAdmin) {
        this.codAdmin = codAdmin;
    }

    public java.time.LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.time.LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public java.time.LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(java.time.LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

/**
 *
 * @author ASUS
 */
public class PuntajeTotalEstudiante {
    private int codigo;
    private String nombreCompleto;
    private int unidad;
    private int sesiones;
    private int totalPuntaje;
    private double promedio;
    private int puntajeMaximo;

    public PuntajeTotalEstudiante() {
    }

    public PuntajeTotalEstudiante(int codigo, String nombreCompleto, int unidad, int sesiones, int totalPuntaje, double promedio, int puntajeMaximo) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.unidad = unidad;
        this.sesiones = sesiones;
        this.totalPuntaje = totalPuntaje;
        this.promedio = promedio;
        this.puntajeMaximo = puntajeMaximo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public int getSesiones() {
        return sesiones;
    }

    public void setSesiones(int sesiones) {
        this.sesiones = sesiones;
    }

    public int getTotalPuntaje() {
        return totalPuntaje;
    }

    public void setTotalPuntaje(int totalPuntaje) {
        this.totalPuntaje = totalPuntaje;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public void setPuntajeMaximo(int puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    }

    


    
}

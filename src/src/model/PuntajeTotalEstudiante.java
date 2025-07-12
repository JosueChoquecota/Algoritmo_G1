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
    private int semanas;
    private int totalPuntaje;
    private double promedioPorSemana;

    public PuntajeTotalEstudiante() {
    }
    
    public PuntajeTotalEstudiante(int codigo, String nombreCompleto, int unidad, int semanas, int totalPuntaje, double promedioPorSemana) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.unidad = unidad;
        this.semanas = semanas;
        this.totalPuntaje = totalPuntaje;
        this.promedioPorSemana = promedioPorSemana;
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

    public int getSemanas() {
        return semanas;
    }

    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }

    public int getTotalPuntaje() {
        return totalPuntaje;
    }

    public void setTotalPuntaje(int totalPuntaje) {
        this.totalPuntaje = totalPuntaje;
    }

    public double getPromedioPorSemana() {
        return promedioPorSemana;
    }

    public void setPromedioPorSemana(double promedioPorSemana) {
        this.promedioPorSemana = promedioPorSemana;
    }


    
}

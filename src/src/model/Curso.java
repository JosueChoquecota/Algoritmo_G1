/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import java.time.LocalDate;


public class Curso {
    private int cursoID;
    private String cursoNombre;
    private String cursoCodigo;
    private String ciclo;
    private LocalDate  fechaInicio; 
    private LocalDate  fechaFin;
    private String modalidad;
    private int creditos;
    private Boolean estado;
    
     public Curso() {
     }

    public Curso(int cursoID, String cursoNombre, String cursoCodigo, String ciclo, LocalDate  fechaInicio, LocalDate  fechaFin, String modalidad, int creditos, Boolean estado) {
        this.cursoID = cursoID;
        this.cursoNombre = cursoNombre;
        this.cursoCodigo = cursoCodigo;
        this.ciclo = ciclo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.creditos = creditos;
        this.estado = estado;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public String getCursoCodigo() {
        return cursoCodigo;
    }

    public void setCursoCodigo(String cursoCodigo) {
        this.cursoCodigo = cursoCodigo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate  getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate  fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate  getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate  fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
 
     
 
}

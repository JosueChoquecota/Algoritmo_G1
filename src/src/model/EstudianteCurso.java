/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class EstudianteCurso {
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fechaInscripcion;
    private String estado;
    private int participacionTotal;
    private Docente docente;
    private int sesionID;

    public EstudianteCurso() {
    }

    public EstudianteCurso(Estudiante estudiante, Curso curso, LocalDate fechaInscripcion, String estado, int participacionTotal, Docente docente, int sesionID) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.participacionTotal = participacionTotal;
        this.docente = docente;
        this.sesionID = sesionID;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getParticipacionTotal() {
        return participacionTotal;
    }

    public void setParticipacionTotal(int participacionTotal) {
        this.participacionTotal = participacionTotal;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getSesionID() {
        return sesionID;
    }

    public void setSesionID(int sesionID) {
        this.sesionID = sesionID;
    }

    
    
    
    
    
    
}


package src.model;

import java.time.LocalDate;


public class Participacion {
    private int partID;
    private Estudiante estudiante;
    private SesionClase sesion;
    private Docente docente;      
    private String tipo;        
    private int puntaje;        
    private String observacion; 
    private LocalDate fecha;       
    private Curso curso;
    public Participacion() {
    }

    public Participacion(int partID, Estudiante estudiante, SesionClase sesion, Docente docente, String tipo, int puntaje, String observacion, LocalDate fecha) {
        this.partID = partID;
        this.estudiante = estudiante;
        this.sesion = sesion;
        this.docente = docente;
        this.tipo = tipo;
        this.puntaje = puntaje;
        this.observacion = observacion;
        this.fecha = fecha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public SesionClase getSesion() {
        return sesion;
    }

    public void setSesion(SesionClase sesion) {
        this.sesion = sesion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
   

    
}

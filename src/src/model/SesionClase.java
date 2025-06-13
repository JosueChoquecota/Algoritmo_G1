
package src.model;

import java.time.LocalDate;
import java.util.List;


public class SesionClase {
  private int sesID;
    private Curso curso;
    private LocalDate fecha;
    private int semana;
    private String tema;
    private String ciclo;
    private List<SesionDetalle> detalles;
    private int unidad;
    private String horario;

    public SesionClase() {
    }

    public SesionClase(int sesID, Curso curso, LocalDate fecha, int semana, String tema, String ciclo, List<SesionDetalle> detalles, int unidad, String horario) {
        this.sesID = sesID;
        this.curso = curso;
        this.fecha = fecha;
        this.semana = semana;
        this.tema = tema;
        this.ciclo = ciclo;
        this.detalles = detalles;
        this.unidad = unidad;
        this.horario = horario;
    }

    public int getSesID() {
        return sesID;
    }

    public void setSesID(int sesID) {
        this.sesID = sesID;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public List<SesionDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<SesionDetalle> detalles) {
        this.detalles = detalles;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

   

   
    
    
}

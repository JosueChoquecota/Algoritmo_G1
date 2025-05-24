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
public class Reprogramación {
    private int reproID;
    private SesionClase sesion;
    private LocalDate fechaAnterior;
    private LocalDate fechaNueva;
    private String motivo;

    public Reprogramación() {}

    public Reprogramación(int reproID, SesionClase sesion, LocalDate fechaAnterior, LocalDate fechaNueva, String motivo) {
        this.reproID = reproID;
        this.sesion = sesion;
        this.fechaAnterior = fechaAnterior;
        this.fechaNueva = fechaNueva;
        this.motivo = motivo;
    }

    public int getReproID() {
        return reproID;
    }

    public void setReproID(int reproID) {
        this.reproID = reproID;
    }

    public SesionClase getSesion() {
        return sesion;
    }

    public void setSesion(SesionClase sesion) {
        this.sesion = sesion;
    }

    public LocalDate getFechaAnterior() {
        return fechaAnterior;
    }

    public void setFechaAnterior(LocalDate fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }

    public LocalDate getFechaNueva() {
        return fechaNueva;
    }

    public void setFechaNueva(LocalDate fechaNueva) {
        this.fechaNueva = fechaNueva;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

   

   
}

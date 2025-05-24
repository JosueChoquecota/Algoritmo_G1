/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

/**
 *
 * @author ASUS
 */
public class Observación {
    private int obsID;
    private String obsDescripcion;
    private Participacion participacion;

    public Observación() {}

    public Observación(int obsID, String obsDescripcion, Participacion participacion) {
        this.obsID = obsID;
        this.obsDescripcion = obsDescripcion;
        this.participacion = participacion;
    }

    public int getObsID() {
        return obsID;
    }

    public void setObsID(int obsID) {
        this.obsID = obsID;
    }

    public String getObsDescripcion() {
        return obsDescripcion;
    }

    public void setObsDescripcion(String obsDescripcion) {
        this.obsDescripcion = obsDescripcion;
    }

    public Participacion getParticipacion() {
        return participacion;
    }

    public void setParticipacion(Participacion participacion) {
        this.participacion = participacion;
    }

   
}

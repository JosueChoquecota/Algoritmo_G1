/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

/**
 *
 * @author ASUS
 */
public class Actividad {
    private int actID;
    private String actNombre;
    private String actDescripcion;
    private SesionClase sesion; // 

    public Actividad() {
    }

    public Actividad(int actID, String actNombre, String actDescripcion, SesionClase sesion) {
        this.actID = actID;
        this.actNombre = actNombre;
        this.actDescripcion = actDescripcion;
        this.sesion = sesion;
    }

    public int getActID() {
        return actID;
    }

    public void setActID(int actID) {
        this.actID = actID;
    }

    public String getActNombre() {
        return actNombre;
    }

    public void setActNombre(String actNombre) {
        this.actNombre = actNombre;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public SesionClase getSesion() {
        return sesion;
    }

    public void setSesion(SesionClase sesion) {
        this.sesion = sesion;
    }

    
    
}


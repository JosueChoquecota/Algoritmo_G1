/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class GrupoActividad {
    private int grupoID;
    private SesionClase sesion;
    private String nombreGrupo;
    private String actividad;
    private List<Estudiante> integrantes;

    public GrupoActividad() {
    }
    public GrupoActividad(int grupoID, SesionClase sesion, String nombreGrupo, String actividad, List<Estudiante> integrantes) {
        this.grupoID = grupoID;
        this.sesion = sesion;
        this.nombreGrupo = nombreGrupo;
        this.actividad = actividad;
        this.integrantes = integrantes;
    }

    public int getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(int grupoID) {
        this.grupoID = grupoID;
    }

    public SesionClase getSesion() {
        return sesion;
    }

    public void setSesion(SesionClase sesion) {
        this.sesion = sesion;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public List<Estudiante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Estudiante> integrantes) {
        this.integrantes = integrantes;
    }
    
    
    
}

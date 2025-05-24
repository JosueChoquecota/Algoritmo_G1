/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import java.util.ArrayList;
import java.util.List;


public class Grupo {
    private int grupoID;
    private String grupoNombre;
    private Actividad actividad;
    private List<Estudiante> estudiantes;

    public Grupo() {
        estudiantes = new ArrayList<>();
    }

    public Grupo(int grupoID, String grupoNombre, Actividad actividad) {
        this.grupoID = grupoID;
        this.grupoNombre = grupoNombre;
        this.actividad = actividad;
        this.estudiantes = new ArrayList<>();
    }

    public int getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(int grupoID) {
        this.grupoID = grupoID;
    }

    public String getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    // AGREGA ESTUDIANTE
    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    // QUITA ESTUDIANTE
    public void eliminarEstudiante(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);
    }


}

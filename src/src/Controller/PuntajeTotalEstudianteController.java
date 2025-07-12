/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.util.List;
import servicio.ParticipacionesService;
import src.dao.ParticipacionDAO;
import src.dao.PuntajeTotalEstudianteDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.PuntajeTotalEstudiante;

/**
 *
 * @author ASUS
 */
public class PuntajeTotalEstudianteController {
    private PuntajeTotalEstudianteDAO puntaje;
    
    public PuntajeTotalEstudianteController(PuntajeTotalEstudianteDAO puntaje) {
        this.puntaje = puntaje;
    }
    public List<PuntajeTotalEstudiante> listarPuntajePorUnidad(int unidad, int cursoID, Docente docente) {
        return puntaje.listarPuntajePorUnidad(unidad, cursoID, docente);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.util.List;
import servicio.EstudianteService;
import src.dao.EstudianteDAO;
import src.model.Estudiante;

/**
 *
 * @author ASUS
 */
public class EstudianteController {
    private EstudianteDAO estudianteDAO;
    private EstudianteService estudianteService;
    
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    public EstudianteController(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    // REQMS-034: REGISTRAR ALUMNO
    public boolean registrarEstudiante(Estudiante estudiante) {
        return estudianteDAO.insertarEstudiante(estudiante);
    }

    // REQMS-027: RETIRAR ALUMNO
    public boolean retirarEstudianteDeCurso(int estID, int cursoID) {
        return estudianteDAO.retirarEstudianteDelCurso(estID, cursoID);
    }

}

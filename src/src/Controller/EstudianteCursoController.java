/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.sql.SQLException;
import java.util.List;
import servicio.EstudianteCursoService;
import servicio.EstudianteService;
import src.dao.EstudianteCursoDAO;
import src.model.EstudianteCurso;
import src.model.SesionDetalle;

public class EstudianteCursoController {
    private EstudianteCursoDAO inscripcionDAO;
    private EstudianteCursoService service;


    public EstudianteCursoController(EstudianteCursoDAO inscripcionDAO) {
        this.inscripcionDAO = inscripcionDAO;
    }
    public EstudianteCursoController(EstudianteCursoService service) {
        this.service = service;
    }
    //REQMS-009: Registrar estudiante a curso
    public boolean registrarInscripcion(int estID, int cursoID, int docID) {
        return inscripcionDAO.inscribirEstudianteACurso(estID, cursoID, docID);
    }
    //REQMS-013: Visualizar participaciones filtradas por clase, curso o tipo de sesión
    public List<EstudianteCurso> obtenerEstudiantesPorSesion(int sesionID) {
        return inscripcionDAO.obtenerEstudiantesPorSesion(sesionID);
    }
    public List<EstudianteCurso> ordenarPorNotaDescendente(List<EstudianteCurso> estudiantesCurso) {
        return service.ordenarPorNotaDeso(estudiantesCurso);
    }
    public List<EstudianteCurso> ordenarPorNotaAscendente(List<EstudianteCurso> estudiantesCurso) {
        return service.ordenarPorNotaAsc(estudiantesCurso);
    }


}

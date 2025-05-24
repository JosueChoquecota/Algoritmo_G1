/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import src.dao.EstudianteCursoDAO;

public class EstudianteCursoController {
    private EstudianteCursoDAO inscripcionDAO;

    public EstudianteCursoController(EstudianteCursoDAO inscripcionDAO) {
        this.inscripcionDAO = inscripcionDAO;
    }

    public boolean registrarInscripcion(int estID, int cursoID, int docID) {
        return inscripcionDAO.inscribirEstudianteACurso(estID, cursoID, docID);
    }
}

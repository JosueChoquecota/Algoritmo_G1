/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.util.List;
import src.dao.CursoDAO;
import src.model.Curso;

public class CursoController {
    private CursoDAO cursoDAO;

    public CursoController(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    // REQMS-007: Registrar curso
    public boolean registrarCurso(Curso curso, int semanas) {
        return cursoDAO.insertarCurso(curso,semanas);
    }

    // LISTAR CURSOS 
    public List<Curso> mostrarCursosDocente (int docID) {
        return cursoDAO.obtenerCursosPorDocente(docID);
    }

}

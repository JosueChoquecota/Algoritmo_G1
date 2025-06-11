/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import src.Controller.EstudianteCursoController;
import src.dao.EstudianteCursoDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class TestEstudiantesPorCurso {
    public static void main(String[] args) throws SQLException {
        int cursoID = 1017;     // Reemplaza con un cursoID válido
        int docenteID = 5001;  // Reemplaza con un docenteID válido

        EstudianteCursoController controller = new EstudianteCursoController(
            new EstudianteCursoDAO(new ConexionBD())
        );
    }
}

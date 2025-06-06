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

        List<EstudianteCurso> estudiantes = controller.obtenerEstudiantesPorCurso(cursoID, docenteID);

        if (estudiantes.isEmpty()) {
            System.out.println("⚠️ No se encontraron estudiantes.");
        } else {
            System.out.println("✅ Estudiantes del curso:");
            for (EstudianteCurso ec : estudiantes) {
                Estudiante e = ec.getEstudiante();
                Curso c = ec.getCurso();
                Docente d = ec.getDocente();
                LocalDate fecha = ec.getFechaInscripcion();

                System.out.printf("👨‍🎓 %s %s | Carrera: %s | Correo: %s | Código: %s | Curso: %s | Puntos: %d | Fecha: %s%n",
                    e.getNombre(), e.getApellido(), e.getCarrera(),
                    e.getCorreo(), e.getCodEst(), c.getCursoNombre(),
                    ec.getParticipacionTotal(), fecha);
            }
        }
    }
}

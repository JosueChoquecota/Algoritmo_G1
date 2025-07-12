
import java.util.List;
import src.dao.EstudianteDAO;
import src.model.Curso;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.util.ConexionBD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class main {
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        EstudianteDAO dao = new EstudianteDAO(conexion);

        int docenteID = 5001; // Reemplaza con el ID real de un docente existente

        List<EstudianteCurso> lista = dao.obtenerEstudiantesPorDocente(docenteID);

        for (EstudianteCurso ec : lista) {
            Estudiante e = ec.getEstudiante();
            Curso c = ec.getCurso();

            System.out.println("Estudiante: " + e.getCodEst() + " - " + e.getNombre() + " " + e.getApellido());
            System.out.println("Carrera: " + e.getCarrera());
            System.out.println("Correo: " + e.getCorreo());
            System.out.println("Curso: " + c.getCursoNombre());
            System.out.println("Fecha Inscripción: " + ec.getFechaInscripcion());
            System.out.println("Estado: " + ec.getEstado());
            System.out.println("Puntos: " + ec.getParticipacionTotal());
            System.out.println("-----------------------------------------------------");
        }
    }
}

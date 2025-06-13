
package test;

import java.time.LocalDate;
import servicio.SesionClaseService;
import src.dao.CursoDAO;
import src.dao.DocenteDAO;
import src.dao.EstudianteCursoDAO;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.EstudianteCurso;
import src.util.ConexionBD;
import src.Controller.SesionClaseController;

public class MainCrearCursoYGenerarSesiones {
  public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        CursoDAO cursoDAO = new CursoDAO(conexion);
        SesionClaseDAO sesionDAO = new SesionClaseDAO(conexion);
        SesionDetalleDAO detalleDAO = new SesionDetalleDAO(conexion);
        SesionClaseController controller = new SesionClaseController(sesionDAO, detalleDAO);

        Curso curso = new Curso();
        curso.setCursoNombre("Programación Avanzada");
        curso.setCiclo("2025-2");
        curso.setModalidad("Presencial");
        curso.setCreditos(4);
        curso.setCursoCodigo("TEMPORAL"); // será reemplazado internamente
        curso.setFechaInicio(LocalDate.of(2025, 8, 5));
        curso.setHorario("Lunes 13:00, Viernes 16:00");

        
        int semanas = 8;

        boolean insertado = cursoDAO.insertarCurso(curso, semanas);
        
        String horarioUno = "Lunes 13:00";
        String horarioDos = "Viernes 16:00";
        if (insertado) {
            controller.generarSesiones(
                curso,
                semanas,
                true,        // incluir teórica
                5001,        // ID docente teórica
                2,           // horas teórica
                true,        // incluir práctica
                5001,        // ID docente práctica
                3,           // horas práctica
                2,           // sesiones por semana
                horarioUno,
                horarioDos// horario
            );
        } else {
            System.out.println("❌ No se pudo registrar el curso.");
        }
    }
}

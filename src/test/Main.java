
package test;
import servicio.SesionClaseService;
import java.time.LocalDate;
import src.Controller.SesionClaseController;
import src.dao.CursoDAO;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.Curso;
import src.util.ConexionBD;

public class Main {

    public static void main(String[] args) {
        ConexionBD conn = new ConexionBD();

        // Instancias DAO
        CursoDAO cursoDAO = new CursoDAO(conn);
        SesionClaseDAO sesionDAO = new SesionClaseDAO(conn);
        SesionDetalleDAO detalleDAO = new SesionDetalleDAO(conn);

        
        // Crear el curso
        Curso curso = new Curso();
        curso.setCursoNombre("Algoritmos");
        curso.setCiclo("2025-1");
        curso.setFechaInicio(LocalDate.of(2025, 6, 10));
        curso.setModalidad("Presencial");
        curso.setCreditos(3);

        int semanas = 18;

        if (cursoDAO.insertarCurso(curso, semanas)) {
            System.out.println("✅ Curso insertado correctamente");

            // Crear el controlador
            SesionClaseController controller = new SesionClaseController(sesionDAO, detalleDAO);

            controller.generarSesionesConDetalles(
                curso,
                curso.getFechaInicio(),
                semanas,
                curso.getCiclo(),
                true,     // incluir teoría
                5001,     // ID válido de docente
                2,        // horas de teoría
                true,    // práctica desactivada (ya que no tienes docente 5002)
                5001,
                1
            );
        } else {
            System.out.println("❌ Error al insertar el curso.");
        }
    }
}

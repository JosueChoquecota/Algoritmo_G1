package test;


import src.model.Curso;
import src.model.Curso;
import src.model.Docente;
import src.model.SesionClase;
import src.model.SesionDetalle;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.util.ConexionBD;

import java.time.LocalDate;
import java.util.Scanner;
import servicio.SesionClaseService;
import src.Controller.SesionClaseController;

public class MainGenerarSesionesConDetalles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConexionBD conexionBD = new ConexionBD();
        SesionClaseDAO sesionDAO = new SesionClaseDAO(conexionBD);
        SesionDetalleDAO detalleDAO = new SesionDetalleDAO(conexionBD);
        SesionClaseController controller = new SesionClaseController(sesionDAO, detalleDAO);

        System.out.println("=== GENERAR SESIONES USANDO CONTROLLER ===");

        System.out.print("ID del curso: ");
        int cursoID = Integer.parseInt(sc.nextLine());

        System.out.print("Fecha de inicio (AAAA-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(sc.nextLine());

        System.out.print("Cantidad de semanas: ");
        int semanas = Integer.parseInt(sc.nextLine());

        System.out.print("Ciclo académico (ej. 2025-I): ");
        String ciclo = sc.nextLine();

        System.out.print("¿Deseas incluir parte teórica? (s/n): ");
        boolean incluirTeorica = sc.nextLine().equalsIgnoreCase("s");

        Integer docenteTeoricaID = null;
        int horasTeorica = 0;
        if (incluirTeorica) {
            System.out.print("ID del docente para parte teórica (0 si no aplica): ");
            int id = Integer.parseInt(sc.nextLine());
            docenteTeoricaID = (id > 0) ? id : null;

            System.out.print("Duración en horas de la parte teórica: ");
            horasTeorica = Integer.parseInt(sc.nextLine());
        }

        System.out.print("¿Deseas incluir parte práctica? (s/n): ");
        boolean incluirPractica = sc.nextLine().equalsIgnoreCase("s");

        Integer docentePracticaID = null;
        int horasPractica = 0;
        if (incluirPractica) {
            System.out.print("ID del docente para parte práctica (0 si no aplica): ");
            int id = Integer.parseInt(sc.nextLine());
            docentePracticaID = (id > 0) ? id : null;

            System.out.print("Duración en horas de la parte práctica: ");
            horasPractica = Integer.parseInt(sc.nextLine());
        }

        // OBTENCION DEL CURSO
        Curso curso = new Curso();
        curso.setCursoID(cursoID);

        // CONTROLLER
        controller.generarSesionesConDetalles(
                curso,
                fechaInicio,
                semanas,
                ciclo,
                incluirTeorica,
                docenteTeoricaID,
                horasTeorica,
                incluirPractica,
                docentePracticaID,
                horasPractica
        );
    }
}

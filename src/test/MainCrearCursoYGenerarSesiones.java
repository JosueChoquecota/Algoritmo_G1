
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

        int ano = Integer.parseInt("2025");
        int mes = Integer.parseInt("05");
        int dia = Integer.parseInt("12");
        
        
        Curso curso = new Curso();
        curso.setCursoNombre("Programación Avanzada"); //<---
        curso.setCiclo("2025-2"); //<---
        curso.setModalidad("Presencial"); //<---
        curso.setCreditos(4); //<---
        curso.setCursoCodigo("TEMPORAL"); // será reemplazado internamente
        curso.setFechaInicio(LocalDate.of(ano, mes, dia)); //<---
        curso.setHorario("Lunes 13:00 - 15:00"); //<---

        
        int semanas = 8;

        boolean insertado = cursoDAO.insertarCurso(curso, semanas);
        
        String horarioUno = "Lunes 13:00 - 15:00";
        String horarioDos = "Viernes 16:00";
        if (insertado) {
            controller.generarSesiones(
                curso,
                semanas,
                true,        // incluir teórica
                5001,        // ID docente teórica
                2,           // horas teórica
                false,        // incluir práctica
                null,        // ID docente práctica
                0,           // horas práctica
                1,           // sesiones por semana
                horarioUno,
                null// horario
            );
        } else {
            System.out.println("❌ No se pudo registrar el curso.");
        }
    }
}

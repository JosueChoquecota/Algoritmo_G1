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
import src.Controller.CursoController;
import src.Controller.SesionClaseController;
import src.dao.CursoDAO;

public class MainGenerarSesionesConDetalles {

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();

        CursoDAO cursoDAO = new CursoDAO(conexion);
        SesionClaseDAO sesionDAO = new SesionClaseDAO(conexion);
        SesionDetalleDAO detalleDAO = new SesionDetalleDAO(conexion);

        CursoController cursoController = new CursoController(cursoDAO);
        SesionClaseController sesionController = new SesionClaseController(sesionDAO, detalleDAO);

        // ✅ 1. Crear curso
        Curso curso = new Curso();
        curso.setCursoNombre("Derecho y mas");
        curso.setCiclo("2025-2");
        curso.setFechaInicio(LocalDate.of(2025, 4, 8)); 
        curso.setFechaFin(LocalDate.of(2025, 4, 9)); 
        curso.setModalidad("Presencial");
        curso.setCreditos(4);
        curso.setHorario("Miercoles 10:00 - 12:00 PM / Jueves 10:00 - 12:00 PM "); // Horario general
        int semanas = 2;

        boolean cursoRegistrado = cursoController.registrarCurso(curso, semanas);
        if (!cursoRegistrado) {
            System.out.println("⛔ No se pudo registrar el curso.");
            return;
        }

        // ✅ 2. Asignar docente para sesiones teóricas
        int docenteID = 5002;

        // ✅ 3. Generar sesiones (solo teóricas, una por semana)
        sesionController.generarSesiones(
            curso,
            semanas,            // semanas
            true,               // incluir teórica
            docenteID,          // ID docente teórica
            2,                  // horas teóricas
            true,              // sin práctica
            docenteID,               // sin docente práctica
            2,                  // sin horas práctica
            2,                  // 1 sesión por semana
            "Miercoles 10:00 - 12:00 PM",  // horario teórico
            "Jueves 10:00 - 12:00 PM"                // sin horario práctico
        );
    }
}

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
        ConexionBD conexion = new ConexionBD();
        SesionClaseDAO sesionDAO = new SesionClaseDAO(conexion);
        SesionDetalleDAO detalleDAO = new SesionDetalleDAO(conexion);

        SesionClaseController controller = new SesionClaseController(sesionDAO, detalleDAO);

        Curso curso = new Curso();
        curso.setCursoID(1017); // Asegúrate que este ID existe en tu BD
        curso.setCiclo("2025-2");
        curso.setFechaInicio(LocalDate.of(2025, 4, 11)); // Lunes
        curso.setFechaFin(LocalDate.of(2025, 4, 16)); // Ajusta según tu curso real

        controller.generarSesiones(
            curso,
            5,            // semanas
            true,         // incluir teórica
            5001,         // ID docente teórica
            2,            // horas teórica
            true,         // incluir práctica 
            5001,         // ID docente práctica
            3,             // horas práctica
            2
        );
    }
}

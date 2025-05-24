/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.time.LocalDate;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.SesionClase;
import src.model.SesionDetalle;


public class SesionClaseService {
    private final SesionClaseDAO sesionDAO;
    private final SesionDetalleDAO detalleDAO;

    public SesionClaseService(SesionClaseDAO sesionDAO, SesionDetalleDAO detalleDAO) {
        this.sesionDAO = sesionDAO;
        this.detalleDAO = detalleDAO;
    }

    public void generarSesionesConDetalles(
    Curso curso,
    int semanas,
    boolean incluirTeorica,
    Integer docenteTeoricaID,
    int horasTeorica,
    boolean incluirPractica,
    Integer docentePracticaID,
    int horasPractica
) {
    LocalDate fechaInicio = curso.getFechaInicio();
    String ciclo = curso.getCiclo();

    int sesionesPorSemana = 2; // ✅ Asumes 2 clases por semana (por ejemplo martes y viernes)
    int totalSesiones = semanas * sesionesPorSemana;

    for (int i = 0; i < totalSesiones; i++) {
        int semana = (i / sesionesPorSemana) + 1;
        int unidad = ((semana - 1) / 4) + 1;

        // Distribuye las fechas: una cada 3 días a partir del inicio
        LocalDate fechaSesion = fechaInicio.plusDays(i * 3);

        SesionClase sesion = new SesionClase();
        sesion.setCurso(curso);
        sesion.setFecha(fechaSesion);
        sesion.setSemana(semana);
        sesion.setTema("Semana " + semana);
        sesion.setCiclo(ciclo);
        sesion.setUnidad(unidad);

        if (!sesionDAO.insertarSesion(sesion)) {
            System.out.println("❌ Error al insertar sesión (semana " + semana + ")");
            continue;
        }

        // Parte teórica
        if (incluirTeorica) {
            SesionDetalle teorica = new SesionDetalle();
            teorica.setTipo("teórica");
            teorica.setDuracionHoras(horasTeorica);
            if (docenteTeoricaID != null) {
                Docente d = new Docente();
                d.setDocID(docenteTeoricaID);
                teorica.setDocente(d);
            }
            detalleDAO.insertarDetalle(sesion.getSesID(), teorica);
        }

        // Parte práctica
        if (incluirPractica) {
            SesionDetalle practica = new SesionDetalle();
            practica.setTipo("práctica");
            practica.setDuracionHoras(horasPractica);
            if (docentePracticaID != null) {
                Docente d = new Docente();
                d.setDocID(docentePracticaID);
                practica.setDocente(d);
            }
            detalleDAO.insertarDetalle(sesion.getSesID(), practica);
        }

        System.out.println("✅ Sesión generada (Semana " + semana + ", Unidad " + unidad + ", Fecha " + fechaSesion + ")");
    }

    System.out.println("=== Todas las sesiones fueron generadas correctamente ===");
}

}

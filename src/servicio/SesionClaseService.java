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
    int horasPractica,
    int sesionesPorSemana,
    String horarioTeorico,   
    String horarioPractico
) {
    LocalDate fecha1 = curso.getFechaInicio(); 
    LocalDate fecha2 = curso.getFechaFin();   
    String ciclo = curso.getCiclo();

    for (int semana = 1; semana <= semanas; semana++) {
        int unidad = ((semana - 1) / 4) + 1;

        // PRIMERA SESION
        if (incluirTeorica || sesionesPorSemana == 1) {
            LocalDate fechaSesion = fecha1.plusWeeks(semana - 1);

            SesionClase sesion = new SesionClase();
            sesion.setCurso(curso);
            sesion.setFecha(fechaSesion);
            sesion.setSemana(semana);
            sesion.setTema("Semana " + semana + " - " + (incluirTeorica ? "Teórica" : "Única"));
            sesion.setCiclo(ciclo);
            sesion.setUnidad(unidad);
            sesion.setHorario(horarioTeorico); 
            if (sesionDAO.insertarSesion(sesion)) {
                SesionDetalle detalle = new SesionDetalle();
                detalle.setTipo(incluirTeorica ? "teórica" : (incluirPractica ? "práctica" : "única"));
                detalle.setDuracionHoras(incluirTeorica ? horasTeorica : horasPractica);

                Integer docenteID = incluirTeorica ? docenteTeoricaID : docentePracticaID;
                if (docenteID != null) {
                    Docente d = new Docente();
                    d.setDocID(docenteID);
                    detalle.setDocente(d);
                }

                detalleDAO.registrarDetalleSesion(sesion.getSesID(), detalle);
                System.out.println("✅ Sesión 1 - Semana " + semana + ": " + fechaSesion);
            }
        }

        // SEGUNDA SESION
        if (sesionesPorSemana == 2 && incluirTeorica && incluirPractica) {
            LocalDate fechaSesion = fecha2.plusWeeks(semana - 1);

            SesionClase sesion = new SesionClase();
            sesion.setCurso(curso);
            sesion.setFecha(fechaSesion);
            sesion.setSemana(semana);
            sesion.setTema("Semana " + semana + " - Práctica");
            sesion.setCiclo(ciclo);
            sesion.setUnidad(unidad);
            sesion.setHorario(horarioPractico);


            if (sesionDAO.insertarSesion(sesion)) {
                SesionDetalle detalle = new SesionDetalle();
                detalle.setTipo("práctica");
                detalle.setDuracionHoras(horasPractica);

                if (docentePracticaID != null) {
                    Docente d = new Docente();
                    d.setDocID(docentePracticaID);
                    detalle.setDocente(d);
                }

                detalleDAO.registrarDetalleSesion(sesion.getSesID(), detalle);
                System.out.println("✅ Sesión 2 - Semana " + semana + ": " + fechaSesion);
            }
        }
    }

    System.out.println(" Generación de sesiones finalizada");
}

}

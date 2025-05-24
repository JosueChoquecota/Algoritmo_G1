/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.time.LocalDate;
import servicio.SesionClaseService;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.Curso;

/**
 *
 * @author ASUS
 */
public class SesionClaseController {
    private SesionClaseService servicio;

    public SesionClaseController(SesionClaseDAO sesionDAO, SesionDetalleDAO detalleDAO) {
        this.servicio = new SesionClaseService(sesionDAO, detalleDAO);
    }

    
    public void generarSesionesConDetalles(Curso curso,
                                           LocalDate fechaInicio,
                                           int semanas,
                                           String ciclo,
                                           boolean incluirTeorica,
                                           Integer docenteTeoricaID,
                                           int horasTeorica,
                                           boolean incluirPractica,
                                           Integer docentePracticaID,
                                           int horasPractica) {
        servicio.generarSesionesConDetalles(
            curso,
            semanas,
            incluirTeorica,
            docenteTeoricaID,
            horasTeorica,
            incluirPractica,
            docentePracticaID,
            horasPractica
        );
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.time.LocalDate;
import java.util.List;
import servicio.SesionClaseService;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.Curso;

/**
 *
 * @author ASUS
 */
    public class SesionClaseController {
        private final SesionClaseService service;
        private final SesionClaseDAO sesionDAO;

        public SesionClaseController(SesionClaseDAO sesionDAO, SesionDetalleDAO detalleDAO) {
            this.sesionDAO = sesionDAO; // ✅ Aquí estaba el error (antes era null)
            this.service = new SesionClaseService(sesionDAO, detalleDAO);
        }

        public void generarSesiones(Curso curso, int semanas, boolean incluirTeorica, Integer docenteTeoricaID, int horasTeorica, boolean incluirPractica, Integer docentePracticaID, int horasPractica, int sesionesPorSemana) {
            service.generarSesionesConDetalles(
                curso, semanas,
                incluirTeorica, docenteTeoricaID, horasTeorica,
                incluirPractica, docentePracticaID, horasPractica,
                sesionesPorSemana
            );
        }

        public List<Object[]> obtenerSesionesPorCursoYDocente(int cursoID, int docenteID) {
            return sesionDAO.listarSesionesConDetallesPorCursoYDocente(cursoID, docenteID);
        }
    }

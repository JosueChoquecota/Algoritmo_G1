/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.util.List;
import servicio.ParticipacionesService;
import src.dao.ParticipacionDAO;
import src.model.Participacion;

/**
 *
 * @author ASUS
 */
public class ParticipacionController {

    private final ParticipacionesService participacionesService;
    private ParticipacionDAO participacion;
    
    public ParticipacionController(ParticipacionesService service, ParticipacionDAO dao) {
    this.participacionesService = service;
    this.participacion = dao;
}

    public List<Participacion> listarParticipacionesPorEstudiante(int estID) {
        return participacionesService.obtenerParticipacionesPorEstudiante(estID);
    }

    public boolean insertarParticipacion(Participacion participacion) {
        return participacionesService.insertarParticipacion(participacion);
    }
}




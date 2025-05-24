/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.util.List;
import servicio.ParticipacionesService;
import src.model.Participacion;

/**
 *
 * @author ASUS
 */
public class ParticipacionController {
    
    private ParticipacionesService participacionesService;

    public ParticipacionController(ParticipacionesService participacionesService) {
        this.participacionesService = participacionesService;
    }

    public List<Participacion> listarParticipacionesPorEstudiante(int estID) {
        return participacionesService.obtenerParticipacionesPorEstudiante(estID);
    }
}

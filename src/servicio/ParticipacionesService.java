/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.List;
import src.dao.ParticipacionDAO;
import src.model.Participacion;

/**
 *
 * @author ASUS
 */
public class ParticipacionesService {
    private ParticipacionDAO participacionDAO;

    public ParticipacionesService(ParticipacionDAO participacionDAO) {
        this.participacionDAO = participacionDAO;
    }
    
    public List<Participacion> obtenerParticipacionesPorEstudiante(int estID) {
    return participacionDAO.obtenerParticipacionesPorEstudiante(estID);
}
}

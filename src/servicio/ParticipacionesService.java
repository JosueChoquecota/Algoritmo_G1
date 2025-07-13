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
    public boolean insertarParticipacion(Participacion participacion) {
    return participacionDAO.insertarParticipacion(participacion);
}
    public boolean registrarParticipacion(Participacion participacion) {
           int estID = participacion.getEstudiante().getEstID();
           int sesID = participacion.getSesion().getSesID();
           int puntosActuales = participacionDAO.obtenerPuntajeAcumulado(estID, sesID);
           int nuevoPuntaje = participacion.getPuntaje();

           if (puntosActuales + nuevoPuntaje > 3) {
               System.out.println("❌ No se puede registrar: se exceden los 3 puntos máximos por sesión.");
               return false;
           }

           return participacionDAO.insertarParticipacion(participacion);
       }
}

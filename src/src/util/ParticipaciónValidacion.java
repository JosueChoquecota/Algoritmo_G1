/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.util;

import src.model.Participacion;

/**
 *
 * @author ASUS
 */
public class ParticipaciónValidacion {
      public static boolean validarParticipacion(Participacion p) {
        if (p.getEstudiante() == null || p.getEstudiante().getEstID() <= 0)
            return false;

        if (p.getSesion() == null || p.getSesion().getSesID() <= 0)
            return false;

        if (p.getDocente() == null || p.getDocente().getDocID() <= 0)
            return false;

        if (p.getTipo() == null || !(p.getTipo().equals("aporte") ||
                                     p.getTipo().equals("pregunta") ||
                                     p.getTipo().equals("actividad")))
            return false;

        if (p.getPuntaje() < 1 || p.getPuntaje() > 3)
            return false;

        if (p.getFecha() == null)
            return false;

        return true;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.util.List;
import servicio.ParticipacionesService;
import src.dao.GrupoActividadDAO;
import src.dao.ParticipacionDAO;
import src.model.GrupoActividad;

/**
 *
 * @author ASUS
 */
public class GrupoActividadController {
        private GrupoActividadDAO grupoActividadDAO;

   public GrupoActividadController(GrupoActividadDAO grupoActividadDAO) {
        this.grupoActividadDAO = grupoActividadDAO;
    }
   
   public int insertarGrupoActividad(GrupoActividad grupo) {
       return grupoActividadDAO.insertarGrupoActividad(grupo);
   
   }
   public boolean eliminarIntegrante(int grupoID, int estID) {
        return grupoActividadDAO.eliminarIntegranteDelGrupo(grupoID, estID);
    }
    public boolean eliminarVariosIntegrantes(int grupoID, List<Integer> listaEstID) {
        boolean todoOk = true;
        for (int estID : listaEstID) {
            boolean eliminado = grupoActividadDAO.eliminarIntegranteDelGrupo(grupoID, estID);
            if (!eliminado) {
                todoOk = false; // Si alguno falla, marcarlo
            }
        }
        return todoOk;
    }

}

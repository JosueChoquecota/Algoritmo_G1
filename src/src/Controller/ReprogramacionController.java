/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import src.dao.ReprogramacionDAO;
import src.model.Reprogramación;

/**
 *
 * @author ASUS
 */
public class ReprogramacionController {
    private ReprogramacionDAO reprogramacionDAO;
    
    public ReprogramacionController(ReprogramacionDAO reprogramacionDAO) {
        this.reprogramacionDAO = reprogramacionDAO;
    }
    public boolean registrarReprogramacion(Reprogramación repro) {
        return reprogramacionDAO.registrarReprogramacion(repro);
    }
}

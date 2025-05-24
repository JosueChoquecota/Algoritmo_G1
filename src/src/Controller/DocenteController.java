/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import java.util.List;
import src.dao.DocenteDAO;
import src.model.Docente;

/**
 *
 * @author ASUS
 */
public class DocenteController {
    
    private DocenteDAO docenteDAO;
    
    public DocenteController(DocenteDAO docenteDAO) {
    this.docenteDAO = docenteDAO;
    }
    // REQMS-001: Registrar Docente
    public boolean registrarDocente(Docente docente) {
        return docenteDAO.insertarDocente(docente);
    }
    
    // REQMS-004: Login de docente
    public Docente loginDocente(String correo, String contrasena) {
        return docenteDAO.loginDocente(correo, contrasena);
    }
}

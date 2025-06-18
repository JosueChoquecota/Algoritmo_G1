/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

import src.dao.AdministradoDAO;
import src.model.Administrador;

/**
 *
 * @author ASUS
 */
public class AdministradorController {
    
    private AdministradoDAO administrador;
    
    public AdministradorController(AdministradoDAO administrador){
        this.administrador = administrador;
    }
    
    public Administrador loginAdministrador(String correo, String contrasena) {
        return administrador.loginAdministrador(correo, contrasena);      
    }
    
}

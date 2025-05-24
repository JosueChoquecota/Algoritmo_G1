/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.util;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;


/**
 *
 * @author ASUS
 */
public class ConexionBD {
//DATOS DE CONEXION A MI BASE DE DATOS SQL SERVER    
    Connection conectar = null;
    String usuario = "db_ab8e3a_sistemaparticipaci_admin";
    String contrasena = "a7852396541";
    String bd = "db_ab8e3a_sistemaparticipaci";
    String ip = " SQL1003.site4now.net";
    String puerto = "1433";
    String cadena = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + bd + ";encrypt=true;trustServerCertificate=true;";
    
//CON ESTO CONECTO MI SERVIDOR
        public Connection establecerConexion() {
        try {
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            System.out.println("Se conecto base de datos");        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return conectar;
    }
     public static void main(String[] args) {
        ConexionBD db = new ConexionBD();
        
         System.out.println(db.establecerConexion());
    }
}

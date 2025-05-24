/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import src.model.SesionDetalle;
import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.PreparedStatement; 

/**
 *
 * @author ASUS
 */
public class SesionDetalleDAO {
    
    private ConexionBD conn;

    public SesionDetalleDAO(ConexionBD conn) {
        this.conn = conn;
    }
    
    public boolean insertarDetalle(int sesID, SesionDetalle detalle) {
    String sql = "INSERT INTO SesionDetalle (sesID, tipo, duracionHoras, docenteID) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
        stmt.setInt(1, sesID);
        stmt.setString(2, detalle.getTipo());
        stmt.setInt(3, detalle.getDuracionHoras());

        if (detalle.getDocente() != null) {
            stmt.setInt(4, detalle.getDocente().getDocID());
        } else {
            stmt.setNull(4, java.sql.Types.INTEGER);
        }

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error insertando detalle: " + e.getMessage());
        return false;
    }
}

}

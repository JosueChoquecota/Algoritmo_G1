/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import java.sql.Connection;
import src.model.SesionDetalle;
import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.PreparedStatement; 
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class SesionDetalleDAO {
    
    private ConexionBD conn;

    public SesionDetalleDAO(ConexionBD conn) {
        this.conn = conn;
    }
    
   public boolean registrarDetalleSesion(int sesID, SesionDetalle detalle) {
        String sql = "INSERT INTO SesionDetalle (sesID, tipo, duracionHoras, docenteID) VALUES (?, ?, ?, ?)";
        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, sesID);
            stmt.setString(2, detalle.getTipo());
            stmt.setInt(3, detalle.getDuracionHoras());

            if (detalle.getDocente() != null) {
                stmt.setInt(4, detalle.getDocente().getDocID());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER); 
            }
            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al registrar detalle de sesión: " + e.getMessage());
            return false;
        }
    }

}

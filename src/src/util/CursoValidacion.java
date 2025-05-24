
package src.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CursoValidacion {
    private ConexionBD conn;
    
    public CursoValidacion(ConexionBD conn){
        this.conn = conn;
    }
    public boolean existeCursoPorCodigo(String cursoCodigo) {
        String sql = "SELECT COUNT(*) FROM Curso WHERE cursoCodigo = ?";
        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, cursoCodigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al validar curso existente: " + e.getMessage());
        }
        return false;
    }
    
    
}

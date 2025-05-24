
package servicio;

import java.sql.Connection;
import src.util.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
public class DocenteService {
    private ConexionBD conn;
    
    
    public DocenteService(ConexionBD conn) {
        this.conn = conn;
    }
    
    public String generarCodigoDocente() {
        String codigo = null;
        String sql = "{call GenerarCodigoDocente }";
       
        
        try (Connection connection = conn.establecerConexion();
             CallableStatement stmt = connection.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
        
            if (rs.next()) {
                codigo = rs.getString("CodigoGenerado");
            }
        
        } catch (SQLException e) {
        
            System.out.println("Error genrando codigo: " + e.getMessage());
        }
        return codigo;
    }
    
}

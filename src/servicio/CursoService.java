
package servicio;

import java.sql.Connection;
import src.util.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
public class CursoService {
       private ConexionBD conn;
       
       public CursoService(ConexionBD conn) {
        this.conn = conn;
    }

    public String generarCodigoCurso() {
        String codigo = null;
        String sql = "{ call GenerarCodigoCurso }";

        try (Connection connection = conn.establecerConexion();
             CallableStatement stmt = connection.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                codigo = rs.getString("codigoGenerado");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error generando código: " + e.getMessage());
        }

        return codigo;
    }
}

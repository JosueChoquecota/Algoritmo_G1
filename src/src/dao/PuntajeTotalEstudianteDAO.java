
package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import src.model.PuntajeTotalEstudiante;
import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import src.model.Curso;
import src.model.Docente;


public class PuntajeTotalEstudianteDAO {
    private ConexionBD conn;

    public PuntajeTotalEstudianteDAO(ConexionBD conn) {
        this.conn = conn;
    }
    
    public List<PuntajeTotalEstudiante> listarPuntajePorUnidad(int unidad, int cursoID, Docente docente) {
        List<PuntajeTotalEstudiante> lista = new ArrayList<>();
        String sql = "{call sp_puntaje_por_unidad(?, ?, ?)}";

        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, unidad);
            stmt.setInt(2, cursoID);
            stmt.setInt(3, docente.getDocID());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("Codigo");
                String nombre = rs.getString("nombreCompleto");
                int unidadResult = rs.getInt("unidad");
                int sesiones = rs.getInt("sesiones");
                int totalPuntaje = rs.getInt("totalPuntaje");
                double promedio = rs.getDouble("Promedio");
                int puntajeMaximo = rs.getInt("puntajeMaximo");

                PuntajeTotalEstudiante pte = new PuntajeTotalEstudiante(
                    codigo, nombre, unidadResult, sesiones, totalPuntaje, promedio, puntajeMaximo
                );

                lista.add(pte);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


}

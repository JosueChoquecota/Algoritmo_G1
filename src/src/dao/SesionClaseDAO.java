
package src.dao;


import src.util.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
import src.model.Curso;
import src.model.SesionClase;
/**
 *
 * @author ASUS
 */
public class SesionClaseDAO {
    private ConexionBD conn;

    public SesionClaseDAO(ConexionBD conn) {
        this.conn = conn;
    }
    
    public boolean insertarSesion(SesionClase sesion) {
    String sql = "INSERT INTO SesionClase (cursoID, fecha,tema,semana,ciclo, unidad) VALUES (?, ?, ?, ?, ?,?)";
    try (Connection connection = conn.establecerConexion();
         PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, sesion.getCurso().getCursoID());
        stmt.setDate(2, Date.valueOf(sesion.getFecha()));
        stmt.setInt(4, sesion.getSemana());
        stmt.setString(3, sesion.getTema());
        stmt.setString(5, sesion.getCiclo());
        stmt.setInt(6,sesion.getUnidad());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            sesion.setSesID(rs.getInt(1));
        }
        return true;
    } catch (SQLException e) {
        System.out.println("Error insertando sesión de clase: " + e.getMessage());
        return false;
    }
    }
    public SesionClase obtenerPrimeraSesionPorDocente(int docenteID) {
        String sql = """
            SELECT TOP 1 s.sesID, s.fecha, s.semana, s.unidad, s.cursoID, c.cursoNombre
                    FROM SesionClase s
                    JOIN SesionDetalle d ON s.sesID = d.sesID
                    JOIN Curso c ON s.cursoID = c.cursoID
                    WHERE d.docenteID = ?
                    ORDER BY s.fecha ASC
        """;

        try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
            stmt.setInt(1, docenteID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                SesionClase sesion = new SesionClase();
                sesion.setSesID(rs.getInt("sesID"));
                sesion.setFecha(rs.getDate("fecha").toLocalDate());
                sesion.setSemana(rs.getInt("semana"));
                sesion.setUnidad(rs.getInt("unidad"));
                // Aquí podrías instanciar el curso si lo necesitas completo
                Curso curso = new Curso();
                curso.setCursoID(rs.getInt("cursoID"));
                curso.setCursoNombre(rs.getString("cursoNombre"));
                sesion.setCurso(curso); // ✅ Aquí seteas el curso correctamente
                return sesion;
            }
        } catch (SQLException e) {
            System.out.println("❌ Error obteniendo sesión: " + e.getMessage());
        }
        return null;
    }

   
}

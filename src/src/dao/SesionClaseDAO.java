
package src.dao;


import src.util.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        String sql = "INSERT INTO SesionClase (cursoID, fecha, tema, semana, ciclo, unidad) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, sesion.getCurso().getCursoID());
            stmt.setDate(2, Date.valueOf(sesion.getFecha()));
            stmt.setString(3, sesion.getTema());
            stmt.setInt(4, sesion.getSemana());
            stmt.setString(5, sesion.getCiclo());
            stmt.setInt(6, sesion.getUnidad());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                sesion.setSesID(rs.getInt(1)); // guardar el ID generado
            }

            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error insertando sesión de clase: " + e.getMessage());
            return false;
        }
    }
    public List<Object[]> listarSesionesConDetallesPorCursoYDocente(int cursoID, int docenteID) {
        List<Object[]> lista = new ArrayList<>();

        String sql = """
            SELECT 
                s.sesID,
                s.unidad,
                s.semana,
                s.fecha,
                d.tipo,
                d.duracionHoras
            FROM SesionClase s
            JOIN SesionDetalle d ON s.sesID = d.sesID
            WHERE s.cursoID = ? AND d.docenteID = ?
            ORDER BY s.fecha
        """;

        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, cursoID);
            stmt.setInt(2, docenteID);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getInt("sesID"),          // ✅ ID de sesión
                    rs.getInt("unidad"),         // Unidad
                    rs.getInt("semana"),         // Semana
                    rs.getDate("fecha"),         // Fecha
                    rs.getString("tipo"),        // Tipo de sesión
                    rs.getInt("duracionHoras")   // Duración
                };
                lista.add(fila);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar sesiones por curso y docente: " + e.getMessage());
        }

        return lista;
    }



}

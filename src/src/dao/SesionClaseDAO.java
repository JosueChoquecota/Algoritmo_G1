
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
    //REQMS-020: Registrar sesión de clase
    //REQMS-019: Generar sesiones por semana 
    public boolean insertarSesion(SesionClase sesion) {
        String sql = "INSERT INTO SesionClase (cursoID, fecha, tema, semana, ciclo, unidad, horario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, sesion.getCurso().getCursoID());
            stmt.setDate(2, Date.valueOf(sesion.getFecha()));
            stmt.setString(3, sesion.getTema());
            stmt.setInt(4, sesion.getSemana());
            stmt.setString(5, sesion.getCiclo());
            stmt.setInt(6, sesion.getUnidad());
            stmt.setString(7, sesion.getHorario());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                sesion.setSesID(rs.getInt(1));
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
                    rs.getInt("sesID"),        
                    rs.getInt("unidad"),         
                    rs.getInt("semana"),        
                    rs.getDate("fecha"),        
                    rs.getString("tipo"),        
                    rs.getInt("duracionHoras")   
                };
                lista.add(fila);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar sesiones por curso y docente: " + e.getMessage());
        }

        return lista;
    }



}

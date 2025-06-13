/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import java.sql.Connection;
import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.PreparedStatement; 
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import src.model.Curso;
import src.model.Docente;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.model.Participacion;
import src.model.SesionDetalle;


public class EstudianteCursoDAO {
    private ConexionBD conn;

    public EstudianteCursoDAO(ConexionBD conn) {
        this.conn = conn;
    }
    //REQMS-009: Registrar estudiante a curso
    public boolean inscribirEstudianteACurso(int estID, int cursoID, int docID) {
        String sql = "INSERT INTO EstudianteCurso (estID, cursoID, docID) VALUES (?, ?,?)";

        try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
            stmt.setInt(1, estID);
            stmt.setInt(2, cursoID);
            stmt.setInt(3, docID);
            stmt.executeUpdate();
            System.out.println("✅ Estudiante " + estID + " inscrito al curso " + cursoID);
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al inscribir estudiante: " + e.getMessage());
            return false;
        }
    }
    
    //REQMS-013: Visualizar participaciones filtradas por clase, curso o tipo de sesión
    public List<EstudianteCurso> obtenerEstudiantesPorSesion(int sesionID) {
        List<EstudianteCurso> lista = new ArrayList<>();
        System.out.println("Sesión ID: " + sesionID);

        String sql = "{CALL ObtenerEstudiantesPorSesion(?)}";

        try (Connection connection = conn.establecerConexion();
             CallableStatement stmt = connection.prepareCall(sql)) {

            stmt.setInt(1, sesionID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setEstID(rs.getInt("estID")); // ✅ NUEVO
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCarrera(rs.getString("carrera"));
                estudiante.setCorreo(rs.getString("correo"));
                estudiante.setCodEst(rs.getString("codEst"));

                Curso curso = new Curso();

                EstudianteCurso ec = new EstudianteCurso();
                ec.setEstudiante(estudiante);
                ec.setCurso(curso);
                ec.setFechaInscripcion(rs.getDate("fechaInscripcion").toLocalDate());
                ec.setEstado(rs.getString("estado"));
                ec.setParticipacionTotal(rs.getInt("participacionTotal"));
                ec.setSesionID(sesionID);

                lista.add(ec);
            }

        } catch (SQLException ex) {
            System.out.println("❌ Error al obtener estudiantes por sesión: " + ex.getMessage());
        }

        return lista;
    }
}

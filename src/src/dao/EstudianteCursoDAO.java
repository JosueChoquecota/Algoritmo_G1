/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.PreparedStatement; 
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import src.model.Curso;
import src.model.Docente;
import src.model.Estudiante;
import src.model.EstudianteCurso;


public class EstudianteCursoDAO {
    private ConexionBD conn;

    public EstudianteCursoDAO(ConexionBD conn) {
        this.conn = conn;
    }
    
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
   
    public List<EstudianteCurso> listarEstudiantesPorCursoYDocente(int cursoID, int docenteID) throws SQLException {
    List<EstudianteCurso> lista = new ArrayList<>();
    String sql = "{call sp_ListarEstudiantesPorCursoYDocente(?, ?)}";

    try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {

        stmt.setInt(1, cursoID);
        stmt.setInt(2, docenteID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Estudiante est = new Estudiante();
            est.setEstID(rs.getInt("estID"));
            est.setNombre(rs.getString("nombre"));
            est.setApellido(rs.getString("apellido"));
            est.setCarrera(rs.getString("carrera"));
            est.setCorreo(rs.getString("correo"));
            est.setCodEst(rs.getString("codigo"));

            Curso curso = new Curso();
            curso.setCursoID(rs.getInt("cursoID"));
            curso.setCursoNombre(rs.getString("curso"));

            Docente docente = new Docente();
            docente.setDocID(docenteID); // puedes setear más si necesitas

            EstudianteCurso ec = new EstudianteCurso(
                est,
                curso,
                rs.getDate("fechaInscripcion").toLocalDate(),
                rs.getString("estado"),
                rs.getInt("puntosTotales"),
                docente
            );

            lista.add(ec);
        }

    return lista;
}
}

}

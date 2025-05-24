/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.PreparedStatement; 

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
    public static void main(String[] args) {

        ConexionBD conn = new ConexionBD();
        
        EstudianteCursoDAO inscripcionDAO = new EstudianteCursoDAO(conn);

        boolean resultado = inscripcionDAO.inscribirEstudianteACurso(6006, 1017,5001);

        if (resultado) {
            System.out.println("✅ Inscripción realizada correctamente.");
        } else {
            System.out.println("❌ Falló la inscripción.");
        }
    }
}

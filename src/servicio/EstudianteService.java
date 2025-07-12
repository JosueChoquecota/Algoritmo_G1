/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.dao.EstudianteDAO;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class EstudianteService {
    private ConexionBD conn;
       
    public EstudianteService(ConexionBD conn) {
        this.conn = conn;
    }
    private EstudianteDAO estudianteDAO;

    public EstudianteService(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }
    //CON ESTO GENERAS MI CODIGO ESTUDIANTE
    public String generarCodigoEstudiante() {
        String codigo = null;
        String sql = "{ call GenerarCodigoEstudiante }";
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

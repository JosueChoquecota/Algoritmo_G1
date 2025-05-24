
package src.dao;


import src.util.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import servicio.CursoService;
import servicio.DocenteService;
import servicio.EstudianteService;
import src.model.Estudiante;
import src.util.EstudianteValidacion;


public class EstudianteDAO {
    private ConexionBD conn;
    private EstudianteService service;

    public EstudianteDAO(ConexionBD conn) {
        this.conn = conn;
        this.service = new EstudianteService(conn);
    }
    // REQMS-034: Registrar alumno
    public boolean insertarEstudiante(Estudiante estudiante) {
        
        if (!EstudianteValidacion.validarDNI(estudiante.getDni())) {
               System.out.println("❌ El DNI debe tener exactamente 8 dígitos numéricos.");
               return false;
           }
        try {
            Connection connection = conn.establecerConexion();

            String sqlUsuario = "INSERT INTO Estudiante (codEst, carrera, dni, correo, estado, nombre, apellido) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, service.generarCodigoEstudiante());
                stmt.setString(2, estudiante.getCarrera());
                stmt.setString(3, estudiante.getDni());
                stmt.setString(4, estudiante.getCorreo());
                stmt.setBoolean(5, estudiante.getEstado());
                stmt.setString(6, estudiante.getNombre());
                stmt.setString(7, estudiante.getApellido());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    estudiante.setEstID(rs.getInt(1));
                } 
            }
   
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertando estudiante: " + e.getMessage());
            return false;
        }     
    }
    
    // REQMS-027: Retirar estudiante del curso
    public boolean retirarEstudianteDelCurso(int estID, int cursoID) {
        String sql = "DELETE FROM EstudianteCurso WHERE estID = ? AND cursoID = ?";
        try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
            stmt.setInt(1, estID);
            stmt.setInt(2, cursoID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al retirar estudiante del curso: " + e.getMessage());
            return false;
        }
    }    
   
 public List<Estudiante> listarEstudiantesPorCurso(int cursoID) {
    List<Estudiante> lista = new ArrayList<>();
    String sql = """
        SELECT e.estID, e.nombre
        FROM Estudiante e
        JOIN EstudianteCurso ec ON e.estID = ec.estID
        WHERE ec.cursoID = ?
    """;

    try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
        stmt.setInt(1, cursoID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Estudiante e = new Estudiante();
            e.setEstID(rs.getInt("estID"));
            e.setNombre(rs.getString("nombre"));
            lista.add(e);
        }
    } catch (SQLException e) {
        System.out.println("❌ Error listando estudiantes: " + e.getMessage());
    }

    return lista;
}

    
}

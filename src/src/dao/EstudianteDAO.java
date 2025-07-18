
package src.dao;


import java.sql.CallableStatement;
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
import src.model.Curso;
import src.model.Docente;
import src.model.Estudiante;
import src.model.EstudianteCurso;
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
        /*codigo marco*/
        if (dniExiste(estudiante.getDni())) {
            System.out.println(" DNI ya existe, no se inserta.");
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
    
    public List<EstudianteCurso> obtenerEstudiantesPorDocente(int DocenteID) {
        List<EstudianteCurso> lista = new ArrayList<>();
        System.out.println("Docente ID: " + DocenteID);

        String sql = "{CALL ObtenerEstudiantesPorDocente(?)}";

        try (Connection connection = conn.establecerConexion();
             CallableStatement stmt = connection.prepareCall(sql)) {

            stmt.setInt(1, DocenteID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                 Estudiante estudiante = new Estudiante();
                estudiante.setEstID(rs.getInt("estID")); 
                estudiante.setCodEst(rs.getString("codEst"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCarrera(rs.getString("carrera"));
                estudiante.setCorreo(rs.getString("correo"));

                Curso curso = new Curso();
                curso.setCursoNombre(rs.getString("cursoNombre"));

                EstudianteCurso ec = new EstudianteCurso();
                ec.setFechaInscripcion(rs.getDate("fechaInscripcion").toLocalDate());
                ec.setEstado(rs.getString("estado"));
                ec.setParticipacionTotal(rs.getInt("participacionTotal"));
                
                ec.setEstudiante(estudiante); // ✅ Esto faltaba
                ec.setCurso(curso);           // ✅ Esto faltaba

                lista.add(ec);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener estudiantes por sesión: " + ex.getMessage());
        }

        return lista;
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
/*CODIGO MARCO*/
    public boolean dniExiste(String dni) {
    String sql = "SELECT 1 FROM Estudiante WHERE dni = ?";
        try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Error comprobando DNI: " + ex.getMessage());
            return true; 
        }
    }
    public boolean correoExiste(String correo) {
        String sql = "SELECT 1 FROM Estudiante WHERE correo = ?";
        try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
            stmt.setString(1, correo);
            return stmt.executeQuery().next(); 
        } catch (SQLException e) {
            System.out.println("Error comprobando correo: " + e.getMessage());
            return true;       
        }
    }
    
 
    
}

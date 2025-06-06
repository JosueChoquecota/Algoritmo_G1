package src.dao;


import src.util.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.sql.Date;     
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import servicio.CursoService;
import src.model.Curso;
import src.util.CursoValidacion;

public class CursoDAO {
    
    private ConexionBD conn;
    
    private CursoService service;

    public CursoDAO(ConexionBD conn) {
        this.conn = conn;
        this.service = new CursoService(conn);

    }
    // REQMS-007: REGISTRAR CURSO
    public boolean insertarCurso(Curso curso, int semanas) {
        CursoValidacion validacion = new CursoValidacion(conn);

        if (validacion.existeCursoPorCodigo(curso.getCursoCodigo())) {
            System.out.println("⚠️ Cuidado, ya existe este curso con el código.");
            return false;
        }

        LocalDate fechaInicio = curso.getFechaInicio();
        LocalDate fechaFin = fechaInicio.plusWeeks(semanas);

        String sql = "INSERT INTO Curso (cursoNombre, cursoCodigo, ciclo, fechaInicio, fechaFin, modalidad, creditos, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, curso.getCursoNombre());
            stmt.setString(2, service.generarCodigoCurso());
            stmt.setString(3, curso.getCiclo());
            stmt.setDate(4, Date.valueOf(fechaInicio));
            stmt.setDate(5, Date.valueOf(fechaFin));
            stmt.setString(6, curso.getModalidad());
            stmt.setInt(7, curso.getCreditos());
            stmt.setBoolean(8, true);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                curso.setCursoID(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error insertando curso: " + e.getMessage());
            return false;
        }
    }
    // REQMS-010: RETIRAR CURSO
    public boolean retirarCurso(int cursoID) {
        String sql = "UPDATE Curso SET estado = ? WHERE cursoID = ?";

        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setBoolean(1, false); // false = retirado/inactivo
            stmt.setInt(2, cursoID);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Curso retirado correctamente.");
                return true;
            } else {
                System.out.println("⚠️ No se encontró un curso con ese ID.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al retirar curso: " + e.getMessage());
            return false;
        }
    }
      public List<Curso> obtenerCursosPorDocente(int docID) {
      List<Curso> cursos = new ArrayList<>();
      String sql = """
          SELECT c.cursoNombre, c.cursoCodigo, c.modalidad, c.ciclo
          FROM Curso c
          INNER JOIN CursoDocente cd ON c.cursoID = cd.cursoID
          WHERE cd.docID = ?
      """;

      try (Connection connection = conn.establecerConexion();
           PreparedStatement stmt = connection.prepareStatement(sql)) {

          stmt.setInt(1, docID);
          ResultSet rs = stmt.executeQuery();

          while (rs.next()) {
              Curso curso = new Curso();
              curso.setCursoNombre(rs.getString("cursoNombre"));
              curso.setCursoCodigo(rs.getString("cursoCodigo"));
              curso.setModalidad(rs.getString("modalidad"));
              curso.setCiclo(rs.getString("ciclo"));

              cursos.add(curso);
          }
      } catch (SQLException e) {
          System.out.println("❌ Error obteniendo cursos por docente: " + e.getMessage());
      }

      return cursos;
  }
      
      public int obtenerCursoIDPorCodigo(String codigo) {
        String sql = "SELECT cursoID FROM Curso WHERE cursoCodigo = ?";
        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cursoID");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error obteniendo cursoID: " + e.getMessage());
        }
        return -1;
}
}

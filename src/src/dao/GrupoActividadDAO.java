/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import servicio.EstudianteService;
import src.model.GrupoActividad;
import src.util.ConexionBD;
import java.sql.CallableStatement;
import src.util.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.util.ArrayList;
import java.util.List;
import src.model.Estudiante;

/**
 *
 * @author ASUS
 */
public class GrupoActividadDAO {
    private ConexionBD conn;

    public GrupoActividadDAO(ConexionBD conn) {
        this.conn = conn;
    }
    
   public int insertarGrupoActividad(GrupoActividad grupo) {
    String sqlGrupo = "INSERT INTO GrupoActividad (sesID, nombreGrupo, actividad) VALUES (?, ?, ?)";
    String sqlEstudiante = "INSERT INTO GrupoEstudiante (grupoID, estID) VALUES (?, ?)";

    Connection connection = null;
    PreparedStatement stmtGrupo = null;
    PreparedStatement stmtEstudiante = null;
    ResultSet generatedKeys = null;

    try {
        connection = conn.establecerConexion();
        connection.setAutoCommit(false); // Iniciar transacción

        // Insertar grupo
        stmtGrupo = connection.prepareStatement(sqlGrupo, Statement.RETURN_GENERATED_KEYS);
        stmtGrupo.setInt(1, grupo.getSesion().getSesID());
        stmtGrupo.setString(2, grupo.getNombreGrupo());
        stmtGrupo.setString(3, grupo.getActividad());
        stmtGrupo.executeUpdate();

        generatedKeys = stmtGrupo.getGeneratedKeys();
        int grupoID = -1;
        if (generatedKeys.next()) {
            grupoID = generatedKeys.getInt(1);
        } else {
            throw new SQLException("No se generó el ID del grupo.");
        }

        // Insertar integrantes
        stmtEstudiante = connection.prepareStatement(sqlEstudiante);
        for (Estudiante est : grupo.getIntegrantes()) {
            stmtEstudiante.setInt(1, grupoID);
            stmtEstudiante.setInt(2, est.getEstID());
            stmtEstudiante.addBatch();
        }
        stmtEstudiante.executeBatch();

        connection.commit(); // Todo correcto

        return grupoID; // ✅ Devolver grupoID generado

    } catch (SQLException e) {
        System.out.println("❌ Error al insertar grupo de actividad: " + e.getMessage());
        try {
            if (connection != null) connection.rollback();
        } catch (SQLException ex) {
            System.out.println("⚠️ Error al hacer rollback: " + ex.getMessage());
        }
        return -1; // ❌ Error
    } finally {
        try {
            if (generatedKeys != null) generatedKeys.close();
            if (stmtGrupo != null) stmtGrupo.close();
            if (stmtEstudiante != null) stmtEstudiante.close();
            if (connection != null) connection.setAutoCommit(true);
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            System.out.println("⚠️ Error al cerrar recursos: " + ex.getMessage());
        }
    }
}


    public List<Object[]> listarGruposEstudiantes(int sesionID) {
        List<Object[]> lista = new ArrayList<>();

        String sql = """
            SELECT 
                e.estID, 
                e.nombre, 
                e.apellido, 
                ga.grupoID,
                ga.nombreGrupo
            FROM GrupoActividad ga
            INNER JOIN GrupoEstudiante ge ON ga.grupoID = ge.grupoID
            INNER JOIN Estudiante e ON ge.estID = e.estID
            WHERE ga.sesID = ?
        """;

        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, sesionID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("estID");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getInt("grupoID");
                fila[4] = rs.getString("nombreGrupo");
                lista.add(fila);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar grupos de estudiantes: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminarIntegranteDelGrupo(int grupoID, int estID) {
    String sql = "DELETE FROM GrupoEstudiante WHERE grupoID = ? AND estID = ?";
    try (Connection conn = this.conn.establecerConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, grupoID);
        stmt.setInt(2, estID);

        int filas = stmt.executeUpdate();
        return filas > 0;
    } catch (SQLException e) {
        System.out.println("❌ Error al eliminar integrante del grupo: " + e.getMessage());
        return false;
    }
}

    
}

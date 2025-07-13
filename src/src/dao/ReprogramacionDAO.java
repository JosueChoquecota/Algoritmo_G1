
package src.dao;

import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.model.Reprogramación;
import src.model.SesionClase;

public class ReprogramacionDAO {
    private ConexionBD conn;

    public ReprogramacionDAO(ConexionBD conn) {
        this.conn = conn;
    }
    
    public boolean registrarReprogramacion(Reprogramación repro) {
    String actualizarSesionSQL = "UPDATE SesionClase SET fecha = ?, horario = ? WHERE sesID = ?";
    String insertarReprogramacionSQL = """
        INSERT INTO Reprogramacion (sesID, fechaAnterior, fechaNueva, motivo, horario)
        VALUES (?, ?, ?, ?, ?)
    """;

    try (Connection connection = conn.establecerConexion()) {
        connection.setAutoCommit(false); //

        //  Actualiza la sesión
        try (PreparedStatement stmtUpdate = connection.prepareStatement(actualizarSesionSQL)) {
            stmtUpdate.setDate(1, Date.valueOf(repro.getFechaNueva()));
            stmtUpdate.setString(2, repro.getHorario());
            stmtUpdate.setInt(3, repro.getSesion().getSesID());
            stmtUpdate.executeUpdate();
        }

        // Inserta la reprogramación
        try (PreparedStatement stmtInsert = connection.prepareStatement(insertarReprogramacionSQL)) {
            stmtInsert.setInt(1, repro.getSesion().getSesID());
            stmtInsert.setDate(2, Date.valueOf(repro.getFechaAnterior()));
            stmtInsert.setDate(3, Date.valueOf(repro.getFechaNueva()));
            stmtInsert.setString(4, repro.getMotivo());
            stmtInsert.setString(5, repro.getHorario());
            stmtInsert.executeUpdate();
        }

        connection.commit();
        return true;

    } catch (SQLException e) {
        System.out.println("❌ Error al registrar reprogramación: " + e.getMessage());
        return false;
    }
}
    
}

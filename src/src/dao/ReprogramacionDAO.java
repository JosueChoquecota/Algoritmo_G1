
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

        // 1. Actualiza la sesión
        try (PreparedStatement stmtUpdate = connection.prepareStatement(actualizarSesionSQL)) {
            stmtUpdate.setDate(1, Date.valueOf(repro.getFechaNueva()));
            stmtUpdate.setString(2, repro.getHorario());
            stmtUpdate.setInt(3, repro.getSesion().getSesID());
            stmtUpdate.executeUpdate();
        }

        // 2. Inserta la reprogramación
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
    public static void main(String[] args) {
            ConexionBD conexion = new ConexionBD();
            ReprogramacionDAO dao = new ReprogramacionDAO(conexion);
            Scanner leer = new Scanner(System.in);
            // Simulación de una sesión (supón que esta sesión existe)
            SesionClase sesion = new SesionClase();
            sesion.setSesID(2291); // Cambia esto por un ID real

            // Creamos la reprogramación
            Reprogramación repro = new Reprogramación();
            repro.setSesion(sesion);
            repro.setFechaAnterior(LocalDate.of(2025, 6, 11)); // Fecha actual original
            repro.setFechaNueva(LocalDate.of(2025, 4, 11));     // Fecha modificada
            repro.setMotivo("Docente no disponible");           // Ejemplo de motivo
            
            System.out.println("Ingrese el dia");
            String dia = leer.next();
            System.out.println("Ingrese el horario inicio");
            String horario1 = leer.next();
            System.out.println("Ingrese el horario inicio");
            String horario2 = leer.next();
            repro.setHorario(dia + " " + horario1 + " - " + horario2); 
            
            boolean resultado = dao.registrarReprogramacion(repro);

            if (resultado) {
                System.out.println("✅ Reprogramación registrada con éxito.");
            } else {
                System.out.println("❌ No se pudo registrar la reprogramación.");
            }
        }
    
}

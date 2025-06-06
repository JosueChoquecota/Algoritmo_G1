/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;


import src.util.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.model.Estudiante;
import src.model.Participacion;
import src.model.SesionClase;
import src.util.ParticipaciónValidacion;

/**
 *
 * @author ASUS
 */
public class ParticipacionDAO {
     private ConexionBD conn;

    public ParticipacionDAO(ConexionBD conn) {
        this.conn = conn;
    }

    // REQMS-010: Insertar participación
    public boolean insertarParticipacion(Participacion participacion) {
        
        if (!ParticipaciónValidacion.validarParticipacion(participacion)) {
        System.out.println("❌ Participación no válida.");
        return false;
    }
    String sql = "INSERT INTO Participacion (estudianteID, sesID, tipo, puntaje, observacion, fecha, docID) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection connection = conn.establecerConexion();
         PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, participacion.getEstudiante().getEstID());
        stmt.setInt(2, participacion.getSesion().getSesID());
        stmt.setString(3, participacion.getTipo());
        stmt.setInt(4, participacion.getPuntaje());
        stmt.setString(5, participacion.getObservacion());
        stmt.setDate(6, Date.valueOf(participacion.getFecha()));
        stmt.setInt(7, participacion.getDocente().getDocID()); 

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            participacion.setPartID(rs.getInt(1));
        }

        return true;
    } catch (SQLException e) {
        System.out.println("❌ Error insertando participación: " + e.getMessage());
        return false;
    }
    }

    public List<Participacion> obtenerParticipacionesPorEstudiante(int estID) {
    List<Participacion> lista = new ArrayList<>();
    String sql = "SELECT p.partID, p.tipo, p.puntaje, p.observacion, p.fecha, p.sesID " +
                 "FROM Participacion p WHERE p.estudianteID = ?";

    try (PreparedStatement stmt = conn.establecerConexion().prepareStatement(sql)) {
        stmt.setInt(1, estID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Participacion p = new Participacion();
            p.setPartID(rs.getInt("partID"));
            p.setTipo(rs.getString("tipo"));
            p.setPuntaje(rs.getInt("puntaje"));
            p.setObservacion(rs.getString("observacion"));
            p.setFecha(rs.getDate("fecha").toLocalDate());

            // Solo seteamos el ID de la sesión para referencia rápida
            SesionClase sesion = new SesionClase();
            sesion.setSesID(rs.getInt("sesID"));
            p.setSesion(sesion);

            lista.add(p);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener participaciones: " + e.getMessage());
    }
    return lista;
}
    
    
    
    
}

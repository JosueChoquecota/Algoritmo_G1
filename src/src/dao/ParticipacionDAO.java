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
import src.model.Curso;
import src.model.Estudiante;
import src.model.Participacion;
import src.model.PuntajeTotalEstudiante;
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
    String sql = "INSERT INTO Participacion (estudianteID, sesID, docID, puntaje, tipo, observacion, fecha) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection connection = conn.establecerConexion();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, participacion.getEstudiante().getEstID());
        stmt.setInt(2, participacion.getSesion().getSesID());
        stmt.setInt(3, participacion.getDocente().getDocID());
        stmt.setInt(4, participacion.getPuntaje());
        stmt.setString(5, participacion.getTipo());
        stmt.setString(6, participacion.getObservacion());
        stmt.setDate(7, java.sql.Date.valueOf(participacion.getFecha()));

        int filas = stmt.executeUpdate();
        

        return filas > 0;
    } catch (SQLException e) {
        System.out.println("❌ Error al insertar participación: " + e.getMessage());
        return false;
    }
}
   public int obtenerPuntajeAcumulado(int estudianteID, int sesionID) {
        String sql = "SELECT COALESCE(SUM(puntaje), 0) FROM Participacion WHERE estudianteID = ? AND sesID = ?";
        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, estudianteID);
            stmt.setInt(2, sesionID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener puntaje acumulado: " + e.getMessage());
        }

        return 0;
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

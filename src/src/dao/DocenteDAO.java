
package src.dao;


import src.model.Docente;
import src.util.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 
import java.sql.Date;     
import java.util.ArrayList;
import java.util.List;

import servicio.DocenteService;
import src.model.Curso;



public class DocenteDAO {
    
    private ConexionBD conn; 
    private DocenteService service;

   public DocenteDAO(ConexionBD conn) {
       this.conn = conn;
       this.service = new DocenteService(conn);
   }
   //REQMS-001: Registrar Docente
    public boolean insertarDocente(Docente docente) {
    try {
        Connection connection = conn.establecerConexion();

        String sql = "INSERT INTO Docente (especialidad, telefono, direccion, codDoc, fechaNacimiento, nombre, apellido, contraseña, correo) " +
             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, docente.getEspecialidad()); //<------
            stmt.setString(2, docente.getTelefono()); //<------
            stmt.setString(3, docente.getDireccion()); //<------
            stmt.setString(4, service.generarCodigoDocente());
            stmt.setDate(5, Date.valueOf(docente.getFechaNacimiento())); //<------
            stmt.setString(6, docente.getNombre()); //<------
            stmt.setString(7, docente.getApellido()); //<------ 
            stmt.setString(8, docente.getContraseña()); //<------ !! POR VERSE 
            stmt.setString(9, docente.getCorreo()); //<------
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                docente.setDocID(rs.getInt(1));
            }
            return true;
        }
    } catch (SQLException e) {
        System.out.println("❌ Error insertando docente: " + e.getMessage());
            return false;
        }
    }
    
    //REQMS-004: Iniciar sesión
    public Docente loginDocente(String correo, String contraseña) {
        String sql = "SELECT * FROM Docente WHERE correo = ? AND contraseña = ?";

        try (Connection connection = conn.establecerConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, correo);
            stmt.setString(2, contraseña);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Docente docente = new Docente();
                docente.setDocID(rs.getInt("docID"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellido(rs.getString("apellido"));
                docente.setCorreo(rs.getString("correo"));
                docente.setContraseña(rs.getString("contraseña"));
                docente.setEspecialidad(rs.getString("especialidad"));
                docente.setTelefono(rs.getString("telefono"));
                docente.setDireccion(rs.getString("direccion"));
                docente.setCodDoc(rs.getString("codDoc"));
                docente.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                return docente;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en login: " + e.getMessage());
        }

        return null; 
    }
    
    public int obtenerDocenteIDPorCorreo(String correo) {
        int docenteID = -1;
        
        String sql = "SELECT docID FROM Docente WHERE correo = ?";

            try (Connection connection = conn.establecerConexion();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setString(1, correo);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    docenteID = rs.getInt("docID");
                }

            } catch (SQLException e) {
                System.out.println("❌ Error al obtener ID del docente: " + e.getMessage());
            }

            return docenteID; // Devuelve -1 si no encuentra el docente o hay error
        }


}
    


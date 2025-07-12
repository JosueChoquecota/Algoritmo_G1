package src.dao;

import src.model.Administrador;
import java.sql.Connection;

import src.util.ConexionBD;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement; 

public class AdministradoDAO {
    
    private ConexionBD conn; 
    
    public AdministradoDAO(ConexionBD conn) {
           this.conn = conn;
    }
    
    public Administrador loginAdministrador(String correo, String contraseña) {
        Administrador admin = null;

        if (!correo.toLowerCase().endsWith("@admin.com")) {
            System.out.println("Solo se permite acceso a correos corporativos '@admin.com'");
            return null;
        }
        String sql = "SELECT * FROM Administrador WHERE correo = ? AND contraseña = ?";

        try (Connection connection = conn.establecerConexion();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, correo);
            stmt.setString(2, contraseña);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    admin = new Administrador();
                    admin.setAdminID(rs.getInt("adminID"));
                    admin.setNombre(rs.getString("nombre"));
                    admin.setApellido(rs.getString("apellido"));
                    admin.setCorreo(rs.getString("correo"));
                    admin.setContraseña(rs.getString("contraseña"));
                    admin.setEspecialidad(rs.getString("especialidad"));
                    admin.setTelefono(rs.getString("telefono"));
                    admin.setDireccion(rs.getString("direccion"));
                    admin.setCodAdmin(rs.getString("codAdmin"));
                    admin.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    admin.setEstado(rs.getString("estado"));
                    admin.setFechaRegistro(rs.getDate("fechaRegistro").toLocalDate());
                } else {
                    System.out.println("❌ Correo o contraseña incorrectos.");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al intentar iniciar sesión: " + e.getMessage());
        }

        return admin;
    }

}

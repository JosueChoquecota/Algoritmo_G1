
package test;

import src.Controller.EstudianteController;
import src.dao.EstudianteDAO;
import src.model.Estudiante;
import src.util.ConexionBD;


public class MainRegistrarEstudiante {
    public static void main(String[] args) {
        ConexionBD conn = new ConexionBD();

        // Crear DAO y Controller
        EstudianteDAO estudianteDAO = new EstudianteDAO(conn);
        EstudianteController estudianteController = new EstudianteController(estudianteDAO);

        // Crear nuevo estudiante
        Estudiante nuevoEst = new Estudiante();
        nuevoEst.setNombre("Jouse");
        nuevoEst.setApellido("Uruchi");
        nuevoEst.setCarrera("Ingieneria de Software ");
        nuevoEst.setCorreo("JosueChoquecota@gmail.com");
        nuevoEst.setDni("12345678");
        nuevoEst.setEstado(true); // activo por defecto

        // Insertar estudiante usando el controller
        boolean registrado = estudianteController.registrarEstudiante(nuevoEst);

        if (registrado) {
            System.out.println("✅ Estudiante registrado exitosamente.");
            System.out.println("🆔 ID generado: " + nuevoEst.getEstID());
        } else {
            System.out.println("❌ No se pudo registrar al estudiante.");
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.LocalDate;
import servicio.ParticipacionesService;
import src.Controller.ParticipacionController;
import src.dao.ParticipacionDAO;
import src.model.Docente;
import src.model.Estudiante;
import src.model.Participacion;
import src.model.SesionClase;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class MainRegistrarParticipacion {
      public static void main(String[] args) {
        // 1. Inicializar DAO y Servicio
        ParticipacionDAO participacionDAO = new ParticipacionDAO(new ConexionBD());
        ParticipacionesService service = new ParticipacionesService(participacionDAO);
        ParticipacionController controller = new ParticipacionController(service, participacionDAO);

        // 2. Crear instancia de Participación
        Participacion participacion = new Participacion();
        participacion.setPuntaje(1);  // Puedes cambiar el puntaje
        participacion.setTipo("teórica");  // teórica o práctica
        participacion.setObservacion("Participación destacada");
        participacion.setFecha(LocalDate.now());

        // 3. Asignar estudiante
        Estudiante estudiante = new Estudiante();
        estudiante.setEstID(6006);  // El ID del estudiante
        participacion.setEstudiante(estudiante);

        // 4. Asignar sesión
        SesionClase sesion = new SesionClase();
        sesion.setSesID(2280);  // ID de sesión
        participacion.setSesion(sesion);

        // 5. Asignar docente
        Docente docente = new Docente();
        docente.setDocID(5001);  // ID del docente
        participacion.setDocente(docente);
        System.out.println("Estudiante ID: " + participacion.getEstudiante().getEstID());
        System.out.println("Sesión ID: " + participacion.getSesion().getSesID());
        System.out.println("Docente ID: " + participacion.getDocente().getDocID());

        // 6. Insertar participación
        boolean exito = controller.insertarParticipacion(participacion);

        if (exito) {
            System.out.println("✅ Participación registrada correctamente.");
        } else {
            System.out.println("❌ No se pudo registrar la participación.");
        }
    }
}

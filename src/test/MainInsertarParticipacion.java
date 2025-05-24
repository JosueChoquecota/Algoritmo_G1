/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import java.time.LocalDate;
import java.util.List;
import src.dao.EstudianteDAO;
import src.dao.ParticipacionDAO;
import src.dao.SesionClaseDAO;
import src.model.Docente;
import src.model.Estudiante;
import src.model.Participacion;
import src.model.SesionClase;
import src.util.ConexionBD;

public class MainInsertarParticipacion {

    public static void main(String[] args) {
        ConexionBD conn = new ConexionBD();
        Docente docente = new Docente();

        // DAO instancias
        SesionClaseDAO sesionDAO = new SesionClaseDAO(conn);
        EstudianteDAO estudianteDAO = new EstudianteDAO(conn);
        ParticipacionDAO participacionDAO = new ParticipacionDAO(conn);

        int docenteID = 5001;

        // 1. Obtener la primera sesión del docente
        SesionClase sesion = sesionDAO.obtenerPrimeraSesionPorDocente(docenteID);
        if (sesion == null) {
            System.out.println("❌ No se encontraron sesiones para el docente.");
            return;
        }

        System.out.println("📅 Registrando participación para la sesión:");
        System.out.println("➡ Fecha: " + sesion.getFecha());
        System.out.println("➡ Semana: " + sesion.getSemana());
        System.out.println("➡ Unidad: " + sesion.getUnidad());

        // 2. Obtener estudiantes del curso
        int cursoID = 1017; // el curso actual que mencionas

        List<Estudiante> estudiantes = estudianteDAO.listarEstudiantesPorCurso(cursoID);

        if (estudiantes.isEmpty()) {
            System.out.println("⚠️ No hay estudiantes inscritos en el curso " + cursoID);
        } else {
            System.out.println("📋 Estudiantes inscritos en el curso " + cursoID + ":");
            for (Estudiante e : estudiantes) {
                System.out.println("🧑 ID: " + e.getEstID() + " | Nombre: " + e.getNombre());
            }
        }

        // 3. Seleccionar al primer estudiante (simulación)
        Estudiante est = estudiantes.get(0);

        // 4. Crear la participación
        Participacion participacion = new Participacion();
        participacion.setEstudiante(est);
        participacion.setSesion(sesion);
        participacion.setTipo("aporte");
        participacion.setPuntaje(1);
        participacion.setObservacion("Participación oral básica.");
        participacion.setFecha(LocalDate.now());

        docente.setDocID(docenteID);
        participacion.setDocente(docente);

        // 5. Insertar participación
        boolean exito = participacionDAO.insertarParticipacion(participacion);

        if (exito) {
            System.out.println("✅ Participación registrada para el estudiante: " + est.getNombre());
        } else {
            System.out.println("❌ Error al registrar la participación.");
        }
    }
}


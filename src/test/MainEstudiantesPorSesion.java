/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import src.Controller.EstudianteCursoController;
import src.dao.EstudianteCursoDAO;
import src.model.EstudianteCurso;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class MainEstudiantesPorSesion {
       public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Estudiantes por Sesión");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null);

            JTable tabla = new JTable();
            DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Nombre", "Apellido", "Carrera", "Correo", "Código", "FechaInscripción", "Estado", "Curso", "PuntosTotales"},
                0
            );
            tabla.setModel(modelo);

            // DAO + Controller
            ConexionBD conexionBD = new ConexionBD();
            EstudianteCursoDAO dao = new EstudianteCursoDAO(conexionBD);
            EstudianteCursoController controller = new EstudianteCursoController(dao);

            // Cambia este ID por uno válido de tu base de datos
            int sesionID = 2280;

            List<EstudianteCurso> lista = controller.obtenerEstudiantesPorSesion(sesionID);

            for (EstudianteCurso ec : lista) {
                modelo.addRow(new Object[]{
                    ec.getEstudiante().getNombre(),
                    ec.getEstudiante().getApellido(),
                    ec.getEstudiante().getCarrera(),
                    ec.getEstudiante().getCorreo(),
                    ec.getEstudiante().getCodEst(),
                    ec.getFechaInscripcion(),
                    ec.getEstado(),
                    ec.getCurso().getCursoNombre(),
                    ec.getParticipacionTotal()
                });
            }

            JScrollPane scrollPane = new JScrollPane(tabla);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
       }
}

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
import src.Controller.SesionClaseController;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.SesionClase;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class MainSesionesTabla {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tabla de Sesiones Generadas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);

            DefaultTableModel modelo = new DefaultTableModel(new Object[]{
                "Unidad", "Semana", "Fecha", "Tipo", "Horas"
            }, 0);

            JTable tabla = new JTable(modelo);
            JScrollPane scroll = new JScrollPane(tabla);
            frame.add(scroll, BorderLayout.CENTER);

            int cursoID = 1015;
            int docenteID = 5003;

            ConexionBD conexion = new ConexionBD();
            SesionClaseDAO sesionDAO = new SesionClaseDAO(conexion);
            SesionDetalleDAO detalleDAO = new SesionDetalleDAO(conexion);
            SesionClaseController controller = new SesionClaseController(sesionDAO, detalleDAO); // ✅ YA FUNCIONA

            List<Object[]> sesiones = controller.obtenerSesionesPorCursoYDocente(cursoID, docenteID);

            for (Object[] fila : sesiones) {
                modelo.addRow(fila);
            }

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

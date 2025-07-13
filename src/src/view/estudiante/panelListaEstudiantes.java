/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.view.estudiante;

import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import servicio.EstudianteCursoService;
import servicio.EstudianteService;
import servicio.ExportadorPDFService;
import src.Controller.EstudianteController;
import src.Controller.EstudianteCursoController;
import src.dao.EstudianteDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class panelListaEstudiantes extends javax.swing.JPanel {

    private  Docente docente;    
    private EstudianteController controllerEstudiante;
    private EstudianteCursoController controllerEst; 
    private List<EstudianteCurso> listaEstudiantesCurso;

    public panelListaEstudiantes(Docente docente, JPanel panelDashboard) {
        initComponents();
        this.docente = docente;
        this.panelDashboard = panelDashboard;
        this.controllerEstudiante = new EstudianteController(new EstudianteDAO(new ConexionBD()));
        this.controllerEst = new EstudianteCursoController(new EstudianteCursoService());


        cargarEstudiantesPorDocente();
        
    }
    private void cargarEstudiantesPorDocente() {
    EstudianteController controller = new EstudianteController(new EstudianteDAO(new ConexionBD()));
    listaEstudiantesCurso = controllerEstudiante.obtenerEstudiantesPorDocente(docente.getDocID());

    DefaultTableModel model = (DefaultTableModel) TablaEstudiantes.getModel();
    model.setRowCount(0);
List<EstudianteCurso> estudiantes = listaEstudiantesCurso;

    for (EstudianteCurso ec : estudiantes) {
        Estudiante est = ec.getEstudiante();
        Curso curso = ec.getCurso();

        model.addRow(new Object[]{
            est.getEstID(),
            est.getCodEst(),
            est.getNombre(),
            est.getApellido(),
            est.getCarrera(),
            est.getCorreo(),
            ec.getFechaInscripcion(),
            ec.getEstado(),
            curso.getCursoNombre(), 
            ec.getParticipacionTotal()
        });
    }
}
private void cargarTablaEstudiantes(List<EstudianteCurso> lista) {
    DefaultTableModel modelo = (DefaultTableModel) TablaEstudiantes.getModel();
    modelo.setRowCount(0); 

    for (EstudianteCurso ec : lista) {
        Estudiante est = ec.getEstudiante();
        Curso curso = ec.getCurso();

        modelo.addRow(new Object[]{
            est.getEstID(),
            est.getCodEst(),
            est.getNombre(),
            est.getApellido(),
            est.getCarrera(),
            est.getCorreo(),
            ec.getFechaInscripcion(),
            ec.getEstado(),
            curso.getCursoNombre(), 
            ec.getParticipacionTotal()
        });
    }
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDashboard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEstudiantes = new javax.swing.JTable();
        btnOrdenarPuntos = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        btnOrdenarDes = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        panelDashboard.setBackground(new java.awt.Color(204, 204, 204));
        panelDashboard.setPreferredSize(new java.awt.Dimension(635, 494));

        TablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "EstID", "codEst", "Nombre", "Apellido", "Carrera", "Correo", "FechaInscripcion", "Estado", "cursoNombre", "PuntosTotales"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEstudiantes);

        btnOrdenarPuntos.setBackground(new java.awt.Color(0, 0, 0));
        btnOrdenarPuntos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOrdenarPuntos.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenarPuntos.setText("Ordenar Puntos ↑");
        btnOrdenarPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPuntosActionPerformed(evt);
            }
        });

        btnPdf.setBackground(new java.awt.Color(255, 255, 255));
        btnPdf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPdf.setForeground(new java.awt.Color(0, 0, 0));
        btnPdf.setText("Imprimir PDF");
        btnPdf.setBorder(null);
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        btnOrdenarDes.setBackground(new java.awt.Color(0, 0, 0));
        btnOrdenarDes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOrdenarDes.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenarDes.setText("Ordenar Puntos ↓");
        btnOrdenarDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarDesActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ListAlumno.png"))); // NOI18N
        jLabel7.setText("Lista de Estudiantes:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Visualiza a los estudiantes registrados en el curso seleccionado. Puedes ordenar la lista por puntaje");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("acumulado y generar un reporte en PDF con un solo clic.");

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDashboardLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDashboardLayout.createSequentialGroup()
                        .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(panelDashboardLayout.createSequentialGroup()
                                .addComponent(btnOrdenarPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOrdenarDes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenarDes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenarPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 494, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPuntosActionPerformed
       if (listaEstudiantesCurso == null || listaEstudiantesCurso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes cargados.");
            return;
        }

        List<EstudianteCurso> ordenadosAsc = controllerEst.ordenarPorNotaAscendente(listaEstudiantesCurso);
        cargarTablaEstudiantes(ordenadosAsc);
    }//GEN-LAST:event_btnOrdenarPuntosActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
      JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            new ExportadorPDFService().exportarTabla(listaEstudiantesCurso, archivo);
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnOrdenarDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarDesActionPerformed
    if (listaEstudiantesCurso == null || listaEstudiantesCurso.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay estudiantes cargados.");
        return;
    }

    List<EstudianteCurso> ordenados = controllerEst.ordenarPorNotaDescendente(listaEstudiantesCurso);
    cargarTablaEstudiantes(ordenados);
        
        
    }//GEN-LAST:event_btnOrdenarDesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEstudiantes;
    private javax.swing.JButton btnOrdenarDes;
    private javax.swing.JButton btnOrdenarPuntos;
    private javax.swing.JButton btnPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDashboard;
    // End of variables declaration//GEN-END:variables
}

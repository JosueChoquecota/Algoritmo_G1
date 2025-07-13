/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.view.registrocurso;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.Controller.CursoController;
import src.dao.CursoDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.SesionDetalle;
import src.util.ConexionBD;
import src.view.docente.dashBoardDocente;
import src.view.participaciones.PanelEstudianteCurso;
import src.view.participaciones.PanelInfoSesionClase;

/**
 *
 * @author ASUS
 */
public class panelCursosDocente extends javax.swing.JPanel {

    private Docente docente;
    private javax.swing.JPanel panelDashboard; 
    private CursoDAO curso;
    private SesionDetalle sesion;

    /**
     * Creates new form panelCursosDocente
     */
    public panelCursosDocente(Docente docente, JPanel panelDashboard) {
                this.docente = docente;
                this.panelDashboard = panelDashboard;
                this.curso = new CursoDAO(new ConexionBD());
                initComponents();
                cargarCursos();
        
    }
    public void cargarCursos() {
         if (docente == null) {
            System.out.println("❌ Error: docente es null");
            return;
        }
        CursoController cursoController = new CursoController(new CursoDAO(new ConexionBD()));  
        List<Curso> cursos = cursoController.mostrarCursosDocente(docente.getDocID());
        DefaultTableModel model = (DefaultTableModel) TablaCursos.getModel();
        model.setRowCount(0);
        for (Curso c : cursos) {
            model.addRow(new Object[]{
                c.getCursoNombre(),
                c.getCursoCodigo(),
                c.getModalidad(),
                c.getCiclo(),
                c.getModalidad()
            });
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCursos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCursos = new javax.swing.JTable();
        btnSeleccionarCurso = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        PanelCursos.setBackground(new java.awt.Color(241, 241, 241));
        PanelCursos.setForeground(new java.awt.Color(255, 255, 255));
        PanelCursos.setPreferredSize(new java.awt.Dimension(635, 494));

        TablaCursos.setBackground(new java.awt.Color(255, 255, 255));
        TablaCursos.setForeground(new java.awt.Color(0, 0, 0));
        TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Curso", "CodigoCurso", "Modalidad ", "Ciclo", "Modalidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaCursos.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(TablaCursos);

        btnSeleccionarCurso.setBackground(new java.awt.Color(0, 0, 0));
        btnSeleccionarCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSeleccionarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarCurso.setText("Seleccionar");
        btnSeleccionarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCursoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cursos de Docente:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Estos son los cursos asignados al docente para el ciclo actual. Selecciona uno para visualizar sus sesiones,");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("gestionar la participación de los estudiantes y realizar reprogramaciones si es necesario.");

        javax.swing.GroupLayout PanelCursosLayout = new javax.swing.GroupLayout(PanelCursos);
        PanelCursos.setLayout(PanelCursosLayout);
        PanelCursosLayout.setHorizontalGroup(
            PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCursosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCursosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSeleccionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelCursosLayout.setVerticalGroup(
            PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCursosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCursoActionPerformed
        int filaSeleccionada = TablaCursos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un curso para continuar.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) TablaCursos.getModel();
        String codigoCurso = modelo.getValueAt(filaSeleccionada, 1).toString(); 

        int cursoID = curso.obtenerCursoIDPorCodigo(codigoCurso); 

   
        PanelInfoSesionClase panelSesion = new PanelInfoSesionClase(docente, cursoID, panelDashboard);
        panelSesion.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());

        panelDashboard.removeAll();
        panelDashboard.add(panelSesion, BorderLayout.CENTER);
        panelDashboard.revalidate();
        panelDashboard.repaint();

    }//GEN-LAST:event_btnSeleccionarCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCursos;
    private javax.swing.JTable TablaCursos;
    private javax.swing.JButton btnSeleccionarCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

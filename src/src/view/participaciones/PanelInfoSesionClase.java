/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.view.participaciones;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.Controller.SesionClaseController;
import src.dao.EstudianteCursoDAO;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.Docente;
import src.model.EstudianteCurso;
import src.model.SesionDetalle;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class PanelInfoSesionClase extends javax.swing.JPanel {

    private Docente docente;
    private int cursoID;
    private JPanel panelDashboard;
    
    public PanelInfoSesionClase(Docente docente, int cursoID, JPanel panelDashboard) {
        this.docente = docente;
        this.cursoID = cursoID;
        this.panelDashboard = panelDashboard;
        initComponents();
        cargarSesiones();

    }

   public void cargarSesiones() {
     SesionClaseController controller = new SesionClaseController(
            new SesionClaseDAO(new ConexionBD()),
            new SesionDetalleDAO(new ConexionBD())
        );
        List<Object[]> sesiones = controller.obtenerSesionesPorCursoYDocente(cursoID, docente.getDocID());

        DefaultTableModel modelo = (DefaultTableModel) TablaSesiones.getModel();
        modelo.setRowCount(0);

        for (Object[] fila : sesiones) {
            modelo.addRow(fila); // Esto ya contiene sesionID, unidad, semana, fecha, tipo, horas
        }
   }
   private int obtenerSesionIDDesdeTabla(int fila) {
    DefaultTableModel modelo = (DefaultTableModel) TablaSesiones.getModel();
    return Integer.parseInt(modelo.getValueAt(fila, 0).toString());
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCursos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaSesiones = new javax.swing.JTable();
        btnSeleccionarCurso = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        PanelCursos.setBackground(new java.awt.Color(204, 204, 204));

        TablaSesiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "SesionID", "Unidad", "Semana", "Fecha", "Tipo", "Horas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaSesiones);

        btnSeleccionarCurso.setBackground(new java.awt.Color(255, 153, 153));
        btnSeleccionarCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSeleccionarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarCurso.setText("Seleccionar");
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
        jLabel1.setText("Aqui va todos los cursos del docente para seleccionar al que le corresponde");

        javax.swing.GroupLayout PanelCursosLayout = new javax.swing.GroupLayout(PanelCursos);
        PanelCursos.setLayout(PanelCursosLayout);
        PanelCursosLayout.setHorizontalGroup(
            PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCursosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSeleccionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelCursosLayout.setVerticalGroup(
            PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCursosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSeleccionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCursoActionPerformed
        int filaSeleccionada = TablaSesiones.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una sesión.");
            return;
        }

        int sesionIDSeleccionado = obtenerSesionIDDesdeTabla(filaSeleccionada);
        System.out.println("✅ Sesión seleccionada: " + sesionIDSeleccionado);
        
        PanelEstudianteCurso panelEstudiantes = new PanelEstudianteCurso(cursoID, docente, sesionIDSeleccionado, panelDashboard);

        panelEstudiantes.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());
        panelDashboard.removeAll();
        panelDashboard.add(panelEstudiantes, BorderLayout.CENTER);
        panelDashboard.revalidate();
        panelDashboard.repaint();
    }//GEN-LAST:event_btnSeleccionarCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCursos;
    private javax.swing.JTable TablaSesiones;
    private javax.swing.JButton btnSeleccionarCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

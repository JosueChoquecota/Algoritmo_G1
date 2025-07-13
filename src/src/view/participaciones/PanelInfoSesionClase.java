/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.view.participaciones;

import java.awt.BorderLayout;
import java.time.LocalDate;
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
import src.model.SesionClase;
import src.model.SesionDetalle;
import src.util.ConexionBD;
import src.view.estudiante.panelReprogramacion;
import src.view.registrocurso.panelCursosDocente;

/**
 *
 * @author ASUS
 */
public class PanelInfoSesionClase extends javax.swing.JPanel {

    private Docente docente;
    private int cursoID;
    private JPanel panelDashboard;
    private panelCursosDocente panelDocente;
    
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
        List<Object[]> sesiones = 
        controller.obtenerSesionesPorCursoYDocente(cursoID, docente.getDocID());

        DefaultTableModel modelo = (DefaultTableModel) TablaSesiones.getModel();
        modelo.setRowCount(0);

        for (Object[] fila : sesiones) {
            modelo.addRow(fila);
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
        btnRepro = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

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

        btnSeleccionarCurso.setBackground(new java.awt.Color(0, 0, 0));
        btnSeleccionarCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSeleccionarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarCurso.setText("Seleccionar");
        btnSeleccionarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCursoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cursos de Docente:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aqui va todos los cursos del docente para seleccionar al que le corresponde");

        btnRepro.setBackground(new java.awt.Color(0, 0, 0));
        btnRepro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRepro.setForeground(new java.awt.Color(255, 255, 255));
        btnRepro.setText("Reprogramación");
        btnRepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 255, 255));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCursosLayout = new javax.swing.GroupLayout(PanelCursos);
        PanelCursos.setLayout(PanelCursosLayout);
        PanelCursosLayout.setHorizontalGroup(
            PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCursosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCursosLayout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRepro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(18, 18, 18)
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRepro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
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

    private void btnReproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproActionPerformed
        int fila = TablaSesiones.getSelectedRow();
       if (fila == -1) {
           JOptionPane.showMessageDialog(this, "Selecciona una sesión para reprogramar.");
           return;
       }

       DefaultTableModel modelo = (DefaultTableModel) TablaSesiones.getModel();

       int sesionID = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
       String unidad = modelo.getValueAt(fila, 1).toString();
       String semana = modelo.getValueAt(fila, 2).toString();
       LocalDate fecha = LocalDate.parse(modelo.getValueAt(fila, 3).toString());
       String tipo = modelo.getValueAt(fila, 4).toString();
       String horario = modelo.getValueAt(fila, 5).toString();

       SesionClase sesion = new SesionClase();
       sesion.setSesID(sesionID);
       sesion.setFecha(fecha);
       sesion.setHorario(horario);

       panelReprogramacion panelRepro = new panelReprogramacion(sesion, panelDashboard, docente, cursoID);
       panelRepro.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());
       panelDashboard.removeAll();
       panelDashboard.add(panelRepro, BorderLayout.CENTER);
       panelDashboard.revalidate();
       panelDashboard.repaint();
    }//GEN-LAST:event_btnReproActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        panelCursosDocente panel = new panelCursosDocente(docente, panelDashboard);
        panelDashboard.removeAll();
        panelDashboard.add(panel);
        panelDashboard.revalidate();
        panelDashboard.repaint();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCursos;
    private javax.swing.JTable TablaSesiones;
    private javax.swing.JButton btnRepro;
    private javax.swing.JButton btnSeleccionarCurso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

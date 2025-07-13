package src.view.participaciones;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.Controller.PuntajeTotalEstudianteController;
import src.dao.PuntajeTotalEstudianteDAO;
import src.model.Docente;
import src.model.PuntajeTotalEstudiante;
import src.util.ConexionBD;

public class panelCalculoPuntaje extends javax.swing.JPanel {
    private PuntajeTotalEstudianteController controller;
    private int cursoID;
    private Docente docente;
    private javax.swing.JPanel panelDashboard;
    private int sesionID;
    
    public panelCalculoPuntaje(Docente docente, int cursoID, int sesionID, JPanel panelDashboard) {
        initComponents();
        this.docente = docente;
        this.cursoID = cursoID;
        this.sesionID = sesionID;
        this.panelDashboard = panelDashboard;
        
        ConexionBD conn = new ConexionBD();
        PuntajeTotalEstudianteDAO dao = new PuntajeTotalEstudianteDAO(conn);
        controller = new PuntajeTotalEstudianteController(dao);

    }
    private void llenarTablaPorUnidad(int unidad) {
        List<PuntajeTotalEstudiante> lista = controller.listarPuntajePorUnidad(unidad, cursoID, docente);
        DefaultTableModel modelo = (DefaultTableModel) TablaPromedio.getModel();
        modelo.setRowCount(0); 

        for (PuntajeTotalEstudiante p : lista) {
            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNombreCompleto(),
                p.getUnidad(),
                p.getSesiones(),
                p.getTotalPuntaje(),
                String.format("%.2f", p.getPromedio()),
                p.getPuntajeMaximo()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnUnidad1 = new javax.swing.JButton();
        btnUnidad2 = new javax.swing.JButton();
        btnUnidad3 = new javax.swing.JButton();
        btnUnidad4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPromedio = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnUnidad1.setBackground(new java.awt.Color(0, 0, 0));
        btnUnidad1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUnidad1.setForeground(new java.awt.Color(255, 255, 255));
        btnUnidad1.setText("Unidad 1");
        btnUnidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidad1ActionPerformed(evt);
            }
        });

        btnUnidad2.setBackground(new java.awt.Color(0, 0, 0));
        btnUnidad2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUnidad2.setForeground(new java.awt.Color(255, 255, 255));
        btnUnidad2.setText("Unidad 2");
        btnUnidad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidad2ActionPerformed(evt);
            }
        });

        btnUnidad3.setBackground(new java.awt.Color(0, 0, 0));
        btnUnidad3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUnidad3.setForeground(new java.awt.Color(255, 255, 255));
        btnUnidad3.setText("Unidad 3");
        btnUnidad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidad3ActionPerformed(evt);
            }
        });

        btnUnidad4.setBackground(new java.awt.Color(0, 0, 0));
        btnUnidad4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUnidad4.setForeground(new java.awt.Color(255, 255, 255));
        btnUnidad4.setText("Unidad 4");
        btnUnidad4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidad4ActionPerformed(evt);
            }
        });

        TablaPromedio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre Completo", "Unidad", "Semanas", "Total Puntaje", "Promedio", "puntajeMáximo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaPromedio);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUnidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUnidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUnidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUnidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUnidad1)
                    .addComponent(btnUnidad2)
                    .addComponent(btnUnidad3)
                    .addComponent(btnUnidad4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidad1ActionPerformed
       llenarTablaPorUnidad(1);
    }//GEN-LAST:event_btnUnidad1ActionPerformed

    private void btnUnidad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidad2ActionPerformed
    llenarTablaPorUnidad(2);
    }//GEN-LAST:event_btnUnidad2ActionPerformed

    private void btnUnidad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidad3ActionPerformed
    llenarTablaPorUnidad(3);
    }//GEN-LAST:event_btnUnidad3ActionPerformed

    private void btnUnidad4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidad4ActionPerformed
    llenarTablaPorUnidad(4);
    }//GEN-LAST:event_btnUnidad4ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
            PanelEstudianteCurso panelEstudianteCurso = new PanelEstudianteCurso(cursoID, docente, sesionID, panelDashboard);
            panelDashboard.removeAll();
            panelDashboard.add(panelEstudianteCurso);
            panelDashboard.revalidate();
            panelDashboard.repaint();  
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPromedio;
    private javax.swing.JButton btnUnidad1;
    private javax.swing.JButton btnUnidad2;
    private javax.swing.JButton btnUnidad3;
    private javax.swing.JButton btnUnidad4;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

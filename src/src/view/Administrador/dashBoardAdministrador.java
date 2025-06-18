/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.view.Administrador;

import java.awt.BorderLayout;
import src.model.Administrador;
import src.view.Administrador.CursosAdm.PanelRegistroDocente;
import src.view.Administrador.CursosAdm.PanelRegistroEstudiante;
import src.view.Administrador.CursosAdm.PanelTablaAlumnos;
import src.view.Administrador.CursosAdm.panelCursos;

/**
 *
 * @author ASUS
 */
public class dashBoardAdministrador extends javax.swing.JFrame {

    private Administrador administrador;
    private panelCursos panelCursos;
    private PanelRegistroDocente panelDocente;
    private PanelRegistroEstudiante panelRegistroEstudiante;
    private PanelTablaAlumnos panelTablaAlumnos;
    
    public dashBoardAdministrador(Administrador administrador) {
        this.administrador = administrador;
        initComponents();
        setTitle("Panel del Administrador");
        
        panelDashboardAdm.setLayout(new BorderLayout()); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCursos = new javax.swing.JButton();
        btnDocente = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAlumnos1 = new javax.swing.JButton();
        panelDashboardAdm = new javax.swing.JPanel();

        panelDashboard.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        btnCursos.setBackground(new java.awt.Color(0, 153, 153));
        btnCursos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnCursos.setText("Registrar Curso");
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });

        btnDocente.setBackground(new java.awt.Color(0, 153, 153));
        btnDocente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDocente.setForeground(new java.awt.Color(255, 255, 255));
        btnDocente.setText("Registrar Curso");
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });

        btnAlumnos.setBackground(new java.awt.Color(0, 153, 153));
        btnAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setText("Registrar Alumno");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 153, 153));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Log Out");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAlumnos1.setBackground(new java.awt.Color(0, 153, 153));
        btnAlumnos1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlumnos1.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos1.setText("Asignar Alumnos a Curso");
        btnAlumnos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlumnos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnAlumnos1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panelDashboardAdm.setBackground(new java.awt.Color(204, 204, 204));
        panelDashboardAdm.setMaximumSize(new java.awt.Dimension(740, 650));
        panelDashboardAdm.setMinimumSize(new java.awt.Dimension(740, 650));
        panelDashboardAdm.setPreferredSize(new java.awt.Dimension(740, 650));

        javax.swing.GroupLayout panelDashboardAdmLayout = new javax.swing.GroupLayout(panelDashboardAdm);
        panelDashboardAdm.setLayout(panelDashboardAdmLayout);
        panelDashboardAdmLayout.setHorizontalGroup(
            panelDashboardAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        panelDashboardAdmLayout.setVerticalGroup(
            panelDashboardAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDashboardAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelDashboardAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        panelDashboardAdm.removeAll();
        panelRegistroEstudiante = new PanelRegistroEstudiante();
        panelDashboardAdm.add(panelRegistroEstudiante,BorderLayout.CENTER);
        panelRegistroEstudiante.setVisible(true);


    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        panelDashboardAdm.removeAll();  
        panelCursos = new panelCursos();
        panelDashboardAdm.add(panelCursos, BorderLayout.CENTER);
        panelCursos.setVisible(true);
        panelCursos.cargarDocente();
        panelDashboardAdm.revalidate();
        panelDashboardAdm.repaint();
    }//GEN-LAST:event_btnCursosActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        panelDashboardAdm.removeAll();
        panelDocente = new PanelRegistroDocente();
        panelDashboardAdm.add(panelDocente, BorderLayout.CENTER);
        panelDocente.setVisible(true);
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de que deseas cerrar sesión?", "Cerrar sesión",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose();
            new src.view.login.LoginForm().setVisible(true);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAlumnos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnos1ActionPerformed

                panelDashboardAdm.removeAll();
                panelTablaAlumnos = new PanelTablaAlumnos();
                panelDashboardAdm.add(panelTablaAlumnos, BorderLayout.CENTER);
                panelTablaAlumnos.setVisible(true);
    }//GEN-LAST:event_btnAlumnos1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnAlumnos1;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelDashboardAdm;
    // End of variables declaration//GEN-END:variables
}

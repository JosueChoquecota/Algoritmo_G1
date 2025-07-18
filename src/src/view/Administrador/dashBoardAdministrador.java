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
import src.view.docente.PanelListaDocentes;

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
    private PanelListaDocentes panelListaDocentes;
    
    public dashBoardAdministrador(Administrador administrador) {
        this.administrador = administrador;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Panel del Administrador");
        
        labelDocente.setText(administrador.getNombre() + " " + administrador.getApellido());
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
        btnAlumnos2 = new javax.swing.JButton();
        btnTablaDoncete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelDocente = new javax.swing.JLabel();
        panelDashboardAdm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnCursos.setBackground(new java.awt.Color(255, 255, 255));
        btnCursos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCursos.setForeground(new java.awt.Color(0, 0, 0));
        btnCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Cursos.png"))); // NOI18N
        btnCursos.setText("Registrar Curso");
        btnCursos.setBorder(null);
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });

        btnDocente.setBackground(new java.awt.Color(255, 255, 255));
        btnDocente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDocente.setForeground(new java.awt.Color(0, 0, 0));
        btnDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/cursos_registro.png"))); // NOI18N
        btnDocente.setText("Registrar Curso");
        btnDocente.setBorder(null);
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });

        btnAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        btnAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Estudiantes.png"))); // NOI18N
        btnAlumnos.setText("Registrar Alumno");
        btnAlumnos.setBorder(null);
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Log Out");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAlumnos2.setBackground(new java.awt.Color(0, 0, 0));
        btnAlumnos2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlumnos2.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos2.setText("Lista Alumnos");
        btnAlumnos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnos2ActionPerformed(evt);
            }
        });

        btnTablaDoncete.setBackground(new java.awt.Color(0, 0, 0));
        btnTablaDoncete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTablaDoncete.setForeground(new java.awt.Color(255, 255, 255));
        btnTablaDoncete.setText("Lista Docentes");
        btnTablaDoncete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaDonceteActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Marca.png"))); // NOI18N
        jLabel3.setText("PuntoClase");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/usuario.png"))); // NOI18N

        labelDocente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelDocente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDocente.setText("NombreAdm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlumnos2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTablaDoncete, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(labelDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(labelDocente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlumnos2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTablaDoncete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        panelDashboardAdm.setBackground(new java.awt.Color(255, 255, 255));
        panelDashboardAdm.setForeground(new java.awt.Color(255, 255, 255));
        panelDashboardAdm.setMaximumSize(new java.awt.Dimension(740, 650));
        panelDashboardAdm.setMinimumSize(new java.awt.Dimension(740, 650));
        panelDashboardAdm.setPreferredSize(new java.awt.Dimension(740, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Panel_adm.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bienvenido al Panel de Administración ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Accede a las herramientas esenciales para gestionar eficientemente la plataforma educativa.  ");

        javax.swing.GroupLayout panelDashboardAdmLayout = new javax.swing.GroupLayout(panelDashboardAdm);
        panelDashboardAdm.setLayout(panelDashboardAdmLayout);
        panelDashboardAdmLayout.setHorizontalGroup(
            panelDashboardAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardAdmLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelDashboardAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelDashboardAdmLayout.setVerticalGroup(
            panelDashboardAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDashboardAdmLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDashboardAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelDashboardAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
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

    private void btnTablaDonceteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaDonceteActionPerformed
        panelDashboardAdm.removeAll();
        panelListaDocentes = new PanelListaDocentes();
        panelDashboardAdm.add(panelListaDocentes,BorderLayout.CENTER);
        panelListaDocentes.setVisible(true);
        panelDashboardAdm.revalidate();
        panelDashboardAdm.repaint();
    }//GEN-LAST:event_btnTablaDonceteActionPerformed

    private void btnAlumnos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnos2ActionPerformed
        panelDashboardAdm.removeAll();
        panelTablaAlumnos = new PanelTablaAlumnos();
        panelDashboardAdm.add(panelTablaAlumnos, BorderLayout.CENTER);
        panelTablaAlumnos.setVisible(true);
    }//GEN-LAST:event_btnAlumnos2ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de que deseas cerrar sesión?", "Cerrar sesión",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose();
            new src.view.login.LoginForm().setVisible(true);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        panelDashboardAdm.removeAll();
        panelRegistroEstudiante = new PanelRegistroEstudiante();
        panelDashboardAdm.add(panelRegistroEstudiante,BorderLayout.CENTER);
        panelRegistroEstudiante.setVisible(true);
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        panelDashboardAdm.removeAll();
        panelDocente = new PanelRegistroDocente();
        panelDashboardAdm.add(panelDocente, BorderLayout.CENTER);
        panelDocente.setVisible(true);
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        panelDashboardAdm.removeAll();
        panelCursos = new panelCursos();
        panelDashboardAdm.add(panelCursos, BorderLayout.CENTER);
        panelCursos.setVisible(true);
        panelCursos.cargarDocente();
        panelDashboardAdm.revalidate();
        panelDashboardAdm.repaint();
    }//GEN-LAST:event_btnCursosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnAlumnos2;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTablaDoncete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelDocente;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelDashboardAdm;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.view.estudiante;

import java.awt.BorderLayout;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import src.Controller.ReprogramacionController;
import src.dao.ReprogramacionDAO;
import src.model.Docente;
import src.model.Reprogramación;
import src.model.SesionClase;
import src.util.ConexionBD;
import src.view.participaciones.PanelInfoSesionClase;


public class panelReprogramacion extends javax.swing.JPanel {

    private SesionClase sesionSeleccionada;
    private JPanel panelDashboard;
    private Docente docente;
    private int cursoID;
    
    public panelReprogramacion(SesionClase sesionSeleccionada, JPanel panelDashboard, Docente docente, int cursoID) {
        this.sesionSeleccionada = sesionSeleccionada;
        this.panelDashboard = panelDashboard;
        this.docente = docente;
        this.cursoID = cursoID;
        initComponents();
        cargarDatosSesion();
    }


      private void cargarDatosSesion() {
        fecha_Actual.setText(sesionSeleccionada.getFecha().toString());
        Dia_Actual1.setText(sesionSeleccionada.getHorario());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        boxDia1 = new javax.swing.JComboBox<>();
        txtHora1 = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        fecha_Actual = new javax.swing.JLabel();
        btnRepro = new javax.swing.JButton();
        Dia_Actual = new javax.swing.JLabel();
        Dia_Actual1 = new javax.swing.JLabel();
        txtHora2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/tiemp.png"))); // NOI18N
        jLabel7.setText("Reprogramación de Clase:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fecha Actual:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Hora Actual:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dia Actual:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Dia Modificada:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha Modificada:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Hora Inicio:");

        boxDia1.setBackground(new java.awt.Color(255, 255, 255));
        boxDia1.setForeground(new java.awt.Color(0, 0, 0));
        boxDia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado" }));

        txtHora1.setBackground(new java.awt.Color(255, 255, 255));
        txtHora1.setForeground(new java.awt.Color(0, 0, 0));
        txtHora1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHora1ActionPerformed(evt);
            }
        });

        txtAno.setBackground(new java.awt.Color(255, 255, 255));
        txtAno.setForeground(new java.awt.Color(0, 0, 0));
        txtAno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAno.setText("2025");
        txtAno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtMes.setBackground(new java.awt.Color(255, 255, 255));
        txtMes.setForeground(new java.awt.Color(0, 0, 0));
        txtMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMes.setText("05");
        txtMes.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtDia.setBackground(new java.awt.Color(255, 255, 255));
        txtDia.setForeground(new java.awt.Color(0, 0, 0));
        txtDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDia.setText("12");
        txtDia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDia.setPreferredSize(new java.awt.Dimension(55, 22));

        fecha_Actual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fecha_Actual.setForeground(new java.awt.Color(0, 0, 0));
        fecha_Actual.setText("Fecha_Actual");

        btnRepro.setBackground(new java.awt.Color(0, 0, 0));
        btnRepro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRepro.setForeground(new java.awt.Color(255, 255, 255));
        btnRepro.setText("Reprogramar");
        btnRepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproActionPerformed(evt);
            }
        });

        Dia_Actual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Dia_Actual.setForeground(new java.awt.Color(0, 0, 0));
        Dia_Actual.setText("Dia_Actual");

        Dia_Actual1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Dia_Actual1.setForeground(new java.awt.Color(0, 0, 0));
        Dia_Actual1.setText("Hora_Actual");

        txtHora2.setBackground(new java.awt.Color(255, 255, 255));
        txtHora2.setForeground(new java.awt.Color(0, 0, 0));
        txtHora2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHora2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Hora Final:");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha_Actual))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Dia_Actual)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Dia_Actual1)
                                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(boxDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRepro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha_Actual)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dia_Actual)
                    .addComponent(boxDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dia_Actual1))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRepro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
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

    private void btnReproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproActionPerformed
       try {
        // Obtener valores
        int anio = Integer.parseInt(txtAno.getText().trim());
        int mes = Integer.parseInt(txtMes.getText().trim());
        int dia = Integer.parseInt(txtDia.getText().trim());
        String diaModificado = boxDia1.getSelectedItem().toString();
        String horaInicio = txtHora1.getText().trim();
        String horaFin = txtHora2.getText().trim();

        // Validar datos
        if (horaInicio.isEmpty() || horaFin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos de hora.");
            return;
        }

        LocalDate fechaModificada = LocalDate.of(anio, mes, dia);

        // Crear objeto de reprogramación
        Reprogramación repro = new Reprogramación();
        repro.setSesion(sesionSeleccionada);
        repro.setFechaAnterior(sesionSeleccionada.getFecha());
        repro.setFechaNueva(fechaModificada);
        repro.setHorario(diaModificado + " " + horaInicio + " - " + horaFin);

        // Guardar en base de datos
        ReprogramacionController controller = new ReprogramacionController(new ReprogramacionDAO(new ConexionBD()));
        boolean exito = controller.registrarReprogramacion(repro);

        if (exito) {
            JOptionPane.showMessageDialog(this, "✅ Se reprogramó correctamente.");

            // Volver al panel de sesiones
            PanelInfoSesionClase panelSesiones = new PanelInfoSesionClase(docente, 
                                                                           cursoID,
                                                                           panelDashboard);
            panelSesiones.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());
            panelDashboard.removeAll();
            panelDashboard.add(panelSesiones, BorderLayout.CENTER);
            panelDashboard.revalidate();
            panelDashboard.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Ocurrió un error al reprogramar la sesión.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "⚠ Error: " + e.getMessage());
        e.printStackTrace();
    }
        
        
        
    }//GEN-LAST:event_btnReproActionPerformed

    private void txtHora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHora1ActionPerformed

    private void txtHora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHora2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHora2ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        PanelInfoSesionClase panel = new PanelInfoSesionClase(docente, cursoID, panelDashboard);
        panelDashboard.removeAll();
        panelDashboard.add(panel);
        panelDashboard.revalidate();
        panelDashboard.repaint();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dia_Actual;
    private javax.swing.JLabel Dia_Actual1;
    private javax.swing.JComboBox<String> boxDia1;
    private javax.swing.JButton btnRepro;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fecha_Actual;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtHora1;
    private javax.swing.JTextField txtHora2;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}

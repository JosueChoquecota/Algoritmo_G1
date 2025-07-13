package src.view.docente;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.util.ConexionBD;
        
public class PanelListaDocentes extends javax.swing.JPanel {
        private static final String Q_DOCENTES = """
        SELECT docID , nombre , apellido , codDoc , correo
        FROM   Docente
        ORDER  BY apellido , nombre
        """;

        private static final String D_SESIONDET = "DELETE FROM SesionDetalle WHERE docenteID = ?";
        private static final String D_CURSO_DOC = "DELETE FROM CursoDocente  WHERE docID     = ?";
        private static final String D_DOCENTE   = "DELETE FROM Docente       WHERE docID     = ?";

        private final DefaultTableModel modelo = new DefaultTableModel(
                null, new String[]{"docID", "Nombre", "Apellidos", "Código", "Correo"}) {

            @Override public boolean isCellEditable(int r, int c) { return false; }
        };

    public PanelListaDocentes() {
        initComponents(); 
        tablaDocentes.setModel(modelo);
        ocultarColumnaId();
        cargarDocentes();  
    }
    
    private void cargarDocentes() {
        modelo.setRowCount(0);

        try (Connection cn = new ConexionBD().establecerConexion();
             Statement  st = cn.createStatement();
             ResultSet  rs = st.executeQuery(Q_DOCENTES)) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt   ("docID"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("codDoc"),
                    rs.getString("correo")
                });
            }
        } catch (SQLException ex) {
            error("Error al cargar docentes", ex);
        }
    }
    
    private void eliminarDocente() {
        int fila = tablaDocentes.getSelectedRow();
        if (fila == -1) {
            info("Selecciona un docente.");
            return;
        }

        int docID   = (Integer) modelo.getValueAt(fila, 0);
        String nombre = (String) modelo.getValueAt(fila, 1);
        String apellido = (String) modelo.getValueAt(fila, 2);
        
        int ok = JOptionPane.showConfirmDialog(
                this, "¿Eliminar definitivamente a " + nombre + " " + apellido +"?",
                "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (ok != JOptionPane.YES_OPTION) return;

        try (Connection cn = new ConexionBD().establecerConexion()) {
            cn.setAutoCommit(false);

            try (PreparedStatement ps1 = cn.prepareStatement(D_SESIONDET);
                 PreparedStatement ps2 = cn.prepareStatement(D_CURSO_DOC);
                 PreparedStatement ps3 = cn.prepareStatement(D_DOCENTE)) {

                ps1.setInt(1, docID); ps1.executeUpdate();
                ps2.setInt(1, docID); ps2.executeUpdate();

                ps3.setInt(1, docID);
                int filas = ps3.executeUpdate();

                cn.commit();

                if (filas == 1) modelo.removeRow(fila);
                else            info("No se encontró el registro.");

            } catch (SQLException ex) {
                cn.rollback();
                throw ex;
            }

        } catch (SQLException ex) {
            error("No se pudo eliminar", ex);
        }
    }
    
    private void ocultarColumnaId() {
        tablaDocentes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaDocentes.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void info(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void error(String titulo, Exception ex) {
        JOptionPane.showMessageDialog(this,titulo + ":\n" + ex.getMessage(),"BD", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocentes = new javax.swing.JTable();
        btnInhabilitar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tabla Docentes:");

        tablaDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Codigo", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tablaDocentes);

        btnInhabilitar.setBackground(new java.awt.Color(0, 0, 0));
        btnInhabilitar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInhabilitar.setForeground(new java.awt.Color(255, 255, 255));
        btnInhabilitar.setText("Inhabilitar");
        btnInhabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInhabilitarActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Consulta y gestiona la lista de docentes registrados en el sistema. ");

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Desde esta tabla puedes visualizar sus datos y deshabilitar aquellos usuarios que ya no estén activos.  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(500, 500, 500)
                                        .addComponent(btnInhabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnInhabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
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

    private void btnInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhabilitarActionPerformed
        eliminarDocente();  
    }//GEN-LAST:event_btnInhabilitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInhabilitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDocentes;
    // End of variables declaration//GEN-END:variables
}

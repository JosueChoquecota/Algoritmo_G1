package src.view.Administrador.CursosAdm;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.util.ConexionBD;
import java.sql.PreparedStatement;

public class PanelTablaAlumnos extends javax.swing.JPanel {

    private static final String SQL_INSERT_RETIRO
            = "INSERT INTO EstudianteRetiro (estID, fechaRetiro, motivo) "
            + "VALUES (?, GETDATE(), ?)";
    private static final String SQL_UPDATE_ESTADO
            = "UPDATE Estudiante SET estado = 0 WHERE estID = ?";

    public PanelTablaAlumnos() {
        initComponents();
        cargarCursos();

        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"ID", "Nombre", "Apellido", "Correo", "Código"}, 0);
        tablaAlumnos.setModel(modelo);

        tablaAlumnos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaAlumnos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAlumnos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        cargarTabla();
    }

    private static class CursoInfo {

        int cursoID;
        int docID;

        CursoInfo(int cursoID, int docID) {
            this.cursoID = cursoID;
            this.docID = docID;
        }
    }

    private CursoInfo obtenerCursoInfo(String cursoCodigo) throws SQLException {
        String sql = """
            SELECT c.cursoID , cd.docID
            FROM   Curso c
            JOIN   CursoDocente cd ON cd.cursoID = c.cursoID
            WHERE  c.cursoCodigo = ?
            """;
        try (Connection cn = new ConexionBD().establecerConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, cursoCodigo);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? new CursoInfo(rs.getInt("cursoID"), rs.getInt("docID")) : null;
            }
        }
    }

    private void cargarTabla() {
        cargarTabla(null);
    }

    private void cargarTabla(Integer cursoID) {
        DefaultTableModel m = (DefaultTableModel) tablaAlumnos.getModel();
        m.setRowCount(0);

        String sql = """
            SELECT  e.estID, e.nombre, e.apellido, e.correo, e.codEst
            FROM    Estudiante e
            """;
        String where = "WHERE e.estado = 1";
        if (cursoID != null) {
            sql += "JOIN EstudianteCurso ec ON ec.estID = e.estID ";
            where += " AND ec.cursoID = ?";
        }
        sql += where + " ORDER BY e.apellido, e.nombre";

        try (Connection cn = new ConexionBD().establecerConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            if (cursoID != null) {
                ps.setInt(1, cursoID);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    m.addRow(new Object[]{
                        rs.getInt("estID"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("codEst")
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar alumnos:\n" + ex.getMessage(),
                    "BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarCursos() {
        tablaComboCursos.removeAllItems();
        tablaComboCursos.addItem("Seleccionar curso");

        String sql = "SELECT DISTINCT cursoNombre FROM Curso ORDER BY cursoNombre";

        try (Connection cn = new ConexionBD().establecerConexion(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                tablaComboCursos.addItem(rs.getString("cursoNombre"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar cursos:\n" + ex.getMessage(),
                    "BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarCodigos(String curso) {
        tablaComboCodigos.removeAllItems();
        tablaComboCodigos.addItem("Código curso");

        String sql = "SELECT DISTINCT cursoCodigo FROM Curso WHERE cursoNombre = ? ORDER BY cursoCodigo";

        try (Connection cn = new ConexionBD().establecerConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, curso);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tablaComboCodigos.addItem(rs.getString("cursoCodigo"));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar códigos:\n" + ex.getMessage(),
                    "BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inhabilitarAlumno() {
        int fila = tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un alumno.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int estID = (Integer) tablaAlumnos.getValueAt(fila, 0);
        String nombre = (String) tablaAlumnos.getValueAt(fila, 1);
        String apellido = (String) tablaAlumnos.getValueAt(fila, 2);

        String motivo = JOptionPane.showInputDialog(this,
                "Motivo de retiro para " + nombre + " " + apellido + ":");
        if (motivo == null || motivo.trim().isEmpty()) {
            return;
        }

        int ok = JOptionPane.showConfirmDialog(this,
                "¿Inhabilitar a " + nombre + " " + apellido + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (ok != JOptionPane.YES_OPTION) {
            return;
        }

        try (Connection cn = new ConexionBD().establecerConexion(); PreparedStatement psIns = cn.prepareStatement(SQL_INSERT_RETIRO); PreparedStatement psUpd = cn.prepareStatement(SQL_UPDATE_ESTADO)) {

            cn.setAutoCommit(false);

            psIns.setInt(1, estID);
            psIns.setString(2, motivo.trim());
            psIns.executeUpdate();

            psUpd.setInt(1, estID);
            psUpd.executeUpdate();

            cn.commit();
            ((DefaultTableModel) tablaAlumnos.getModel()).removeRow(fila);
            JOptionPane.showMessageDialog(this, "Alumno inhabilitado y motivo registrado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al inhabilitar:\n" + ex.getMessage(), "BD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        tablaComboCursos = new javax.swing.JComboBox<>();
        panelTablaAlumnosBtnAgregar = new javax.swing.JButton();
        tablaComboCodigos = new javax.swing.JComboBox<>();
        btnMostrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tabla de Estudiantes:");

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nombre", "Apellido", "Correo", "Codigo"
            }
        ));
        jScrollPane1.setViewportView(tablaAlumnos);

        tablaComboCursos.setBackground(new java.awt.Color(255, 255, 255));
        tablaComboCursos.setForeground(new java.awt.Color(0, 0, 0));
        tablaComboCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Curso", "Item 2", "Item 3", "Item 4" }));
        tablaComboCursos.setBorder(null);
        tablaComboCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablaComboCursosActionPerformed(evt);
            }
        });

        panelTablaAlumnosBtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        panelTablaAlumnosBtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        panelTablaAlumnosBtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        panelTablaAlumnosBtnAgregar.setText("Agregar");
        panelTablaAlumnosBtnAgregar.setBorder(null);
        panelTablaAlumnosBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelTablaAlumnosBtnAgregarActionPerformed(evt);
            }
        });

        tablaComboCodigos.setBackground(new java.awt.Color(255, 255, 255));
        tablaComboCodigos.setForeground(new java.awt.Color(0, 0, 0));
        tablaComboCodigos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo Curso", "Item 2", "Item 3", "Item 4" }));
        tablaComboCodigos.setBorder(null);
        tablaComboCodigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablaComboCodigosActionPerformed(evt);
            }
        });

        btnMostrar.setBackground(new java.awt.Color(0, 0, 0));
        btnMostrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Inhabilitar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tablaComboCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tablaComboCodigos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(268, 268, 268)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelTablaAlumnosBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tablaComboCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tablaComboCodigos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTablaAlumnosBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
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

    private void tablaComboCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablaComboCursosActionPerformed
        String curso = (String) tablaComboCursos.getSelectedItem();
        if (curso != null && !curso.startsWith("Seleccionar")) {
            cargarCodigos(curso);
        } else {
            tablaComboCodigos.removeAllItems();
            tablaComboCodigos.addItem("Código curso");
        }
    }//GEN-LAST:event_tablaComboCursosActionPerformed

    private void tablaComboCodigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablaComboCodigosActionPerformed
        
    }//GEN-LAST:event_tablaComboCodigosActionPerformed

    private void panelTablaAlumnosBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelTablaAlumnosBtnAgregarActionPerformed
        int fila = tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un alumno.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cursoCodigo = (String) tablaComboCodigos.getSelectedItem();

        if (cursoCodigo == null || cursoCodigo.startsWith("Seleccionar")) {
            JOptionPane.showMessageDialog(this,
                    "Elige un código de curso.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Integer estID = (Integer) tablaAlumnos.getValueAt(fila, 0);
            CursoInfo info = obtenerCursoInfo(cursoCodigo);

            if (estID == null || info == null) {
                JOptionPane.showMessageDialog(this,
                        "No se obtuvo el ID del alumno o no se encontró el curso/docente.",
                        "BD", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = """
                INSERT INTO EstudianteCurso
                    (estID, cursoID, fechaInscripcion,
                     estado, participacionTotal, docID)
                VALUES (?, ?, GETDATE(), 'activo', 0, ?)
                """;

            try (Connection cn = new ConexionBD().establecerConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

                ps.setInt(1, estID);
                ps.setInt(2, info.cursoID);
                ps.setInt(3, info.docID);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,
                        "Alumno inscrito correctamente.");
                tablaAlumnos.clearSelection();
                tablaComboCodigos.setSelectedIndex(0);
            }

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) {
                JOptionPane.showMessageDialog(this,
                        "NO SE PUDO AGREGAR.  El alumno se cuentra INSCRITO en ese curso.",
                        "Duplicado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al inscribir:\n" + ex.getMessage(),
                        "BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_panelTablaAlumnosBtnAgregarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        String codSel = (String) tablaComboCodigos.getSelectedItem();

        if (codSel == null || codSel.startsWith("Código")) {
            cargarTabla();
            return;
        }

        try {
            CursoInfo info = obtenerCursoInfo(codSel);
            if (info == null) {
                JOptionPane.showMessageDialog(this,
                        "Código de curso no encontrado.", "BD",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            cargarTabla(info.cursoID);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al obtener curso:\n" + ex.getMessage(),
                    "BD", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inhabilitarAlumno();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton panelTablaAlumnosBtnAgregar;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JComboBox<String> tablaComboCodigos;
    private javax.swing.JComboBox<String> tablaComboCursos;
    // End of variables declaration//GEN-END:variables
}

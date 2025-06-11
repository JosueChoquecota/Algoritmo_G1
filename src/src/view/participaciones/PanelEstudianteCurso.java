package src.view.participaciones;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.Controller.EstudianteCursoController;
import src.dao.EstudianteCursoDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.util.ConexionBD;
import src.view.registrocurso.panelCursosDocente;


public class PanelEstudianteCurso extends javax.swing.JPanel {

    DefaultTableModel modelo;
    private javax.swing.JPanel panelDashboard;
    private Docente docente;
    private int cursoID;
    private int docenteID;
    private int sesionID;
    public PanelEstudianteCurso(int cursoID, int docenteID, int sesionID, JPanel panelDashboard) {
        this.cursoID = cursoID;
        this.docenteID = docenteID;
        this.sesionID = sesionID;
        this.panelDashboard = panelDashboard;
        initComponents();
        
        modelo = (DefaultTableModel) TablaEstudiantes.getModel();
        cargarDatos(cursoID, docenteID);

    }
    
     public void cargarDatos(int cursoID, int docenteID) {
        try {
            modelo.setRowCount(0);
            EstudianteCursoController controller = new EstudianteCursoController(new EstudianteCursoDAO(new ConexionBD()));
            List<EstudianteCurso> lista = controller.obtenerEstudiantesPorSesion(sesionID);

            for (EstudianteCurso ec : lista) {
                modelo.addRow(new Object[]{
                    ec.getEstudiante().getNombre(),
                    ec.getEstudiante().getApellido(),
                    ec.getEstudiante().getCarrera(),
                    ec.getEstudiante().getCorreo(),
                    ec.getEstudiante().getCodEst(),
                    ec.getFechaInscripcion(),  
                    ec.getEstado(),
                    ec.getCurso().getCursoNombre(),
                    ec.getParticipacionTotal()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error al cargar datos: " + e.getMessage());
        }
    }
    private Estudiante obtenerEstudianteSeleccionado() {
            int fila = TablaEstudiantes.getSelectedRow();
            if (fila == -1) return null;

            DefaultTableModel modelo = (DefaultTableModel) TablaEstudiantes.getModel();
            Estudiante est = new Estudiante();
            est.setNombre((String) modelo.getValueAt(fila, 0));
            est.setApellido((String) modelo.getValueAt(fila, 1));
            est.setCodEst((String) modelo.getValueAt(fila, 4));
            return est;
        }

    private Curso obtenerCursoSeleccionado() {
            int fila = TablaEstudiantes.getSelectedRow();
            if (fila == -1) return null;

            DefaultTableModel modelo = (DefaultTableModel) TablaEstudiantes.getModel();
            Curso curso = new Curso();
            curso.setCursoNombre((String) modelo.getValueAt(fila, 7));
            return curso;
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCursos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEstudiantes = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        PanelCursos.setBackground(new java.awt.Color(204, 204, 204));

        TablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Carrera", "Correo", "Codigo", "FechaInscripcion", "Estado", "Curso", "PuntosTotales"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEstudiantes);

        btnSeleccionar.setBackground(new java.awt.Color(255, 153, 153));
        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Estudiantes por Curso:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Aqui va todos los cursos del docente para seleccionar al que le corresponde");

        btnVolver.setBackground(new java.awt.Color(153, 153, 255));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int filaSeleccionada = TablaEstudiantes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un estudiante.");
            return;
        }

        Estudiante estudiante = obtenerEstudianteSeleccionado();
        Curso curso = obtenerCursoSeleccionado();

        PanelParticipacionEstudiante panelParticipar = new PanelParticipacionEstudiante(estudiante, curso, docente, panelDashboard);
        panelParticipar.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());

        panelDashboard.removeAll();
        panelDashboard.add(panelParticipar, BorderLayout.CENTER);
        panelDashboard.revalidate();
        panelDashboard.repaint();    
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        panelCursosDocente panelCursos = new panelCursosDocente(docente,panelDashboard);
        panelCursos.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());

        panelDashboard.removeAll();
        panelDashboard.add(panelCursos, BorderLayout.CENTER);
        panelDashboard.revalidate();
        panelDashboard.repaint();

        panelCursos.cargarCursos();
        
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCursos;
    private javax.swing.JTable TablaEstudiantes;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

package src.view.participaciones;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.Controller.EstudianteCursoController;
import src.Controller.GrupoActividadController;
import src.dao.EstudianteCursoDAO;
import src.dao.GrupoActividadDAO;
import src.model.Curso;
import src.model.Docente;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.model.GrupoActividad;
import src.model.SesionClase;
import src.model.SesionDetalle;
import src.util.ConexionBD;
import src.view.registrocurso.panelCursosDocente;


public class PanelEstudianteCurso extends javax.swing.JPanel {

    DefaultTableModel modelo;
    private javax.swing.JPanel panelDashboard;
    private Docente docente;
    private int cursoID;
    private int sesionID;
    
    public PanelEstudianteCurso(int cursoID, Docente docente, int sesionID, JPanel panelDashboard) {
        this.cursoID = cursoID;
        this.docente = docente;
        this.sesionID = sesionID;
        this.panelDashboard = panelDashboard;
        initComponents();        
        modelo = (DefaultTableModel) TablaEstudiantes.getModel();
        cargarDatos(cursoID, docente);
    }
    
     public void cargarDatos(int cursoID, Docente docente) {
        try {
            modelo.setRowCount(0);
            EstudianteCursoController controller = new EstudianteCursoController(new EstudianteCursoDAO(new ConexionBD()));
            List<EstudianteCurso> lista = controller.obtenerEstudiantesPorSesion(sesionID);

            for (EstudianteCurso ec : lista) {
                modelo.addRow(new Object[]{
                    ec.getEstudiante().getEstID(),
                    ec.getEstudiante().getNombre(),
                    ec.getEstudiante().getApellido(),
                    ec.getEstudiante().getCarrera(),
                    ec.getEstudiante().getCorreo(),
                    ec.getEstudiante().getCodEst(),
                    ec.getFechaInscripcion(),  
                    ec.getEstado(),
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
            est.setEstID((int) modelo.getValueAt(fila, 0)); 
            est.setNombre(String.valueOf(modelo.getValueAt(fila, 1)));
            est.setApellido(String.valueOf(modelo.getValueAt(fila, 2)));
            est.setCodEst(String.valueOf(modelo.getValueAt(fila, 5))); 
            return est;
        }
        
        private List<Estudiante> obtenerEstudiantesSeleccionados() {
            int[] filasSeleccionadas = TablaEstudiantes.getSelectedRows();
            List<Estudiante> seleccionados = new ArrayList<>();

            DefaultTableModel modelo = (DefaultTableModel) TablaEstudiantes.getModel();

            for (int fila : filasSeleccionadas) {
                Estudiante est = new Estudiante();
                est.setEstID(Integer.parseInt(modelo.getValueAt(fila, 0).toString()));
                est.setNombre(modelo.getValueAt(fila, 1).toString());
                est.setApellido(modelo.getValueAt(fila, 2).toString());
                // Puedes mapear más campos si lo deseas
                seleccionados.add(est);
            }

            return seleccionados;
        }

        private Curso obtenerCursoSeleccionado() {
            int fila = TablaEstudiantes.getSelectedRow();
            if (fila == -1) return null;

            DefaultTableModel modelo = (DefaultTableModel) TablaEstudiantes.getModel();
            Curso curso = new Curso();
            curso.setCursoNombre(String.valueOf(modelo.getValueAt(fila, 8)));
            return curso;
        }
        
        private void cargarTablaGrupos() {
            DefaultTableModel modelo = (DefaultTableModel) GruposEstudiantes.getModel();
            modelo.setRowCount(0); // Limpiar tabla

            GrupoActividadDAO dao = new GrupoActividadDAO(new ConexionBD());
            List<Object[]> grupos = dao.listarGruposEstudiantes(sesionID); // sesión actual

            for (Object[] fila : grupos) {
                modelo.addRow(fila);
            }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCursos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEstudiantes = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnPuntajeUnidad = new javax.swing.JButton();
        btnCrearGrupos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GruposEstudiantes = new javax.swing.JTable();
        comboGrupo = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();

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
                "EstID", "Nombre", "Apellido", "Carrera", "Correo", "Codigo", "FechaInscripcion", "Estado", "PuntosTotales"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEstudiantes);

        btnSeleccionar.setBackground(new java.awt.Color(0, 0, 0));
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
        jLabel7.setText("Estudiantes:");

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

        btnPuntajeUnidad.setBackground(new java.awt.Color(0, 0, 0));
        btnPuntajeUnidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPuntajeUnidad.setForeground(new java.awt.Color(255, 255, 255));
        btnPuntajeUnidad.setText("Ver Total");
        btnPuntajeUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntajeUnidadActionPerformed(evt);
            }
        });

        btnCrearGrupos.setBackground(new java.awt.Color(0, 0, 0));
        btnCrearGrupos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCrearGrupos.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearGrupos.setText("Crear Grupos");
        btnCrearGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearGruposActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Grupos Creados:");

        GruposEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EstID", "Nombre", "Apellido", "GrupoID", "GrupoEstudiantes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(GruposEstudiantes);

        comboGrupo.setBackground(new java.awt.Color(255, 255, 255));
        comboGrupo.setForeground(new java.awt.Color(0, 0, 0));
        comboGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grupo 1", "Grupo 2", "Grupo 3", "Grupo 4", "Grupo 5", " " }));
        comboGrupo.setBorder(null);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar Grupo");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCursosLayout = new javax.swing.GroupLayout(PanelCursos);
        PanelCursos.setLayout(PanelCursosLayout);
        PanelCursosLayout.setHorizontalGroup(
            PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCursosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPuntajeUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCursosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(38, 38, 38)
                                .addComponent(btnCrearGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(PanelCursosLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)))
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelCursosLayout.setVerticalGroup(
            PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCursosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(PanelCursosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPuntajeUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        PanelParticipacionEstudiante panelParticipar = new PanelParticipacionEstudiante(estudiante, curso, docente, sesionID, panelDashboard);
        panelParticipar.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());

        panelDashboard.removeAll();
        panelDashboard.add(panelParticipar, BorderLayout.CENTER);
        panelDashboard.revalidate();
        panelDashboard.repaint();    
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
            PanelInfoSesionClase panelInfoSesionClase = new PanelInfoSesionClase(docente, cursoID, panelDashboard);
            panelDashboard.removeAll();
            panelDashboard.add(panelInfoSesionClase);
            panelDashboard.revalidate();
            panelDashboard.repaint();    
            
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPuntajeUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntajeUnidadActionPerformed
       
        panelCalculoPuntaje panel = new panelCalculoPuntaje(docente, cursoID,sesionID, panelDashboard);
        panel.setSize(panelDashboard.getWidth(), panelDashboard.getHeight());

        panelDashboard.removeAll();
        panelDashboard.add(panel, BorderLayout.CENTER);
        panelDashboard.revalidate();
        panelDashboard.repaint();
     
        
    }//GEN-LAST:event_btnPuntajeUnidadActionPerformed

    private void btnCrearGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearGruposActionPerformed
        List<Estudiante> estudiantesSeleccionados = obtenerEstudiantesSeleccionados();

            if (estudiantesSeleccionados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecciona al menos un estudiante.");
                return;
            }

            String nombreGrupo = comboGrupo.getSelectedItem().toString(); // e.g., "Grupo 1"
            String actividad = JOptionPane.showInputDialog(this, "Describe la actividad del grupo:");

            // Crear sesión con ID real
            SesionClase sesion = new SesionClase();
            sesion.setSesID(sesionID); // <- reemplaza con tu ID actual de sesión

            // Crear objeto grupo
            GrupoActividad grupo = new GrupoActividad();
            grupo.setSesion(sesion);
            grupo.setNombreGrupo(nombreGrupo);
            grupo.setActividad(actividad);
            grupo.setIntegrantes(estudiantesSeleccionados);

            // Guardar en BD
            GrupoActividadDAO dao = new GrupoActividadDAO(new ConexionBD());
            int grupoID = dao.insertarGrupoActividad(grupo);

            if (grupoID != -1) {
                JOptionPane.showMessageDialog(this, "✅ Grupo creado correctamente. ID: " + grupoID);
                grupo.setGrupoID(grupoID); // Guardas el ID si lo necesitas después
                cargarTablaGrupos();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Error al crear el grupo.");
            }

    
    }//GEN-LAST:event_btnCrearGruposActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int[] filasSeleccionadas = GruposEstudiantes.getSelectedRows();

        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona al menos un estudiante para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar estudiantes seleccionados del grupo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        DefaultTableModel modelo = (DefaultTableModel) GruposEstudiantes.getModel();
        List<Integer> listaEstID = new ArrayList<>();
        int grupoID = -1;

        for (int fila : filasSeleccionadas) {
            try {
                int estID = Integer.parseInt(String.valueOf(modelo.getValueAt(fila, 0)));
                int grupoActual = Integer.parseInt(String.valueOf(modelo.getValueAt(fila, 3))); 
                listaEstID.add(estID);

                if (grupoID == -1) {
                    grupoID = grupoActual;
                } else if (grupoID != grupoActual) {
                    JOptionPane.showMessageDialog(this, "Seleccionaste estudiantes de diferentes grupos.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error al convertir ID. Verifica los datos.");
                return;
            }
        }

        if (grupoID == -1) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener el grupoID.");
            return;
        }
        GrupoActividadController controller = new GrupoActividadController(new GrupoActividadDAO(new ConexionBD()));
        boolean ok = controller.eliminarVariosIntegrantes(grupoID, listaEstID);

        if (ok) {
            JOptionPane.showMessageDialog(this, "✅ Estudiantes eliminados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al eliminar estudiantes.");
        }

        cargarTablaGrupos(); 
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GruposEstudiantes;
    private javax.swing.JPanel PanelCursos;
    private javax.swing.JTable TablaEstudiantes;
    private javax.swing.JButton btnCrearGrupos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPuntajeUnidad;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboGrupo;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

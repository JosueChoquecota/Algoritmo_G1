/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.view.Administrador.CursosAdm;

import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import src.Controller.DocenteController;
import src.Controller.SesionClaseController;
import src.dao.CursoDAO;
import src.dao.DocenteDAO;
import src.dao.SesionClaseDAO;
import src.dao.SesionDetalleDAO;
import src.model.Curso;
import src.model.Docente;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class panelCursos extends javax.swing.JPanel {

    public panelCursos() {
        initComponents();
    }
    //ACA ESTA TODO EL CODIGO PARA EL BOTON DE REGISTRAR Y GENERAR CURSOS
    public void cargarDocente() {
        DocenteController docenteController = new DocenteController(new DocenteDAO(new ConexionBD()));
        List<Docente> docentes = docenteController.listaDeDocenteParaInsertarCurso();

        DefaultTableModel modelTeorica = (DefaultTableModel) TablaDocentes.getModel();
        DefaultTableModel modelPractica = (DefaultTableModel) TablaDocentesPractica.getModel();

        modelTeorica.setRowCount(0);
        modelPractica.setRowCount(0);

        for (Docente fila : docentes) {
            Object[] rowData = {
                fila.getDocID(),
                fila.getNombre(),
                fila.getApellido(),
                fila.getEspecialidad()
            };

            modelTeorica.addRow(rowData);
            modelPractica.addRow(rowData);
        }
    }
    private Curso obtenerCursoDesdeFormulario() throws Exception {
        Curso curso = new Curso();

        int anio = Integer.parseInt(txtAno.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int dia = Integer.parseInt(txtDia.getText());

        curso.setCursoNombre(txtNombre.getText());
        curso.setCiclo(boxCiclo.getSelectedItem().toString());
        curso.setModalidad(boxModalidad.getSelectedItem().toString());
        curso.setCreditos(Integer.parseInt(boxCreditos.getSelectedItem().toString()));
        curso.setCursoCodigo("TEMPORAL");
        curso.setFechaInicio(LocalDate.of(anio, mes, dia));

        String diaTeoria = boxDia.getSelectedItem().toString();
        String horaTeoria = txtHora.getText();
        String horarioUno = diaTeoria + " " + horaTeoria;

        String seleccion = boxPractica.getSelectedItem().toString();         
        boolean habilitar = seleccion.equalsIgnoreCase("Si");

        if (habilitar) {
            int anioFin = Integer.parseInt(txtAno1.getText());
            int mesFin = Integer.parseInt(txtMes1.getText());
            int diaFin = Integer.parseInt(txtDia1.getText());
            String diaPractica = boxDia1.getSelectedItem().toString();
            String horaPractica = txtHora1.getText();
            curso.setHorario(horarioUno + " / " + diaPractica + " " + horaPractica);
            curso.setFechaFin(LocalDate.of(anioFin, mesFin, diaFin));
        } else {
            curso.setHorario(horarioUno);
        }

        return curso;
    }
    private int obtenerDocenteSeleccionado(JTable tabla) throws Exception {
        int fila = tabla.getSelectedRow();
        if (fila == -1) throw new Exception("Debes seleccionar un docente.");
        return Integer.parseInt(tabla.getValueAt(fila, 0).toString());
    }
    private void registrarCursoYGenerarSesiones(Curso curso) throws Exception {
        ConexionBD conexion = new ConexionBD();
        CursoDAO cursoDAO = new CursoDAO(conexion);
        SesionClaseDAO sesionDAO = new SesionClaseDAO(conexion);
        SesionDetalleDAO detalleDAO = new SesionDetalleDAO(conexion);
        SesionClaseController controller = new SesionClaseController(sesionDAO, detalleDAO);

        int semanas = Integer.parseInt(boxSemanas.getSelectedItem().toString());
        boolean insertado = cursoDAO.insertarCurso(curso, semanas);
        if (!insertado) throw new Exception("No se pudo registrar el curso.");

        int docenteTeoriaID = obtenerDocenteSeleccionado(TablaDocentes);
        int horasTeoria = Integer.parseInt(boxHoras.getSelectedItem().toString());

        String diaTeoria = boxDia.getSelectedItem().toString();
        String horaTeoria = txtHora.getText();
        String horarioUno = diaTeoria + " " + horaTeoria;

        boolean incluirPractica = boxPractica.getSelectedItem().toString().equalsIgnoreCase("Si");
        Integer docentePracticaID = null;
        int horasPractica = 0;
        String horarioDos = null;

        if (incluirPractica) {
            docentePracticaID = obtenerDocenteSeleccionado(TablaDocentesPractica);
            horasPractica = Integer.parseInt(boxHoras1.getSelectedItem().toString());
            String diaPractica = boxDia1.getSelectedItem().toString();
            String horaPractica = txtHora1.getText();
            horarioDos = diaPractica + " " + horaPractica;
        }

        controller.generarSesiones(
            curso,
            semanas,
            true,
            docenteTeoriaID,
            horasTeoria,
            incluirPractica,
            docentePracticaID,
            horasPractica,
            incluirPractica ? 2 : 1,
            horarioUno,
            horarioDos
        );
    }
    //ACA ESTA TODO EL CODIGO PARA EL BOTON DE REGISTRAR Y GENERAR CURSOS

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDashboard2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        boxCreditos = new javax.swing.JComboBox<>();
        boxCiclo = new javax.swing.JComboBox<>();
        boxSemanas = new javax.swing.JComboBox<>();
        boxModalidad = new javax.swing.JComboBox<>();
        boxDia = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtHora1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        boxDia1 = new javax.swing.JComboBox<>();
        txtMes = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtAno1 = new javax.swing.JTextField();
        txtMes1 = new javax.swing.JTextField();
        txtDia1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        boxHoras = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        boxHoras1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        boxPractica = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDocentes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDocentesPractica = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        panelDashboard2.setBackground(new java.awt.Color(255, 255, 255));
        panelDashboard2.setMaximumSize(new java.awt.Dimension(740, 650));
        panelDashboard2.setMinimumSize(new java.awt.Dimension(740, 650));

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText(" Registrar Curso");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre del Curso:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ciclo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("FechaInicio:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("SegundaFecha:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Modalidad:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Creditos:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Horario-Turno-1");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Semanas:");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtAno.setBackground(new java.awt.Color(255, 255, 255));
        txtAno.setForeground(new java.awt.Color(0, 0, 0));
        txtAno.setText("2025");
        txtAno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtHora.setBackground(new java.awt.Color(255, 255, 255));
        txtHora.setForeground(new java.awt.Color(0, 0, 0));
        txtHora.setText("ej: 13:00 - 15:00");
        txtHora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        boxCreditos.setBackground(new java.awt.Color(255, 255, 255));
        boxCreditos.setForeground(new java.awt.Color(0, 0, 0));
        boxCreditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        boxCreditos.setBorder(null);

        boxCiclo.setBackground(new java.awt.Color(255, 255, 255));
        boxCiclo.setForeground(new java.awt.Color(0, 0, 0));
        boxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025-Verano", "2025-I", "2025-II", "2026-Verano", "2026-I", "2026-II", "2027-Verano", "2027-I", "2027-II", " " }));
        boxCiclo.setBorder(null);

        boxSemanas.setBackground(new java.awt.Color(255, 255, 255));
        boxSemanas.setForeground(new java.awt.Color(0, 0, 0));
        boxSemanas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "8", "12", "16", "18" }));
        boxSemanas.setBorder(null);

        boxModalidad.setBackground(new java.awt.Color(255, 255, 255));
        boxModalidad.setForeground(new java.awt.Color(0, 0, 0));
        boxModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presencial", "Virtual" }));
        boxModalidad.setBorder(null);

        boxDia.setBackground(new java.awt.Color(255, 255, 255));
        boxDia.setForeground(new java.awt.Color(0, 0, 0));
        boxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado" }));
        boxDia.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Día-Turno-1");

        txtHora1.setBackground(new java.awt.Color(255, 255, 255));
        txtHora1.setForeground(new java.awt.Color(0, 0, 0));
        txtHora1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtHora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHora1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Horario-Turno-2");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Día-Turno-2");

        boxDia1.setBackground(new java.awt.Color(255, 255, 255));
        boxDia1.setForeground(new java.awt.Color(0, 0, 0));
        boxDia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado" }));
        boxDia1.setBorder(null);

        txtMes.setBackground(new java.awt.Color(255, 255, 255));
        txtMes.setForeground(new java.awt.Color(0, 0, 0));
        txtMes.setText("05");
        txtMes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtDia.setBackground(new java.awt.Color(255, 255, 255));
        txtDia.setForeground(new java.awt.Color(0, 0, 0));
        txtDia.setText("12");
        txtDia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtDia.setPreferredSize(new java.awt.Dimension(55, 22));

        txtAno1.setBackground(new java.awt.Color(255, 255, 255));
        txtAno1.setForeground(new java.awt.Color(0, 0, 0));
        txtAno1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtMes1.setBackground(new java.awt.Color(255, 255, 255));
        txtMes1.setForeground(new java.awt.Color(0, 0, 0));
        txtMes1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtDia1.setBackground(new java.awt.Color(255, 255, 255));
        txtDia1.setForeground(new java.awt.Color(0, 0, 0));
        txtDia1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtDia1.setPreferredSize(new java.awt.Dimension(55, 22));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Hora-Curso-1");

        boxHoras.setBackground(new java.awt.Color(255, 255, 255));
        boxHoras.setForeground(new java.awt.Color(0, 0, 0));
        boxHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        boxHoras.setBorder(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Hora-Curso-2:");

        boxHoras1.setBackground(new java.awt.Color(255, 255, 255));
        boxHoras1.setForeground(new java.awt.Color(0, 0, 0));
        boxHoras1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        boxHoras1.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("¿Tiene sesiónes Prácticas?");

        boxPractica.setBackground(new java.awt.Color(255, 255, 255));
        boxPractica.setForeground(new java.awt.Color(0, 0, 0));
        boxPractica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        boxPractica.setBorder(null);
        boxPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPracticaActionPerformed(evt);
            }
        });

        TablaDocentes.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "EstID", "Nombre", "Apellido", "Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaDocentes);
        if (TablaDocentes.getColumnModel().getColumnCount() > 0) {
            TablaDocentes.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Docente Sesión Teórica:");

        TablaDocentesPractica.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "EstID", "Nombre", "Apellido", "Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaDocentesPractica);
        if (TablaDocentesPractica.getColumnModel().getColumnCount() > 0) {
            TablaDocentesPractica.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Docente Sesión Práctica:");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Limpiar");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDashboard2Layout = new javax.swing.GroupLayout(panelDashboard2);
        panelDashboard2.setLayout(panelDashboard2Layout);
        panelDashboard2Layout.setHorizontalGroup(
            panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboard2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(panelDashboard2Layout.createSequentialGroup()
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(boxDia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHora, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDashboard2Layout.createSequentialGroup()
                                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(boxSemanas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boxModalidad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel9)
                            .addComponent(boxHoras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(boxDia1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHora1)
                            .addGroup(panelDashboard2Layout.createSequentialGroup()
                                .addComponent(txtAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMes1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxPractica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxCreditos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxCiclo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxHoras1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDashboard2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        panelDashboard2Layout.setVerticalGroup(
            panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDashboard2Layout.createSequentialGroup()
                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDashboard2Layout.createSequentialGroup()
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDashboard2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDashboard2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDashboard2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boxModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boxSemanas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxPractica, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDashboard2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMes1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxHoras1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDashboard2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelDashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDashboard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDashboard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        try {
            Curso curso = obtenerCursoDesdeFormulario();
            registrarCursoYGenerarSesiones(curso);
            JOptionPane.showMessageDialog(this, "✅ Curso y sesiones registradas correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void boxPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPracticaActionPerformed
            String seleccion = boxPractica.getSelectedItem().toString();
            
            boolean habilitar = seleccion.equalsIgnoreCase("Si");
            
            txtHora1.setEnabled(habilitar);
            boxDia1.setEnabled(habilitar);
            boxHoras1.setEnabled(habilitar);
            txtAno1.setEnabled(habilitar);
            txtMes1.setEnabled(habilitar);
            txtDia1.setEnabled(habilitar);
            TablaDocentesPractica.setEnabled(habilitar);


    }//GEN-LAST:event_boxPracticaActionPerformed

    private void txtHora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHora1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDocentes;
    private javax.swing.JTable TablaDocentesPractica;
    private javax.swing.JComboBox<String> boxCiclo;
    private javax.swing.JComboBox<String> boxCreditos;
    private javax.swing.JComboBox<String> boxDia;
    private javax.swing.JComboBox<String> boxDia1;
    private javax.swing.JComboBox<String> boxHoras;
    private javax.swing.JComboBox<String> boxHoras1;
    private javax.swing.JComboBox<String> boxModalidad;
    private javax.swing.JComboBox<String> boxPractica;
    private javax.swing.JComboBox<String> boxSemanas;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelDashboard2;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAno1;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtDia1;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtHora1;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMes1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

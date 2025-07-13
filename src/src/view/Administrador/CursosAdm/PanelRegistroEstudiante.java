package src.view.Administrador.CursosAdm;

import src.model.Estudiante;
import src.Controller.EstudianteController;
import src.dao.EstudianteDAO;
import src.util.ConexionBD;

import javax.swing.JOptionPane;  


public class PanelRegistroEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegistroEstudiante
     */
    public PanelRegistroEstudiante() {
        initComponents();
    }
    private void limpiarCampos() {
        registrarAlumnoNombre.setText("");
        registrarAlumnoApellido.setText("");
        registrarAlumnoDNI.setText("");
        registrarAlumnoCorreo.setText("");
        registrarAlumnoElegirCarrera.setSelectedIndex(0);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        registrarAlumnoApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        registrarAlumnoNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        registrarAlumnoDNI = new javax.swing.JTextField();
        registrarAlumnoCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        registrarAlumnoBtnRegistrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        registrarAlumnoElegirCarrera = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrar Alumno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");

        registrarAlumnoApellido.setBackground(new java.awt.Color(255, 255, 255));
        registrarAlumnoApellido.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido:");

        registrarAlumnoNombre.setBackground(new java.awt.Color(255, 255, 255));
        registrarAlumnoNombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DNI:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Correo:");

        registrarAlumnoDNI.setBackground(new java.awt.Color(255, 255, 255));
        registrarAlumnoDNI.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        registrarAlumnoDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarAlumnoDNIActionPerformed(evt);
            }
        });

        registrarAlumnoCorreo.setBackground(new java.awt.Color(255, 255, 255));
        registrarAlumnoCorreo.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Carrera:");

        registrarAlumnoBtnRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        registrarAlumnoBtnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registrarAlumnoBtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        registrarAlumnoBtnRegistrar.setText("Registrar");
        registrarAlumnoBtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarAlumnoBtnRegistrarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Limpiar");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        registrarAlumnoElegirCarrera.setBackground(new java.awt.Color(255, 255, 255));
        registrarAlumnoElegirCarrera.setForeground(new java.awt.Color(0, 0, 0));
        registrarAlumnoElegirCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige una carrera", "Ingeniería Ambiental", "Ingeniería Automotriz", "Ingeniería Civil", "Ingeniería Eléctrica y de Potencia", "Ingeniería Industrial", "Ingeniería Mecánica", "Ingeniería de Minas", "Ingeniería de Seguridad Industrial y Minera", "Ingeniería de Software", "Ingeniería en Seguridad Laboral y Ambiental" }));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Completa el formulario con los datos del alumno que deseas registrar en el sistema. ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6))
                                            .addGap(171, 171, 171))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(170, 170, 170)))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(registrarAlumnoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registrarAlumnoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(registrarAlumnoElegirCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registrarAlumnoDNI)
                                    .addComponent(registrarAlumnoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registrarAlumnoBtnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))))
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(registrarAlumnoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(registrarAlumnoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(registrarAlumnoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(registrarAlumnoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(registrarAlumnoElegirCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarAlumnoBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registrarAlumnoBtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarAlumnoBtnRegistrarActionPerformed
       
        String nombre   = registrarAlumnoNombre.getText().trim();
        String apellido = registrarAlumnoApellido.getText().trim();
        String dni      = registrarAlumnoDNI.getText().trim();
        String correo   = registrarAlumnoCorreo.getText().trim();
        String carrera  = registrarAlumnoElegirCarrera.getSelectedItem().toString();

        
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el nombre.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoNombre.requestFocus();
            return;
        }
        if (nombre.length() > 30) {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede superar los 30 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoNombre.requestFocus();
            return;
        }
        if (nombre.length() < 3) {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede tener menos de 3 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoNombre.requestFocus();
            return;
        }
        if (!nombre.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede contener números ni símbolos.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registrarAlumnoNombre.requestFocus();
            return;
        }
        
        
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el apellido.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoApellido.requestFocus();
            return;
        }
        if (apellido.length() > 30) {
            JOptionPane.showMessageDialog(this,
                "El apellido no puede superar los 30 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoApellido.requestFocus();
            return;
        }
        if (apellido.length() < 3) {
            JOptionPane.showMessageDialog(this,
                "El apellido no puede tener menos de 3 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoApellido.requestFocus();
            return;
        }
        if (!apellido.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            JOptionPane.showMessageDialog(this,
                "El apellido no puede contener números ni símbolos.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registrarAlumnoApellido.requestFocus();
            return;
        }
        
        
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el DNI.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoApellido.requestFocus();
            return;
        }
        if (dni.length() < 8 || dni.length() > 8) {
            JOptionPane.showMessageDialog(this,
                "El DNI debe tener 8 numeros",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoApellido.requestFocus();
            return;
        }
        EstudianteDAO daoTmp = new EstudianteDAO(new ConexionBD());
        if (daoTmp.dniExiste(dni)) {
            JOptionPane.showMessageDialog(this,
                "El DNI ingresado ya está registrado.",
                "Duplicado", JOptionPane.ERROR_MESSAGE);
            registrarAlumnoDNI.requestFocus();
            return;
        }
        
        
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el correo.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoCorreo.requestFocus();
            return;
        }
        if (correo.length() > 100) {
            JOptionPane.showMessageDialog(this,
                "El correo no puede exceder los 100 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoCorreo.requestFocus();
            return;
        }
        if (correo.contains(" ")) {
            JOptionPane.showMessageDialog(this,
                "El correo no puede contener espacios.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registrarAlumnoCorreo.requestFocus();
            return;
        }
        if (!(correo.endsWith("@gmail.com") || correo.endsWith("@utp.edu.pe"))) {
            JOptionPane.showMessageDialog(this,
                "El correo debe terminar en @gmail.com o @utp.edu.pe.",
                "Dominio inválido", JOptionPane.ERROR_MESSAGE);
            registrarAlumnoCorreo.requestFocus();
            return;
        }
        if (daoTmp.correoExiste(correo)) {
            JOptionPane.showMessageDialog(this,
                "El correo ingresado ya está registrado.",
                "Duplicado", JOptionPane.ERROR_MESSAGE);
            registrarAlumnoCorreo.requestFocus();
            return;
        }
        
        
        if (registrarAlumnoElegirCarrera.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                "Por favor, seleccione una carrera.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registrarAlumnoElegirCarrera.requestFocus();
            return;
        }

        Estudiante e = new Estudiante();
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setDni(dni);
        e.setCorreo(correo);
        e.setCarrera(carrera); 
        e.setEstado(true); 

        
        EstudianteController ctrl = new EstudianteController(
        new EstudianteDAO(new ConexionBD()));
        boolean ok = ctrl.registrarEstudiante(e);

        if (ok) {
            JOptionPane.showMessageDialog(this,
                "✅ Estudiante registrado con ID: " + e.getEstID());
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                "No se pudo registrar", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registrarAlumnoBtnRegistrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiarCampos();
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void registrarAlumnoDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarAlumnoDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarAlumnoDNIActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField registrarAlumnoApellido;
    private javax.swing.JButton registrarAlumnoBtnRegistrar;
    private javax.swing.JTextField registrarAlumnoCorreo;
    private javax.swing.JTextField registrarAlumnoDNI;
    private javax.swing.JComboBox<String> registrarAlumnoElegirCarrera;
    private javax.swing.JTextField registrarAlumnoNombre;
    // End of variables declaration//GEN-END:variables
}

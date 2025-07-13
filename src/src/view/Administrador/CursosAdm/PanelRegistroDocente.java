/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.view.Administrador.CursosAdm;

/*Marco Codigo*/
import src.model.Docente;
import src.Controller.DocenteController;
import javax.swing.JOptionPane;
import java.time.LocalDate;

import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;

import src.dao.DocenteDAO;
import src.util.ConexionBD;

import java.time.ZoneId;

public class PanelRegistroDocente extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegistroDocente
     */
    public PanelRegistroDocente() {
        initComponents();
        
        /*Codigo Marco*/
        
        /*
        SpinnerDateModel dateModel = new SpinnerDateModel(
            new Date(),     
            null,           
            null,        
            Calendar.DAY_OF_MONTH
        );*/
        Date hoy = new Date();
        
        SpinnerDateModel dateModel = new SpinnerDateModel(
            hoy,     
            null,    
            hoy,
            Calendar.DAY_OF_MONTH
        );
        registroDocenteFechaNac.setModel(dateModel); 
        JSpinner.DateEditor dateEditor =
        new JSpinner.DateEditor(registroDocenteFechaNac, "yyyy-MM-dd");
        registroDocenteFechaNac.setEditor(dateEditor);  
        registroDocenteFechaNac.setValue(new Date());    
    }
    private void limpiarCampos() {
        registroDocenteNom.setText("");
        registroDocenteApelli.setText("");
        registroDocenteCorreo.setText("");
        registroDocenteEspecialidad.setSelectedIndex(0);
        registroDocenteDireccion.setText("");
        registroDocenteFechaNac.setValue(new Date());
        registroDocenteTelefono.setText("");
        registroDocenteContrasena.setText("");
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        registroDocentebtnLimpiar = new javax.swing.JButton();
        registroDocenteBtnRegistrar = new javax.swing.JButton();
        registroDocenteApelli = new javax.swing.JTextField();
        registroDocenteNom = new javax.swing.JTextField();
        registroDocenteCorreo = new javax.swing.JTextField();
        registroDocenteEspecialidad = new javax.swing.JComboBox<>();
        registroDocenteDireccion = new javax.swing.JTextField();
        registroDocenteFechaNac = new javax.swing.JSpinner();
        registroDocenteTelefono = new javax.swing.JTextField();
        registroDocenteContrasena = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registro Docente:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Correo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Especialidad:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Apellido:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Teléfono:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Fecha Nacimiento:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Dirección:");

        registroDocentebtnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        registroDocentebtnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registroDocentebtnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        registroDocentebtnLimpiar.setText("Limpiar");
        registroDocentebtnLimpiar.setBorder(null);
        registroDocentebtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDocentebtnLimpiarActionPerformed(evt);
            }
        });

        registroDocenteBtnRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        registroDocenteBtnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registroDocenteBtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        registroDocenteBtnRegistrar.setText("Registrar");
        registroDocenteBtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDocenteBtnRegistrarActionPerformed(evt);
            }
        });

        registroDocenteApelli.setBackground(new java.awt.Color(255, 255, 255));
        registroDocenteApelli.setForeground(new java.awt.Color(0, 0, 0));

        registroDocenteNom.setBackground(new java.awt.Color(255, 255, 255));
        registroDocenteNom.setForeground(new java.awt.Color(0, 0, 0));
        registroDocenteNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDocenteNomActionPerformed(evt);
            }
        });

        registroDocenteCorreo.setBackground(new java.awt.Color(255, 255, 255));
        registroDocenteCorreo.setForeground(new java.awt.Color(0, 0, 0));

        registroDocenteEspecialidad.setBackground(new java.awt.Color(255, 255, 255));
        registroDocenteEspecialidad.setForeground(new java.awt.Color(0, 0, 0));
        registroDocenteEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige una pocion", "Matematica", "Informatico" }));

        registroDocenteDireccion.setBackground(new java.awt.Color(255, 255, 255));
        registroDocenteDireccion.setForeground(new java.awt.Color(0, 0, 0));

        registroDocenteTelefono.setBackground(new java.awt.Color(255, 255, 255));
        registroDocenteTelefono.setForeground(new java.awt.Color(0, 0, 0));

        registroDocenteContrasena.setBackground(new java.awt.Color(255, 255, 255));
        registroDocenteContrasena.setForeground(new java.awt.Color(0, 0, 0));
        registroDocenteContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDocenteContrasenaActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Completa el formulario con los datos del docente que deseas registrar en el sistema.");

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Asegúrate de que la información sea precisa para garantizar una correcta identificación y gestión dentro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(registroDocenteNom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registroDocenteCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registroDocenteDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(0, 245, Short.MAX_VALUE))
                                    .addComponent(registroDocenteTelefono))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(registroDocenteApelli)
                                        .addComponent(registroDocenteEspecialidad, 0, 300, Short.MAX_VALUE)
                                        .addComponent(registroDocenteFechaNac))
                                    .addComponent(registroDocenteContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(registroDocentebtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(registroDocenteBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registroDocenteNom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registroDocenteApelli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroDocenteEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registroDocenteCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroDocenteDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registroDocenteFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroDocenteContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registroDocenteTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroDocenteBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registroDocentebtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
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

    private void registroDocenteContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDocenteContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroDocenteContrasenaActionPerformed

    private void registroDocenteBtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDocenteBtnRegistrarActionPerformed

        /* Codigo Marco*/
        String nombre    = registroDocenteNom.getText().trim();
        String apellido  = registroDocenteApelli.getText().trim();
        String correo    = registroDocenteCorreo.getText().trim();
        String especial  = registroDocenteEspecialidad.getSelectedItem().toString();
        String direccion = registroDocenteDireccion.getText().trim();
        String telefono  = registroDocenteTelefono.getText().trim();
        String pass      = new String(registroDocenteContrasena.getPassword());
        
    
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el nombre.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registroDocenteNom.requestFocus();
            return;
        }
        if (nombre.length() > 30) {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede superar los 30 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registroDocenteNom.requestFocus();
            return;
        }
        if (!nombre.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede contener números ni símbolos.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteNom.requestFocus();
            return;
        }
        
        
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el apellido.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registroDocenteApelli.requestFocus();
            return;
        }
        if (apellido.length() > 30) {
            JOptionPane.showMessageDialog(this,
                "El apellido no puede superar los 30 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registroDocenteApelli.requestFocus();
            return;
        }
        if (!apellido.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            JOptionPane.showMessageDialog(this,
                "El apellido no puede contener números ni símbolos.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteApelli.requestFocus();
            return;
        }
        
        
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el correo.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registroDocenteCorreo.requestFocus();
            return;
        }
        if (correo.length() > 100) {
            JOptionPane.showMessageDialog(this,
                "El correo no puede exceder los 100 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registroDocenteCorreo.requestFocus();
            return;
        }
        if (correo.contains(" ")) {
            JOptionPane.showMessageDialog(this,
                "El correo no puede contener espacios.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteCorreo.requestFocus();
            return;
        }
        if (!(correo.endsWith("@gmail.com") || correo.endsWith("@utp.edu.pe"))) {
            JOptionPane.showMessageDialog(this,
                "El correo debe terminar en @gmail.com o @utp.edu.pe.",
                "Dominio inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteCorreo.requestFocus();
            return;
        }
        
        
        if (registroDocenteEspecialidad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                "Por favor, seleccione una especialidad.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registroDocenteEspecialidad.requestFocus();
            return;
        }
        
        
        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese la dirección.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registroDocenteDireccion.requestFocus();
            return;
        }
        if (direccion.length() < 8 || direccion.length() > 50) {
            JOptionPane.showMessageDialog(this,
                "La dirección debe tener entre 8 y 50 caracteres.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteDireccion.requestFocus();
            return;
        }
        if (!direccion.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ0-9\\s\\.,\\-#º°]+")) {
            JOptionPane.showMessageDialog(this,
                "La dirección contiene caracteres no permitidos.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteDireccion.requestFocus();
            return;
        }
        
        
        Date fechaDate = (Date) registroDocenteFechaNac.getValue();
        LocalDate fecha = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now();
        
        if (fecha.isAfter(hoy)) {
            JOptionPane.showMessageDialog(this,
                "La fecha de nacimiento no puede ser una fecha futura.",
                "Fecha inválida", JOptionPane.ERROR_MESSAGE);
            registroDocenteFechaNac.requestFocus();
            return;
        }
        if (fecha.isAfter(hoy.minusYears(18))) {
            JOptionPane.showMessageDialog(this,
                "El docente debe ser mayor de 18 años.",
                "Edad inválida", JOptionPane.ERROR_MESSAGE);
            registroDocenteFechaNac.requestFocus();
            return;
        }
        
        
        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese el teléfono.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registroDocenteTelefono.requestFocus();
            return;
        }
        if (!telefono.matches("9\\d{8}")) {
            JOptionPane.showMessageDialog(this,
                "El teléfono debe tener 9 numeros y comenzar con 9",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteTelefono.requestFocus();
            return;
        }
        
        
        if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, ingrese la contraseña.",
                "Campo obligatorio", JOptionPane.WARNING_MESSAGE);
            registroDocenteContrasena.requestFocus();
            return;
        }
        if (pass.length() <= 5) {
            JOptionPane.showMessageDialog(this,
                "La contraseña debe tener al menos 6 caracteres.",
                "Longitud inválida", JOptionPane.WARNING_MESSAGE);
            registroDocenteContrasena.requestFocus();
            return;
        }
        if (!pass.matches(".*[A-Za-z].*")) {
            JOptionPane.showMessageDialog(this,
                "La contraseña debe contener al menos una letra.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteContrasena.requestFocus();
            return;
        }
        if (!pass.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(this,
                "La contraseña debe contener al menos un número.",
                "Formato inválido", JOptionPane.ERROR_MESSAGE);
            registroDocenteContrasena.requestFocus();
            return;
        }
        
        
        Docente d = new Docente();
        d.setNombre(nombre);
        d.setApellido(apellido);
        d.setCorreo(correo);
        d.setEspecialidad(especial);
        d.setDireccion(direccion);
        d.setFechaNacimiento(fecha);
        d.setTelefono(telefono);
        d.setContraseña(pass);

        
        DocenteController ctrl = new DocenteController(
            new DocenteDAO(new ConexionBD())
        );
            boolean ok = ctrl.registrarDocente(d);
        if (ok) {
            JOptionPane.showMessageDialog(this, "✅ Docente registrado con ID: " + d.getDocID());
            
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al registrar docente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registroDocenteBtnRegistrarActionPerformed

    private void registroDocenteNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDocenteNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroDocenteNomActionPerformed

    private void registroDocentebtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDocentebtnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_registroDocentebtnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField registroDocenteApelli;
    private javax.swing.JButton registroDocenteBtnRegistrar;
    private javax.swing.JPasswordField registroDocenteContrasena;
    private javax.swing.JTextField registroDocenteCorreo;
    private javax.swing.JTextField registroDocenteDireccion;
    private javax.swing.JComboBox<String> registroDocenteEspecialidad;
    private javax.swing.JSpinner registroDocenteFechaNac;
    private javax.swing.JTextField registroDocenteNom;
    private javax.swing.JTextField registroDocenteTelefono;
    private javax.swing.JButton registroDocentebtnLimpiar;
    // End of variables declaration//GEN-END:variables
}

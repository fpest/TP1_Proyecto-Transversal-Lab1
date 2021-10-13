/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.AlumnoData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Conexion;

/**
 *
 * @author juani
 */
public class RegistroAlumno extends javax.swing.JInternalFrame {

    AlumnoData alumnoData;
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    Alumno alumno;

    public RegistroAlumno(AlumnoData alumnoData) {

        initComponents();
        limpiarCampos();
        this.alumnoData = alumnoData;
        listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos();
        llenarListaAlumnos(true);
        desactivarControles();
    }

    public void limpiarCampos() {
        txtLegajo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtBuscarAlu.setText("");
        chkActivo.setSelected(false);
        rbtnActivos.setSelected(true);
        jdcFechaNacimiento.setDate(new Date());
        btnAltaAlu.setText("Alta");
        btnModificarAlu.setText("Modificación");

    }

    public void llenarListaAlumnos(Boolean activo) {

        if (!txtBuscarAlu.getText().isBlank()) {
            listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos(txtBuscarAlu.getText());
        } else {
            listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos();
        }

        lstAlumnos.removeAll();

        int largoLista = listaAlumnos.size();
        //    String[] apellidoNombre = new String[largoLista];
        Alumno[] apellidoNombre = new Alumno[largoLista];
        int i = 0;

        for (Alumno alumno : listaAlumnos) {
            if (alumno.isActivo() == activo) {
                apellidoNombre[i] = alumno;
                i++;
            }
        }

        lstAlumnos.setModel(new javax.swing.AbstractListModel<Alumno>() {
            public int getSize() {
                return listaAlumnos.size();
            }

            public Alumno getElementAt(int i) {
                return apellidoNombre[i];
            }
        });
    }

    public void activarControles() {
        btnBajaAlu.setEnabled(true);
        btnModificarAlu.setEnabled(true);
        txtLegajo.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        jdcFechaNacimiento.setEnabled(true);
        chkActivo.setEnabled(true);
    }

    public void desactivarControles() {
        btnBajaAlu.setEnabled(false);
        btnModificarAlu.setEnabled(false);
        txtLegajo.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        jdcFechaNacimiento.setEnabled(false);
        chkActivo.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        btngAlumnos = new javax.swing.ButtonGroup();
        panelAltaAlumno = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        btnAltaAlu = new javax.swing.JButton();
        btnBajaAlu = new javax.swing.JButton();
        btnModificarAlu = new javax.swing.JButton();
        txtBuscarAlu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAlumnos = new javax.swing.JList<>();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        chkActivo = new javax.swing.JCheckBox();
        rbtnActivos = new javax.swing.JRadioButton();
        rbtnInactivos = new javax.swing.JRadioButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Alta / Bajas / Modificaciones de Alumnos");

        panelAltaAlumno.setBackground(new java.awt.Color(204, 204, 204));
        panelAltaAlumno.setPreferredSize(new java.awt.Dimension(690, 343));

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("N° de Legajo");

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ALTA / BAJA / MODIFICACIONES DE ALUMNOS");

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fecha de nacimiento");

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Buscar por Nombre / Legajo.");

        txtLegajo.setNextFocusableComponent(txtNombre);
        txtLegajo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLegajoFocusLost(evt);
            }
        });

        txtNombre.setNextFocusableComponent(txtApellido);

        txtApellido.setNextFocusableComponent(jdcFechaNacimiento);

        btnAltaAlu.setText("Alta");
        btnAltaAlu.setMaximumSize(new java.awt.Dimension(91, 23));
        btnAltaAlu.setMinimumSize(new java.awt.Dimension(91, 23));
        btnAltaAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaAluActionPerformed(evt);
            }
        });

        btnBajaAlu.setText("Baja");
        btnBajaAlu.setMaximumSize(new java.awt.Dimension(91, 23));
        btnBajaAlu.setMinimumSize(new java.awt.Dimension(91, 23));
        btnBajaAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaAluActionPerformed(evt);
            }
        });

        btnModificarAlu.setText("Modificación");
        btnModificarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAluActionPerformed(evt);
            }
        });

        txtBuscarAlu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAluKeyReleased(evt);
            }
        });

        lstAlumnos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAlumnosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstAlumnos);

        chkActivo.setText("Activo");

        btngAlumnos.add(rbtnActivos);
        rbtnActivos.setSelected(true);
        rbtnActivos.setText("Activos");
        rbtnActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivosActionPerformed(evt);
            }
        });

        btngAlumnos.add(rbtnInactivos);
        rbtnInactivos.setText("Inactivos");
        rbtnInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInactivosActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAltaAlumnoLayout = new javax.swing.GroupLayout(panelAltaAlumno);
        panelAltaAlumno.setLayout(panelAltaAlumnoLayout);
        panelAltaAlumnoLayout.setHorizontalGroup(
            panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAltaAlumnoLayout.createSequentialGroup()
                .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtnActivos)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnInactivos))
                    .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                                .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                                        .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                                                .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3))
                                                .addGap(91, 91, 91))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAltaAlumnoLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(10, 10, 10)))
                                        .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkActivo)
                                            .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtLegajo)
                                                .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                                .addComponent(txtNombre)
                                                .addComponent(txtApellido))))
                                    .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                                        .addComponent(btnAltaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBajaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModificarAlu, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSalir)
                                    .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtBuscarAlu)
                                        .addComponent(jLabel6)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 85, Short.MAX_VALUE)))))
                .addGap(57, 57, 57))
        );
        panelAltaAlumnoLayout.setVerticalGroup(
            panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 41, Short.MAX_VALUE)
                        .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnInactivos)
                            .addComponent(rbtnActivos))
                        .addGap(27, 27, 27))
                    .addGroup(panelAltaAlumnoLayout.createSequentialGroup()
                        .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(chkActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarAlu)
                    .addComponent(btnBajaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAltaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbtnInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInactivosActionPerformed
        txtBuscarAlu.setText("");
        listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos();
        if (rbtnActivos.isSelected()) {
            llenarListaAlumnos(true);
        } else {
            llenarListaAlumnos(false);
        }
    }//GEN-LAST:event_rbtnInactivosActionPerformed

    private void rbtnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivosActionPerformed
        txtBuscarAlu.setText("");
        listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos();
        if (rbtnActivos.isSelected()) {
            llenarListaAlumnos(true);
        } else {
            llenarListaAlumnos(false);
        }
    }//GEN-LAST:event_rbtnActivosActionPerformed

    private void txtBuscarAluKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAluKeyReleased
        if (txtBuscarAlu.getText().isEmpty()){
        desactivarControles();
        btnAltaAlu.setEnabled(true);
        
        
        }
        llenarListaAlumnos(rbtnActivos.isSelected());
    }//GEN-LAST:event_txtBuscarAluKeyReleased

    private void btnAltaAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaAluActionPerformed
        if (btnAltaAlu.getText() == "Alta") {
            limpiarCampos();
            activarControles();
            llenarListaAlumnos(true);
            btnBajaAlu.setEnabled(false);
            btnModificarAlu.setEnabled(false);
            chkActivo.setSelected(true);
            btnAltaAlu.setText("Guardar");
            txtLegajo.requestFocus();
        } else {
            //Archivar
            if (validarCampos()) {
                int legajo = Integer.valueOf(txtLegajo.getText());
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                Date fechaNac = jdcFechaNacimiento.getDate();
                boolean activo = chkActivo.isSelected();
                btnAltaAlu.setText("Alta");

                alumno = new Alumno(legajo, nombre, apellido, convertToLocalDate(fechaNac), activo);

                if (alumnoData.guardarAlumno(alumno)) {
                    limpiarCampos();
                    desactivarControles();
                    llenarListaAlumnos(true);
                    JOptionPane.showMessageDialog(null, " Alumno Registrado");
                } else {
                    txtLegajo.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btnAltaAluActionPerformed

    private void txtLegajoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLegajoFocusLost

    }//GEN-LAST:event_txtLegajoFocusLost

    private void llenarCampos(Alumno alumno) {
        txtLegajo.setText(String.valueOf(alumno.getLegajo()));
        txtNombre.setText(alumno.getNombre());
        txtApellido.setText(alumno.getApellido());
        chkActivo.setSelected(alumno.isActivo());
        jdcFechaNacimiento.setDate(convertToDate(alumno.getFechaNac()));
    }


    private void lstAlumnosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAlumnosValueChanged
        if (!lstAlumnos.isSelectionEmpty()) {
            txtBuscarAlu.setText(lstAlumnos.getSelectedValue().toString());
            desactivarControles();
            btnBajaAlu.setEnabled(true);
            btnModificarAlu.setEnabled(true);
            btnAltaAlu.setEnabled(false);
            btnAltaAlu.setText("Alta");
            btnModificarAlu.setText("Modificación");
            llenarCampos(lstAlumnos.getSelectedValue());
        }
    }//GEN-LAST:event_lstAlumnosValueChanged

    private void btnBajaAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaAluActionPerformed

        int idAlumno = lstAlumnos.getSelectedValue().getIdAlumno();
        int legajo = Integer.valueOf(txtLegajo.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        Date fechaNac = jdcFechaNacimiento.getDate();
        boolean activo = false;
        alumno = new Alumno(idAlumno, legajo, nombre, apellido, convertToLocalDate(fechaNac), activo);
        alumnoData.actualizarAlumno(alumno);

        limpiarCampos();
        desactivarControles();
        llenarListaAlumnos(true);
        JOptionPane.showMessageDialog(null, " Alumno Dado de Baja");


    }//GEN-LAST:event_btnBajaAluActionPerformed

    private void btnModificarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAluActionPerformed
        if (btnModificarAlu.getText() == "Modificación") {
            activarControles();
            btnModificarAlu.setText("Guardar Cambios");
        } else {
            if (validarCampos()) {
                int idAlumno = lstAlumnos.getSelectedValue().getIdAlumno();
                int legajo = Integer.valueOf(txtLegajo.getText());
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                Date fechaNac = jdcFechaNacimiento.getDate();
                boolean activo = chkActivo.isSelected();
                alumno = new Alumno(idAlumno, legajo, nombre, apellido, convertToLocalDate(fechaNac), activo);

                if (alumnoData.actualizarAlumno(alumno)) {
                    limpiarCampos();
                    desactivarControles();
                    btnAltaAlu.setEnabled(true);
                    btnAltaAlu.setText("Alta");
                    llenarListaAlumnos(true);
                    JOptionPane.showMessageDialog(null, "Datos del Alumno Modificados.");
                } else {
                    txtLegajo.requestFocus();
                }
            }
        }

    }//GEN-LAST:event_btnModificarAluActionPerformed

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    private boolean validarCampos() {
        boolean validado = true;
        try {
            int modelo = Integer.parseInt(txtLegajo.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Legajo.");
            txtLegajo.requestFocus();
            validado = false;
        }
        if (txtLegajo.getText().isEmpty()
                || txtNombre.getText().isEmpty()
                || txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los Campos deben estar llenos.");
            txtLegajo.requestFocus();
            validado = false;
        }
        return validado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaAlu;
    private javax.swing.JButton btnBajaAlu;
    private javax.swing.JButton btnModificarAlu;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup btngAlumnos;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JList<Alumno> lstAlumnos;
    private javax.swing.JPanel panelAltaAlumno;
    private javax.swing.JRadioButton rbtnActivos;
    private javax.swing.JRadioButton rbtnInactivos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarAlu;
    private javax.swing.JTextField txtLegajo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.Materia;

/**
 *
 * @author juani
 */
public class RegistroMaterias extends javax.swing.JInternalFrame {
    MateriaData materiaData;
    InscripcionData inscripcionData;
    Materia materia;
    ArrayList<Materia> listaMaterias = new ArrayList<>();
    
    /**
     * Creates new form RegistroMaterias
     */
    public RegistroMaterias(MateriaData materiaData, InscripcionData inscripcionData) {
        initComponents();
        limpiarCampos();
        this.materiaData = materiaData;
        this.inscripcionData = inscripcionData;
        listaMaterias = (ArrayList) materiaData.obtenerMateria();
        llenarListaMaterias(true);
        desactivarControles();
    }
    
    public void llenarListaMaterias(Boolean activo) {

        if (txtBuscarMat.getText() != ""){
            listaMaterias = (ArrayList) materiaData.obtenerMateria (txtBuscarMat.getText());
        } else {
            listaMaterias = (ArrayList) materiaData.obtenerMateria();
        }

        lstMaterias.removeAll();

        int largoLista = listaMaterias.size();
        //    String[] apellidoNombre = new String[largoLista];
        Materia[] nombreMateria = new Materia[largoLista];
        int i = 0;

        for (Materia materia : listaMaterias) {
            if (materia.isActivo() == activo) {
                nombreMateria[i] = materia;
                i++;
            }
        }

        lstMaterias.setModel(new javax.swing.AbstractListModel<Materia>(){
            @Override
            public int getSize() {
                return listaMaterias.size();
            }

            @Override
            public Materia getElementAt(int i) {
                return nombreMateria[i];
            }
        });
    }
    
    public void limpiarCampos() {
        txtAño.setText("");
        txtNombreMateria.setText("");
        txtBuscarMat.setText("");
        chkActiva.setSelected(false);
        
        btnAltaMat.setText("Alta");
        btnModificarMat.setText("Modificación");

    }
    
    public void activarControles() {
        btnBajaMat.setEnabled(true);
        btnModificarMat.setEnabled(true);
        txtAño.setEnabled(true);
        txtNombreMateria.setEnabled(true);
        chkActiva.setEnabled(true);
    }

    public void desactivarControles() {
        btnBajaMat.setEnabled(false);
        btnModificarMat.setEnabled(false);
        txtAño.setEnabled(false);
        txtNombreMateria.setEnabled(false);
        chkActiva.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgMaterias = new javax.swing.ButtonGroup();
        panelAltaMaterias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMaterias = new javax.swing.JList<>();
        txtBuscarMat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnModificarMat = new javax.swing.JButton();
        btnBajaMat = new javax.swing.JButton();
        btnAltaMat = new javax.swing.JButton();
        txtAño = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreMateria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        chkActiva = new javax.swing.JCheckBox();
        rbtnActivas = new javax.swing.JRadioButton();
        rbtnInactivas = new javax.swing.JRadioButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Alta de materias");

        panelAltaMaterias.setBackground(new java.awt.Color(204, 204, 204));
        panelAltaMaterias.setPreferredSize(new java.awt.Dimension(690, 325));

        lstMaterias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstMateriasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstMaterias);

        txtBuscarMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarMatKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Buscar");

        btnModificarMat.setText("Modificación");
        btnModificarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMatActionPerformed(evt);
            }
        });

        btnBajaMat.setText("Baja");
        btnBajaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaMatActionPerformed(evt);
            }
        });

        btnAltaMat.setText("Alta");
        btnAltaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaMatActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Año");

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ALTA DE MATERIAS");

        chkActiva.setText("Activa");

        bgMaterias.add(rbtnActivas);
        rbtnActivas.setSelected(true);
        rbtnActivas.setText("Activas");
        rbtnActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivasActionPerformed(evt);
            }
        });

        bgMaterias.add(rbtnInactivas);
        rbtnInactivas.setText("Inactivas");
        rbtnInactivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInactivasActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAltaMateriasLayout = new javax.swing.GroupLayout(panelAltaMaterias);
        panelAltaMaterias.setLayout(panelAltaMateriasLayout);
        panelAltaMateriasLayout.setHorizontalGroup(
            panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAltaMateriasLayout.createSequentialGroup()
                .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAltaMat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBajaMat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarMat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                                .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chkActiva)
                                        .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22))
                            .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(230, 230, 230)))
                        .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                                    .addComponent(rbtnActivas)
                                    .addGap(60, 60, 60)
                                    .addComponent(rbtnInactivas))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(105, 105, 105))
        );
        panelAltaMateriasLayout.setVerticalGroup(
            panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAltaMateriasLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscarMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAltaMateriasLayout.createSequentialGroup()
                        .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkActiva)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnInactivas)
                    .addComponent(rbtnActivas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelAltaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarMat)
                    .addComponent(btnBajaMat)
                    .addComponent(btnAltaMat)
                    .addComponent(btnSalir))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAltaMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAltaMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbtnInactivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInactivasActionPerformed
        limpiarCampos();
        listaMaterias = (ArrayList) materiaData.obtenerMateria();
        if (rbtnActivas.isSelected()) {
            llenarListaMaterias(true);
        } else {
            llenarListaMaterias(false);
        }
    }//GEN-LAST:event_rbtnInactivasActionPerformed

    private void rbtnActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivasActionPerformed
        limpiarCampos();
        listaMaterias = (ArrayList) materiaData.obtenerMateria();
        if (rbtnActivas.isSelected()) {
            llenarListaMaterias(true);
        } else {
            llenarListaMaterias(false);
        }
    }//GEN-LAST:event_rbtnActivasActionPerformed

    private void btnBuscarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMatActionPerformed
        llenarListaMaterias(true);
    }//GEN-LAST:event_btnBuscarMatActionPerformed

    private void btnAltaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaMatActionPerformed
        if (btnAltaMat.getText() == "Alta") {
            limpiarCampos();
            activarControles();
            llenarListaMaterias(true);
            btnBajaMat.setEnabled(false);
            btnModificarMat.setEnabled(false);
            chkActiva.setSelected(true);
            btnAltaMat.setText("Guardar");
        } else {
            if (validarCampos()) {
                int anio = Integer.valueOf(txtAño.getText());
                String nombre = txtNombreMateria.getText();
                boolean activo = chkActiva.isSelected();
                btnAltaMat.setText("Alta");

                materia = new Materia(nombre, anio,activo );
                materiaData.guardarMateria(materia);

                limpiarCampos();
                desactivarControles();
                llenarListaMaterias(true);
                JOptionPane.showMessageDialog(null, " Materia Registrada");
            }
        }
    }//GEN-LAST:event_btnAltaMatActionPerformed

    private void btnBajaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaMatActionPerformed
    
    
        
        
        if (inscripcionData.obtenerAlumnoMaterias(lstMaterias.getSelectedValue().getIdMateria()).size() != 0){
        JOptionPane.showMessageDialog(null, " Esta Materia No se puede desactivar porque tiene Alumnos Inscriptos.");
        }
        else{
        
        int anio = Integer.valueOf(txtAño.getText());
        String nombre = txtNombreMateria.getText();
        boolean activo = false;
        int idMateria = lstMaterias.getSelectedValue().getIdMateria();
        materia = new Materia(idMateria, nombre, anio, activo);
        materiaData.actualizarMateria(materia);

        limpiarCampos();
        desactivarControles();
        llenarListaMaterias(true);
        JOptionPane.showMessageDialog(null, " Materia Dada de Baja");
        }
    }//GEN-LAST:event_btnBajaMatActionPerformed

    private void btnBuscarMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarMatKeyReleased
        
    }//GEN-LAST:event_btnBuscarMatKeyReleased

    private void llenarCampos(Materia materia) {
        txtAño.setText(String.valueOf(materia.getAnio()));
        txtNombreMateria.setText(materia.getNombre());
        chkActiva.setSelected(materia.isActivo());
    }
    
    private void lstMateriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMateriasValueChanged
        
        try{
        if (!lstMaterias.isSelectionEmpty()) {
            txtBuscarMat.setText(lstMaterias.getSelectedValue().toString());
            btnBajaMat.setEnabled(true);
            btnModificarMat.setEnabled(true);
            btnAltaMat.setEnabled(false);
            llenarCampos(lstMaterias.getSelectedValue());
        }
         }catch(NullPointerException ex){
           JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la lista.");
                    }

        
        
        
    }//GEN-LAST:event_lstMateriasValueChanged

    private void txtBuscarMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMatKeyReleased
       if (txtBuscarMat.getText().isEmpty()){
        desactivarControles();
        btnAltaMat.setEnabled(true);
        
        
        }
        
        llenarListaMaterias(rbtnActivas.isSelected());
    }//GEN-LAST:event_txtBuscarMatKeyReleased

    private void btnModificarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMatActionPerformed
 
        
        
        if (btnModificarMat.getText() == "Modificación") {
            activarControles();
     
            if (rbtnActivas.isSelected()){chkActiva.setEnabled(false);};
            btnModificarMat.setText("Guardar Cambios");
        } else {
            if (validarCampos()) {
                int idAlumno = lstMaterias.getSelectedValue().getIdMateria();
                String nombre = txtNombreMateria.getText();
                int anio = Integer.parseInt(txtAño.getText());
                boolean activo = chkActiva.isSelected();
                int idMateria = lstMaterias.getSelectedValue().getIdMateria();
                materia = new Materia(idMateria, nombre, anio, activo);

                if (materiaData.actualizarMateria(materia)) {
                    limpiarCampos();
                    desactivarControles();
                    btnAltaMat.setEnabled(true);
                    btnAltaMat.setText("Alta");
                    llenarListaMaterias(true);
                    JOptionPane.showMessageDialog(null, "Datos de la Materia Modificados.");
                } else {
                    txtNombreMateria.requestFocus();
                }
            }
        }



    }//GEN-LAST:event_btnModificarMatActionPerformed

    private boolean validarCampos() {
        boolean validado = true;
        try {
            int modelo = Integer.parseInt(txtAño.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar sólo números en el campo Legajo.");
            txtAño.requestFocus();
            validado = false;
        }
        if (txtAño.getText().isEmpty()
                || txtNombreMateria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los Campos deben estar llenos.");
            txtAño.requestFocus();
            validado = false;
        }
        return validado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMaterias;
    private javax.swing.JButton btnAltaMat;
    private javax.swing.JButton btnBajaMat;
    private javax.swing.JButton btnModificarMat;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkActiva;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Materia> lstMaterias;
    private javax.swing.JPanel panelAltaMaterias;
    private javax.swing.JRadioButton rbtnActivas;
    private javax.swing.JRadioButton rbtnInactivas;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBuscarMat;
    private javax.swing.JTextField txtNombreMateria;
    // End of variables declaration//GEN-END:variables
}

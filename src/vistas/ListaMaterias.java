package vistas;

import control.AlumnoData;
import control.InscripcionData;
import control.MateriaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Materia;
import modelo.Nota;

public class ListaMaterias extends javax.swing.JInternalFrame {

    MateriaData materiaData;
    AlumnoData alumnoData;
    InscripcionData inscripcionData;
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    ArrayList<Materia> listaMaterias = new ArrayList<>();

    public ListaMaterias(AlumnoData alumnoData, MateriaData materiaData, InscripcionData inscripcionData) {
        initComponents();
        limpiarCampos();
        this.alumnoData = alumnoData;
        this.materiaData = materiaData;
        this.inscripcionData = inscripcionData;
        listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos();
        llenarListaAlumnos(true);
    }

    public void limpiarCampos() {
        DefaultTableModel model = (DefaultTableModel) tblMaterias.getModel();
        model.setRowCount(0);
        txtAlumnos.setText("");
    }

    public void llenarListaAlumnos(Boolean activo) {
        if (txtAlumnos.getText() != "") {
            listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos(txtAlumnos.getText());
        } else {
            listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos();
        }

        lstAlumnos.removeAll();

        int largoLista = listaAlumnos.size();
        //    String[] apellidoNombre = new String[largoLista];
        Alumno[] nombre = new Alumno[largoLista];
        int i = 0;

        for (Alumno alumno : listaAlumnos) {
            if (alumno.isActivo()) {
                nombre[i] = alumno;
                i++;
            }
        }

        lstAlumnos.setModel(new javax.swing.AbstractListModel<Alumno>() {
            @Override
            public int getSize() {
                return listaAlumnos.size();
            }

            @Override
            public Alumno getElementAt(int i) {
                return nombre[i];
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMaterias = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAlumnos = new javax.swing.JList<>();
        txtAlumnos = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Lista de materias");

        panelMaterias.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE MATERIAS POR ALUMNO");

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Alumnos por Nombre/Legajo");

        lstAlumnos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAlumnosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstAlumnos);

        txtAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnosKeyReleased(evt);
            }
        });

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Materia", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMaterias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMateriasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblMaterias);
        if (tblMaterias.getColumnModel().getColumnCount() > 0) {
            tblMaterias.getColumnModel().getColumn(0).setResizable(false);
            tblMaterias.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMateriasLayout = new javax.swing.GroupLayout(panelMaterias);
        panelMaterias.setLayout(panelMateriasLayout);
        panelMateriasLayout.setHorizontalGroup(
            panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
            .addGroup(panelMateriasLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addGroup(panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(panelMateriasLayout.createSequentialGroup()
                            .addGroup(panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMateriasLayout.setVerticalGroup(
            panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMateriasLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMateriasLayout.createSequentialGroup()
                        .addComponent(txtAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void llenarCampos(Alumno alumno) {
        txtAlumnos.setText(String.valueOf(alumno.toString()));
        alumno = lstAlumnos.getSelectedValue();
        llenarTablaMaterias(alumno);
    }

    private void llenarTablaMaterias(Alumno alumno) {
        DefaultTableModel model = (DefaultTableModel) tblMaterias.getModel();
        model.setRowCount(0);

        ArrayList<Nota> listaNotas = inscripcionData.buscarNotas(alumno);

        for (Nota nota : listaNotas) {
            // DefaultTableModel model = (DefaultTableModel) tblNotas.getModel();
            model.addRow(new Object[]{nota, nota.getNota()});
        }
    }

    private void lstAlumnosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAlumnosValueChanged

        try {
            if (!lstAlumnos.isSelectionEmpty()) {
                txtAlumnos.setText(lstAlumnos.getSelectedValue().toString());
                llenarCampos(lstAlumnos.getSelectedValue());
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la lista.");
        }
    }//GEN-LAST:event_lstAlumnosValueChanged

    private void txtAlumnosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnosKeyReleased
        llenarListaAlumnos(true);
    }//GEN-LAST:event_txtAlumnosKeyReleased


    private void tblMateriasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMateriasKeyReleased

    }//GEN-LAST:event_tblMateriasKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Alumno> lstAlumnos;
    private javax.swing.JPanel panelMaterias;
    private javax.swing.JTable tblMaterias;
    private javax.swing.JTextField txtAlumnos;
    // End of variables declaration//GEN-END:variables

}

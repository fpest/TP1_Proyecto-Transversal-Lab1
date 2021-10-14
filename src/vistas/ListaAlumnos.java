package vistas;

import control.AlumnoData;
import control.InscripcionData;
import control.MateriaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Materia;

public class ListaAlumnos extends javax.swing.JInternalFrame {

    MateriaData materiaData;
    AlumnoData alumnoData;
    InscripcionData inscripcionData;
    DefaultTableModel modeloTabla;
    String data[][] = {};
    String cabeza[] = {"Apellido", "Nombre"};
    ArrayList<Materia> listaMaterias = new ArrayList<>();
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public ListaAlumnos(AlumnoData alumnoData, MateriaData materiaData, InscripcionData inscripcionData) {
        initComponents();
        limpiarCampos();
        this.alumnoData = alumnoData;
        this.materiaData = materiaData;
        this.inscripcionData = inscripcionData;
        listaMaterias = (ArrayList) materiaData.obtenerMateria();
        llenarListaMaterias();
        tablaAlumnos(0);

    }

    public void limpiarCampos() {

        DefaultTableModel model = (DefaultTableModel) tblAlumnos.getModel();
        model.setRowCount(0);
    }

    public void llenarListaMaterias() {

        if (!"".equals(txtMateria.getText())) {
            listaMaterias = (ArrayList) materiaData.obtenerMateria(txtMateria.getText());
        } else {
            listaMaterias = (ArrayList) materiaData.obtenerMateria();
        }

        lstMaterias.removeAll();

        int largoLista = listaMaterias.size();
        //    String[] apellidoNombre = new String[largoLista];
        Materia[] nombre = new Materia[largoLista];
        int i = 0;

        for (Materia materia : listaMaterias) {
            if (materia.isActivo()) {
                nombre[i] = materia;
                i++;
            }
        }

        lstMaterias.setModel(new javax.swing.AbstractListModel<Materia>() {
            public int getSize() {
                return listaMaterias.size();
            }

            public Materia getElementAt(int i) {
                return nombre[i];
            }
        });
    }

    public void tablaAlumnos(int idMateria) {
        listaAlumnos = inscripcionData.obtenerAlumnoMaterias(idMateria);
        modeloTabla = new DefaultTableModel(data, cabeza) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        tblAlumnos.setModel(modeloTabla);
        for (Alumno a : listaAlumnos) {

            Object datos[] = {a.getApellido(), a.getNombre()};
            modeloTabla.addRow(datos);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAlumnos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        txtMateria = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMaterias = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Lista de Alumnos");

        panelAlumnos.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE ALUMNOS POR MATERIA");

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Buscar Materia");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMateriaKeyReleased(evt);
            }
        });

        lstMaterias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMaterias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstMateriasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstMaterias);

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAlumnos.setFocusable(false);
        jScrollPane1.setViewportView(tblAlumnos);

        javax.swing.GroupLayout panelAlumnosLayout = new javax.swing.GroupLayout(panelAlumnos);
        panelAlumnos.setLayout(panelAlumnosLayout);
        panelAlumnosLayout.setHorizontalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelAlumnosLayout.createSequentialGroup()
                            .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMateria)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        panelAlumnosLayout.setVerticalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(btnSalir)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lstMateriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMateriasValueChanged

        try {
            if (!lstMaterias.isSelectionEmpty()) {
                txtMateria.setText(lstMaterias.getSelectedValue().toString());
                limpiarCampos();
                tablaAlumnos(lstMaterias.getSelectedValue().getIdMateria());

            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la lista.");
        }

    }//GEN-LAST:event_lstMateriasValueChanged

    private void txtMateriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMateriaKeyReleased
        llenarListaMaterias();
    }//GEN-LAST:event_txtMateriaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Materia> lstMaterias;
    private javax.swing.JPanel panelAlumnos;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables
}

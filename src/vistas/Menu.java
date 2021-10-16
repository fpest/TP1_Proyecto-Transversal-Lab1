package vistas;

import control.AlumnoData;
import control.InscripcionData;
import control.MateriaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        MenuBar = new javax.swing.JMenuBar();
        Registro = new javax.swing.JMenu();
        ResgistroAlumno = new javax.swing.JMenuItem();
        RegistroMaterias = new javax.swing.JMenuItem();
        RegistroInscripciones = new javax.swing.JMenuItem();
        RegistroNotas = new javax.swing.JMenuItem();
        Informes = new javax.swing.JMenu();
        ListaA = new javax.swing.JMenuItem();
        ListaM = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();
        Desconectarse = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        MenuBar.setMinimumSize(new java.awt.Dimension(147, 30));

        Registro.setText("Registros");

        ResgistroAlumno.setText("Alumnos");
        ResgistroAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResgistroAlumnoActionPerformed(evt);
            }
        });
        Registro.add(ResgistroAlumno);

        RegistroMaterias.setText("Materias");
        RegistroMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroMateriasActionPerformed(evt);
            }
        });
        Registro.add(RegistroMaterias);

        RegistroInscripciones.setText("Inscripciones");
        RegistroInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroInscripcionesActionPerformed(evt);
            }
        });
        Registro.add(RegistroInscripciones);

        RegistroNotas.setText("Notas");
        RegistroNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroNotasActionPerformed(evt);
            }
        });
        Registro.add(RegistroNotas);

        MenuBar.add(Registro);

        Informes.setText("Informes");

        ListaA.setText("Lista de alumnos por materia");
        ListaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaAActionPerformed(evt);
            }
        });
        Informes.add(ListaA);

        ListaM.setText("Lista de materias por alumno");
        ListaM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaMActionPerformed(evt);
            }
        });
        Informes.add(ListaM);

        MenuBar.add(Informes);

        Salir.setText("Salir");

        Desconectarse.setText("Desconectarse");
        Desconectarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesconectarseActionPerformed(evt);
            }
        });
        Salir.add(Desconectarse);

        MenuBar.add(Salir);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResgistroAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResgistroAlumnoActionPerformed

        try {
            Conexion conexion = new Conexion();
            AlumnoData alumnoData = new AlumnoData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            RegistroAlumno ra = new RegistroAlumno(alumnoData);
            ra.setVisible(true);
            escritorio.add(ra);
            escritorio.moveToFront(ra);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_ResgistroAlumnoActionPerformed

    private void RegistroMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroMateriasActionPerformed

        try {
            Conexion conexion = new Conexion();
            MateriaData materiaData = new MateriaData(conexion);
            InscripcionData inscripcionData = new InscripcionData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            RegistroMaterias rm = new RegistroMaterias(materiaData, inscripcionData);
            rm.setVisible(true);
            escritorio.add(rm);
            escritorio.moveToFront(rm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RegistroMateriasActionPerformed

    private void RegistroInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroInscripcionesActionPerformed

        try {
            Conexion conexion = new Conexion();
            AlumnoData alumnoData = new AlumnoData(conexion);
            MateriaData materiaData = new MateriaData(conexion);
            InscripcionData inscripcionData = new InscripcionData(conexion);

            escritorio.removeAll();
            escritorio.repaint();
            RegistroInscripciones ri = new RegistroInscripciones(alumnoData, materiaData, inscripcionData);
            ri.setVisible(true);
            escritorio.add(ri);
            escritorio.moveToFront(ri);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RegistroInscripcionesActionPerformed

    private void ListaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaAActionPerformed

        try {
            Conexion conexion = new Conexion();
            AlumnoData alumnoData = new AlumnoData(conexion);
            MateriaData materiaData = new MateriaData(conexion);
            InscripcionData inscripcionData = new InscripcionData(conexion);

            escritorio.removeAll();
            escritorio.repaint();
            ListaAlumnos la = new ListaAlumnos(alumnoData, materiaData, inscripcionData);
            la.setVisible(true);
            escritorio.add(la);
            escritorio.moveToFront(la);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ListaAActionPerformed

    private void ListaMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaMActionPerformed

        try {
            Conexion conexion = new Conexion();
            AlumnoData alumnoData = new AlumnoData(conexion);
            MateriaData materiaData = new MateriaData(conexion);
            InscripcionData inscripcionData = new InscripcionData(conexion);

            escritorio.removeAll();
            escritorio.repaint();
            ListaMaterias lm = new ListaMaterias(alumnoData, materiaData, inscripcionData);
            lm.setVisible(true);
            escritorio.add(lm);
            escritorio.moveToFront(lm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ListaMActionPerformed

    private void DesconectarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesconectarseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_DesconectarseActionPerformed

    private void RegistroNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroNotasActionPerformed

        try {
            Conexion conexion = new Conexion();
            AlumnoData alumnoData = new AlumnoData(conexion);
            MateriaData materiaData = new MateriaData(conexion);
            InscripcionData inscripcionData = new InscripcionData(conexion);
            escritorio.removeAll();
            escritorio.repaint();
            RegistroNotas rn = new RegistroNotas(alumnoData, materiaData, inscripcionData);
            rn.setVisible(true);
            escritorio.add(rn);
            escritorio.moveToFront(rn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RegistroNotasActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Desconectarse;
    private javax.swing.JMenu Informes;
    private javax.swing.JMenuItem ListaA;
    private javax.swing.JMenuItem ListaM;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu Registro;
    private javax.swing.JMenuItem RegistroInscripciones;
    private javax.swing.JMenuItem RegistroMaterias;
    private javax.swing.JMenuItem RegistroNotas;
    private javax.swing.JMenuItem ResgistroAlumno;
    private javax.swing.JMenu Salir;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

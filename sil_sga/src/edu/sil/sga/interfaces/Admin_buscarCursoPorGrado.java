/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.interfaces;

import edu.sil.sga.dao.CursoPorGradoDAO;
import edu.sil.sga.entidades.CursoPorGrado;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo Lopez
 */
public class Admin_buscarCursoPorGrado extends javax.swing.JDialog {

    /**
     * Creates new form Admin_buscarCursoPorGrado
     */
    public List<CursoPorGrado> listaCursoPorGrado;
    private List<CursoPorGrado> lstCursoPorGrado;

    public Admin_buscarCursoPorGrado(java.awt.Frame parent, boolean modal, List<CursoPorGrado> lstCursoPorGrado) {
        super(parent, modal);
        initComponents();
        btnSeleccionar.setEnabled(false);
        listarCursoPorGrado();
        this.lstCursoPorGrado = lstCursoPorGrado;
    }

    void listarCursoPorGrado() {

        CursoPorGradoDAO dao = new CursoPorGradoDAO();
        listaCursoPorGrado = dao.ListarCursoPorGrado();
        DefaultTableModel modelo1 = new DefaultTableModel();
        //modelo1.addColumn("id");
        modelo1.addColumn("Grado");
        modelo1.addColumn("Seccion");
        modelo1.addColumn("Nivel");
        modelo1.addColumn("Curso");

        for (CursoPorGrado cursoGrado : listaCursoPorGrado) {
            modelo1.addRow(new String[]{
                cursoGrado.getGrado().getnumeroGrado() + "",
                cursoGrado.getGrado().getSeccion().getDescripcion() + "",
                cursoGrado.getGrado().getNivel().getNombreLargo() + "",
                cursoGrado.getCurso().getNombreLargo() + ""
            });
        }
        tblGradoPorCurso.setModel(modelo1);

        System.out.println("Error - cargar - grado - listar");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblGradoPorCurso = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblGradoPorCurso.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGradoPorCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGradoPorCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGradoPorCurso);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeleccionar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSeleccionar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int index = tblGradoPorCurso.getSelectedRow();
        if (index != -1) {
            CursoPorGrado objCursoGrado = listaCursoPorGrado.get(index);
            lstCursoPorGrado.add(objCursoGrado);
            this.dispose();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void tblGradoPorCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGradoPorCursoMouseClicked
        // TODO add your handling code here:
        btnSeleccionar.setEnabled(true);
    }//GEN-LAST:event_tblGradoPorCursoMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblGradoPorCurso;
    // End of variables declaration//GEN-END:variables
}

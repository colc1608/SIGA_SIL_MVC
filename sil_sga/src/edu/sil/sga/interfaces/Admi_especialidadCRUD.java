/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.interfaces;

import edu.sil.sga.dao.EspecialidadDAO;
import edu.sil.sga.entidades.Especialidad;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar Lopez
 */
public class Admi_especialidadCRUD extends javax.swing.JInternalFrame {

    /**
     * Creates new form Admi_especialidadCRUD
     */
    public List<Especialidad> listaEspecialidad;
    public Especialidad objEspecialidad;

    public Admi_especialidadCRUD() {

        initComponents();
        setSize(740, 460); // X , Y
        setLocation(350, 200);
        activaBotones(true, false, false, false);
        ListarEspecialidad();
        activaCajas(false);
        txtcodigo.setVisible(false);

    }

    //metodos a utilizar en el formulario =D
    void activaCajas(boolean a) {
        txtdescripcion.setEnabled(a);
    }

    void limpiarCajas() {
        txtcodigo.setText("");
        txtdescripcion.setText("");
    }

    public void activaBotones(boolean a, boolean b, boolean c, boolean d) {
        btnNuevo.setEnabled(a);
        btnGuardar.setEnabled(b);
        btnActualizar.setEnabled(c);
        btnEliminar.setEnabled(d);
    }

    ;
    
    public void ListarEspecialidad() {

        try {
            EspecialidadDAO dao = new EspecialidadDAO();
            listaEspecialidad = dao.ListarEspecialidad();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Descripcion");
            for (Especialidad objEspecialidad : listaEspecialidad) {
                modelo.addRow(new String[]{objEspecialidad.getId() + "", objEspecialidad.getDescripcion()});
            }
            tablaLista.setModel(modelo);
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEspecialidad = new javax.swing.JPanel();
        txtdescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLista = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtcodigo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestionar Especialidad - IEP San Ignacio de Loyola");

        panelEspecialidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Especialidad"));

        jLabel1.setText("* Nombre:");

        javax.swing.GroupLayout panelEspecialidadLayout = new javax.swing.GroupLayout(panelEspecialidad);
        panelEspecialidad.setLayout(panelEspecialidadLayout);
        panelEspecialidadLayout.setHorizontalGroup(
            panelEspecialidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEspecialidadLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelEspecialidadLayout.setVerticalGroup(
            panelEspecialidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEspecialidadLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelEspecialidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Especialidad");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listar Especialidad"));

        tablaLista.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tablaLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLista);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtcodigo.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListaMouseClicked
        // TODO add your handling code here:

        int fila = tablaLista.getSelectedRow();
        String codigo = tablaLista.getValueAt(fila, 0).toString();
        String descripcion = tablaLista.getValueAt(fila, 1).toString();
        if (descripcion.equals("")) {
            descripcion = "";
        }
        txtdescripcion.setText(descripcion);
        txtcodigo.setText(codigo);
        activaCajas(true);
        btnNuevo.setText("Nuevo");

        activaBotones(true, false, true, true);
    }//GEN-LAST:event_tablaListaMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

        if (btnNuevo.getText().equals("Nuevo")) {
            limpiarCajas();
            activaBotones(true, true, false, false);
            btnNuevo.setText("Cancelar");
            activaCajas(true);
        } else {
            activaBotones(true, false, false, false);
            btnNuevo.setText("Nuevo");
            activaCajas(false);
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String descripcion = txtdescripcion.getText();
        if (descripcion.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una descripcion", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Especialidad objEspecialidad = new Especialidad();
                objEspecialidad.setDescripcion(descripcion);
                EspecialidadDAO dao = new EspecialidadDAO();
                if (dao.RegistrarEspecialidad(objEspecialidad)) {
                    JOptionPane.showMessageDialog(null, "Se registro correctamente", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
                    activaBotones(true, false, false, false);
                    btnNuevo.setText("Nuevo");
                    limpiarCajas();
                    ListarEspecialidad();
                    activaCajas(false);
                } else {
                    JOptionPane.showMessageDialog(this, "No se puede registrar");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String codigo = txtcodigo.getText();
        String descripcion = txtdescripcion.getText();
        if (codigo.equalsIgnoreCase("") && descripcion.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {
            try {
                Especialidad objEspecialidad = new Especialidad();
                objEspecialidad.setId(Integer.parseInt(txtcodigo.getText()));
                objEspecialidad.setDescripcion(txtdescripcion.getText());
                EspecialidadDAO dao = new EspecialidadDAO();
                if (dao.ActualizarEspecialidad(objEspecialidad)) {
                    JOptionPane.showMessageDialog(this, "Se actualizo correctamente");
                    txtcodigo.setText("");
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    activaCajas(false);
                    ListarEspecialidad();
                } else {
                    JOptionPane.showMessageDialog(null, "No se puedo registrar su especialidad :( ", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        if (txtcodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {
            try {
                Especialidad especialidad = new Especialidad();
                especialidad.setId(Integer.parseInt(txtcodigo.getText()));
                especialidad.setDescripcion(txtdescripcion.getText());
                EspecialidadDAO dao = new EspecialidadDAO();
                if (dao.EliminarEspecialidad(especialidad)) {
                    JOptionPane.showMessageDialog(this, "Se elimino correctamente");
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    ListarEspecialidad();
                    activaCajas(false);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelEspecialidad;
    private javax.swing.JTable tablaLista;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
}

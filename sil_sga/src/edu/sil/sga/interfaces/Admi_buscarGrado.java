/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.interfaces;

import edu.sil.sga.dao.GradoDAO;
import edu.sil.sga.dao.NivelDAO;
import edu.sil.sga.entidades.Grado;
import edu.sil.sga.entidades.Nivel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paul
 */
public class Admi_buscarGrado extends javax.swing.JDialog {

    /**
     * Creates new form Admi_buscarGrado
     */
    
    public List<Nivel> listaNivel;
    
    
    
    public List<Grado> listaGrado;
    private List<Grado> lstGrado;
    
    
    public Admi_buscarGrado(java.awt.Frame parent, boolean modal, List<Grado> lstGrado) {
        super(parent, modal);
        initComponents();
        setLocation(20, 200);
        CargarNivel();
        listarGrado();
        ActivaSeleccionar(false);
        this.lstGrado = lstGrado;
        
        
    }
    
    
    public void ActivaSeleccionar(boolean a) {
        btnEnviar.setEnabled(a);
    }

    void CargarNivel() {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            listaNivel = new NivelDAO().ListarNivel();
            for (Nivel nivel : listaNivel) {
                model.addElement(nivel.getNombreLargo());
            }
            cboNivel.setModel(model);
        } catch (Exception e) {
            System.out.println("error - cargar - combo - nivel");
        }
    }

    void listarGrado() {
        try {
            GradoDAO dao = new GradoDAO();
            listaGrado = dao.ListarGrado();
            DefaultTableModel modelo1 = new DefaultTableModel();
            //modelo1.addColumn("id");
            modelo1.addColumn("Nivel");
            modelo1.addColumn("Grado");
            modelo1.addColumn("Seccion");

            for (Grado grado : listaGrado) {
                modelo1.addRow(new String[]{
                    //grado.getId() + "",
                    grado.getNivel().getNombreLargo()+ "",
                    grado.getnumeroGrado() + "",
                    grado.getSeccion().getDescripcion() + ""
                });
            }
            tblGrado.setModel(modelo1);
        } catch (Exception e) {
            System.out.println("Error - cargar - grado - listar");
        }
    }
    
    void ActualizarBusquedaCombo(){
        try {
            Grado g = new Grado();
            Nivel n = new Nivel();
            n.setNombreLargo(String.valueOf(cboNivel.getSelectedItem()));
            g.setNivel(n);
            listaGrado = new GradoDAO().buscarGradoCombo(g);
            DefaultTableModel modelo1 = (DefaultTableModel)tblGrado.getModel();
            while (modelo1.getRowCount()>0) {                
                modelo1.removeRow(0);
            }
            for (Grado grado : listaGrado) {
                modelo1.addRow(new String[]{
                    //grado.getId() + "",
                    grado.getNivel().getNombreLargo()+ "",
                    grado.getnumeroGrado() + "",
                    grado.getSeccion().getDescripcion() + ""
                });
            }
            tblGrado.setModel(modelo1);
        } catch (Exception e) {
            System.out.println("ERROR - CARGAR - GRADO - ACTUALIZARBUSQUEDACOMBO");
        }
    }
    
    void ActualizarBusquedaCaja(){
        try {
            Grado g = new Grado();
            Nivel n = new Nivel();
            n.setNombreLargo(String.valueOf(cboNivel.getSelectedItem()));
            g.setNivel(n);
            g.setnumeroGrado(txtbusqueda.getText());
            
            listaGrado = new GradoDAO().buscarGradoCaja(g);
            DefaultTableModel modelo1 = (DefaultTableModel)tblGrado.getModel();
            while (modelo1.getRowCount()>0) {                
                modelo1.removeRow(0);
            }
            for (Grado grado : listaGrado) {
                modelo1.addRow(new String[]{
                    //grado.getId() + "",
                    grado.getNivel().getNombreLargo()+ "",
                    grado.getnumeroGrado() + "",
                    grado.getSeccion().getDescripcion() + ""
                });
            }
        } catch (Exception e) {
            System.out.println("ERROR - CARGAR - GRADO - ACTUALIZARBUSQUEDACAJA");
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

        jPanel1 = new javax.swing.JPanel();
        txtbusqueda = new javax.swing.JTextField();
        cboNivel = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrado = new javax.swing.JTable();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda de Grado"));

        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyReleased(evt);
            }
        });

        cboNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNivelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboNivelMousePressed(evt);
            }
        });
        cboNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNivelActionPerformed(evt);
            }
        });

        tblGrado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGradoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrado);

        btnEnviar.setText("Seleccionar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEnviar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(90, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnEnviar)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 550, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        
        int index = tblGrado.getSelectedRow();
        if (index != -1) {
            Grado objGrado = listaGrado.get(index);
            lstGrado.add(objGrado);
            this.dispose();
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void tblGradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGradoMouseClicked
        // TODO add your handling code here:
        ActivaSeleccionar(true);
    }//GEN-LAST:event_tblGradoMouseClicked

    private void cboNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNivelMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cboNivelMouseClicked
 
    private void cboNivelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNivelMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cboNivelMousePressed

    private void cboNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNivelActionPerformed
        // TODO add your handling code here:
          ActualizarBusquedaCombo();
    }//GEN-LAST:event_cboNivelActionPerformed

    private void txtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyReleased
        // TODO add your handling code here:
        if (String.valueOf(txtbusqueda.getText())== "") {
            listarGrado();
        }else{
            ActualizarBusquedaCaja();
        }
    }//GEN-LAST:event_txtbusquedaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox cboNivel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGrado;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}

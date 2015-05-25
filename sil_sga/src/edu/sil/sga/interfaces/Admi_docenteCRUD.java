/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.interfaces;

import edu.sil.sga.dao.Conexion;
import edu.sil.sga.dao.DocenteDAO;
import edu.sil.sga.dao.EspecialidadDAO;
import edu.sil.sga.entidades.Docente;
import edu.sil.sga.entidades.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Cesar Lopez
 */
public class Admi_docenteCRUD extends javax.swing.JInternalFrame {

    /**
     * Creates new form Admi_docenteCRUD
     */
    public List<Docente> listaDocente;
    public List<Especialidad> listaEspecialidad;

    public Admi_docenteCRUD() {
        initComponents();

        setLocation(250, 100);
        setSize(850, 700); // X , Y
        CargarEspecialidad();
        activaBotones(true, false, false, false);
        ListarDocente();
        activaCajas(false);
        txtCodigo.setVisible(false);
    }

    //metodos a utulizar 
    void activaCajas(boolean a) {

        cboEspecialidad.setEnabled(a);
        txtnombre.setEnabled(a);
        txtapellidoPaterno.setEnabled(a);
        txtApellidoMaterno.setEnabled(a);
        txtDNI.setEnabled(a);
        txtTelefono.setEnabled(a);
        txtEmail.setEnabled(a);
        txtMovil.setEnabled(a);
    }

    void activaBotones(boolean a, boolean b, boolean c, boolean d) {

        btnNuevo.setEnabled(a);
        btnGuardar.setEnabled(b);
        btnActualizar.setEnabled(c);
        btnEliminar.setEnabled(d);

    }

    void CargarEspecialidad() {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            listaEspecialidad = new EspecialidadDAO().ListarEspecialidad();
            for (Especialidad objEspecialidad : listaEspecialidad) {
                model.addElement(objEspecialidad.getDescripcion());
            }
            cboEspecialidad.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de base de datos" + e.getMessage());
            System.out.println("Error: Carga Categoria");
        }
    }

    void ListarDocente() {
        try {
            DocenteDAO dao = new DocenteDAO();
            listaDocente = dao.ListarDocente();
            DefaultTableModel modelo1 = new DefaultTableModel();

            modelo1.addColumn("id");
            modelo1.addColumn("Nombre");
            modelo1.addColumn("Apellido Paterno");
            modelo1.addColumn("Apellido Materno");
            modelo1.addColumn("DNI");
            modelo1.addColumn("Telefono");
            modelo1.addColumn("Movil");
            modelo1.addColumn("Email");
            modelo1.addColumn("Especialidad");

            for (Docente objDocente : listaDocente) {
                modelo1.addRow(new String[]{
                    objDocente.getId() + "",
                    objDocente.getNombre() + "",
                    objDocente.getApellidopaterno() + "",
                    objDocente.getApellidomaterno() + "",
                    objDocente.getDni() + "",
                    objDocente.getTelefono() + "",
                    objDocente.getMovil() + "",
                    objDocente.getEmail() + "",
                    objDocente.getEspecialidad().getDescripcion()
                });
            }
            
            tablaListaDocente.setModel(modelo1);

        } catch (Exception e) {
            System.out.println("error --> interfaz --> docente --> listar");
        }

    }

    void actualizarBusqueda() {

        try {
            listaDocente = new DocenteDAO().buscarDocente(String.valueOf(cboSeleccion.getSelectedItem()), txtCampoBusqueda.getText());

            DefaultTableModel modelo1 = new DefaultTableModel();

            modelo1.addColumn("id");
            modelo1.addColumn("Nombre");
            modelo1.addColumn("Apellido Paterno");
            modelo1.addColumn("Apellido Materno");
            modelo1.addColumn("DNI");
            modelo1.addColumn("Telefono");
            modelo1.addColumn("Movil");
            modelo1.addColumn("Email");
            modelo1.addColumn("Especialidad");

            for (Docente objDocente : listaDocente) {
                modelo1.addRow(new String[]{
                    objDocente.getId() + "",
                    objDocente.getNombre() + "",
                    objDocente.getApellidopaterno() + "",
                    objDocente.getApellidomaterno() + "",
                    objDocente.getDni() + "",
                    objDocente.getTelefono() + "",
                    objDocente.getMovil() + "",
                    objDocente.getEmail() + "",
                    String.valueOf(objDocente.getEspecialidad().getDescripcion())
                });
            }

            tablaListaDocente.setModel(modelo1);

            //buscando como ocultar columnas
            tablaListaDocente.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablaListaDocente.getColumnModel().getColumn(1).setPreferredWidth(1500);
            tablaListaDocente.getColumnModel().getColumn(2).setPreferredWidth(1500);
            tablaListaDocente.getColumnModel().getColumn(3).setPreferredWidth(1500);
            tablaListaDocente.getColumnModel().getColumn(4).setPreferredWidth(1500);
        } catch (Exception e) {
            System.out.println("error --> interfaz --> docente --> actualizar busqueda");
        }

    }

    void limpiarCajas() {
        txtCodigo.setText("");
        txtnombre.setText("");
        txtapellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        txtMovil.setText("");
        txtEmail.setText("");
        txtFechaNacimiento.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        txtapellidoPaterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        cboEspecialidad = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaDocente = new javax.swing.JTable();
        txtCampoBusqueda = new javax.swing.JTextField();
        cboSeleccion = new javax.swing.JComboBox();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestionar Docente - IEP San Ignacio de Loyola");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Docente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel3.setText("* Apellido Paterno: ");

        jLabel8.setText("* Especialidad:");

        jLabel2.setText("* Nombres: ");

        jLabel4.setText("* Apellido Materno: ");

        jLabel5.setText("* DNI:");

        jLabel7.setText("Fecha Nacimiento");

        jLabel6.setText("Telefono :");

        jLabel11.setText("Email");

        jLabel12.setText("Movil: ");

        txtFechaNacimiento.setEnabled(false);

        cboEspecialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaNacimiento)
                            .addComponent(txtEmail)
                            .addComponent(txtMovil)
                            .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtapellidoPaterno, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Docente"));

        tablaListaDocente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tablaListaDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListaDocenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaListaDocente);

        txtCampoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCampoBusquedaKeyReleased(evt);
            }
        });

        cboSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "DNI" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCampoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(cboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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

        txtCodigo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(27, 27, 27)
                                .addComponent(btnGuardar)
                                .addGap(19, 19, 19)
                                .addComponent(btnActualizar)
                                .addGap(21, 21, 21)
                                .addComponent(btnEliminar)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar))))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        String nombre = txtnombre.getText();
        String apellidoPa = txtapellidoPaterno.getText();
        String apellidoMa = txtApellidoMaterno.getText();
        String dni = txtDNI.getText();
        String telefono = txtTelefono.getText();
        String movil = txtMovil.getText();
        String email = txtEmail.getText();

        if (nombre.equalsIgnoreCase("") || apellidoPa.equalsIgnoreCase("")
                && apellidoMa.equalsIgnoreCase("") || dni.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "debe ingresar los campos requeridos (*)");

        } else {

            try {
                Docente objDocente = new Docente();
                int posicionComboSeleccionado = cboEspecialidad.getSelectedIndex();
                Especialidad objEspecialidadSeleccionada = listaEspecialidad.get(posicionComboSeleccionado);
                objDocente.setEspecialidad(objEspecialidadSeleccionada);
                objDocente.setNombre(nombre);
                objDocente.setApellidopaterno(apellidoPa);
                objDocente.setApellidomaterno(apellidoMa);
                objDocente.setDni(dni);
                objDocente.setTelefono(telefono);
                objDocente.setMovil(movil);
                objDocente.setEmail(email);

                DocenteDAO dao = new DocenteDAO();
                if (dao.RegistrarDocente(objDocente)) {
                    JOptionPane.showMessageDialog(this, "Se registro correctamente al docente :) ");
                    ListarDocente();
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    activaCajas(false);
                    btnNuevo.setText("Nuevo");
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique los datos ingresados e intentelo nuevamente");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No pudimos agregar al nuevo docente :( " + e.getMessage());

            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        String id = txtCodigo.getText();
        String nombre = txtnombre.getText();
        String apellidoPa = txtapellidoPaterno.getText();
        String apellidoMa = txtApellidoMaterno.getText();
        String dni = txtDNI.getText();
        String telefono = txtTelefono.getText();
        String movil = txtMovil.getText();
        String email = txtEmail.getText();

        if (nombre.equalsIgnoreCase("") || apellidoPa.equalsIgnoreCase("") 
                || apellidoMa.equalsIgnoreCase("") || dni.equalsIgnoreCase("") || id.equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(this, "debe ingresar los campos requeridos (*) y debe existir el codigo");

        } else {

            try {

                Docente objDocente = new Docente();
                objDocente.setEspecialidad(listaEspecialidad.get(cboEspecialidad.getSelectedIndex()));
                objDocente.setId(Integer.parseInt(id));
                objDocente.setNombre(nombre);
                objDocente.setApellidopaterno(apellidoPa);
                objDocente.setApellidomaterno(apellidoMa);
                objDocente.setDni(dni);
                objDocente.setTelefono(telefono);
                objDocente.setMovil(movil);
                objDocente.setEmail(email);

                DocenteDAO dao = new DocenteDAO();
                if (dao.ActualizarDocente(objDocente)) {
                    JOptionPane.showMessageDialog(this, "Se Actualizo correctamente los datos del Docente ");
                    ListarDocente();
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    activaCajas(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique los datos ingresados e intentelo nuevamente");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No pudimos actualizar datos del docente :(" + e.getMessage());
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tablaListaDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListaDocenteMouseClicked
        // TODO add your handling code here:
        int fila = tablaListaDocente.getSelectedRow();
        String id = tablaListaDocente.getValueAt(fila, 0).toString();
        String nomb = tablaListaDocente.getValueAt(fila, 1).toString();
        String apePater = tablaListaDocente.getValueAt(fila, 2).toString();
        String apeMater = tablaListaDocente.getValueAt(fila, 3).toString();
        String dni = tablaListaDocente.getValueAt(fila, 4).toString();
        String telef = tablaListaDocente.getValueAt(fila, 5).toString();
        String movil = tablaListaDocente.getValueAt(fila, 6).toString();
        String email = tablaListaDocente.getValueAt(fila, 7).toString();
        String espec = tablaListaDocente.getValueAt(fila, 8).toString();

        txtCodigo.setText(id);
        txtnombre.setText(nomb);
        txtapellidoPaterno.setText(apePater);
        txtApellidoMaterno.setText(apeMater);
        txtDNI.setText(dni);
        txtTelefono.setText(telef);
        txtMovil.setText(movil);
        txtEmail.setText(email);
        cboEspecialidad.setSelectedItem(espec);

        btnNuevo.setText("Nuevo");
        activaBotones(true, false, true, true);
        activaCajas(true);
    }//GEN-LAST:event_tablaListaDocenteMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

        limpiarCajas();
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

       if (txtnombre.getText().equalsIgnoreCase("") || txtapellidoPaterno.getText().equalsIgnoreCase("") 
                || txtApellidoMaterno.getText().equalsIgnoreCase("") || txtDNI.getText().equalsIgnoreCase("") || txtCodigo.getText().equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(this, "no borre los campos requeridos porfavor (*)");

        } else {
            
            try {

                Docente objDocente = new Docente();
                DocenteDAO dao = new DocenteDAO();
                
                //objDocente.setId(Integer.parseInt(txtCodigo.getText()));
                
                //Docente objDocente = new Docente();
                objDocente.setEspecialidad(listaEspecialidad.get(cboEspecialidad.getSelectedIndex()));
                objDocente.setId(Integer.parseInt(txtCodigo.getText()));
                objDocente.setNombre(txtnombre.getText());
                objDocente.setApellidopaterno(txtapellidoPaterno.getText());
                objDocente.setApellidomaterno(txtApellidoMaterno.getText());
                objDocente.setDni(txtDNI.getText());
                objDocente.setTelefono(txtTelefono.getText());
                objDocente.setMovil(txtMovil.getText());
                objDocente.setEmail(txtEmail.getText());
                
                
                if (dao.EliminarDocente(objDocente)) {
                    JOptionPane.showMessageDialog(this, "Se elimino correctamente");
                    ListarDocente();
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    activaCajas(false);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar ");
                }

            } catch (Exception e) {
                System.out.println("error --> interfaz --> docente --> eliminar");
            }

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCampoBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoBusquedaKeyReleased
        // TODO add your handling code here:
        if (String.valueOf(cboSeleccion.getSelectedIndex()) == "") {
            ListarDocente();
        } else {
            actualizarBusqueda();
        }
    }//GEN-LAST:event_txtCampoBusquedaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboEspecialidad;
    private javax.swing.JComboBox cboSeleccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaListaDocente;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtCampoBusqueda;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtapellidoPaterno;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}

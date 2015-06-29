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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    Docente objDocenteSeleccionado;
    Especialidad especialidad;

    public Admi_docenteCRUD() {
        initComponents();

        setLocation(200, 20);

        CargarEspecialidad();
        activaBotones(true, false, false, false);
        ListarDocente();
        activaCajas(false);

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
        spnFechaNacimiento.setEnabled(a);
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

            //modelo1.addColumn("id");
            modelo1.addColumn("Nombre Completo");
            //modelo1.addColumn("Apellido Paterno");
            //modelo1.addColumn("Apellido Materno");
            modelo1.addColumn("DNI");
            //modelo1.addColumn("Telefono");
            //modelo1.addColumn("Movil");
            //modelo1.addColumn("Email");
            //modelo1.addColumn("Especialidad");

            for (Docente objDocente : listaDocente) {
                modelo1.addRow(new String[]{
                    //objDocente.getId() + "",
                    objDocente.getApellidopaterno() + " " + objDocente.getApellidomaterno() + ", " + objDocente.getNombre() + "",
                    objDocente.getDni() + ""
                    //objDocente.getEspecialidad().getDescripcion()
                //objDocente.getTelefono() + "",
                //objDocente.getMovil() + "",
                //objDocente.getEmail() + "",
                //objDocente.getEspecialidad().getDescripcion()
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

            DefaultTableModel modelo1 = (DefaultTableModel) tablaListaDocente.getModel();
            while (modelo1.getRowCount() > 0) {
                modelo1.removeRow(0);
            }
            for (Docente objDocente : listaDocente) {
                modelo1.addRow(new String[]{
                    objDocente.getNombre() + "",
                    objDocente.getApellidopaterno() + "",
                    objDocente.getApellidomaterno() + "",
                    objDocente.getDni() + ""
                });
            }

            tablaListaDocente.setModel(modelo1);

        } catch (Exception e) {
            System.out.println("error --> interfaz --> docente --> actualizar busqueda");
        }

    }

    void limpiarCajas() {

        txtnombre.setText("");
        txtapellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        txtMovil.setText("");
        txtEmail.setText("");
        //String fecha = txtFechaNacimiento.getText();
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
        cboEspecialidad = new javax.swing.JComboBox();
        spnFechaNacimiento = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaDocente = new javax.swing.JTable();
        txtCampoBusqueda = new javax.swing.JTextField();
        cboSeleccion = new javax.swing.JComboBox();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestionar Docente - IEP San Ignacio de Loyola");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Gestionar Docente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        jLabel3.setText("* Apellido Paterno: ");

        txtMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMovilKeyTyped(evt);
            }
        });

        txtapellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoPaternoKeyTyped(evt);
            }
        });

        jLabel8.setText("* Especialidad:");

        txtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyTyped(evt);
            }
        });

        jLabel2.setText("* Nombres: ");

        jLabel4.setText("* Apellido Materno: ");

        jLabel5.setText("* DNI:");

        jLabel7.setText("Fecha Nacimiento");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jLabel6.setText("Telefono :");

        jLabel11.setText("Email");

        jLabel12.setText("Movil: ");

        cboEspecialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        spnFechaNacimiento.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(spnFechaNacimiento)
                        .addComponent(txtEmail)
                        .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtapellidoPaterno)
                        .addComponent(txtnombre)
                        .addComponent(txtApellidoMaterno)
                        .addComponent(txtDNI)
                        .addComponent(cboEspecialidad, 0, 137, Short.MAX_VALUE)
                        .addComponent(txtTelefono)))
                .addGap(35, 35, 35))
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
                    .addComponent(jLabel7)
                    .addComponent(spnFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(21, Short.MAX_VALUE))
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCampoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(cboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
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

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGuardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnActualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel1)
                .addContainerGap(463, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        if (txtnombre.getText().equalsIgnoreCase("")
                || txtapellidoPaterno.getText().equalsIgnoreCase("")
                || txtApellidoMaterno.getText().equalsIgnoreCase("")
                || txtDNI.getText().equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(this, "Debe ingresar los campos requeridos (*)");

        } else {

            try {
                Docente objDocente = new Docente();
                DocenteDAO dao = new DocenteDAO();

                int posicionComboSeleccionado = cboEspecialidad.getSelectedIndex();
                Especialidad objEspecialidadSeleccionada = listaEspecialidad.get(posicionComboSeleccionado);

                objDocente.setEspecialidad(objEspecialidadSeleccionada);
                objDocente.setNombre(txtnombre.getText());
                objDocente.setApellidopaterno(txtapellidoPaterno.getText());
                objDocente.setApellidomaterno(txtApellidoMaterno.getText());
                objDocente.setDni(txtDNI.getText());
                objDocente.setTelefono(txtTelefono.getText());
                objDocente.setMovil(txtMovil.getText());
                objDocente.setEmail(txtEmail.getText());

                /*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 objDocente.setFechadenacimiento(sdf.parse(fecha));*/
                objDocente.setFechadenacimiento((Date) spnFechaNacimiento.getValue());
                //SwingX

                if (dao.RegistrarDocente(objDocente)) {
                    JOptionPane.showMessageDialog(this, "Se registro correctamente al docente :) ");
                    ListarDocente();
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    activaCajas(false);
                    btnNuevo.setText("Nuevo");
                } else {
                    JOptionPane.showMessageDialog(this, "No lo pudimos registrar por problemas internos :( ");
                }

            } catch (Exception e) {
                System.out.println(" ERROR --> INTERFAZ --> DOCENTE CRUD --> " + e.getMessage());

            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        if (txtnombre.getText().equalsIgnoreCase("")
                || txtapellidoPaterno.getText().equalsIgnoreCase("")
                || txtApellidoMaterno.getText().equalsIgnoreCase("")
                || txtDNI.getText().equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(this, "Debe ingresar los campos requeridos (*)");

        } else {

            try {
                DocenteDAO dao = new DocenteDAO();
                Docente objDocente = new Docente();

                objDocente.setEspecialidad(listaEspecialidad.get(cboEspecialidad.getSelectedIndex()));
                objDocente.setId(objDocenteSeleccionado.getId());
                objDocente.setNombre(txtnombre.getText());
                objDocente.setApellidopaterno(txtapellidoPaterno.getText());
                objDocente.setApellidomaterno(txtApellidoMaterno.getText());
                objDocente.setDni(txtDNI.getText());
                objDocente.setTelefono(txtTelefono.getText());
                objDocente.setMovil(txtMovil.getText());
                objDocente.setEmail(txtEmail.getText());

                if (dao.ActualizarDocente(objDocente)) {
                    JOptionPane.showMessageDialog(this, "Se Actualizo correctamente los datos del Docente ");
                    ListarDocente();
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    activaCajas(false);
                } else {
                    JOptionPane.showMessageDialog(this, "No lo pudimos actualizar por problemas internos :( ");
                }
            } catch (Exception e) {
                System.out.println(" ERROR --> Interfaz --> Docente --> Actualizar --> " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tablaListaDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListaDocenteMouseClicked
        // TODO add your handling code here:
        int fila = tablaListaDocente.getSelectedRow();
        if (fila != -1) {

            objDocenteSeleccionado = listaDocente.get(fila);
            especialidad = objDocenteSeleccionado.getEspecialidad();

            txtnombre.setText(objDocenteSeleccionado.getNombre());
            txtapellidoPaterno.setText(objDocenteSeleccionado.getApellidopaterno());
            txtApellidoMaterno.setText(objDocenteSeleccionado.getApellidomaterno());
            txtDNI.setText(objDocenteSeleccionado.getDni());
            txtTelefono.setText(objDocenteSeleccionado.getTelefono());
            txtEmail.setText(objDocenteSeleccionado.getEmail());
            txtMovil.setText(objDocenteSeleccionado.getMovil());

            cboEspecialidad.setSelectedItem(String.valueOf(objDocenteSeleccionado.getEspecialidad().getDescripcion()));

            btnNuevo.setText("Nuevo");
            activaBotones(true, false, true, true);
            activaCajas(true);
        }

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
                || txtApellidoMaterno.getText().equalsIgnoreCase("") || txtDNI.getText().equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(this, "no borre los campos requeridos porfavor (*)");

        } else {

            try {

                Docente objDocente = new Docente();
                DocenteDAO dao = new DocenteDAO();

                //objDocente.setId(Integer.parseInt(txtCodigo.getText()));
                //Docente objDocente = new Docente();
                objDocente.setId(objDocenteSeleccionado.getId());
                objDocente.setEspecialidad(listaEspecialidad.get(cboEspecialidad.getSelectedIndex()));

                objDocente.setNombre(txtnombre.getText());
                objDocente.setApellidopaterno(txtapellidoPaterno.getText());
                objDocente.setApellidomaterno(txtApellidoMaterno.getText());
                objDocente.setDni(txtDNI.getText());
                objDocente.setTelefono(txtTelefono.getText());
                objDocente.setMovil(txtMovil.getText());
                objDocente.setEmail(txtEmail.getText());

                if (dao.EliminarDocente(objDocente)) {
                    JOptionPane.showMessageDialog(this, "Se elimino correctamente al docente ^^ ");
                    ListarDocente();
                    limpiarCajas();
                    activaBotones(true, false, false, false);
                    activaCajas(false);
                } else {
                    JOptionPane.showMessageDialog(this, "No lo pudimos actualizar por problemas internos =(  ");
                }

            } catch (Exception e) {
                System.out.println(" ERROR --> Interfaz --> Docente --> Eliminar --> " + e.getMessage());
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

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }

        if (txtDNI.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtMovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovilKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }

        if (txtDNI.getText().length() == 8) {
            evt.consume();
        }

    }//GEN-LAST:event_txtMovilKeyTyped

    private void txtapellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoPaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidoPaternoKeyTyped

    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoMaternoKeyTyped


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
    private javax.swing.JSpinner spnFechaNacimiento;
    private javax.swing.JTable tablaListaDocente;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtCampoBusqueda;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtapellidoPaterno;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}

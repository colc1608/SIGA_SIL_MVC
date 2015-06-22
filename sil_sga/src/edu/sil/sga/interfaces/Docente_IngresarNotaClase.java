/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.interfaces;

import edu.sil.sga.dao.AlumnoDAO;
import edu.sil.sga.entidades.Alumno;
import edu.sil.sga.entidades.Clase;
import edu.sil.sga.entidades.Periodo;
import edu.sil.sga.entidades.TipoEvaluacion;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo Lopez
 */
public class Docente_IngresarNotaClase extends javax.swing.JInternalFrame {

    /**
     * Creates new form Docente_IngresarNotaClase
     */
    
    Clase clase = new Clase();
    Periodo periodo = new Periodo();
    TipoEvaluacion tipoEval = new TipoEvaluacion();
    public List<Alumno> listaDeAlumnos;
    
    
    
    public Docente_IngresarNotaClase(Clase objClase, TipoEvaluacion objTipoEval, Periodo objPeriodo) {
        initComponents();
        
        clase = objClase;
        periodo = objPeriodo;
        tipoEval = objTipoEval;
        
        lblCurso.setText(clase.getCursoGrado().getCurso().getNombreLargo());
        lblPeriodo.setText(periodo.getDescripcion());
        lblTipoEvaluacion.setText(tipoEval.getDescripcion());

        ListarALumno();

        
        
    }//fin del INIT COMPONENTS
    
    
    void ListarALumno() {
        try {
            AlumnoDAO dao = new AlumnoDAO();
            listaDeAlumnos = dao.ListadoAlumno();
            DefaultTableModel modelo1 = new DefaultTableModel();

            modelo1.addColumn("Nombre Completo");
            modelo1.addColumn("NOTA");

            for (Alumno obAlumno : listaDeAlumnos) {
                modelo1.addRow(new String[]{
                     obAlumno.getApellidopaterno()+" "+obAlumno.getApellidomaterno() +", "+obAlumno.getNombre(),
                    
                    });
            }
            tblAlumnoNota.setModel(modelo1);
        } catch (Exception e) {
            System.out.println("ERROR - INTERFAZ - ALUMNO - LISTAR");
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnoNota = new javax.swing.JTable();
        lblCurso = new javax.swing.JLabel();
        lblTipoEvaluacion = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Ingresar Notas");

        jButton1.setText("Guardar");

        tblAlumnoNota.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAlumnoNota);

        lblCurso.setText("Cu");

        lblTipoEvaluacion.setText("tipo eval");

        lblPeriodo.setText("periodo");

        jLabel2.setText("Curso:");

        jLabel3.setText("Tipo de Nota:");

        jLabel4.setText("Bimestre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCurso)
                            .addGap(62, 62, 62)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblTipoEvaluacion)
                            .addGap(67, 67, 67)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblPeriodo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addComponent(jLabel1))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCurso)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoEvaluacion)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblPeriodo)))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTipoEvaluacion;
    private javax.swing.JTable tblAlumnoNota;
    // End of variables declaration//GEN-END:variables
}

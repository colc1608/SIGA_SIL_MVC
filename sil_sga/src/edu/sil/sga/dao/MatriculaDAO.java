/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Clase;
import edu.sil.sga.entidades.DetalleMatricula;
import edu.sil.sga.entidades.Matricula;
import edu.sil.sga.entidades.Periodo;
import edu.sil.sga.entidades.TipoEvaluacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Lopez
 */
public class MatriculaDAO {

    public boolean RegistrarMatricula(Matricula matricula, List<Clase> ListaDeClases) {

        boolean retornar = false;
        int idMatricula = 0;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into matricula(id,idAlumno,idGrado,fecha, montoPension, observacion)"
                    + "values (sq_matricula.NEXTVAL,?,?,?,?,?)");

            pstm.setInt(1, matricula.getAlumno().getId());
            pstm.setInt(2, matricula.getGrado().getId());
            pstm.setDate(3, new Date(matricula.getFecha().getTime()));
            pstm.setDouble(4, matricula.getMonto());
            pstm.setString(5, matricula.getObservacion());
            pstm.execute();

            //SELECIONAR EL ULTIMO ID DE MATRICULA
            pstm = con.prepareStatement("select max(id) from matricula");

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                idMatricula = rs.getInt(1);
                //System.out.println("el valor del ultimo id Matricula es: " + idMatricula);
            }

            //ingreso Detalle Matricula
            pstm = con.prepareStatement("insert into DETALLEMATRICULA(id, IDMATRICULA, IDCLASE)"
                    + " values(SQ_DETALLEMATRICULA.nextval, ?, ?)");

            for (int i = 0; i < ListaDeClases.size(); i++) {

                pstm.setInt(1, idMatricula);
                pstm.setInt(2, ListaDeClases.get(i).getId());
                pstm.execute();
                //System.out.println("exito al ingresar el DETALLE VENTA");
            }
            //-----------------------------------------------------------------
            //-----------------------------------------------------------------
            //-----------------------------------------------------------------
            //-----------------------------------------------------------------
            //probando cosas nuevas para la NOTA =D
            List<Periodo> listaDePeriodos = new ArrayList<>();
            List<TipoEvaluacion> listaDeTipoEvaluacion = new ArrayList<>();

            listaDePeriodos = new PeriodoDAO().ListarPeriodo();
            listaDeTipoEvaluacion = new TipoEvaluacionDAO().ListarTipoEvaluacion();
            
            //System.out.println("antes de cambiar el PSTM ");
            
            pstm = con.prepareStatement(" insert into nota(id, IDALUMNO, IDCLASE, IDPERIODO, IDTIPOEVALUACION ) "
                    + " values(sq_nota.NEXTVAL, ? , ?, ?, ?) ");

            for (int i = 0; i < ListaDeClases.size(); i++) {
                for (int j = 0; j < listaDePeriodos.size(); j++) {
                    for (int k = 0; k < listaDeTipoEvaluacion.size(); k++) {
                        
                        System.out.println("el alumno es: "+matricula.getAlumno().getId());
                        System.out.println("la clase es: "+ListaDeClases.get(i).getId());
                        System.out.println("el periodo es: "+listaDePeriodos.get(j).getId());
                        System.out.println("el tipo nota es: "+listaDeTipoEvaluacion.get(k).getId());
                        
                        
                        pstm.setInt(1, matricula.getAlumno().getId());
                        pstm.setInt(2, ListaDeClases.get(i).getId());
                        pstm.setInt(3, listaDePeriodos.get(j).getId());
                        pstm.setInt(4, listaDeTipoEvaluacion.get(k).getId());
                        pstm.execute();
                        //System.out.println("exito al ingresar las TIPO EVALUACION");
                    }//System.out.println("FIIIIIIIN DEL TIPO EVALUACION");
                }//System.out.println("FIIIIIIIN DEL PERIODO");
            }
            //System.out.println("FIN DE LOS FOR ANINADOS PARA LA NOTA - CLASE");

            //-----------------------------------------------------------------
            //-----------------------------------------------------------------
            //-----------------------------------------------------------------
            //-----------------------------------------------------------------
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Matricula --> RegistrarMatricula " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    /*
     public boolean RegistrarDetalleMatricula(List<DetalleMatricula> listaDetalleMatricula) {
     boolean retornar = false;

     try {
     Connection con = Conexion.getConnection();

     PreparedStatement pstm = con.prepareStatement("insert into detalleMatricula(id, idMatricula, idClase) "
     + " values(sq_detalleMatricula.nextval, ?, ?) ");

     for (int i = 0; i < listaDetalleMatricula.size(); i++) {

     pstm.setInt(1, listaDetalleMatricula.get(i).getMatricula().getId());
     pstm.setInt(2, listaDetalleMatricula.get(i).getClase().getId());

     pstm.execute();

     }
     pstm.close();
     con.close();
     retornar = true;
     } catch (Exception e) {
     System.out.println(" ERROR --> DAO --> Matricula --> RegistrarDetalleMatricula() --> " + e.getMessage());
     e.printStackTrace();
     }
     return retornar;
     }*/
}

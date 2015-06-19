/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.DetalleMatricula;
import edu.sil.sga.entidades.Matricula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Cesar Lopez
 */
public class MatriculaDAO {

    public boolean RegistrarMatricula(Matricula matricula) {
        
        boolean retornar = false;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into matricula(id,idAlumno,idGrado,fecha, montoPension, observacion)"
                    + "values (sq_matricula.NEXTVAL,?,?,?,?,?)");

            pstm.setInt(1, matricula.getAlumno().getId());
            pstm.setInt(2, matricula.getGrado().getId());
            pstm.setDate(6, new Date(matricula.getFecha().getTime()));
            pstm.setDouble(2, matricula.getMonto());
            pstm.setString(3, matricula.getObservacion());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Matricula --> registrar () " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
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
    }
    
    
}

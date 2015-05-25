/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Cesar Lopez
 */
public class GradoDAO {
/*hola mundo..!!*/
    public boolean RegistrarGrado(Grado grado) throws Exception {
        boolean retornar = false;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into grado(id,idNivelEducacion,idSeccion,descripcion)"
                    + "values (sq_docente.NEXTVAL,?,?,?)");

            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getDescripcion());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    
    public boolean ActualizarGrado(Grado grado){
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE grado SET idNivelEducacion = ? ,"
                    + "idSeccion = ?, descripcion = ?  WHERE id = ? ");
            
            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getDescripcion());
            pstm.setInt(4, grado.getId());
            
            
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    
    
}

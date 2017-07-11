/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.siga.bean.TipoEvaluacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Lopez
 */
public class TipoEvaluacionDAO {

    
    
    public boolean RegistrarTipoEvaluacion(TipoEvaluacion tipoEval) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO TipoEvaluacion (id,descripcion,peso, observacion)"
                    + " values (sq_tipoevaluacion.NEXTVAL, ?, ? ,?) ");
            pstm.setString(1, tipoEval.getDescripcion());
            System.out.println("el valor del peso en el DAO para insertar es : "+tipoEval.getPeso());
            pstm.setDouble(2, tipoEval.getPeso());
            pstm.setString(3, tipoEval.getObservacion());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> TipoEvaluacion --> registrar " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean ActualizarTipoEvaluacion(TipoEvaluacion tipoEval) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE TipoEvaluacion "
                    + " SET descripcion = ? , peso = ?, observacion = ? WHERE id = ? ");
            pstm.setString(1, tipoEval.getDescripcion());
            pstm.setDouble(2, tipoEval.getPeso());
            pstm.setString(3, tipoEval.getObservacion());
            pstm.setInt(4, tipoEval.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> TipoEvaluacion --> actualizar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    
    public boolean EliminarTipoEvaluacion(TipoEvaluacion tipoEval) throws SQLException {
        boolean retornar = false;
        try {
            // update usuario set usuario='3001', clave='rojo2' where id=3;
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE TipoEvaluacion "
                    + " SET descripcion = ? , peso = ?, observacion = ?, estado = ?  WHERE id = ? ");
            pstm.setString(1, tipoEval.getDescripcion());
            pstm.setDouble(2, tipoEval.getPeso());
            pstm.setString(3, tipoEval.getObservacion());
            pstm.setString(4, "0");
            pstm.setInt(5, tipoEval.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> TipoEvaluacion --> eliminar  "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public List<TipoEvaluacion> ListarTipoEvaluacion() throws SQLException{
        List<TipoEvaluacion> listarTipoEval = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    " select id, descripcion, peso, observacion from TipoEvaluacion where estado = 1 order by id ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                TipoEvaluacion tipoEval = new TipoEvaluacion();
                tipoEval.setId(rst.getInt("id"));
                tipoEval.setDescripcion(rst.getString("descripcion"));
                tipoEval.setPeso(rst.getDouble("peso"));
                tipoEval.setObservacion(rst.getString("observacion"));

                listarTipoEval.add(tipoEval);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> TipoEvaluacion --> listar  "+e.getMessage());
            e.printStackTrace();
        }
        return listarTipoEval;
    }
}

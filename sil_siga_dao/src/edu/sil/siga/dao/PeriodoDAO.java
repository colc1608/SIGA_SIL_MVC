/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.siga.dao;

import edu.sil.siga.bean.Periodo;
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
public class PeriodoDAO {

    public boolean RegistrarPeriodo(Periodo periodo) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO Periodo (id,descripcion,observacion)"
                    + " values (sq_periodo.NEXTVAL, ?, ? ) ");
            pstm.setString(1, periodo.getDescripcion());
            pstm.setString(2, periodo.getObservacion());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Periodo --> registrar " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    
    
    public boolean ActualizarPeriodo(Periodo periodo) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Periodo "
                    + " SET descripcion = ? , observacion = ? WHERE id = ? ");
            pstm.setString(1, periodo.getDescripcion());
            pstm.setString(2, periodo.getObservacion());
            pstm.setInt(3, periodo.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Periodo --> actualizar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarPeriodo(Periodo periodo) throws SQLException {
        boolean retornar = false;
        try {
            // update usuario set usuario='3001', clave='rojo2' where id=3;
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Periodo "
                    + " SET descripcion = ? , observacion = ?, estado = ? WHERE id = ? ");
            pstm.setString(1, periodo.getDescripcion());
            pstm.setString(2, periodo.getObservacion());
            pstm.setString(3, "0");
            pstm.setInt(4, periodo.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Periodo --> eliminar  "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public List<Periodo> ListarPeriodo() throws SQLException{
        List<Periodo> listarPeriodo = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    " select id, descripcion, observacion from Periodo where estado = 1 order by id ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Periodo periodo = new Periodo();
                periodo.setId(rst.getInt("id"));
                periodo.setDescripcion(rst.getString("descripcion"));
                periodo.setObservacion(rst.getString("observacion"));

                listarPeriodo.add(periodo);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Periodo --> listar  "+e.getMessage());
            e.printStackTrace();
        }
        return listarPeriodo;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.siga.bean.Apoderado;
import edu.sil.siga.bean.Parentesco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul
 */
public class ApoderadoDAO {
    public boolean RegistarApoderado(Apoderado obApoderado)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO APODERADO(ID,NOMBRE,APELLIDOPATERNO,"
                    + "APELLIDOMATERNO,DNI,TELEFONO,MOVIL,FECHANACIMIENTO,EMAIL) \n" +
                      "VALUES(SQ_APODERADO.NEXTVAL,?,?,?,?,?,?,?,?)");
            pstm.setString(1, obApoderado.getNombre());
            pstm.setString(2, obApoderado.getApellidoPaterno());
            pstm.setString(3, obApoderado.getApellidoMaterno());
            pstm.setString(4, obApoderado.getDni());
            pstm.setString(5, obApoderado.getTelefono());
            pstm.setString(6, obApoderado.getMovil());
            pstm.setDate(7, new Date(obApoderado.getFechanacimiento().getTime()));
            pstm.setString(8, obApoderado.getEmail());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - APODERADO - DAO - REGISTRAR APODERADO" + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean ActualizarApoderado(Apoderado obApoderado)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE APODERADO SET NOMBRE = ?,APELLIDOPATERNO = ?,"
                    + "APELLIDOMATERNO = ?,DNI = ?,TELEFONO = ?,MOVIL = ?,FECHANACIMIENTO = ?,EMAIL =? \n" +
                      "WHERE ID = ?");
            pstm.setString(1, obApoderado.getNombre());
            pstm.setString(2, obApoderado.getApellidoPaterno());
            pstm.setString(3, obApoderado.getApellidoMaterno());
            pstm.setString(4, obApoderado.getDni());
            pstm.setString(5, obApoderado.getTelefono());
            pstm.setString(6, obApoderado.getMovil());
            pstm.setDate(7, new Date(obApoderado.getFechanacimiento().getTime()));
            pstm.setString(8, obApoderado.getEmail());
            pstm.setInt(9, obApoderado.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - APODERADO - DAO - ACTUALIZAR APODERADO" + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarApoderado(Apoderado obApoderado)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE APODERADO SET NOMBRE = ?,APELLIDOPATERNO = ?,APELLIDOMATERNO = ?,"
                    + "DNI = ?,TELEFONO = ?,MOVIL = ?,FECHANACIMIENTO = ?,EMAIL =?,ESTADO = ? \n" +
                      "WHERE ID = ?");
            pstm.setString(1, obApoderado.getNombre());
            pstm.setString(2, obApoderado.getApellidoPaterno());
            pstm.setString(3, obApoderado.getApellidoMaterno());
            pstm.setString(4, obApoderado.getDni());
            pstm.setString(5, obApoderado.getTelefono());
            pstm.setString(6, obApoderado.getMovil());
            pstm.setDate(7, new Date(obApoderado.getFechanacimiento().getTime()));
            pstm.setString(8, obApoderado.getEmail());
            pstm.setString(9, "0");
            pstm.setInt(10, obApoderado.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - APODERADO - DAO - ELIMINAR APODERADO" + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    
}

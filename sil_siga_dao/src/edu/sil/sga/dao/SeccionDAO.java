/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.siga.bean.Seccion;
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
public class SeccionDAO {

    public boolean RegistrarSeccion(Seccion seccion) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO seccion (id,descripcion)"
                    + " values (sq_seccion.NEXTVAL, ? ) ");
            pstm.setString(1, seccion.getDescripcion());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Seccion --> registrar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean ActualizarSeccion(Seccion seccion) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE seccion "
                    + " SET descripcion = ? WHERE id = ? ");
            pstm.setString(1, seccion.getDescripcion());
            pstm.setInt(2, seccion.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Seccion --> actualizar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarSeccion(Seccion seccion) throws SQLException {
        boolean retornar = false;
        try {
            // update usuario set usuario='3001', clave='rojo2' where id=3;
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE seccion "
                    + " SET descripcion = ? , estado = ? WHERE id = ? ");
            pstm.setString(1, seccion.getDescripcion());
            pstm.setString(2, "0");
            pstm.setInt(3, seccion.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Seccion --> eliminar  "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public List<Seccion> ListarSeccion()throws SQLException {
        List<Seccion> listarSeccion = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    " select id, descripcion from seccion where estado = 1 ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Seccion seccion = new Seccion();
                seccion.setId(rst.getInt("id"));
                seccion.setDescripcion(rst.getString("descripcion"));
                listarSeccion.add(seccion);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Seccion --> listar  "+e.getMessage());
            e.printStackTrace();
        }
        return listarSeccion;
    }

}

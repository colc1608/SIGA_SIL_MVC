/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.siga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import edu.sil.siga.bean.Especialidad;
import java.sql.SQLException;
/**
 *
 * @author Cesar Lopez
 */
public class EspecialidadDAO {
    
    public boolean RegistrarEspecialidad(Especialidad objEspecialidad)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO Especialidad(id,descripcion) "
                    + "values (sq_especialidad.NEXTVAL,?)");
            pstm.setString(1, objEspecialidad.getDescripcion());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("error --> DAO --> especialidad  --> registrar"+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean ActualizarEspecialidad(Especialidad objEspecialidad)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Especialidad SET descripcion = ? WHERE id = ?");
            pstm.setString(1, objEspecialidad.getDescripcion());
            pstm.setInt(2, objEspecialidad.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("error --> DAO --> especialidad  --> actualizar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean EliminarEspecialidad(Especialidad objEspecialidad)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Especialidad SET descripcion = ?, estado = ?"
                    + " WHERE id = ? ");
            pstm.setString(1, objEspecialidad.getDescripcion());
            pstm.setString(2, "0");
            pstm.setInt(3, objEspecialidad.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("error --> DAO --> especialidad  --> eliminar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public List<Especialidad>ListarEspecialidad()throws SQLException{
        List<Especialidad> listarEspecialidad = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT id, descripcion FROM Especialidad where estado = 1 order by descripcion asc");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setId(rst.getInt("id"));
                especialidad.setDescripcion(rst.getString("descripcion"));
                listarEspecialidad.add(especialidad);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> especialidad  --> listar "+e.getMessage());
            e.printStackTrace();
        }
        return listarEspecialidad;
    }
    
    /*
    public ResultSet ObtenerCodigoEspecialidad(String desc)throws SQLException{
        ResultSet rst = null;
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select id from Especialidad  where descripcion = '"+desc+"'");
            rst = pstm.executeQuery();
        }catch(Exception e){
            System.out.println("error en OBTENER codigo ID de especialidad");
            e.printStackTrace();
        }
        return rst;
    }
    
    
    public Especialidad BuscarEspecialidad(int id)throws SQLException{
        Especialidad objEspecialidad = null;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM Especialidad WHERE id=?");
            pstm.setInt(1, id);
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {                
                objEspecialidad = new Especialidad();;
                objEspecialidad.setId(rst.getInt("id"));
                objEspecialidad.setDescripcion("descripcion");
            }
        } catch (Exception e) {
            System.out.println("error en buscar especialidad");
            e.printStackTrace();
        }
        return objEspecialidad;
    }
    */
}

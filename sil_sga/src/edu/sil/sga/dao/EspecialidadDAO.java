/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import edu.sil.sga.entidades.Especialidad;
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
            PreparedStatement pstm = con.prepareStatement("INSERT INTO Especialidad(id,descripcion)values"+"(sq_especialidad.NEXTVAL,?)");
            pstm.setString(1, objEspecialidad.getDescripcion());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("error --> DAO registrar especialidad");
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean ActualizarEspecialidad(Especialidad objEspecialidad)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Especialidad SET descripcion = ? " + "WHERE id=?");
            pstm.setString(1, objEspecialidad.getDescripcion());
            pstm.setInt(2, objEspecialidad.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("error --> DAO actualizar especialidad");
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean EliminarEspecialidad(Especialidad objEspecialidad)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("DELETE FROM Especialidad WHERE id=?");
            pstm.setInt(1, objEspecialidad.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("error --> DAO eliminar especialidad ");
            e.printStackTrace();
        }
        return retornar;
    }
    
    public List<Especialidad>ListarEspecialidad(){
        List<Especialidad> listarEspecialidad = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM Especialidad order by descripcion asc");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                listarEspecialidad.add(new Especialidad(rst.getInt("id"),rst.getString("descripcion")));
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("error --> DAO listar especialidad ");
            e.printStackTrace();
        }
        return listarEspecialidad;
    }
    
    
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
    
}

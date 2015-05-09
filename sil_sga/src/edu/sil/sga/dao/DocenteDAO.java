/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Docente;
import edu.sil.sga.entidades.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Lopez
 */
public class DocenteDAO {
    
    public boolean RegistrarDocente(Docente objDocente){
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO Docente(id,nombre,apellidopaterno,apellidomaterno,dni,telefono,movil,email,idEspecialidad)values"+"(sq_docente.NEXTVAL,?,?,?,?,?,?,?,?)");
            pstm.setString(1, objDocente.getNombre());
            pstm.setString(2, objDocente.getApellidopaterno());
            pstm.setString(3, objDocente.getApellidomaterno());
            pstm.setString(4, objDocente.getDni());
            pstm.setString(5, objDocente.getTelefono());
            pstm.setString(6, objDocente.getMovil());
            pstm.setString(7, objDocente.getEmail());
            pstm.setInt(8, objDocente.getEspecialidad().getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean ActualizarDocente(Docente objDocente){
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Docente SET apellidopaterno=?,apellidomaterno=?,dni=?,telefono=?,movil=?,email=?,idespecialidad=?" + "WHERE nombre=?");
            pstm.setString(1, objDocente.getApellidopaterno());
            pstm.setString(2, objDocente.getApellidomaterno());
            pstm.setString(3, objDocente.getDni());
            pstm.setString(4, objDocente.getTelefono());
            pstm.setString(5, objDocente.getMovil());
            pstm.setString(6, objDocente.getEmail());
            pstm.setInt(7, objDocente.getEspecialidad().getId());
            pstm.setString(8, objDocente.getNombre());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean EliminarDocente(Docente objDocente){
        boolean retornar=false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("DELETE FROM Docente WHERE nombre=?");
            /*se pone dependiendo el primer elemento de la tabla que vas a llenar*/
            pstm.setString(1, objDocente.getNombre());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    public List<Docente>ListarDocente(){
        List<Docente> listarDocente = new ArrayList<>();
        try {
            Connection con  = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT d.nombre,d.apellidopaterno,d.apellidomaterno,d.dni,d.telefono,d.movil,d.email,e.descripcion FROM docente d INNER JOIN Especialidad e ON (d.IDESPECIALIDAD = e.ID)");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {                
                Docente d = new Docente();
                d.setNombre(rst.getString("nombre"));
                d.setApellidopaterno(rst.getString("apellidopaterno"));
                d.setApellidomaterno(rst.getString("apellidomaterno"));
                d.setDni(rst.getString("dni"));
                d.setTelefono(rst.getString("telefono"));
                d.setMovil(rst.getString("movil"));
                d.setEmail(rst.getString("email"));
                Especialidad e = new Especialidad();
                e.setDescripcion(rst.getString("descripcion"));
                d.setEspecialidad(e);
                listarDocente.add(d);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listarDocente;
    }
    
    public Docente buscarDocente(String nombre){
        Docente objDocente = null;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM docente WHERE nombre=?");
            pstm.setString(1, nombre);
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {                
                objDocente = new Docente();
                objDocente.setNombre(rst.getString("nombre"));
                objDocente.setApellidopaterno(rst.getString("apellidopaterno"));
                objDocente.setApellidomaterno(rst.getString("apellidomaterno"));
                objDocente.setDni(rst.getString("dnio"));
                objDocente.setTelefono(rst.getString("telefono"));
                objDocente.setMovil(rst.getString("movil"));
                objDocente.setEmail(rst.getString("email"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objDocente;
    }
    
}

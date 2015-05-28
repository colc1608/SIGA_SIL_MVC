/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sil.sga.dao;

import edu.sil.sga.entidades.Alumno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
* @author Cesar Lopez
 */
public class AlumnoDAO {
public boolean RegistrarAlumno(Alumno objAlumno)throws  SQLException{
        /*
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
        */
        
        
        //----------------------------------------------------------------------
        //METODO CON UN PROCEDIMIENTO ALMACENADO
        Connection con=null;
        CallableStatement cstm=null;
        try {
            
            con=Conexion.getConnection();
            String sql="CALL sp_addAlumno(?,?,?,?,?,?,?,?)";
            cstm=con.prepareCall(sql);
            cstm.setInt(1,objAlumno.getGrado().getId());
            cstm.setString(2,objAlumno.getNombre());
            cstm.setString(3,objAlumno.getApellidopaterno());
            cstm.setString(4,objAlumno.getApellidomaterno());
            cstm.setString(5, objAlumno.getDni());
            cstm.setString(6, objAlumno.getTelefono());
            cstm.setString(7, objAlumno.getMovil());
            cstm.setString(8, objAlumno.getEmail());
            
            
            cstm.execute();
            
            return true;
        } catch (Exception e) {
            System.out.println(" ERROR --> DAO --> Alumno --> registrar  "+e.getMessage());
            e.printStackTrace();
            return false;
        }finally{
            cstm.close();
            con.close();
        }
    }
}

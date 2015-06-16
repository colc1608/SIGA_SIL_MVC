/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sil.sga.dao;

import edu.sil.sga.entidades.Alumno;
import edu.sil.sga.entidades.Grado;
import edu.sil.sga.entidades.Nivel;
import edu.sil.sga.entidades.Seccion;
import java.sql.CallableStatement;
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
            cstm.setInt(1, objAlumno.getGrado().getId());
            cstm.setString(2, objAlumno.getNombre());
            cstm.setString(3, objAlumno.getApellidopaterno());
            cstm.setString(4, objAlumno.getApellidomaterno());
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

public boolean ActualizarAlumno(Alumno objAlumno)throws SQLException{
    boolean retornar = false;
    try {
        Connection con = Conexion.getConnection();
        PreparedStatement pstm = con.prepareStatement("UPDATE alumno SET IDGRADO=?,NOMBRE=?,APELLIDOPATERNO=?,APELLIDOMATERNO=?,DNI=?,TELEFONO=?,"
                + "MOVIL=?,EMAIL=?"+" WHERE ID=?");
        pstm.setInt(1, objAlumno.getGrado().getId());
        pstm.setString(2, objAlumno.getNombre());
        pstm.setString(3, objAlumno.getApellidopaterno());
        pstm.setString(4, objAlumno.getApellidomaterno());
        pstm.setString(5, objAlumno.getDni());
        pstm.setString(6, objAlumno.getTelefono());
        pstm.setString(7, objAlumno.getMovil());
        pstm.setString(8, objAlumno.getEmail());
        pstm.setInt(9, objAlumno.getId());
        pstm.execute();
        pstm.close();
        con.close();
        retornar = true;
    } catch (Exception e) {
        System.out.println("ERROR - DAO - ALUMNO - ACTUALIZAR");
        e.printStackTrace();
    }
    return retornar;
}

public boolean EliminarAlumno(Alumno obAlumno)throws SQLException{
    boolean retornar = false;
    try {
        Connection con = Conexion.getConnection();
        PreparedStatement pstm = con.prepareStatement("UPDATE alumno SET NOMBRE=?,APELLIDOPATERNO=?,APELLIDOMATERNO=?,DNI=?,TELEFONO=?,"
                + "MOVIL=?,EMAIL=?,ESTADO=? WHERE ID=?");
        pstm.setString(1, obAlumno.getNombre());
        pstm.setString(2, obAlumno.getApellidopaterno());
        pstm.setString(3, obAlumno.getApellidomaterno());
        pstm.setString(4, obAlumno.getDni());
        pstm.setString(5, obAlumno.getTelefono());
        pstm.setString(6, obAlumno.getMovil());
        pstm.setString(7, obAlumno.getEmail());
        pstm.setString(8, "0");
        pstm.setInt(9, obAlumno.getId());
        pstm.execute();
        pstm.close();
        con.close();
        retornar = true;
    } catch (Exception e) {
        System.out.println("ERROR - ALUMNO - DAO - ELIMINAR");
    }
    return retornar;
}

public List<Alumno> ListadoAlumno()throws SQLException{
    List<Alumno> listarAlumno = new ArrayList<>();
    try {
        Connection con = Conexion.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT A.ID,A.NOMBRE,A.APELLIDOPATERNO,A.APELLIDOMATERNO,A.DNI,A.TELEFONO,A.MOVIL,A.EMAIL,G.ID,G.numeroGrado,S.DESCRIPCION as Seccion,N.NOMBRECORTO \n" +
                    "FROM ALUMNO A,GRADO G,SECCION S,NIVELEDUCACION N\n" +
                    "WHERE A.IDGRADO = G.ID AND G.IDSECCION=S.ID AND G.IDNIVELEDUCACION=N.ID AND A.ESTADO=1 ORDER BY A.ID ASC");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {            
            Alumno a = new Alumno();
            a.setId(rst.getInt("ID"));
            a.setNombre(rst.getString("NOMBRE"));
            a.setApellidopaterno(rst.getString("APELLIDOPATERNO"));
            a.setApellidomaterno(rst.getString("APELLIDOMATERNO"));
            a.setDni(rst.getString("DNI"));
            a.setTelefono(rst.getString("TELEFONO"));
            a.setMovil(rst.getString("MOVIL"));
            a.setEmail(rst.getString("EMAIL"));
            Grado g = new Grado();
            g.setId(rst.getInt("ID"));
            g.setnumeroGrado(rst.getString("numeroGrado"));
            Seccion s = new Seccion();
            s.setDescripcion(rst.getString("Seccion"));
            g.setSeccion(s);
            Nivel n = new Nivel();
            n.setNombreCorto(rst.getString("NOMBRECORTO"));
            g.setNivel(n);
            a.setGrado(g);
            listarAlumno.add(a);
        }
        pstm.close();
        con.close();
    } catch (Exception e) {
        System.out.println("ERROR - DAO - ALUMNO - LISTAR");
    }
    return listarAlumno;
}

public List<Alumno> BuscarAlumno(String tipo,String cadena)throws SQLException{
    List<Alumno> listarAlumno = new ArrayList<>();
    try {
        Connection con = Conexion.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT A.ID,A.NOMBRE,A.APELLIDOPATERNO,A.APELLIDOMATERNO,A.DNI,A.TELEFONO,A.MOVIL,A.EMAIL,G.numeroGrado,S.DESCRIPCION as Seccion,N.NOMBRECORTO \n" +
                    "FROM ALUMNO A,GRADO G,SECCION S,NIVELEDUCACION N\n" +
                    "WHERE A.IDGRADO = G.ID AND G.IDSECCION=S.ID AND G.IDNIVELEDUCACION=N.ID AND A.ESTADO=1 AND A."+tipo+" LIKE '%"+cadena+"%' ORDER BY A.ID ASC");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {            
            Alumno a = new Alumno();
            a.setId(rst.getInt("ID"));
            a.setNombre(rst.getString("NOMBRE"));
            a.setApellidopaterno(rst.getString("APELLIDOPATERNO"));
            a.setApellidomaterno(rst.getString("APELLIDOMATERNO"));
            a.setDni(rst.getString("DNI"));
            a.setTelefono(rst.getString("TELEFONO"));
            a.setMovil(rst.getString("MOVIL"));
            a.setEmail(rst.getString("EMAIL"));
            Grado g = new Grado();
            g.setnumeroGrado(rst.getString("numeroGrado"));
            Seccion s = new Seccion();
            s.setDescripcion(rst.getString("Seccion"));
            g.setSeccion(s);
            Nivel n = new Nivel();
            n.setNombreCorto(rst.getString("NOMBRECORTO"));
            g.setNivel(n);
            a.setGrado(g);
            listarAlumno.add(a);
        }
        pstm.close();
        con.close();
    } catch (Exception e) {
        System.out.println("ERROR --> ALUMNO --> DAO --> BUSCAR"+e.getMessage());
    }
    return listarAlumno;
}
}

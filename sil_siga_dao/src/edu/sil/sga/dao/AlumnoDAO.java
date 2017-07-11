/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.siga.bean.Alumno;
import edu.sil.siga.bean.Usuario;
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

    public boolean RegistrarAlumno(Alumno objAlumno) throws SQLException {
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
        Connection con = null;
        CallableStatement cstm = null;
        try {

            con = Conexion.getConnection();
            String sql = "CALL sp_addAlumno(?,?,?,?,?,?,?,?)";
            cstm = con.prepareCall(sql);

            cstm.setString(1, objAlumno.getNombre());
            cstm.setString(2, objAlumno.getApellidopaterno());
            cstm.setString(3, objAlumno.getApellidomaterno());
            cstm.setString(4, objAlumno.getDni());
            cstm.setString(5, objAlumno.getTelefono());
            cstm.setString(6, objAlumno.getMovil());
            cstm.setString(7, objAlumno.getEmail());
            cstm.setDate(8, new java.sql.Date(objAlumno.getFechaNacimiento().getTime()));

            cstm.execute();

            return true;
        } catch (Exception e) {
            System.out.println(" ERROR --> DAO --> Alumno --> registrar  " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            cstm.close();
            con.close();
        }
    }

    public boolean ActualizarAlumno(Alumno objAlumno) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE alumno SET NOMBRE=?,APELLIDOPATERNO=?,"
                    + "APELLIDOMATERNO=?, DNI=?, TELEFONO=?, MOVIL=?, EMAIL=?, FECHADENACIMIENTO=? "
                    + " WHERE ID=?");

            pstm.setString(1, objAlumno.getNombre());
            pstm.setString(2, objAlumno.getApellidopaterno());
            pstm.setString(3, objAlumno.getApellidomaterno());
            pstm.setString(4, objAlumno.getDni());
            pstm.setString(5, objAlumno.getTelefono());
            pstm.setString(6, objAlumno.getMovil());
            pstm.setString(7, objAlumno.getEmail());
            pstm.setDate(8, new java.sql.Date(objAlumno.getFechaNacimiento().getTime()));
            pstm.setInt(9, objAlumno.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> ALUMNO --> ACTUALIZAR " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarAlumno(Alumno obAlumno) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE alumno SET NOMBRE=?,APELLIDOPATERNO=?,APELLIDOMATERNO=?,DNI=?,TELEFONO=?,"
                    + " MOVIL=?, EMAIL=?, FECHADENACIMIENTO=?, ESTADO=? WHERE ID=?");
            pstm.setString(1, obAlumno.getNombre());
            pstm.setString(2, obAlumno.getApellidopaterno());
            pstm.setString(3, obAlumno.getApellidomaterno());
            pstm.setString(4, obAlumno.getDni());
            pstm.setString(5, obAlumno.getTelefono());
            pstm.setString(6, obAlumno.getMovil());
            pstm.setString(7, obAlumno.getEmail());
            pstm.setDate(8, new java.sql.Date(obAlumno.getFechaNacimiento().getTime()));
            pstm.setString(9, "0");
            pstm.setInt(10, obAlumno.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR --> ALUMNO --> DAO --> ELIMINAR"+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public List<Alumno> ListadoAlumno() throws SQLException {
        List<Alumno> listarAlumno = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT A.ID,A.NOMBRE,A.APELLIDOPATERNO,A.APELLIDOMATERNO,A.DNI,"
                    + "A.TELEFONO,A.MOVIL,A.EMAIL, A.FECHADENACIMIENTO \n"
                    + " FROM ALUMNO A where a.estado = 1 \n"
                    + "ORDER BY A.ID ASC");

            ResultSet rst = pstm.executeQuery();

            while (rst.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rst.getInt("ID"));
                alumno.setNombre(rst.getString("NOMBRE"));
                alumno.setApellidopaterno(rst.getString("APELLIDOPATERNO"));
                alumno.setApellidomaterno(rst.getString("APELLIDOMATERNO"));
                alumno.setDni(rst.getString("DNI"));
                alumno.setTelefono(rst.getString("TELEFONO"));
                alumno.setMovil(rst.getString("MOVIL"));
                alumno.setEmail(rst.getString("EMAIL"));
                alumno.setFechaNacimiento(rst.getDate("FECHADENACIMIENTO"));

                listarAlumno.add(alumno);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> ALUMNO --> LISTAR " + e.getMessage());
            e.printStackTrace();
        }
        return listarAlumno;
    }

    public List<Alumno> BuscarAlumno(String tipo, String cadena) throws SQLException {
        List<Alumno> listarAlumno = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT A.ID,A.NOMBRE,A.APELLIDOPATERNO,A.APELLIDOMATERNO,A.DNI,A.TELEFONO,A.MOVIL,A.EMAIL \n"
                    + "FROM ALUMNO A \n"
                    + "WHERE  A.ESTADO=1 AND A." + tipo + " LIKE '%" + cadena + "%' ORDER BY A.ID ASC");
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

                listarAlumno.add(a);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR --> ALUMNO --> DAO --> BUSCAR Alumno " + e.getMessage());
        }
        return listarAlumno;
    }
    
    
    public Alumno devolverAlumno(Usuario usuario) throws SQLException {
        Alumno alumno = new Alumno();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select a.ID, a.NOMBRE, a.APELLIDOPATERNO, a.APELLIDOMATERNO, a.DNI, "
                    + "  a.MOVIL, a.TELEFONO, a.EMAIL\n" +
"                     from alumno a, usuario u where\n" +
"                     u.ID = a.IDUSUARIO and\n" +
"                     u.id = ? ");
            
            pstm.setInt(1, usuario.getId());
            
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                alumno.setId(rst.getInt("id"));
                alumno.setNombre(rst.getString("nombre"));
                alumno.setApellidopaterno(rst.getString("APELLIDOPATERNO"));
                alumno.setApellidomaterno(rst.getString("APELLIDOMATERNO"));
                alumno.setDni(rst.getString("DNI"));
                alumno.setMovil(rst.getString("movil"));
                alumno.setTelefono(rst.getString("telefono"));
                alumno.setEmail(rst.getString("email"));
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" ERROR --> DAO --> devolver Alumno "+e.getMessage());
            e.printStackTrace();
        }
        return alumno;
    }
    
    
}

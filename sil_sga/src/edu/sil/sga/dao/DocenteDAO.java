/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Docente;
import edu.sil.sga.entidades.Especialidad;
import edu.sil.sga.entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Lopez
 */
public class DocenteDAO {

    public boolean RegistrarDocente(Docente objDocente) throws SQLException {
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
            String sql = "CALL sp_addDocente(?,?,?,?,?,?)";
            cstm = con.prepareCall(sql);
            cstm.setInt(1, objDocente.getEspecialidad().getId());
            cstm.setString(2, objDocente.getNombre());
            cstm.setString(3, objDocente.getApellidopaterno());
            cstm.setString(4, objDocente.getApellidomaterno());
            cstm.setString(5, objDocente.getDni());
            cstm.setDate(6, new Date(objDocente.getFechadenacimiento().getTime()));

            cstm.execute();

            return true;
        } catch (Exception e) {
            System.out.println(" ERROR --> DAO --> Docente --> registrar  " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            cstm.close();
            con.close();
        }
    }

    public boolean ActualizarDocente(Docente objDocente) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Docente SET apellidopaterno=?, apellidomaterno=?,"
                    + "dni=?,telefono=?,movil=?,email=?,idespecialidad=?,nombre=? WHERE id=?");
            pstm.setString(1, objDocente.getApellidopaterno());
            pstm.setString(2, objDocente.getApellidomaterno());
            pstm.setString(3, objDocente.getDni());
            pstm.setString(4, objDocente.getTelefono());
            pstm.setString(5, objDocente.getMovil());
            pstm.setString(6, objDocente.getEmail());
            pstm.setInt(7, objDocente.getEspecialidad().getId());
            pstm.setString(8, objDocente.getNombre());
            pstm.setInt(9, objDocente.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> Docente --> actualizar --> " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarDocente(Docente objDocente) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE Docente SET apellidopaterno=?,apellidomaterno=?,dni=?,"
                    + "telefono=?, movil=?, email=?, idespecialidad=?, nombre=?, estado = ?" + "WHERE id=?");
            pstm.setString(1, objDocente.getApellidopaterno());
            pstm.setString(2, objDocente.getApellidomaterno());
            pstm.setString(3, objDocente.getDni());
            pstm.setString(4, objDocente.getTelefono());
            pstm.setString(5, objDocente.getMovil());
            pstm.setString(6, objDocente.getEmail());
            pstm.setInt(7, objDocente.getEspecialidad().getId());//todo bien
            pstm.setString(8, objDocente.getNombre());
            pstm.setString(9, "0");
            pstm.setInt(10, objDocente.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> Docente --> eliminar" + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public List<Docente> ListarDocente() throws SQLException {
        List<Docente> listarDocente = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" SELECT d.id, d.nombre,d.apellidopaterno,d.apellidomaterno, d.dni, d.telefono, d.movil, d.email, e.descripcion"
                    + " FROM docente d, Especialidad e "
                    + " where d.IDESPECIALIDAD = e.ID and d.estado = 1 ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Docente d = new Docente();
                d.setId(rst.getInt("id"));
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
            System.out.println("ERROR --> DAO --> Docente --> listar" + e.getMessage());
            e.printStackTrace();
        }
        return listarDocente;
    }

    public List<Docente> buscarDocente(String tipo, String cadena) throws SQLException {
        List<Docente> listarDocente = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    " select d.ID, d.NOMBRE, d.APELLIDOPATERNO, d.APELLIDOMATERNO, d.DNI, d.TELEFONO, d.MOVIL, d.EMAIL, e.DESCRIPCION \n"
                    + " from docente d, especialidad e \n"
                    + " WHERE d.IDESPECIALIDAD = e.ID AND d." + tipo + " like '%" + cadena + "%' \n"
                    + " ORDER BY d.NOMBRE ASC"
            );
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Docente d = new Docente();
                d.setId(rst.getInt("id"));
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
            System.out.println("ERROR --> DAO --> Docente --> Buscar" + e.getMessage());
            e.printStackTrace();
        }
        return listarDocente;
    }

    public Docente devolverDocente(Usuario usuario) throws SQLException {
        Docente docente = new Docente();
        //int id = 0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select d.ID, d.NOMBRE, d.APELLIDOPATERNO, d.APELLIDOMATERNO, d.DNI\n"
                    + " from docente d, usuario u where\n"
                    + " u.ID = d.IDUSUARIO and\n"
                    + " u.id = ? ");
            
            pstm.setInt(1, usuario.getId());
            
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                docente.setId(rst.getInt("id"));
                docente.setNombre(rst.getString("nombre"));
                docente.setApellidopaterno(rst.getString("APELLIDOPATERNO"));
                docente.setApellidomaterno(rst.getString("APELLIDOMATERNO"));
                docente.setDni(rst.getString("DNI"));
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Usuario --> validaLogin");
            e.printStackTrace();
        }
        return docente;
    }

}

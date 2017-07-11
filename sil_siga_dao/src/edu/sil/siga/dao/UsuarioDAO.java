/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sil.siga.dao;
import edu.sil.siga.bean.Usuario;
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
public class UsuarioDAO {

    public Usuario validaLogin(String user, String cla)throws SQLException{
        Usuario objUsuario = new Usuario();
        //int id = 0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select id, tipo  from usuario where usuario = '"+user+"'  and clave = '"+cla+"' ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                objUsuario.setId(rst.getInt("id"));
                objUsuario.setTipo(rst.getString("tipo"));
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Usuario --> validaLogin");
            e.printStackTrace();
        }
        return objUsuario;
    }
    
    
    //select u.id from usuario u where usuario = ? and clave = ? 
    
    
   
    
    public List<Usuario> ListarUsuario()throws  Exception{
        List<Usuario> listarUsuario = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select ID,USUARIO,CLAVE,TIPO from usuario where ESTADO=1 order by ID asc");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {                
                Usuario u = new Usuario();
                u.setId(rst.getInt("ID"));
                u.setUsuario(rst.getString("USUARIO"));
                u.setClave(rst.getString("CLAVE"));
                u.setTipo(rst.getString("TIPO"));
                listarUsuario.add(u);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR - USUARIO - DAO - LISTARUSUARIO");
        }
        return listarUsuario;
    }
    
    public boolean RegistrarUsuario(Usuario objUsuario)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO USUARIO(ID,USUARIO,CLAVE,TIPO) "
                    + "VALUES(SQ_USUARIO.NEXTVAL,?,?,?)");
            pstm.setString(1, objUsuario.getUsuario());
            pstm.setString(2, objUsuario.getClave());
            pstm.setString(3, objUsuario.getTipo());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - USUARIO - DAO - REGISTRARUSUARIO");
        }
        return retornar;
    }
    
    public boolean ActualizarUsuario(Usuario objUsuario)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE USUARIO SET USUARIO=? ,CLAVE=? ,TIPO=? "
                    + "WHERE ID=?");
            pstm.setString(1, objUsuario.getUsuario());
            pstm.setString(2, objUsuario.getClave());
            pstm.setString(3, objUsuario.getTipo());
            pstm.setInt(4, objUsuario.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - ACTUALIZAR - DAO - ACTUALIZARUSUARIO");
        }
        return retornar;
    }
    
    public boolean EliminarUsuario(Usuario objUsuario)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE USUARIO SET USUARIO=? ,CLAVE=? ,TIPO=? ,ESTADO=? "
                    + "WHERE ID=?");
            pstm.setString(1, objUsuario.getUsuario());
            pstm.setString(2, objUsuario.getClave());
            pstm.setString(3, objUsuario.getTipo());
            pstm.setString(4, "0");
            pstm.setInt(5, objUsuario.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - USUARIO - DAO- ELIMINARUSUARIO");
        }
        return retornar;
    }
    
    public List<Usuario> buscarUsuario(String cadena, String usuario)throws SQLException{
        List<Usuario> listarusuario = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select ID,USUARIO,CLAVE,TIPO from usuario where ESTADO=1 and "+cadena+" LIKE '%"+usuario+"%'order by ID asc");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {                
                Usuario u = new Usuario();
                u.setId(rst.getInt("ID"));
                u.setUsuario(rst.getString("USUARIO"));
                u.setClave(rst.getString("CLAVE"));
                u.setTipo(rst.getString("TIPO"));
                listarusuario.add(u);
            }
        } catch (Exception e) {
            System.out.println("ERROR - USUARIO - DAO - BUSCARUSUARIO");
        }
        return listarusuario;
    }
}

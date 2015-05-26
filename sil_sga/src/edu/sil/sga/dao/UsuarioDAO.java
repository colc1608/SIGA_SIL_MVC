/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sil.sga.dao;
import edu.sil.sga.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                //id = rst.getInt("id");
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
    
    
    public int tipoUsuario(int idUsu){
        int tipo = 0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select count(*) as id from docente where idusuario = '"+idUsu+"' ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                tipo = rst.getInt("id");
                System.out.println("el valor del tipo es : "+tipo);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Usuario --> tipoUsuario ");
            e.printStackTrace();
        }
        return tipo;
    }
}

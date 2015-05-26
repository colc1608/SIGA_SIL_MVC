/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul
 */
public class CursoDAO {
    
   public boolean RegistrarCurso(Curso curso) throws SQLException{
       boolean retornar = false;
       try {
           Connection con = Conexion.getConnection();
           PreparedStatement pstm = con.prepareStatement("insert into curso(id,nombreCorto,nombreLargo,horasTecnicas,horasPracticas,descripcion)"
                   + " values (sq_curso.NEXTVAL,?,?,?,?,?)");
           pstm.setString(1, curso.getNombreCorto());
           pstm.setString(2, curso.getNombreLargo());
           pstm.setInt(3, curso.getHorasTecnicas());
           pstm.setInt(4, curso.getHorasPracticas());
           pstm.setString(5, curso.getDescripcion());
           pstm.execute();
           pstm.close();
           con.close();
           retornar = true;
       } catch (Exception e) {
           System.out.println("Error - DAO - Curso - Registrar Curso");
           e.printStackTrace();
       }
       return retornar;
   }
   
   public boolean ActualizarCurso(Curso curso) throws SQLException{
       boolean retornar = false;
       try {
           Connection con = Conexion.getConnection();
           PreparedStatement pstm = con.prepareStatement("update curso set nombreCorto=?, nombreLargo=?, horasTecnicas=?, horasPracticas=?, descripcion=? where id=?");
           pstm.setString(1, curso.getNombreCorto());
           pstm.setString(2, curso.getNombreLargo());
           pstm.setInt(3, curso.getHorasTecnicas());
           pstm.setInt(4, curso.getHorasPracticas());
           pstm.setString(5, curso.getDescripcion());
           pstm.setInt(6, curso.getId());
           pstm.execute();
           pstm.close();
           con.close();
           retornar = true;
       } catch (Exception e) {
           System.out.println("Error - DAO - Curso - Actualizar Curso");
           e.printStackTrace();
       }
       return retornar;
   }
   
   public boolean EliminarCurso(Curso curso) throws SQLException{
       boolean retornar = false;
       try {
         Connection con = Conexion.getConnection();
         PreparedStatement pstm = con.prepareStatement("update curso set nombreCorto=?, nombreLargo=?, horasTecnicas=?, horasPracticas=?, descripcion=?, estado=? where id=?");
         pstm.setString(1, curso.getNombreCorto());
         pstm.setString(2, curso.getNombreLargo());
         pstm.setInt(3, curso.getHorasTecnicas());
         pstm.setInt(4, curso.getHorasPracticas());
         pstm.setString(5, curso.getDescripcion());
         pstm.setString(6, "0");
         pstm.setInt(7, curso.getId());
         pstm.execute();
         pstm.close();
         con.close();
         retornar = true;
       } catch (Exception e) {
           System.out.println("ERROR - DAO - Curso - Eliminar Curso");
           e.printStackTrace();
       }
       return retornar;
   }
   
   public List<Curso> ListarCurso(){
       List<Curso> listarCurso = new ArrayList<>();
       try {
           Connection con = Conexion.getConnection();
           PreparedStatement pstm = con.prepareStatement(
                   "select id,nombreCorto,nombreLargo,horasTecnicas,horasPracticas,descripcion from curso where estado = 1 ");
           ResultSet rst = pstm.executeQuery();
           while (rst.next()) {               
               Curso curso = new Curso();
               curso.setId(rst.getInt("id"));
               curso.setNombreCorto(rst.getString("nombreCorto"));
               curso.setNombreLargo(rst.getString("nombreLargo"));
               curso.setHorasTecnicas(rst.getInt("horasTecnicas"));
               curso.setHorasPracticas(rst.getInt("horasPracticas"));
               curso.setDescripcion(rst.getString("descripcion"));
               listarCurso.add(curso);
           }
           pstm.close();
           con.close();
       } catch (Exception e) {
           System.out.println("Error - DAO - Curso - ListarCurso");
           e.printStackTrace();
       }
       return listarCurso;
   }
   
   public List<Curso>BuscarCurso(String nomLar){
       List<Curso> listarCurso = new ArrayList<>();
       try {
           Connection con = Conexion.getConnection();
           PreparedStatement pstm = con.prepareStatement("select id,nombreCorto,nombreLargo,horasTecnicas,horasPracticas,descripcion from curso where estado=1 and nombreLargo like '%" + nomLar+"%'");
           ResultSet rst = pstm.executeQuery();
           while (rst.next()) {               
               Curso c = new Curso();
               c.setId(rst.getInt("id"));
               c.setNombreCorto(rst.getString("nombreCorto"));
               c.setNombreLargo(rst.getString("nombreLargo"));
               c.setHorasTecnicas(rst.getInt("horasTecnicas"));
               c.setHorasPracticas(rst.getInt("horasPracticas"));
               c.setDescripcion(rst.getString("descripcion"));
               listarCurso.add(c);
           }
           pstm.close();
           con.close();
       } catch (Exception e) {
           System.out.println("ERRO - DAO CURSO - BUSCAR");
           e.printStackTrace();
       }
       return listarCurso;
   }
}

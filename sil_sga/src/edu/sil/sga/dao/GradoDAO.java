/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Especialidad;
import edu.sil.sga.entidades.Grado;
import edu.sil.sga.entidades.Nivel;
import edu.sil.sga.entidades.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// HOLA SOY CESAR
// LALALALALALALALALALALALLALALALALALAL
/**
 *
 * @author Cesar Lopez
 */
public class GradoDAO {
    /*hola mundo..!!*/

    public boolean RegistrarGrado(Grado grado) throws SQLException {
        boolean retornar = false;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into grado(id,idNivelEducacion,idSeccion,descripcion)"
                    + "values (sq_docente.NEXTVAL,?,?,?)");

            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getDescripcion());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> grado --> registrar  " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean ActualizarGrado(Grado grado) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE grado SET "
                    + " idNivelEducacion = ?, idSeccion = ?, descripcion = ?  WHERE id = ? ");

            System.out.println("en el dao el nivel tiene: "+grado.getNivel().getId());
            
            
            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getDescripcion());
            pstm.setInt(4, grado.getId());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> grado --> actualizar  " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarGrado(Grado grado) throws SQLException {
        boolean retornar = false;
        try {
            // update usuario set usuario='3001', clave='rojo2' where id=3;
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE grado SET "
                    + " idNivelEducacion = ? , idSeccion = ?, descripcion = ?, estado = ? WHERE id = ? ");

            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getDescripcion());
            pstm.setString(4, "0");
            pstm.setInt(5, grado.getId());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> grado --> eliminar " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public List<Grado> ListarGrado() throws SQLException{
        List<Grado> listarGrado = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" select g.id as id , n.NOMBRECORTO as nivel, g.DESCRIPCION as grado, s.descripcion as seccion  "
                    + " from nivelEducacion n, grado g , seccion s "
                    + " where g.IDNIVELEDUCACION = n.ID and "
                    + " g.IDSECCION = s.ID and "
                    + " g.ESTADO = 1  "
                    + " order by nivel, grado asc  ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Grado grado = new Grado();
                Nivel nivel = new Nivel();
                Seccion seccion = new Seccion();
                
                grado.setId(rst.getInt("id"));
                nivel.setNombreCorto(rst.getString("nivel"));
                grado.setNivel(nivel);
                seccion.setDescripcion(rst.getString("seccion"));
                grado.setSeccion(seccion);
                grado.setDescripcion(rst.getString("grado"));
                
                
                listarGrado.add(grado);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> grado --> listar " + e.getMessage());
            e.printStackTrace();
        }
        return listarGrado;
    }
  
   /* public List<Grado>buscarGrado(String nomLa, String desc)throws SQLException{
        List<Grado> listarGrado = new ArrayList<>();
        System.out.println("nombre Largo = " + nomLa);
        System.out.println("descripcion = " + desc);
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select g.id as id , n.NOMBRECORTO as nivel, g.DESCRIPCION as grado, s.descripcion as seccion from niveleducacion n \n" +
            "inner join grado g on(n.ID = g.idniveleducacion)\n" +
            "inner join seccion s on(g.idseccion = s.ID)\n" +
            "where n.nombreLargo='"+ nomLa +"' and g.descripcion= '"+desc+"'");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {                
                Grado grado = new Grado();
                Nivel nivel = new Nivel();
                Seccion seccion = new Seccion();
                
                grado.setId(rst.getInt("id"));
                nivel.setNombreCorto(rst.getString("nivel"));
                grado.setNivel(nivel);
                seccion.setDescripcion(rst.getString("seccion"));
                grado.setSeccion(seccion);
                grado.setDescripcion(rst.getString("grado"));
                listarGrado.add(grado);
            }
        } catch (Exception e) {
            System.out.println("Error - Grado - DAO - Busqueda");
        }
        return listarGrado;
    }
*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.siga.dao;

import edu.sil.siga.bean.Especialidad;
import edu.sil.siga.bean.Grado;
import edu.sil.siga.bean.Nivel;
import edu.sil.siga.bean.Seccion;
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
            PreparedStatement pstm = con.prepareStatement("insert into grado(id,idNivelEducacion,idSeccion,numeroGrado)"
                    + "values (sq_grado.NEXTVAL,?,?,?)");

            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getnumeroGrado());

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
                    + " idNivelEducacion = ?, idSeccion = ?, numeroGrado = ?  WHERE id = ? ");

            System.out.println("en el dao el nivel tiene: " + grado.getNivel().getId());

            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getnumeroGrado());
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
                    + " idNivelEducacion = ? , idSeccion = ?, numeroGrado = ?, estado = ? WHERE id = ? ");
            pstm.setInt(1, grado.getNivel().getId());
            pstm.setInt(2, grado.getSeccion().getId());
            pstm.setString(3, grado.getnumeroGrado());
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

    public List<Grado> ListarGrado()  throws SQLException{
        List<Grado> listarGrado = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" select g.id as id , n.NOMBRECORTO as nivelNombreCorto,n.NOMBRELARGO as nivelNombreLARGO, g.numeroGrado as grado, s.descripcion as seccion  "
                    + " from nivelEducacion n, grado g , seccion s "
                    + " where g.IDNIVELEDUCACION = n.ID and "
                    + " g.IDSECCION = s.ID and "
                    + " g.ESTADO = 1  "
                    + " order by nivelNombreLARGO, grado asc  ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Grado grado = new Grado();
                Nivel nivel = new Nivel();
                Seccion seccion = new Seccion();

                grado.setId(rst.getInt("id"));
                nivel.setNombreCorto(rst.getString("nivelNombreCorto"));
                nivel.setNombreLargo(rst.getString("nivelNombreLARGO"));
                grado.setnumeroGrado(rst.getString("grado"));
                seccion.setDescripcion(rst.getString("seccion"));
                grado.setNivel(nivel);
                grado.setSeccion(seccion);

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

    public List<Grado> buscarGradoCombo(Grado objGrado) throws SQLException {
        List<Grado> listarGrado = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select g.id as id , n.nombreCORTO as nivelNombreCorto,n.nombrelargo as nivelNombreLARGO, g.numeroGrado as grado, s.descripcion as seccion "
                    + "from niveleducacion n\n"
                    + "inner join grado g on(n.ID = g.idniveleducacion)\n"
                    + "inner join seccion s on(g.idseccion = s.ID)\n"
                    + "where  n.NOMBRELARGO like ?");
            pstm.setString(1, "%"+objGrado.getNivel().getNombreLargo()+"%");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Grado grado = new Grado();
                Nivel nivel = new Nivel();
                Seccion seccion = new Seccion();

                grado.setId(rst.getInt("id"));
                nivel.setNombreCorto(rst.getString("nivelNombreCorto"));
                nivel.setNombreLargo(rst.getString("nivelNombreLARGO"));
                grado.setNivel(nivel);
                seccion.setDescripcion(rst.getString("seccion"));
                grado.setSeccion(seccion);
                grado.setnumeroGrado(rst.getString("grado"));
                listarGrado.add(grado);
            }
        } catch (Exception e) {
            System.out.println("Error - Grado - DAO - Busqueda");
            e.printStackTrace();
        }
        return listarGrado;
    }

    public List<Grado> buscarGradoCaja(Grado objGrado) throws SQLException {
        List<Grado> listagrado = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select g.id as id , n.nombreCORTO as nivelNombreCorto,n.nombrelargo as nivelNombreLARGO, g.numeroGrado as grado, s.descripcion as seccion "
                    + " from niveleducacion n\n"
                    + " inner join grado g on(n.ID = g.idniveleducacion)\n"
                    + " inner join seccion s on(g.idseccion = s.ID)\n"
                    + " where g.numeroGrado like ? and n.NOMBRELARGO=?");
            pstm.setString(1, "%"+objGrado.getnumeroGrado()+"%");
            pstm.setString(2, objGrado.getNivel().getNombreLargo());
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Grado grado = new Grado();
                Nivel nivel = new Nivel();
                Seccion seccion = new Seccion();

                grado.setId(rst.getInt("id"));
                nivel.setNombreCorto(rst.getString("nivelNombreCorto"));
                nivel.setNombreLargo(rst.getString("nivelNombreLARGO"));
                grado.setNivel(nivel);
                seccion.setDescripcion(rst.getString("seccion"));
                grado.setSeccion(seccion);
                grado.setnumeroGrado(rst.getString("grado"));
                listagrado.add(grado);
            }
        } catch (Exception e) {
            System.out.println("ERROR - GRADO - DAO - BUSCARGRADOCAJA" + e.getMessage());
            e.printStackTrace();
        }
        return listagrado;
    }
}

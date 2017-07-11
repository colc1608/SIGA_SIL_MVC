
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.siga.dao;

import edu.sil.siga.bean.Nivel;
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
public class NivelDAO {

    public boolean RegistrarNivel(Nivel nivel) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO nivelEducacion (id,nombreCorto,nombreLargo)"
                    + " values (sq_niveleducacion.NEXTVAL, ?, ? ) ");
            pstm.setString(1, nivel.getNombreCorto());
            pstm.setString(2, nivel.getNombreLargo());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Nivel --> registrar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean ActualizarNivel(Nivel nivel) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE nivelEducacion "
                    + " SET nombreCorto = ? , nombreLargo = ? WHERE id = ? ");
            pstm.setString(1, nivel.getNombreCorto());
            pstm.setString(2, nivel.getNombreLargo());
            pstm.setInt(3, nivel.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Nivel --> actualizar "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarNivel(Nivel nivel) throws SQLException {
        boolean retornar = false;
        try {
            // update usuario set usuario='3001', clave='rojo2' where id=3;
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE nivelEducacion "
                    + " SET nombreCorto = ? , nombreLargo = ?, estado = ? WHERE id = ? ");
            pstm.setString(1, nivel.getNombreCorto());
            pstm.setString(2, nivel.getNombreLargo());
            pstm.setString(3, "0");
            pstm.setInt(4, nivel.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Nivel --> eliminar  "+e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public List<Nivel> ListarNivel() throws SQLException{
        List<Nivel> listarNivel = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    " select id, nombreCorto, nombreLargo from nivelEducacion where estado = 1 ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Nivel nivel = new Nivel();
                nivel.setId(rst.getInt("id"));
                nivel.setNombreCorto(rst.getString("nombreCorto"));
                nivel.setNombreLargo(rst.getString("nombreLargo"));

                listarNivel.add(nivel);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Nivel --> listar  "+e.getMessage());
            e.printStackTrace();
        }
        return listarNivel;
    }

}

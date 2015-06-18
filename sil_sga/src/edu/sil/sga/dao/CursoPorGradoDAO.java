/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Curso;
import edu.sil.sga.entidades.CursoPorGrado;
import edu.sil.sga.entidades.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo Lopez
 */
public class CursoPorGradoDAO {

    public boolean RegistrarClase(CursoPorGrado cursoPorGrado) throws SQLException {
        boolean retornar = false;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into cursoporgrado(id,idgrado,idcurso,descripcion) "
                    + " values(sq_cursoporgrado.nextval, ?, ?, ?) ");

            pstm.setInt(1, cursoPorGrado.getGrado().getId());
            pstm.setInt(2, cursoPorGrado.getCurso().getId());
            pstm.setString(3, cursoPorGrado.getDescripcion());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" ERROR --> DAO --> Curso Por Grado --> Registrar  --> " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean ActualizarClase(CursoPorGrado cursoGrado) throws SQLException {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" update cursoporgrado set "
                    + "idgrado=?, idcurso = ? , descripcion = ? where id = ? ");

            pstm.setInt(1, cursoGrado.getGrado().getId());
            pstm.setInt(2, cursoGrado.getCurso().getId());
            pstm.setString(3, cursoGrado.getDescripcion());
            pstm.setInt(4, cursoGrado.getId());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> Curso Por Grado --> ACTUALIZAR --> " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public List<CursoPorGrado> ListarCursoPorGrado() throws SQLException {
        List<CursoPorGrado> listaDeCursoPorGrado = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select cpg.id as idcpg, g.ID as idGrado, c.ID as idCurso, \n"
                    + "n.NOMBRELARGO, s.DESCRIPCION, g.NUMEROGRADO, c.NOMBRELARGO as nombreCurso\n"
                    + "from niveleducacion n, seccion s, grado g, curso c, cursoporgrado cpg where\n"
                    + "g.IDNIVELEDUCACION = n.ID and\n"
                    + "g.IDSECCION = s.ID and\n"
                    + "g. ID = cpg.IDGRADO and\n"
                    + "cpg.IDCURSO = c.ID  ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                CursoPorGrado cursoGrado = new CursoPorGrado();

                cursoGrado.setDescripcion(rst.getString("descripcion"));

                Curso curso = new Curso();
                curso.setNombreLargo(rst.getString("curso"));
                cursoGrado.setCurso(curso);

                Grado grado = new Grado();
                grado.setnumeroGrado(rst.getString("grado"));
                cursoGrado.setGrado(grado);

                cursoGrado.setId(rst.getInt("id"));
                curso.setId(rst.getInt("idCurso"));
                grado.setId(rst.getInt("idGrado"));

                listaDeCursoPorGrado.add(cursoGrado);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> ListarCursoPorGrado --> listar --> " + e.getMessage());
            e.printStackTrace();
        }
        return listaDeCursoPorGrado;
    }

}

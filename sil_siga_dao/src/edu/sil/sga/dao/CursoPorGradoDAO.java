/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.siga.bean.Curso;
import edu.sil.siga.bean.CursoPorGrado;
import edu.sil.siga.bean.Grado;
import edu.sil.siga.bean.Nivel;
import edu.sil.siga.bean.Seccion;
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
public class CursoPorGradoDAO {

    public boolean RegistrarCursoPorGrado(List<CursoPorGrado> listaDeCursoPorGrado) {
        boolean retornar = false;

        try {
            Connection con = Conexion.getConnection();

            PreparedStatement pstm = con.prepareStatement("insert into cursoporgrado(id,idgrado,idcurso,descripcion,CANTIDADALUMNOS) "
                    + " values(sq_cursoporgrado.nextval, ?, ?, ?, ?) ");

            for (int i = 0; i < listaDeCursoPorGrado.size(); i++) {

                pstm.setInt(1, listaDeCursoPorGrado.get(i).getGrado().getId());
                pstm.setInt(2, listaDeCursoPorGrado.get(i).getCurso().getId());
                pstm.setString(3, listaDeCursoPorGrado.get(i).getDescripcion());
                pstm.setInt(4, listaDeCursoPorGrado.get(i).getCantidadAlumnos());

                pstm.execute();

            }
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" ERROR --> DAO --> Curso Por Grado --> Registrar  --> " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean ActualizarCursoPorGrado(CursoPorGrado cursoGrado) {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" update cursoporgrado set "
                    + "idgrado=?, idcurso = ? , descripcion = ?, CANTIDADALUMNOS=? where id = ? ");

            pstm.setInt(1, cursoGrado.getGrado().getId());
            pstm.setInt(2, cursoGrado.getCurso().getId());
            pstm.setString(3, cursoGrado.getDescripcion());
            pstm.setInt(4, cursoGrado.getCantidadAlumnos());
            pstm.setInt(5, cursoGrado.getId());

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

    public List<CursoPorGrado> ListarCursoPorGrado()  {
        List<CursoPorGrado> listaDeCursoPorGrado = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" select g.NUMEROGRADO, s.DESCRIPCION as seccion, n.NOMBRELARGO as nivel, c.NOMBRELARGO as nombreCurso,\n"
                    + " g.ID as idGrado, cpg.ID as idCPG, c.ID as idCurso \n"
                    + " from grado g, NIVELEDUCACION n, SECCION s, CURSOPORGRADO cpg, curso c where \n"
                    + " g.IDSECCION = s.ID and \n"
                    + " g.IDNIVELEDUCACION = n.ID and \n"
                    + " g.ID = cpg.IDGRADO and \n"
                    + " cpg.IDCURSO = c.ID ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                CursoPorGrado cursoGrado = new CursoPorGrado();

                Grado grado = new Grado();
                Seccion seccion = new Seccion();
                Nivel nivel = new Nivel();
                Curso curso = new Curso();

                grado.setnumeroGrado(rst.getString("NUMEROGRADO"));
                seccion.setDescripcion(rst.getString("seccion"));
                nivel.setNombreLargo(rst.getString("nivel"));
                curso.setNombreLargo(rst.getString("nombreCurso"));
                
                grado.setId(rst.getInt("idGrado"));
                cursoGrado.setId(rst.getInt("idCPG"));
                curso.setId(rst.getInt("idCurso"));
                
                grado.setSeccion(seccion);
                grado.setNivel(nivel);
                cursoGrado.setGrado(grado);
                cursoGrado.setCurso(curso);

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

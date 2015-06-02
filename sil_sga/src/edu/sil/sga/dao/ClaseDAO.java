/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Clase;
import edu.sil.sga.entidades.Curso;
import edu.sil.sga.entidades.Docente;
import edu.sil.sga.entidades.Grado;
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
public class ClaseDAO {

    public boolean RegistrarClase(Clase clase) throws SQLException {
        boolean retornar = false;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into clase(id,idCurso,idGrado,idDocente,cantidadAlumnos, observacion)"
                    + "values (SQ_GRADO.NEXTVAL,?,?,?,?,?)");

            pstm.setInt(1, clase.getCurso().getId());
            pstm.setInt(2, clase.getGrado().getId());
            pstm.setInt(3, clase.getDocente().getId());
            pstm.setInt(4, clase.getCantidadAlumnos());
            pstm.setString(5, clase.getObservacion());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" error --> DAO --> Clase --> registrar  " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    
    
    public List<Clase>ListarClases()throws  SQLException{
        List<Clase> listaDeClases = new ArrayList<>();
        try {
            Connection con  = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" select c.id, c.CANTIDADALUMNOS as cantidad , c.observacion as observacion , d.nombre , d.APELLIDOPATERNO , cu.NOMBRELARGO as curso, g.DESCRIPCION as grado "
                    + " from clase c, docente d, grado g, curso cu where "
                    + " c.IDCURSO = cu.ID and "
                    + " c.IDGRADO = g.ID and "
                    + " c.IDDOCENTE = d.ID and "
                    + " c. ESTADO = '1' ");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                Clase clase = new Clase();
                
                clase.setId(rst.getInt("id"));
                clase.setCantidadAlumnos(rst.getInt("cantidad"));
                clase.setObservacion(rst.getString("observacion"));
                
                Docente docente = new Docente();
                docente.setNombre(rst.getString("nombre"));
                docente.setApellidopaterno(rst.getString("APELLIDOPATERNO"));
                clase.setDocente(docente);
                
                Curso curso = new Curso();
                curso.setNombreLargo(rst.getString("curso"));
                clase.setCurso(curso);
                
                Grado grado = new Grado();
                grado.setDescripcion(rst.getString("grado"));
                clase.setGrado(grado);
                
                listaDeClases.add(clase);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> Clase --> listar"+e.getMessage());
            e.printStackTrace();
        }
        return listaDeClases;
    }
    
}
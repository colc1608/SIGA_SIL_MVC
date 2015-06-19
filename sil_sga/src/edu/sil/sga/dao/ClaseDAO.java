/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Clase;
import edu.sil.sga.entidades.Curso;
import edu.sil.sga.entidades.CursoPorGrado;
import edu.sil.sga.entidades.Docente;
import edu.sil.sga.entidades.Grado;
import edu.sil.sga.entidades.Nivel;
import edu.sil.sga.entidades.Seccion;
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

    public boolean RegistrarClase(Clase clase)  {
        boolean retornar = false;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into clase "
                    + " (id, IDCURSOPORGRADO,idDocente,cantidadAlumnos, observacion) "
                    + " values (SQ_GRADO.NEXTVAL,?,?,?,?)");

            pstm.setInt(1, clase.getCursoGrado().getId());
            pstm.setInt(2, clase.getDocente().getId());
            pstm.setInt(3, clase.getCantidadAlumnos());
            pstm.setString(4, clase.getObservacion());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println(" ERROR --> DAO --> Clase --> Registrar  --> " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean ActualizarClase(Clase clase)  {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" UPDATE clase  SET  IDCURSOPORGRADO=?, "
                    + "iddocente =?, cantidadalumnos=?, observacion =? WHERE id=? ");

            pstm.setInt(1, clase.getCursoGrado().getId());
            pstm.setInt(2, clase.getDocente().getId());
            pstm.setInt(3, clase.getCantidadAlumnos());
            pstm.setString(4, clase.getObservacion());
            pstm.setInt(5, clase.getId());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> CLASE --> ACTUALIZAR --> " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public boolean EliminarClase(Clase clase)  {
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" UPDATE clase  SET  IDCURSOPORGRADO=?,  "
                    + "iddocente =?, cantidadalumnos=?, observacion =?, estado = 0 WHERE id=? ");

            pstm.setInt(1, clase.getCursoGrado().getId());
            pstm.setInt(2, clase.getDocente().getId());
            pstm.setInt(3, clase.getCantidadAlumnos());
            pstm.setString(4, clase.getObservacion());
            pstm.setInt(5, clase.getId());

            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> Clase --> Eliminar --> " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }

    public List<Clase> ListarClases()  {
        List<Clase> listaDeClases = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select g.NUMEROGRADO, s.DESCRIPCION as seccion, n.NOMBRELARGO as nivel, c.NOMBRELARGO as nombreCurso, d.NOMBRE, d.APELLIDOPATERNO, cla.CANTIDADALUMNOS, cla.OBSERVACION, \n"
                    + " g.ID as idGrado, cpg.ID as idCPG, c.ID as idCurso, cla.ID as idClase, d.ID as idDocente\n"
                    + " from grado g, NIVELEDUCACION n, SECCION s, CURSOPORGRADO cpg, curso c , clase cla, docente d where\n"
                    + " g.IDSECCION = s.ID and\n"
                    + " g.IDNIVELEDUCACION = n.ID and\n"
                    + " g.ID = cpg.IDGRADO and \n"
                    + " cpg.IDCURSO = c.ID and \n"
                    + " cpg.ID = cla.IDCURSOPORGRADO and\n"
                    + " cla.IDDOCENTE = d.ID and\n"
                    + " cla.ESTADO = '1' ");
            
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                
                Seccion seccion = new Seccion();
                Nivel nivel = new Nivel();
                Grado grado = new Grado();
                CursoPorGrado cursoGrado = new CursoPorGrado();
                Curso curso = new Curso();
                Clase clase = new Clase();
                Docente docente = new Docente();
                
                //capturando campos
                grado.setnumeroGrado(rst.getString("numeroGrado"));
                seccion.setDescripcion(rst.getString("seccion"));
                nivel.setNombreLargo(rst.getString("nivel"));
                
                curso.setNombreLargo(rst.getString("nombreCurso"));
                
                docente.setNombre(rst.getString("nombre"));
                docente.setApellidopaterno(rst.getString("apellidoPaterno"));
                
                clase.setCantidadAlumnos(rst.getInt("cantidadAlumnos"));
                clase.setObservacion(rst.getString("observacion"));

                //capturando ID
                grado.setId(rst.getInt("idGrado"));
                cursoGrado.setId(rst.getInt("idCPG"));
                curso.setId(rst.getInt("idCurso"));
                clase.setId(rst.getInt("idClase"));
                docente.setId(rst.getInt("idDocente"));
                
                //uniendo Objetos
                grado.setNivel(nivel);
                grado.setSeccion(seccion);
                cursoGrado.setGrado(grado);
                cursoGrado.setCurso(curso);
                
                clase.setDocente(docente);
                clase.setCursoGrado(cursoGrado);
                
                listaDeClases.add(clase);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> Clase --> listar --> " + e.getMessage());
            e.printStackTrace();
        }
        return listaDeClases;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Alumno;
import edu.sil.sga.entidades.Clase;
import edu.sil.sga.entidades.Nota;
import edu.sil.sga.entidades.Periodo;
import edu.sil.sga.entidades.TipoEvaluacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo Lopez
 */
public class NotaDAO {

    public List<Nota> ListarNotas(Clase objClase, Periodo objPeriodo, TipoEvaluacion objTipoEvaluacion) {
        List<Nota> listaDeNotas = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement(" select a.NOMBRE, a.APELLIDOPATERNO, a.APELLIDOMATERNO, n.NOTA, \n"
                    + "n.id, n.IDALUMNO, n.IDCLASE, n.IDPERIODO, n.IDTIPOEVALUACION\n"
                    + "from nota n, periodo p, TIPOEVALUACION te, alumno a , clase c where\n"
                    + "n.IDPERIODO = p.id and\n"
                    + "n.IDTIPOEVALUACION = te.id and\n"
                    + "n.IDALUMNO = a.id and\n"
                    + "n.IDCLASE = c.id and\n"
                    + "n.IDCLASE = ? and\n"
                    + "n.IDPERIODO = ? and\n"
                    + "n.IDTIPOEVALUACION = ? ");

            pstm.setInt(1, objClase.getId());
            pstm.setInt(2, objPeriodo.getId());
            pstm.setInt(3, objTipoEvaluacion.getId());
            //pstm.execute();

            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {

                Nota nota = new Nota();
                Alumno alumno = new Alumno();
                Clase clase = new Clase();
                Periodo periodo = new Periodo();
                TipoEvaluacion tipoEvaluacion = new TipoEvaluacion();

                alumno.setNombre(rst.getString("nombre"));
                alumno.setApellidopaterno(rst.getString("apellidoPaterno"));
                alumno.setApellidomaterno(rst.getString("apellidoMaterno"));

                nota.setNota(rst.getInt("nota"));
                nota.setId(rst.getInt("id"));

                alumno.setId(rst.getInt("IDALUMNO"));
                clase.setId(rst.getInt("IDCLASE"));
                periodo.setId(rst.getInt("IDPERIODO"));
                tipoEvaluacion.setId(rst.getInt("IDTIPOEVALUACION"));

                nota.setAlumno(alumno);
                nota.setClase(clase);
                nota.setPeriodo(periodo);
                nota.setTipoEvaluacion(tipoEvaluacion);

                listaDeNotas.add(nota);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> NOTA --> ListarNotas --> " + e.getMessage());
            e.printStackTrace();
        }
        return listaDeNotas;
    }

    public boolean ActualizarNotas(List<Nota> objListaDeNotas) {

        boolean bandera = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("update nota set NOTA = ? where\n"
                    + "IDCLASE = ? and\n"
                    + "IDALUMNO = ? and\n"
                    + "IDTIPOEVALUACION = ? and\n"
                    + "IDPERIODO = ? and \n"
                    + "id = ?  ");

            //PARA ACTUALIZAR LAS NOTAS 
            for (int i = 0; i < objListaDeNotas.size(); i++) {
                pstm.setInt(1, objListaDeNotas.get(i).getNota());
                pstm.setInt(2, objListaDeNotas.get(i).getClase().getId());
                pstm.setInt(3, objListaDeNotas.get(i).getAlumno().getId());
                pstm.setInt(4, objListaDeNotas.get(i).getTipoEvaluacion().getId());
                pstm.setInt(5, objListaDeNotas.get(i).getPeriodo().getId());
                pstm.setInt(6, objListaDeNotas.get(i).getId());
                pstm.execute();
                System.out.println("estoy dentro del FOR ");
            }
            
            System.out.println("se actulizaron las NOTAS =D ");
            
            pstm.close();
            con.close();
            bandera = true;
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> NOTA --> ActualizarNotas --> " + e.getMessage());
            e.printStackTrace();
        }
        return bandera;
    }

}

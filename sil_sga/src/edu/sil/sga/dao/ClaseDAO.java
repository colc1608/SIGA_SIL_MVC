/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.sga.entidades.Clase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
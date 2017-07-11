/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import edu.sil.siga.bean.Alumno;
import edu.sil.siga.bean.Apoderado;
import edu.sil.siga.bean.Parentesco;
import java.sql.CallableStatement;
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
public class ParentescoDAO {
    public boolean RegistrarParentesco(Parentesco obParentesco)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            String sql = "CALL SP_ADDPARENTESCO(?,?)";
            CallableStatement cstm  = con.prepareCall(sql);
            cstm.setString(1, obParentesco.getParentesco());
            cstm.setString(2, obParentesco.getObservacion());
            cstm.execute();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - DAO - PARENTESCO - REGISTRARPARENTESCO" + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
    
    public boolean ActualizarParentesco(Parentesco obParentesco)throws SQLException{
        boolean retornar = false;
        System.out.println("id del parentesco que llega" + obParentesco.getId());
        System.out.println("parentes que llega -- " + obParentesco.getParentesco());
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE PARENTESCO SET PARENTESCO = ?, OBSERVACION = ? where ID = ?");
            pstm.setString(1, obParentesco.getParentesco());
            pstm.setString(2, obParentesco.getObservacion());
            pstm.setInt(3, obParentesco.getId());
            pstm.execute();
            pstm.close();
            con.close();
            retornar = true;
        } catch (Exception e) {
            System.out.println("ERROR - DAO - PARENTESCO - ACTUALIZARPARENTESCO " + e.getMessage());
            e.printStackTrace();
        }
        return retornar;
    }
   
/*    public boolean EliminarParentesco(Parentesco obParentesco)throws SQLException{
        boolean retornar = false;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("");
            pstm
        } catch (Exception e) {
        }
        return retornar; 
    }
  */  
    public List<Parentesco> listarParentesco() throws SQLException{
        List<Parentesco> listadoApoderado = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pstm = con.prepareStatement("select ap.ID,ap.NOMBRE,ap.APELLIDOPATERNO,ap.APELLIDOMATERNO,ap.DNI,ap.TELEFONO,ap.MOVIL,ap.FECHANACIMIENTO,\n" +
                "ap.EMAIL,pa.ID as IDPA,pa.PARENTESCO, al.NOMBRE as ALUMNO,al.APELLIDOPATERNO as ALUMNOAP,al.APELLIDOMATERNO AS ALUMNOAM from APODERADO ap \n" +
                "inner join PARENTESCO pa on(ap.ID = pa.IDAPODERADO)\n" +
                "inner join ALUMNO al on (pa.IDALUMNO = al.ID)");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {                
                Apoderado ap = new Apoderado();
                ap.setId(rst.getInt("ID"));
                ap.setNombre(rst.getString("NOMBRE"));
                ap.setApellidoPaterno(rst.getString("APELLIDOPATERNO"));
                ap.setApellidoMaterno(rst.getString("APELLIDOMATERNO"));
                ap.setDni(rst.getString("DNI"));
                ap.setTelefono(rst.getString("TELEFONO"));
                ap.setMovil(rst.getString("MOVIL"));
                ap.setFechanacimiento(rst.getDate("FECHANACIMIENTO"));
                ap.setEmail(rst.getString("EMAIL"));
                Alumno al = new Alumno();
                al.setNombre(rst.getString("ALUMNO"));
                al.setApellidopaterno(rst.getString("ALUMNOAP"));
                al.setApellidomaterno(rst.getString("ALUMNOAM"));
                Parentesco pa = new Parentesco();
                pa.setApoderado(ap);
                pa.setAlumno(al);
                pa.setId(rst.getInt("IDPA"));
                pa.setParentesco(rst.getString("PARENTESCO"));
                
                listadoApoderado.add(pa);
            }
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR --> DAO --> PARENTESCO --> LISTAR" + e.getMessage());
            e.printStackTrace();
        }
        return listadoApoderado;
    }

}

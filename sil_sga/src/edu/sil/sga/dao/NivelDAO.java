/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sil.sga.dao;

/**
 * 
 * @author Cesar Lopez
 */
public class NivelDAO {
    
    public boolean RegistrarEspecialidad(Nivel nivel)throws SQLException{
            boolean retornar = false;
            try {
                Connection con = Conexion.getConnection();
                PreparedStatement pstm = con.prepareStatement("INSERT INTO Especialidad(id,descripcion)values"+"(sq_especialidad.NEXTVAL,?)");
                pstm.setString(1, objEspecialidad.getDescripcion());
                pstm.execute();
                pstm.close();
                con.close();
                retornar = true;
            } catch (Exception e) {
                System.out.println("error --> DAO registrar especialidad");
                e.printStackTrace();
            }
            return retornar;
        }
}

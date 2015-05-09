/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * SGA por las siglas de
 * Sistema de Gestion Academico
 * 
 * @author Cesar Lopez
 * @author Walter Ramos
 * @author Paul Farfan
 */
public class Conexion {

    private static String user = "system";
    private static String pass = "123456";
    private static String server = "127.0.0.1";
    private static String port = "1521";
    private static String dbname = "DBSILSGA";
    
    public static Connection getConnection()throws Exception{
        Connection con = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@"+server+":"+port+":"+dbname,user,pass);
            System.out.println("conexion finalizada correctamente :) ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error en la clase conexion :(  ");
        }
        return con;
    }
    
}

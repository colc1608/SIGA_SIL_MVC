/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.siga.bean;

import java.util.Date;

/**
 *
 * @author Paul
 */
public class Apoderado {
    int id;
    String nombre;
    String ApellidoPaterno;
    String ApellidoMaterno;
    String dni;
    String telefono;
    String movil;
    Date fechanacimiento;
    String Email;
    String Estado;
    
    public Apoderado(){
        this(0,"","","","","","",new Date(),"","");
    }
    
    public Apoderado(int id, String nombre, String ApellidoPaterno, String ApellidoMaterno, String dni,String telefono, String movil, Date fechanacimiento, String Email,String Estado) {
        this.id = id;
        this.nombre = nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.dni = dni;
        this.telefono = telefono;
        this.movil = movil;
        this.fechanacimiento = fechanacimiento;
        this.Email = Email;
        this.Estado = Estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}

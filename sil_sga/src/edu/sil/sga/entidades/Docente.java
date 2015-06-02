/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.entidades;

import java.util.Date;

/**
 *
 * @author Cesar Lopez
 */
public class Docente {
    int id;
    String nombre;
    String apellidopaterno;
    String apellidomaterno;
    String dni;
    String telefono;
    String movil;
    Date fechadenacimiento; // siempr es el UTIL
    String email;
    Especialidad especialidad;
    String estado;
    
    public Docente(){
        this(0,"","","","","","","",new Especialidad(),"",new Date());
    }

    
    
    public Docente(int id, String nombre, String apellidopaterno, String apellidomaterno, String dni, String telefono, String movil, String email, Especialidad especialidad, String estado, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.dni = dni;
        this.telefono = telefono;
        this.movil = movil;
        this.email = email;
        this.especialidad = especialidad;
        this.estado = estado;
        this.fechadenacimiento = fechaNacimiento;
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

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(Date fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }
    
    
    
    
}

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
public class Matricula {
    
    int id;
    Alumno alumno;
    Grado grado;
    double monto;
    Date fecha;
    String observacion;
    
    
    
    public Matricula(){
        this(0,new Alumno(),new Grado(),0.0,new Date(), "");
    }

    public Matricula(int id, Alumno alumno, Grado grado, double monto, Date fecha, String observacion) {
        this.id = id;
        this.alumno = alumno;
        this.grado = grado;
        this.monto = monto;
        this.fecha = fecha;
        this.observacion = observacion;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
}

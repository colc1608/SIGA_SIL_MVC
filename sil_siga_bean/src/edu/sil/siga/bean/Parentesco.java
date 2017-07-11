/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.siga.bean;

/**
 *
 * @author Paul
 */
public class Parentesco {
    int id;
    String parentesco;
    String observacion;
    Alumno alumno;
    Apoderado apoderado;
    
     public Parentesco(){
        this(0,"","",new Alumno(),new Apoderado());
    }

    public Parentesco(int id, String parentesco, String observacion, Alumno alumno, Apoderado apoderado) {
        this.id = id;
        this.parentesco = parentesco;
        this.observacion = observacion;
        this.alumno = alumno;
        this.apoderado = apoderado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }
}

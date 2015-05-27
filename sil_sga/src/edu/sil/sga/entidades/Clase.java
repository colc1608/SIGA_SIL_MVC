/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.entidades;

/**
 *
 * @author Cesar Lopez
 */
public class Clase {

    Curso curso;
    Grado grado;
    Docente docente;
    int cantidadAlumnos;
    String observacion;
    String estado;
    
    
    public Clase(){
       this(new Curso(), new Grado(), new Docente(), 0 , "","");
    }
    
    
    public Clase(Curso curso, Grado grado, Docente docente, int cantidadAlumnos, String observacion, String estado) {
        this.curso = curso;
        this.grado = grado;
        this.docente = docente;
        this.cantidadAlumnos = cantidadAlumnos;
        this.observacion = observacion;
        this.estado = estado;
    }
    
    
    
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}

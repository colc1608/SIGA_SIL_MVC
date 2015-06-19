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
    
    int id;
    CursoPorGrado cursoGrado;
    Docente docente;
    int cantidadAlumnos;
    String observacion;
    String estado;
    
    
    public Clase(){
       this(0,new CursoPorGrado(), new Docente(), 0 , "","");
    }

    public Clase(int id, CursoPorGrado cursoGrado, Docente docente, int cantidadAlumnos, String observacion, String estado) {
        this.id = id;
        this.cursoGrado = cursoGrado;
        this.docente = docente;
        this.cantidadAlumnos = cantidadAlumnos;
        this.observacion = observacion;
        this.estado = estado;
    }

    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CursoPorGrado getCursoGrado() {
        return cursoGrado;
    }

    public void setCursoGrado(CursoPorGrado cursoGrado) {
        this.cursoGrado = cursoGrado;
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

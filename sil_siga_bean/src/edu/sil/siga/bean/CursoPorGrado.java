/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.siga.bean;

/**
 *
 * @author Eduardo Lopez
 */
public class CursoPorGrado {
    int id;
    Curso curso;
    Grado grado;
    String descripcion;
    String estado;
    int cantidadAlumnos;
    
    
    public CursoPorGrado(){
        this(0,new Curso(),new Grado(),"","",0);
    }

    public CursoPorGrado(int id, Curso curso, Grado grado, String descripcion, String estado, int cantidadAlumnos) {
        this.id = id;
        this.curso = curso;
        this.grado = grado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.cantidadAlumnos = cantidadAlumnos;
    }
    
    

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}

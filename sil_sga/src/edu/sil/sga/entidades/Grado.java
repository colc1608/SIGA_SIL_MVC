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
public class Grado {
    int id;
    Nivel nivel;
    Seccion seccion;
    String descripcion;

    public Grado(){
       this(0,new Nivel(),new Seccion(),"");
    }
    
    public Grado(int id, Nivel nivel, Seccion seccion, String descripcion) {
        this.id = id;
        this.nivel = nivel;
        this.seccion = seccion;
        this.descripcion = descripcion;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

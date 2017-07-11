/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sil.siga.bean;

/**
 * 
 * @author Cesar Lopez
 */
public class Seccion {
    int id;
    String descripcion;
    String estado;

    
    public Seccion(){
       this(0,"","");
    }
    
    
    public Seccion(int id, String descripcion, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

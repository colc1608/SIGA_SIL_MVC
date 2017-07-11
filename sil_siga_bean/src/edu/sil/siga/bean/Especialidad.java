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
public class Especialidad {
    private int id;
    private String Descripcion;
    String estado;
    
    public Especialidad(){
       this(0,"","");
    }

    public Especialidad(int id, String Descripcion, String estado) {
        this.id = id;
        this.Descripcion = Descripcion;
        this.estado = estado;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

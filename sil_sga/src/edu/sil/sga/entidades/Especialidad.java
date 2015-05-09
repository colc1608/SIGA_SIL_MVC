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
public class Especialidad {
    private int id;
    private String Descripcion;
    
    public Especialidad(){
       this(0,"");
    }
    
    public Especialidad(int id, String Descripcion){
        this.id=id;
        this.Descripcion=Descripcion;
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
}

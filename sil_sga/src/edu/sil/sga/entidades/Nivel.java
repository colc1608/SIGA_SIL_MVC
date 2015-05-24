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
public class Nivel {
    int id;
    String nombreCorto;
    String nombreLargo;
    String estado;

    
    public Nivel(){
       this(0,"","","");
    }
    
    
    public Nivel(int id, String nombreCorto, String nombreLargo, String estado) {
        this.id = id;
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
        this.estado = estado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}

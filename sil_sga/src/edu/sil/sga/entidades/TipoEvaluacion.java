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
public class TipoEvaluacion {
    
    int id;
    String descripcion;
    Double peso;
    String observacion;
    String estado;
    
    
    public TipoEvaluacion(){
       this(0,"",0.0,"","");
    }

    public TipoEvaluacion(int id, String descripcion, Double peso, String observacion, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.observacion = observacion;
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
    

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
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

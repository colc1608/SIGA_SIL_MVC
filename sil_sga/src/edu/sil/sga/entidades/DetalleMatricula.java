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
public class DetalleMatricula {
    int id;
    Matricula matricula;
    Clase clase;

    
    
    public DetalleMatricula(){
        this(0,new Matricula(),new Clase());
    }
    
    
    
    public DetalleMatricula(int id, Matricula matricula, Clase clase) {
        this.id = id;
        this.matricula = matricula;
        this.clase = clase;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
    
    
    
}

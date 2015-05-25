/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sil.sga.entidades;

/**
 *
 * @author Paul
 */
public class Curso {
    int id;
    String nombreCorto;
    String nombreLargo;
    int horasTecnicas;
    int horasPracticas;
    String descripcion;
    String estado;
    
    public Curso(){
        this(0,"","",0,0,"","");
    }

    public Curso(int id, String nombreCorto, String nombreLargo, int horasTecnicas, int horasPracticas, String descripcion, String estado) {
        this.id = id;
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
        this.horasTecnicas = horasTecnicas;
        this.horasPracticas = horasPracticas;
        this.descripcion = descripcion;
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

    public int getHorasTecnicas() {
        return horasTecnicas;
    }

    public void setHorasTecnicas(int horasTecnicas) {
        this.horasTecnicas = horasTecnicas;
    }

    public int getHorasPracticas() {
        return horasPracticas;
    }

    public void setHorasPracticas(int horasPracticas) {
        this.horasPracticas = horasPracticas;
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

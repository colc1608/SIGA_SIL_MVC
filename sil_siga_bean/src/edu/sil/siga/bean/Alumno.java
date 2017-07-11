/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sil.siga.bean;
import java.util.Date;
/**
 * 
* @author Cesar Lopez
 */
public class Alumno {

    int id;
    String nombre;
    String apellidopaterno;
    String apellidomaterno;
    String dni;
    String telefono;
    String movil;
    Date fechaNacimiento;
    String email;
    String estado;
    Usuario usuario;
    Sexo sexo;
    
    
    

    public Alumno(){
        this(0,"","","","","","",new Date(),"","", new Usuario(), Sexo.MASCULINO);
    }

    public Alumno(int id, String nombre, String apellidopaterno, String apellidomaterno, String dni, String telefono, String movil, Date fechaNacimiento, String email, String estado, Usuario usuario, Sexo sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.dni = dni;
        this.telefono = telefono;
        this.movil = movil;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.estado = estado;
        this.usuario = usuario;
        this.sexo = sexo;
    }

    

    
    public enum Sexo{
        MASCULINO('M'),
        FEMENINO('F');
        
        private final char valorBD;
        
        Sexo(char valorBD){
            this.valorBD = valorBD;
        }
        public char getValorBD(){
            return valorBD;
        }
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
        public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    
}

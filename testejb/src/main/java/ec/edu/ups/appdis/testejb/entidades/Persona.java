/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinic
 */
public class Persona implements Serializable{
    private int id;
    private String cedula;
    private String nombre;
    private List<Telefono> listaTelefonos;

    public Persona() {
    }

    public Persona(int id, String cedula, String nombre, List<Telefono> listaTelefonos) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.listaTelefonos = listaTelefonos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.controler;

import ec.edu.ups.appdis.testejb.entidades.Telefono;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Vinicio
 */
@ManagedBean
public class ContactosBean {
    private int id = 100;
    private String cedula = "0105452171";
    private String nombre = "Ricardo jara";
    private List<Telefono> listTelefonos;

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

    public List<Telefono> getListTelefonos() {
        return listTelefonos;
    }

    public void setListTelefonos(List<Telefono> listTelefonos) {
        this.listTelefonos = listTelefonos;
    }
    
    public String guardarDatos(){
        System.out.println(toString());
        return null;
    }

    @Override
    public String toString() {
        return "ContactosBean{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", listTelefonos=" + listTelefonos + '}';
    }
    
    
}

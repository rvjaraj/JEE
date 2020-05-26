/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicio
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id")})

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "cedula")
    private String cedula;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId", fetch = FetchType.EAGER)
    private List<Telefono> listTelefonos;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(String cedula, String nombre) {
        
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Persona(Integer id, String cedula, String nombre, List<Telefono> telefonoCollection) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.listTelefonos = telefonoCollection;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void addTelefono(Telefono t){
        if(listTelefonos == null)
            listTelefonos = new ArrayList<>();
        listTelefonos.add(t);
    }

    @Override
    public String toString() {
        return "ec.edu.ups.appdis.testejb.entidades.Persona[ id=" + id + " ]";
    }
    
}

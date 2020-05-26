/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.controler;

import ec.edu.ups.appdis.testejb.business.ContactosON;
import ec.edu.ups.appdis.testejb.business.ContactosONLocal;
import ec.edu.ups.appdis.testejb.entidades.Telefono;
import ec.edu.ups.appdis.testejb.entidades.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Vinicio
 */
@ManagedBean
@ViewScoped
public class ContactosBean {

    @Inject
    private ContactosONLocal on;

    private List<Persona> listaPersonas;
    
    private Persona newPersona;
    
    private Persona personaAux;
    
    @PostConstruct
    public void init() {
        newPersona = new Persona();
        newPersona.addTelefono(new Telefono());
        loadDataPersona();
        System.out.println("acacacacaca");
    }

    public Persona getPersonaAux() {
        return personaAux;
    }

    public void setPersonaAux(Persona personaAux) {
        this.personaAux = personaAux;
    }

    
    
    public Persona getNewPersona() {
        return newPersona;
    }

    public void setNewPersona(Persona newPersona) {
        this.newPersona = newPersona;
    }

    public ContactosONLocal getOn() {
        return on;
    }

    public void setOn(ContactosONLocal on) {
        this.on = on;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    

    public String guardarDatos() {

        try {
            newPersona.getListTelefonos().forEach((t) -> t.setPersonaId(newPersona));
            on.guardadoContacto(newPersona);
            listaPersonas = on.listarContactos();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " >>>>>>>>>>>>>>>>>>>");
        }

        return null;
    }

    private void loadDataPersona() {
        try {
            listaPersonas = on.listarContactos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public  String addTelefono() {
      newPersona.addTelefono(new Telefono());
      return null;
    }
    
    public  String addTelefono1() {
      personaAux.addTelefono(new Telefono());
      return null;
    }

    @Override
    public String toString() {
        return "ContactosBean{" + "on=" + on + ", listaPersonas=" + listaPersonas + ", newPersona=" + newPersona + '}';
    }
    
    
    public String editarContacto(String cedula){
        try{
        personaAux = on.buscarPersonaCedula(cedula);
            System.out.println(personaAux.getNombre() + ">>>>>>>>>>>>>>");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public String updatePersona(){
        try {
            personaAux.getListTelefonos().forEach((t) -> t.setPersonaId(personaAux));
            on.actualizarContacto(personaAux);
            init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

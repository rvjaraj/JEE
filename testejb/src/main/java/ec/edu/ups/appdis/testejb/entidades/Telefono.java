/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.entidades;

import java.io.Serializable;

/**
 *
 * @author vinic
 */
public class Telefono implements Serializable{
    private int id;
    private String  numero;
    private String tipo;    
    private int persona_id;

    public Telefono() {
    }

    public Telefono(int id, String nombre, String tipo, int persona_id) {
        this.id = id;
        this.numero = nombre;
        this.tipo = tipo;
        this.persona_id = persona_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
            
}

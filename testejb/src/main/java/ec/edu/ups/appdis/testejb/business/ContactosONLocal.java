/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.business;


import ec.edu.ups.appdis.testejb.entidades.Persona;
import ec.edu.ups.appdis.testejb.entidades.Telefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vinic
 */
@Local
public interface ContactosONLocal {
    
    public boolean guardadoContacto(Persona persona) throws Exception;

    public List<Persona> listarContactos() throws Exception;

    public List<Telefono> listarTelefonos(int id) throws Exception;

    public Persona buscarPersonaCedula(String cedula) throws Exception;

    public void eliminarPersona(Persona p) throws Exception;

    public void eliminarTelefono(int id) throws Exception;

    public void actualizarContacto(Persona persona) throws Exception;

    public boolean validarCedula(String ced) throws Exception;

}

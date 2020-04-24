/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.business;

import ec.edu.ups.appdis.testejb.dao.PersonaDAO;
import ec.edu.ups.appdis.testejb.dao.TelefonoDAO;
import ec.edu.ups.appdis.testejb.entidades.Persona;
import ec.edu.ups.appdis.testejb.entidades.Telefono;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author vinic
 */
@Stateless
public class ContactosON implements ContactosONRemote, ContactosONLocal {
    @Inject
    PersonaDAO personaDAO ;
    @Inject
    TelefonoDAO telefonoDAO;

    public ContactosON() {
    }

    @Override
    public boolean guardadoContacto(Persona persona) throws Exception {
        if (validarCedula(persona.getCedula())) {
            try {
                personaDAO.ingresar(persona);
                int maxId = personaDAO.maxId();
                if (maxId != 0) {
                    List<Telefono> listaTelefonos = persona.getListaTelefonos();
                    for (Telefono t : listaTelefonos) {
                        t.setPersona_id(maxId);
                        telefonoDAO.ingresar(t);
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        } else {
            throw new Exception("Cedula Incorrecta");
        }

        return true;
    }

    @Override
    public List<Persona> listarContactos() throws Exception {
        try {
            System.out.println("this is site");
           // PersonaDAO p = new PersonaDAO();
            return personaDAO.listar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Telefono> listarTelefonos(int id) throws Exception {
        try {
            return telefonoDAO.listar(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Persona buscarPersonaCedula(String cedula) throws Exception {
        try {
            return personaDAO.buscarCedula(cedula);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void eliminarPersona(Persona p) throws Exception {
        try {
            List<Telefono> lista = p.getListaTelefonos();
            for (Telefono t : lista) {
                eliminarTelefono(t.getId());
            }
            personaDAO.eliminar(p.getId());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void eliminarTelefono(int id) throws Exception {
        try {
            telefonoDAO.eliminar(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void actualizarContacto(Persona persona) throws Exception {
        try {
            personaDAO.actualizar(persona);
            List<Telefono> listPersonas = persona.getListaTelefonos();
            for (Telefono list : listPersonas) {
                telefonoDAO.actualizar(list);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean validarCedula(String ced) {
        boolean verdadera = false;
        int num = 0;
        int ope = 0;
        int suma = 0;
        for (int cont = 0; cont < ced.length(); cont++) {
            num = Integer.valueOf(ced.substring(cont, cont + 1));
            if (cont == ced.length() - 1) {
                break;
            }
            if (cont % 2 != 0 && cont > 0) {
                suma = suma + num;
            } else {
                ope = num * 2;
                if (ope > 9) {
                    ope = ope - 9;
                }
                suma = suma + ope;
            }
        }
        if (suma != 0) {
            suma = suma % 10;
            if (suma == 0) {
                if (suma == num) {
                    verdadera = true;
                }
            } else {
                ope = 10 - suma;
                if (ope == num) {
                    verdadera = true;
                }
            }
        } else {
            verdadera = false;
        }
        return verdadera;
    }

}

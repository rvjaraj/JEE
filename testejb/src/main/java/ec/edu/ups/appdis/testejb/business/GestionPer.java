/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.business;

import ec.edu.ups.appdis.testejb.dao.PerDao;
import ec.edu.ups.appdis.testejb.entidades.Per;
import ec.edu.ups.appdis.testejb.entidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Vinicio
 */
@Stateless
public class GestionPer {

    @Inject
    private PerDao dao;

    public void guardarContacto(Per p) {
        Per per = dao.read(p.getCedula());
        if (per == null) {
            dao.insert(p);
        }else{
            p.setEdad(p.getEdad()+10);
            dao.update(p);
        }
    }

    public List<Per> listarCotacts() {
        return dao.findAll("%");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.dao;

import ec.edu.ups.appdis.testejb.entidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ricardo
 */
@Stateless
public class PersonaDAO {

    @PersistenceContext(name="testjpaPersistenceUnit")
    private EntityManager em;

    public PersonaDAO() {
    }
    
    
    public void insert(Persona persona) throws Exception {
        try {
            System.out.println("si creo que llega aca");
            em.persist(persona);
        } catch (Exception e) {
            throw new Exception("Erro ingreso Persona " + e.getMessage());
        }
    }

    public void delete(Persona persona) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(persona.getId()));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Persona " +e.getMessage());
        }
    }

    public void deleteId(int id) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(id));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Persona " +e.getMessage());
        }
    }
    
    public void update(Persona persona) throws Exception {
        try {
            em.merge(persona);
        } catch (Exception e) {
            throw new Exception("Erro actualizar Persona " +e.getMessage());
        }
    }

    public Persona read(int id) throws Exception {
        try {
            return em.find(Persona.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer Persona " +e.getMessage());
        }
    }

    public List<Persona> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Persona.findAll");
            List<Persona> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Persona " +e.getMessage());
        }

    }

    public Persona findByCedula(String cedula) throws Exception {
        try {
            String jpql = "SELECT P FROM Persona p "
                    + "WHERE cedula = :cedula";
            Query q = em.createQuery(jpql, Persona.class);
            q.setParameter("cedula", cedula);

            return (Persona) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  cedula");
        }

    }

    public int maxId() throws Exception {
        try {
            String jpql = "SELECT P FROM Persona p "
                    + "WHERE cedula = :cedula";
            Query q = em.createQuery(jpql, Persona.class);
            return (int) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error MaxID", e.getCause());
        }
    }

}

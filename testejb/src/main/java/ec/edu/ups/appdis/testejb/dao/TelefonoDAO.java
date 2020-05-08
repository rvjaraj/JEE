/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.dao;


import ec.edu.ups.appdis.testejb.entidades.Telefono;
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
public class TelefonoDAO {

    @PersistenceContext(name="testjpaPersistenceUnit")
    private EntityManager em;

    public TelefonoDAO() {
    }
    
    public void insert(Telefono telefono) throws Exception {
        try {
            em.persist(telefono);
        } catch (Exception e) {
            throw new Exception("Erro ingreso telefono", e);
        }
    }

    public void delete(int id) throws Exception {
        try {
            em.remove(id);
        } catch (Exception e) {
            throw new Exception("Erro Eliminar telefono", e);
        }
    }

    public void update(Telefono telefono) throws Exception {
        try {
            em.merge(telefono);
        } catch (Exception e) {
            throw new Exception("Erro actualizar telefono", e);
        }
    }

    public Telefono read(int id) throws Exception {
        try {
            return em.find(Telefono.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer telefono");
        }
    }

    public List<Telefono> findAll() throws Exception {

        try {
            String jpql = "SELECT P FROM telefono p ";
            Query q = em.createQuery(jpql, Telefono.class);
            return q.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro listar Telefono");
        }

    }
    
    public List<Telefono> findByPersona(int id) throws Exception {

        try {
            Query q = em.createNamedQuery("Telefono.findByPersona");
            q.setParameter("id", id);
            return q.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro listar Telefono /n" +e.getMessage());
        }

    }

    public Telefono findByNumero(String numero) throws Exception {
        try {
            String jpql = "SELECT P FROM telefono p "
                    + "WHERE numero = :cedula";
            Query q = em.createQuery(jpql, Telefono.class);
            q.setParameter("cedula", numero);

            return (Telefono) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  numero");
        }

    }

   
}
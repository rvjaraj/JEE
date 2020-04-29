/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.dao;

import ec.edu.ups.appdis.testejb.entidades.Per;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Vinicio
 */
@Stateless
public class PerDao {
    
    // Mas de una @PersistenceContext(name="testjpaPersistenceUnit")
    @PersistenceContext
    private EntityManager em;
    
    
    public void insert(Per Per){
        em.persist(Per);
    }
    
    public void update(Per Per){
        em.merge(Per);
    }
    
    
    public Per read(String cedula){
        return  em.find(Per.class, cedula);
    }
    
    public void delete(String cedula){
        em.remove(read(cedula));
    }
   
    public List<Per> findAll(String filtro){
        String jpql = "SELECT P FROM Per p "
                + "WHERE nombre LIKE :filtro";
        Query q = em.createQuery(jpql, Per.class);
        q.setParameter("filtro", filtro + "%");
        
        return q.getResultList();
    }
    
}

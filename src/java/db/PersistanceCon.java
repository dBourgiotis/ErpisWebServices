/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dimbourgiotis
 */
public class PersistanceCon {
    
    public void loadAppointments(){
        List <AppointmentForm> list ;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        em.getTransaction().commit();
        em.close();
    }
    
    public void saveAppointments(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        em.getTransaction().commit();
        em.close();
    }
    
    public void changeAppointment(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        em.getTransaction().commit();
        em.close();
    }
    
    public void authUsername(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        em.getTransaction().commit();
        em.close();
    }
    
    public void authPassword(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        em.getTransaction().commit();
        em.close();
    }
}

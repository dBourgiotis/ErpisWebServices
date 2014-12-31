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
import javax.persistence.Query;

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
    
    
    
    public User authCredentials(String password,String username){
         List <User> list ;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        Query q = em.createQuery("select id from User u where u.password = :password and u.fullName = :name");
        q.setParameter("password", password);
        q.setParameter("name", username);
        list= q.getResultList();
        em.getTransaction().commit();
        em.close();
        
        if(list.isEmpty()){
            return null; // an den mporoume na xeiristoume to null 8a to kanw string anti gia user 
        } 
        else{
            User u = list.get(0);
            return u;
        }
        
    }
}

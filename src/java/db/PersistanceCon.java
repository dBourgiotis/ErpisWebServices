/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Date;
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
    
    public List <AppointmentForm> loadAppointments(){
        List <AppointmentForm> list ;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        Query q = em.createQuery("select * from AppointmentForm");
        
        list= q.getResultList();
        
        em.getTransaction().commit();
        em.close();
        
        return list;
    }
    
    public void saveAppointments(int amka,String fullname, Date date, String emerReason, String examination,User user ){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        AppointmentForm ap = new AppointmentForm();
        ap.setAmka(amka);
        ap.setDate(date);
        ap.setEmergencyReason(emerReason);
        ap.setExamination(examination);
        ap.setFullName(fullname);
        ap.setUser(user);
        em.persist(ap);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void changeAppointment(AppointmentForm ap, Date date){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        AppointmentForm myAp = em.getReference(AppointmentForm.class, ap.appointmentFormPK);
        myAp.setDate(date);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    
    
    public User authCredentials(String password,String username){
         List <User> list ;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //todo
        Query q = em.createQuery("select * from User u where u.password = :password and u.fullName = :name");
        q.setParameter("password", password);
        q.setParameter("name", username);
        list= q.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        if(list.isEmpty()){
            return null; // an den mporoume na xeiristoume to null 8a to kanw string anti gia user 
        } 
        else{
            User u = list.get(0);
            return u;
        }
        
    }
}

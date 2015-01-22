/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author dimbourgiotis
 */
@WebService
public class WsMan {
 
    public boolean schedApp(String firstName,String lastName, String insurance, String amka, String examination,int userid ){
      
        Citizen citizen = new Citizen(
            firstName,
            lastName,
            insurance,
            Integer.parseInt(amka)
        );

        Manager manager = new Manager();
        if (!manager.citizenConfig(citizen)) {
            System.out.println("Citizen does not exist");
            return false;
        }

        // Create appointment
        Appointment appointment = new Appointment(
            citizen.getFullName(),
            citizen.getInsuranceName(),
            userid,
            citizen.getAmka(),
            examination
        );
        
        manager = new Manager();
        manager.saveAppointment(appointment);
        
        return true;
    }
    
     public boolean logInExist (String name, String password) {

        Manager manager = new Manager();

        // Connect to the database and check if user exists
        Boolean exists = manager.checkUser(
            name,
            password
        );

        if (!exists)
            return false;

        // Save username to session so that we know
        // if a user has already logged in
        
        manager = new Manager();
        User user = manager.getUser(password);
        
        user.getRole();
        user.getId();
        
        return true;
    }
     
    public int returnId (String name, String password) {

        
        
        Manager manager = new Manager();
        User user = manager.getUser(password);
        
        
        
        return user.getId();
    } 
    
    public String returnRole (String name, String password) {

        
        
        Manager manager = new Manager();
        User user = manager.getUser(password);
        
        
        
        return user.getRole();
    } 
    
    public boolean crUser(String firstName,String lastName, String password,String insurance, String amka){
        Citizen citizen = new Citizen(
            firstName,
            lastName,
            insurance,
            Integer.parseInt(amka)
        );

        Manager manager = new Manager();
        if (!manager.citizenConfig(citizen)) {
            System.out.println("Citizen does not exist");
            return false;
        }
        manager = new Manager();
        User u = new User();
        u.setPassword(password);
        u.setRole("Citizen");
        u.setUname(firstName+" "+lastName);
        manager.createUser(u);
        return true;
    }
    
    public boolean addSub(String mail){
        Manager m = new Manager();
        m.addSubscriber(mail);
        return true;
    }
    
    public List<InformationMeeting> loadMeet(){
        List <InformationMeeting> list = new ArrayList<InformationMeeting>();
        Manager m = new Manager();
        list=m.loadMeetings();
        return list;
    }
}

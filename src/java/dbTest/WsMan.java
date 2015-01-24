/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

import java.sql.Timestamp;
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
    
    public String loadMeet(){
        List <InformationMeeting> ls = new ArrayList<InformationMeeting>();
        Manager m = new Manager();
        ls=m.loadMeetings();
        String rxml= new String();
        rxml+="<informationmeetings>";
        for (int i = 0; i < ls.size(); ++i){
            rxml+="<informationmeeting>";
            rxml+="<name>"+ls.get(i).getName()+"</name>";            
            rxml+="<id>"+ls.get(i).getId()+"</id>";
            rxml+="<place>"+ls.get(i).getPlace()+"</place>";
            rxml+="<date>"+ls.get(i).getDate() + "</date>";
            rxml+="<description>"+ls.get(i).getDescription()+"</description>";
            rxml+="</informationmeeting>";
        }
        rxml+="</informationmeetings>";
        return rxml;
    }
    
    public boolean addEm(int ap_id, String rsn, long dt){
        Manager m = new Manager();

                 if(m.existAp(ap_id)){
                     m = new Manager();
                     m.addEmergency(ap_id, rsn, new Timestamp(dt));
                     return true;
                 }else{
                     return false;
                 }
        
    }
    
    public String loadApps(int amka){
        Manager m = new Manager();
        List <Appointment> ls = m.loadUserApps(amka);
        String rxml= new String();
        rxml+="<appointments>";
        for (int i = 0; i < ls.size(); ++i){
            rxml+="<appointment>";
            rxml+="<fullname>"+ls.get(i).getFullName()+"</fullname>";
            rxml+="<insurance_name>"+ls.get(i).getInsuranceName()+"</insurance_name>";
            rxml+="<id>"+ls.get(i).getId()+"</id>";
            rxml+="<userid>"+ls.get(i).getUserId()+"</userid>";
            rxml+="<amka>"+ls.get(i).getAmka()+"</amka>";
            rxml+="<emergency_reason>"+ls.get(i).getEmergencyReason()+"</emergency_reason>";
            rxml+="<examination>"+ls.get(i).getExamination()+"</examination>";
            rxml+="<date>"+ls.get(i).getDateTimestamp() + "</date>";
            rxml+="<emergency_date>"+ls.get(i).getEmergencyDateTimestamp()+"</emergency_date>";
            rxml+="<medical_office>"+ls.get(i).getMedicalOffice()+"</medical_office>";
            rxml+="</appointment>";
        }
        rxml+="</appointments>";
        return rxml;
    }
 
    public int getAmka(String name){
        Manager m = new Manager();
        int x=m.returnAmka(name);
        return x;
    }
}

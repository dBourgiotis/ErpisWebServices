/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Timestamp;

import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author it21221
 */
public class Manager {
    
    private Connection connection;

         

    public Manager() {

            connection = Database.getConnection();

    }
            public boolean checkUser(String fname, String pasw) {

            try {

                PreparedStatement ps = connection.prepareStatement("select id from User where FullName = ? and Password = ?");

                ps.setString(1, fname);
                ps.setString(2, pasw);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) // found

                {
                   connection.close();
                   System.out.println("Found");
                   return true;

                } else {
                   connection.close();
                   System.out.println("Not Found"); 
                   return false ; 

                }

            } catch (Exception ex) {

                System.out.println("Error in check() -->" + ex.getMessage());

            }
           
             System.out.println("Error yolo");
            return false;

        }    
        
        public void saveAppointment(Appointment ap){
            try {

                PreparedStatement ps = connection.prepareStatement("Insert into AppointmentForm (amka,FullName,Date,InsuranceName,Examination,user_id,MedicalOffice) Values (?,?,?,?,?,?,?)");
                
                ps.setInt(1, ap.getAmka());
                ps.setString(2, ap.getFullName());
                //ps.setString(3, ap.getEmergencyReason());
                ps.setTimestamp(3, ap.getDate());// (4, (Date) ap.getDate());//upopto
                ps.setString(4, ap.getInsuranceName());
                ps.setString(5, ap.getExamination());
                ps.setInt(6, ap.getUserId());
                ps.setString(7,ap.getMedicalOffice());
                ps.executeUpdate();
                System.out.println("appointment added!");
                
                connection.close();
               

            } catch (Exception ex) {

                System.out.println("Error in check() -->" + ex.getMessage());

            }
                       
         
        }
        
        public void updateAppointment(Appointment ap){
            try {
                PreparedStatement ps = connection.prepareStatement("Update appointmentForm set Date = ? , MedicalOffice = ? where id = ?;  ");
                ps.setTimestamp(1, ap.getDate());//upopto
                ps.setString(2, ap.getMedicalOffice());
                ps.setInt(3,ap.getId());
                ps.executeUpdate();
                System.out.println("appointment updated!");
                connection.close();

            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
        }
        
        
        public void changeAppointment(Appointment ap){
            try {
                PreparedStatement ps = connection.prepareStatement("Update appointmentForm set Date = ? , energencyReason = ? where id = ?;  ");
                ps.setTimestamp(1, ap.getEmergencyDate());//upopto
                ps.setString(2, "none");
                ps.setInt(3,ap.getId());
                ps.executeUpdate();
                System.out.println("appointment changed!");
                connection.close();

            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
            
        }
        
        public List<Appointment>loadAppointments(){
            List<Appointment> apList = new ArrayList<Appointment>();
            try {

                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery("select * from AppointmentForm");

                while (rs.next()) {

                    Appointment ap = new Appointment();

                    ap.setId(rs.getInt("id"));
                    ap.setAmka(rs.getInt("amka")); 
                    ap.setFullName(rs.getString("FullName"));
                    ap.setEmergencyReason(rs.getString("EmergencyReason"));
                    ap.setDate(rs.getTimestamp("Date"));
                    ap.setInsuranceName(rs.getString("InsuranceName"));
                    ap.setExamination(rs.getString("Examination"));
                    ap.setUserId(rs.getInt("user_id"));
                    ap.setEmergencyDate(rs.getTimestamp("EmergencyDate"));
                    ap.setMedicalOffice(rs.getString("MedicalOffice"));
                    
                    apList.add(ap);

                }
                System.out.println("Aplist created");
                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }
            return apList;
        }
        
        public User getUser(String pas){
            User user = new User();

            try {

                PreparedStatement preparedStatement = connection.prepareStatement("select * from User where Password =? ");

                preparedStatement.setString(1, pas);

                ResultSet rs = preparedStatement.executeQuery();

 

                if (rs.next()) {

                    user.setUname(rs.getString("FullName"));
                    user.setId(rs.getInt("id"));
                    user.setRole(rs.getString("Role"));
                    user.setPassword(pas);

                }
                System.out.println("User returned");
                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }

 
            
            return user;
        }
        
        
         public boolean citizenConfig(Citizen ci) {

            try {

                PreparedStatement ps = connection.prepareStatement("select id from Citizen where FullName = ? and amka = ?");

                ps.setString(1, ci.getFullName());
                ps.setInt(2, ci.getAmka());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) // found

                {
                   connection.close();
                   System.out.println("Found");
                   return true;

                } else {
                   connection.close();
                   System.out.println("Not Found"); 
                   return false ; 

                }

            } catch (Exception ex) {

                System.out.println("Error in check() -->" + ex.getMessage());

            }
           
             System.out.println("Error 456735425");
            return false;

        }  
         
         
         public void addEmergency(int id, String reason, Timestamp eDate){
             
             try {
                PreparedStatement ps = connection.prepareStatement("Update appointmentForm set EmergencyDate = ? , EmergencyReason = ? where id = ?;  ");
                ps.setTimestamp(1, eDate);
                ps.setString(2, reason);
                ps.setInt(3,id);
                ps.executeUpdate();
                System.out.println("Emergency reason & date created");
                connection.close();

            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
            
        
             
         }
         
         public boolean existAp(int id){
             
            try {
                PreparedStatement ps = connection.prepareStatement("select * from AppointmentForm where id = ? ");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException ex) {
                 System.out.println("Error in check() -->" + ex.getMessage());
            }
                                
            return false;   
        }
         
         public Appointment returnAp(int id){
             Appointment ap = new Appointment();
             
             try {

                PreparedStatement ps = connection.prepareStatement("select * from AppointmentForm where id = ? ");
                                
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()) {
                    

                    ap.setAmka(rs.getInt("amka")); 

                    ap.setDate(rs.getTimestamp("Date"));
                    
                    ap.setEmergencyReason(rs.getString("EmergencyReason"));
                    
                    ap.setExamination(rs.getString("Examination"));
                    
                    ap.setFullName(rs.getString("FullName"));
                    
                    ap.setId(rs.getInt("id"));
                    
                    ap.setUserId(rs.getInt("user_id"));
                    
                    ap.setInsuranceName(rs.getString("InsuranceName"));
                     
                    ap.setEmergencyDate(rs.getTimestamp("EmergencyDate"));
                 
                    ap.setMedicalOffice(rs.getString("MedicalOffice"));

                }
                System.out.println("Ap returned");
                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }
             
             return ap;
         }
    
        public List <String> generatePlaces(){
            List <String> places = new ArrayList<String>();
            try {
                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery("select Name from MedicalOffice");

                while (rs.next()) {
                    places.add(rs.getString("Name"));
                }
                connection.close();

            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
            
            return places;
        } 
        
        public void createUser(User u){
        
            try {
                PreparedStatement ps = connection.prepareStatement("Insert into User (Role,FullName,Password) Values (?,?,?)");
                ps.setString(1,u.getRole());
                ps.setString(2, u.getUname());
                ps.setString(3,u.getPassword() );
                ps.executeUpdate();
                connection.close();
                System.out.println("User Created");
            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
        }
        
        public void changeUsersRole(int id, String newRole){
            try {
                PreparedStatement ps = connection.prepareStatement("Update User set Role = ? where id = ?;  ");
                ps.setString(1,newRole);
                ps.setInt(2, id);
                ps.executeUpdate();
                System.out.println("User changed!");
                connection.close();

            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
            
        
        }
        
        public void deleteUser(int id){
            try {
                PreparedStatement ps = connection.prepareStatement("Delete from User  where id = ?;  ");
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("User deleted!");
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
        }
        
        public int findId(){
            int id=-1;
             try {
                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery("select max(Id) from MedicalOffice");

                while (rs.next()) {
                    id=rs.getInt("max(Id)");
                }
                connection.close();

            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
            return id;
        }
        
        public List<User> loadUsers(){
            List <User> ulist = new ArrayList <User>();
            
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from User");
                while(rs.next()){
                    User mu = new User();
                    mu.setId(rs.getInt("Id"));
                    mu.setPassword(rs.getString("Password"));
                    mu.setRole(rs.getString("Role"));
                    mu.setUname(rs.getString("FullName"));
                    ulist.add(mu);
                }
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
            
            
            return ulist;
        }
        
}

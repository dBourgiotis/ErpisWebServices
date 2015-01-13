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

                PreparedStatement ps = connection.prepareStatement("Insert into AppointmentForm (amka,FullName,EmergencyReason,Date,InsuranceName,Examination,user_id) Values (?,?,?,?,?,?,?)");
                
                ps.setInt(1, ap.getAmka());
                ps.setString(2, ap.getFullName());
                ps.setString(3, ap.getEmergencyReason());
                ps.setDate(4, (Date) ap.getDate());//upopto
                ps.setString(5, ap.getInsuranceName());
                ps.setString(6, ap.getExamination());
                ps.setInt(7, ap.getUserId());
                ps.executeUpdate();
                System.out.println("appointment added!");
                
                connection.close();
               

            } catch (Exception ex) {

                System.out.println("Error in check() -->" + ex.getMessage());

            }
                       
         
        }
        
        public void changeAppointment(Appointment ap){
            try {
                PreparedStatement ps = connection.prepareStatement("Update appointmentForm set Date = ? , energencyReason = ? where id = ?;  ");
                ps.setDate(1, (Date) ap.getEmergencyDate());//upopto
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

                    ap.setAmka(rs.getInt("amka")); 

                    ap.setDate(rs.getDate("Date"));
                    
                    ap.setEmergencyReason(rs.getString("EmergencyReason"));
                    
                    ap.setExamination(rs.getString("Examination"));
                    
                    ap.setFullName(rs.getString("FullName"));
                    
                    ap.setId(rs.getInt("id"));
                    
                    ap.setUserId(rs.getInt("user_id"));
                    
                    ap.setInsuranceName(rs.getString("InsuranceName"));
                     
                    ap.setEmergencyDate(rs.getDate("EmergencyDate"));
                    
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
         
         
         public void addEmergency(int id, String reason, Date eDate){
             
             try {
                PreparedStatement ps = connection.prepareStatement("Update appointmentForm set EmergencyDate = ? , EmergencyReason = ? where id = ?;  ");
                ps.setDate(1, eDate);
                ps.setString(2, reason);
                ps.setInt(3,id);
                ps.executeUpdate();
                System.out.println("Emergency reason & date created");
                connection.close();

            } catch (SQLException ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
            
        
             
         }
         
         public Appointment returnAp(int id){
             Appointment ap = new Appointment();
             
             try {

                PreparedStatement ps = connection.prepareStatement("select * from AppointmentForm where id = ? ");
                                
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()) {
                    

                    ap.setAmka(rs.getInt("amka")); 

                    ap.setDate(rs.getDate("Date"));
                    
                    ap.setEmergencyReason(rs.getString("EmergencyReason"));
                    
                    ap.setExamination(rs.getString("Examination"));
                    
                    ap.setFullName(rs.getString("FullName"));
                    
                    ap.setId(rs.getInt("id"));
                    
                    ap.setUserId(rs.getInt("user_id"));
                    
                    ap.setInsuranceName(rs.getString("InsuranceName"));
                     
                    ap.setEmergencyDate(rs.getDate("EmergencyDate"));
                 
                 

                }
                System.out.println("Ap returned");
                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }
             
             return ap;
         }
        
}

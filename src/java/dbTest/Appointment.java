/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Date;
import javax.jws.WebService;

import javax.validation.constraints.*;

@WebService
public class Appointment {
    
     private String fullName;

     private String insuranceName;

     private int id;
     
     private int userId;

     private int amka;
     
     private String emergencyReason;
     
     private String examination;
     
     private Timestamp date;
     
     private Timestamp emergencyDate;
     
     private String MedicalOffice;
    public Appointment () {}
    public Appointment(String fullName, String insuranceName, int userId, int amka, String examination) {
        this.fullName = fullName;
        this.insuranceName = insuranceName;
        this.userId = userId;
        this.amka = amka;
        this.examination = examination;
    }

    public String getMedicalOffice() {
        return MedicalOffice;
    }

    public void setMedicalOffice(String MedicalOffice) {
        this.MedicalOffice = MedicalOffice;
    }
     
     
    public long getEmergencyDateTimestamp () {
        try {
            return emergencyDate.getTime();
        } catch (Exception e) {
            return 0;
        }
    }
    
    public Timestamp getEmergencyDate() {
        return emergencyDate;
    }

    public void setEmergencyDate(Timestamp emergencyDate) {
        this.emergencyDate = emergencyDate;
    }
              

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    public String getEmergencyReason() {
        return emergencyReason;
    }

    public void setEmergencyReason(String emergencyReason) {
        this.emergencyReason = emergencyReason;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public Timestamp getDate() {
        return date;
    }
    
    public long getDateTimestamp () {
        try {
            return date.getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
     
     
    
}

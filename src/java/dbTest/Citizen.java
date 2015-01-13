/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

/**
 *
 * @author it21221
 */
public class Citizen {
    
        private String fullName;

        private String insuranceName;

        private String id;

        private int amka;

    public Citizen (String firstName, String lastName, String insuranceName, int amka) {
        setFullName(firstName + " " + lastName);
        setInsuranceName(insuranceName);
        setAmka(amka);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }
        
        
}

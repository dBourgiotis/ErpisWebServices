/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dimbourgiotis
 */
@Entity
@Table(name = "Citizen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citizen.findAll", query = "SELECT c FROM Citizen c"),
    @NamedQuery(name = "Citizen.findByAmka", query = "SELECT c FROM Citizen c WHERE c.amka = :amka"),
    @NamedQuery(name = "Citizen.findByInsuranceName", query = "SELECT c FROM Citizen c WHERE c.insuranceName = :insuranceName"),
    @NamedQuery(name = "Citizen.findById", query = "SELECT c FROM Citizen c WHERE c.id = :id"),
    @NamedQuery(name = "Citizen.findByFullName", query = "SELECT c FROM Citizen c WHERE c.fullName = :fullName")})
public class Citizen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMKA")
    private Integer amka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Insurance Name")
    private String insuranceName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Full Name")
    private String fullName;

    public Citizen() {
    }

    public Citizen(Integer amka) {
        this.amka = amka;
    }

    public Citizen(Integer amka, String insuranceName, String id, String fullName) {
        this.amka = amka;
        this.insuranceName = insuranceName;
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getAmka() {
        return amka;
    }

    public void setAmka(Integer amka) {
        this.amka = amka;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amka != null ? amka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citizen)) {
            return false;
        }
        Citizen other = (Citizen) object;
        if ((this.amka == null && other.amka != null) || (this.amka != null && !this.amka.equals(other.amka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Citizen[ amka=" + amka + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dimbourgiotis
 */
@Entity
@Table(name = "Appointment Form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppointmentForm.findAll", query = "SELECT a FROM AppointmentForm a"),
    @NamedQuery(name = "AppointmentForm.findById", query = "SELECT a FROM AppointmentForm a WHERE a.appointmentFormPK.id = :id"),
    @NamedQuery(name = "AppointmentForm.findByAmka", query = "SELECT a FROM AppointmentForm a WHERE a.amka = :amka"),
    @NamedQuery(name = "AppointmentForm.findByFullName", query = "SELECT a FROM AppointmentForm a WHERE a.fullName = :fullName"),
    @NamedQuery(name = "AppointmentForm.findByEmergencyReason", query = "SELECT a FROM AppointmentForm a WHERE a.emergencyReason = :emergencyReason"),
    @NamedQuery(name = "AppointmentForm.findByDate", query = "SELECT a FROM AppointmentForm a WHERE a.date = :date"),
    @NamedQuery(name = "AppointmentForm.findByInsuranceName", query = "SELECT a FROM AppointmentForm a WHERE a.insuranceName = :insuranceName"),
    @NamedQuery(name = "AppointmentForm.findByExamination", query = "SELECT a FROM AppointmentForm a WHERE a.examination = :examination"),
    @NamedQuery(name = "AppointmentForm.findByUserId", query = "SELECT a FROM AppointmentForm a WHERE a.appointmentFormPK.userId = :userId")})
public class AppointmentForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppointmentFormPK appointmentFormPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMKA")
    private int amka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Full Name")
    private String fullName;
    @Size(max = 45)
    @Column(name = "Emergency Reason")
    private String emergencyReason;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Insurance Name")
    private String insuranceName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Examination")
    private String examination;
    @JoinColumn(name = "User_Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public AppointmentForm() {
    }

    public AppointmentForm(AppointmentFormPK appointmentFormPK) {
        this.appointmentFormPK = appointmentFormPK;
    }

    public AppointmentForm(AppointmentFormPK appointmentFormPK, int amka, String fullName, Date date, String insuranceName, String examination) {
        this.appointmentFormPK = appointmentFormPK;
        this.amka = amka;
        this.fullName = fullName;
        this.date = date;
        this.insuranceName = insuranceName;
        this.examination = examination;
    }

    public AppointmentForm(int id, int userId) {
        this.appointmentFormPK = new AppointmentFormPK(id, userId);
    }

    public AppointmentFormPK getAppointmentFormPK() {
        return appointmentFormPK;
    }

    public void setAppointmentFormPK(AppointmentFormPK appointmentFormPK) {
        this.appointmentFormPK = appointmentFormPK;
    }

    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmergencyReason() {
        return emergencyReason;
    }

    public void setEmergencyReason(String emergencyReason) {
        this.emergencyReason = emergencyReason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentFormPK != null ? appointmentFormPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppointmentForm)) {
            return false;
        }
        AppointmentForm other = (AppointmentForm) object;
        if ((this.appointmentFormPK == null && other.appointmentFormPK != null) || (this.appointmentFormPK != null && !this.appointmentFormPK.equals(other.appointmentFormPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.AppointmentForm[ appointmentFormPK=" + appointmentFormPK + " ]";
    }
    
}

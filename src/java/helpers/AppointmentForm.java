package helpers;

import javax.servlet.http.HttpServletRequest;
import dbTest.Manager;
import dbTest.Appointment;
import dbTest.Citizen;

public class AppointmentForm {
    
    public final static String AMKA = "amka";
    public final static String FIRST_NAME = "first_name";
    public final static String LAST_NAME = "last_name";
    public final static String INSURANCE = "insurance";
    public final static String EXAMINATION = "examination";
    
    
    private String error="";
    
    public String getError() {
        return this.error;
    }
    
    private void setError(String error) {
        this.error = error;
    }
    
    public boolean scheduleAppointment (HttpServletRequest request) {
        
        // Get parameters
        String amka = request.getParameter(AMKA);
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String insurance = request.getParameter(INSURANCE);
        String examination = request.getParameter(EXAMINATION);

        // Validate data
        if (!amka.matches("[0-9]+") || amka.length() < 1) {
            setError("Invalid amka");
            return false;
        }
        if (!firstName.matches("[a-zA-Z]+") || firstName.length() < 1) {
            setError("Invalid first name");
            return false;
        }
        if (!lastName.matches("[a-zA-Z]+") || lastName.length() < 1) {
            setError("Invalid last name");
            return false;
        }
        if (!insurance.matches("[a-zA-Z ]+") || insurance.length() < 1) {
            setError("Invalid insurance company name");
            return false;
        }
        if (!examination.matches("[a-zA-Z ]+") || examination.length() < 1) {
            setError("Invalid examination name");
            return false;
        }

        // Check if citizen exists
        Citizen citizen = new Citizen(
            firstName,
            lastName,
            insurance,
            Integer.parseInt(amka)
        );

        Manager manager = new Manager();
        if (!manager.citizenConfig(citizen)) {
            setError("Citizen does not exist");
            return false;
        }

        // Create appointment
        Appointment appointment = new Appointment(
            citizen.getFullName(),
            citizen.getInsuranceName(),
            Integer.parseInt(request.getAttribute("userid").toString()),
            citizen.getAmka(),
            examination
        );
        
        manager = new Manager();
        manager.saveAppointment(appointment);
        
        return true;
    }
}

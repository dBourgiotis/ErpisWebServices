package helpers;

import javax.servlet.http.HttpServletRequest;
import dbTest.Manager;
import dbTest.User;

public class Appointment {
    
    public final static String AMKA = "amka";
    public final static String FIRST_NAME = "first-name";
    public final static String LAST_NAME = "last-name";
    public final static String INSURANCE = "insurance";
    public final static String EXAMINATION = "examination";
    
    public boolean scheduleAppointment (HttpServletRequest request) {
        
        // Get parameters
        String amka = request.getParameter(AMKA);
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String insurance = request.getParameter(INSURANCE);
        String examination = request.getParameter(EXAMINATION);
        
        // Validate data
        if (!amka.matches("[0-9]+") || amka.length() != 11)
            return false;   
        if (firstName.matches("[a-zA-Z]+") && firstName.length() > 0)
            return false;
        if (lastName.matches("[a-zA-Z]+") && lastName.length() > 0)
            return false;
        if (insurance.matches("[a-zA-Z ]+") && insurance.length() > 0)
            return false;
        if (examination.matches("[a-zA-Z ]+") && examination.length() > 0)
            return false;
        
        // Get first available date from database
        // TODO
        Manager dbCon = new Manager();
        
        // Schedule appointment
        // TODO
        
        return true;
    }
}

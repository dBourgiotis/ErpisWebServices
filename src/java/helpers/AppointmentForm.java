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
    
    public boolean scheduleAppointment (HttpServletRequest request) {
        
        // Get parameters
        int amka = Integer.parseInt(request.getParameter(AMKA));
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String insurance = request.getParameter(INSURANCE);
        String examination = request.getParameter(EXAMINATION);

        // Check if citizen exists
        Citizen citizen = new Citizen(
            firstName,
            lastName,
            insurance,
            amka
        );

        Manager manager = new Manager();
        
        if (!manager.citizenConfig(citizen)) {
            return false;
        }

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

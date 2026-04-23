package logic;

import java.util.Date;
import java.util.List;

public class Dentist extends Person{
    
    private int dentistId;
    private String specialty;
    private List<Appointment> appointmentsList;
    private User aUser;
    private Schedule aSchedule;

    public Dentist() {
    }

    public Dentist(int dentistId, String specialty, List<Appointment> appointmentsList, User aUser, Schedule aSchedule, String id_number, String firstName, String lastName, String phoneNumber, String address, Date birthDate) {
        super(id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.dentistId = dentistId;
        this.specialty = specialty;
        this.appointmentsList = appointmentsList;
        this.aUser = aUser;
        this.aSchedule = aSchedule;
    }

    public int getDentistId() {
        return dentistId;
    }

    public void setDentistId(int dentistId) {
        this.dentistId = dentistId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Appointment> getAppointmentsList() {
        return appointmentsList;
    }

    public void setAppointmentsList(List<Appointment> appointmentsList) {
        this.appointmentsList = appointmentsList;
    }

    public User getaUser() {
        return aUser;
    }

    public void setaUser(User aUser) {
        this.aUser = aUser;
    }

    public Schedule getaSchedule() {
        return aSchedule;
    }

    public void setaSchedule(Schedule aSchedule) {
        this.aSchedule = aSchedule;
    }
    
    
    
}

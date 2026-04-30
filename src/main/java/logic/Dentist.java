package logic;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Dentist extends Person{
    
    //private int dentistId;
    private String specialty;
    @OneToMany(mappedBy="dent")
    private List<Appointment> appointmentsList;
    @OneToOne
    private User aUser;
    @OneToOne
    private Schedule aSchedule;

    public Dentist() {
    }

    public Dentist(String specialty, List<Appointment> appointmentsList, User aUser, Schedule aSchedule, String id_number, String firstName, String lastName, String phoneNumber, String address, Date birthDate) {
        super(id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.specialty = specialty;
        this.appointmentsList = appointmentsList;
        this.aUser = aUser;
        this.aSchedule = aSchedule;
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

package logic;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Patient extends Person implements Serializable{
    
    //private int patientId;
    private boolean hasInsurance;
    private String bloodType;
    @OneToOne
    private Guardian aGuardian;
    @OneToMany(mappedBy="pati")       
    private List<Appointment> appointmentsList;

    public Patient() {
    }

    public Patient(boolean hasInsurance, String bloodType, Guardian aGuardian, List<Appointment> appointmentsList, int personId, String id_number, String firstName, String lastName, String phoneNumber, String address, LocalDate birthDate) {
        super(personId, id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.hasInsurance = hasInsurance;
        this.bloodType = bloodType;
        this.aGuardian = aGuardian;
        this.appointmentsList = appointmentsList;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Guardian getaGuardian() {
        return aGuardian;
    }

    public void setaGuardian(Guardian aGuardian) {
        this.aGuardian = aGuardian;
    }

    public List<Appointment> getAppointmentsList() {
        return appointmentsList;
    }

    public void setAppointmentsList(List<Appointment> appointmentsList) {
        this.appointmentsList = appointmentsList;
    }
    
}

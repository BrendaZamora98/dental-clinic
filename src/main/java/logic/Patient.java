package logic;

import java.util.Date;
import java.util.List;

public class Patient extends Person{
    
    private int patientId;
    private boolean hasInsurance;
    private String bloodType;
    private Guardian aGuardian;
    private List<Appointment> appointmentsList;

    public Patient() {
    }

    public Patient(int patientId, boolean hasInsurance, String bloodType, Guardian aGuardian, List<Appointment> appointmentsList, String id_number, String firstName, String lastName, String phoneNumber, String address, Date birthDate) {
        super(id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.patientId = patientId;
        this.hasInsurance = hasInsurance;
        this.bloodType = bloodType;
        this.aGuardian = aGuardian;
        this.appointmentsList = appointmentsList;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

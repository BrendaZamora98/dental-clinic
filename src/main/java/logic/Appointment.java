package logic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class Appointment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int appointmentId;
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;
    private String appointmentTime;
    private String reason;
    @ManyToOne
    @JoinColumn(name="appointmentId")
    private Dentist dent;
    @JoinColumn(name="appointmentId2")
    private Patient pati;

    public Appointment() {
    }

    public Appointment(int appointmentId, Date appointmentDate, String appointmentTime, String reason) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}

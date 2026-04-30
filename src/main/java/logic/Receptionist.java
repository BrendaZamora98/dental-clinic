package logic;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import java.util.Date;

@Entity
public class Receptionist extends Person{
    
    //private int ReceptionistId;
    private String department;
    @OneToOne
    private User aUser;

    public Receptionist() {
    }

    public Receptionist(String department, User aUser, String id_number, String firstName, String lastName, String phoneNumber, String address, Date birthDate) {
        super(id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.department = department;
        this.aUser = aUser;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User getaUser() {
        return aUser;
    }

    public void setaUser(User aUser) {
        this.aUser = aUser;
    }
    
    
}

package logic;

import java.util.Date;

public class Receptionist extends Person{
    
    private int ReceptionistId;
    private String department;
    private User aUser;

    public Receptionist() {
    }

    public Receptionist(int ReceptionistId, String department, User aUser, String id_number, String firstName, String lastName, String phoneNumber, String address, Date birthDate) {
        super(id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.ReceptionistId = ReceptionistId;
        this.department = department;
        this.aUser = aUser;
    }

    public int getReceptionistId() {
        return ReceptionistId;
    }

    public void setReceptionistId(int ReceptionistId) {
        this.ReceptionistId = ReceptionistId;
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

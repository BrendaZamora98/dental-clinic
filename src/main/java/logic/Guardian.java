package logic;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Guardian extends Person implements Serializable{
    
    //private int guardianId;
    private String guardianType;

    public Guardian() {
    }

    public Guardian(String guardianType, int personId, String id_number, String firstName, String lastName, String phoneNumber, String address, LocalDate birthDate) {
        super(personId, id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.guardianType = guardianType;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }
    
    
}

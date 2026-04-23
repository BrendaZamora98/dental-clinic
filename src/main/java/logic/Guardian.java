package logic;

import java.util.Date;

public class Guardian extends Person{
    
    private int guardianId;
    private String guardianType;

    public Guardian() {
    }

    public Guardian(int guardianId, String guardianType, String id_number, String firstName, String lastName, String phoneNumber, String address, Date birthDate) {
        super(id_number, firstName, lastName, phoneNumber, address, birthDate);
        this.guardianId = guardianId;
        this.guardianType = guardianType;
    }

    public int getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(int guardianId) {
        this.guardianId = guardianId;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }
    
    
}

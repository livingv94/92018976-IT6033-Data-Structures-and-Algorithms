


public class Patient {
    
    private String patientID;
    private String name;
    private String checkInDate;
    private String assignedPersonnel;
    
    
    //constructor that assigns values to all the fields
    public Patient(String patID, String name, String checkIn, String doctor){
        patientID = patID;
        this.name = name;
        checkInDate = checkIn;
        assignedPersonnel = doctor;
    }
    
    // displays Patient information in the user-friendly format 
    @Override
    public String toString(){
       return "\nPatient ID: " + getPatientID() + 
    		   "\nName: " + getName() + 
    		   "\nCheck In Date: " + getCheckInDate() + 
    		   "\nAssigned Medical Personnel: " + getAssignedPersonnel() + "\n"; 
    }


    public String getPatientID() {
        return patientID;
    }


    public String getName() {
        return name;
    }


    public String getCheckInDate() {
        return checkInDate;
    }

    
    public String getAssignedPersonnel() {
        return assignedPersonnel;
    }
}

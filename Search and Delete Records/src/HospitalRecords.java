import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalRecords {
    
    private static ArrayList<Patient> patients = new ArrayList();
    public static Scanner in = new Scanner(System.in);
    public static String input;

    public static void main(String[] args) {

        obtainRecords();

        displayMenus();
    }

    //provides main menu options to the user and obtains user input
    public static void displayMenus(){
     
        while (true){
        System.out.println("Press S for search, Press E for exit\n");
        input = in.nextLine();
        if (input.equals("S")){
            search();
        }
        else if (input.equals("E")) {
                System.out.println("Bye...");
                System.exit(0);
        }
        else
            System.out.println("The command is not recognised. Press S for search and E for exit.");
        }            
    }
    
    //calls appropriate method to search patients from the list by patientID and then allows deleting the record found 
    public static void search(){
        Patient result;
        System.out.println("Enter Patient ID to search\n");
        input = in.nextLine();
        result = searchRecordsByID(input);
        if(result == null){
            System.out.println("The search found no matching patients.");
            return;
        }        
        System.out.println(result.toString());
           
        if (!result.equals(null)){
            System.out.println("Would you like to remove the patient's record(s)?\n Y or N?\n");
            input = in.nextLine();
            if (input.equals("Y")){
                for (int i=0 ; i < patients.size(); i++){
                    if (patients.get(i).getPatientID().equals(result.getPatientID())){
                        patients.remove(i);
                        System.out.println("Record(s) removed successfully");                        
                    }
                }
            }               
            else if (input.equals("N")){
                return;
            }
            else {
                System.out.println("The command is not recognised.");            
            }               
        }
    }
    
    /*gets patient details from the ListOfPatients.txt file to the ArrayList of Patient objects.
    */
    
    public static void obtainRecords(){
        String path = "ListOfPatients.txt";
        LineNumberReader lr = null;
        String[] oneRecord = new String[4];
        Patient pat;
        try {
            FileReader inputStream = new FileReader(path);
            lr = new LineNumberReader(inputStream);
            String str;
            while((str = lr.readLine())!= null) {
            	
                oneRecord = str.split(",");
                pat = new Patient(oneRecord[0], oneRecord[1], oneRecord[2], oneRecord[3]);
                patients.add(pat);
            }            
            System.out.println("**Patients records have been recorded successfully**\n");                
        }
        catch(IOException ioe){
            System.out.println("IOExcception occured");
        }
    }
    
    //allows customer to search patients from the list by patientID
    public static Patient searchRecordsByID(String ID){
        ArrayList<Patient> result = new ArrayList();
        for (Patient p: patients){
            if (p.getPatientID().equals(ID)){
                result.add(p);
            }
        }
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }    
}
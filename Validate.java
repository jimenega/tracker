package tracker;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    private List<String> rawInput;
    private List<String> lastName;
    private String firstName;
    private String email;

    Validate(List<String> rawInput) {
        this.rawInput = rawInput;
        //assign();
    }
    boolean run() {
        if(inputErrorChecks()) {
            assign();
            return true;
        } else {
            List<String> rawCopy = new ArrayList<>(this.rawInput);
            checkCredential(rawCopy);
            return false;
        }
    }
    private void checkCredential(List<String> rawCopy) {
        System.out.println("checkCredentials: Incorrect first or last name or email - note: break this out");
    }
    //fixme - change inputErrorChecks return type to int to indicate to checkCreentials what to check.
    private boolean inputErrorChecks(){
        boolean checksOK = true;
        List<String> rawCopy = new ArrayList<>(this.rawInput);
        if(rawCopy.size() == 1 && !rawCopy.get(0).equalsIgnoreCase("back")) {
            checksOK = false;
            System.out.println("Incorrect credentials");
        } else
        if(rawCopy.size() < 3 ) {
            checksOK = false;
            System.out.println("Incorrect credentials");
        } else
        if(rawCopy.get(0).length() < 2 || rawCopy.get(1).length() < 2 || rawCopy.get(rawCopy.size() - 1).length() < 8) {
            checksOK = false;
            //System.out.println("Incorrect first or last name or email - note: break this out");
        }
        return checksOK;
    }
    private void assign(){
        List<String> rawCopy = new ArrayList<>(this.rawInput);
        int stringIndex = rawCopy.size() - 1;
        firstName = rawCopy.get(0);
        email = rawCopy.get(stringIndex);
        rawCopy.remove(0);
        stringIndex = rawCopy.size() - 1;
        rawCopy.remove(stringIndex);
        lastName = new ArrayList<>(rawCopy);
        System.out.println("name: " + firstName + " last name: " + lastName + " email: " + email);
    }
}
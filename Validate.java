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
    }

    private int inputErrorChecks(){
        int checksOK = 0;
        List<String> rawCopy = new ArrayList<>(this.rawInput);
        if(rawCopy.size() == 1 && !rawCopy.get(0).equalsIgnoreCase("back")) {
            checksOK = 101;
            System.out.println("Error 101: Incorrect credentials");
        } else if(rawCopy.size() < 3 ) {
            checksOK = 102;
            System.out.println("Error 102: Incorrect credentials");
        } else if(rawCopy.get(0).length() < 2 || rawCopy.get(1).length() < 2 || rawCopy.get(rawCopy.size() - 1).length() < 8) {
            checksOK = 103;
            System.out.println("Error 103: Incorrect first or last name or email - note: break this out");
        }
        return checksOK;
    }

    boolean run() {
        int inputErrorCode = inputErrorChecks();
        if(inputErrorCode == 0) {
            assign();
            return true;
        } else {
            List<String> rawCopy = new ArrayList<>(this.rawInput);
            //checkCredential(rawCopy, inputErrorCode);
            System.out.println("Input error code: " + inputErrorCode);
            return false;
        }
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
        new Match(firstName, lastName, email);
    }
}
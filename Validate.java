package tracker;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    private final List<String> rawCopy;
    private List<String> lastName;
    private String firstName;
    private String email;
    private Match match;

    Validate(List<String> rawInput) {
        this.rawCopy = new ArrayList<>(rawInput);
    }

    public String getFirstName() {
        return firstName;
    }

    public List<String> getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    private int inputErrorChecks(){
        int errorCode = 0;
        if(rawCopy.size() == 1 && !rawCopy.get(0).equalsIgnoreCase("back")) {
            errorCode = 101;
            System.out.println("Incorrect credentials.");
        } else if(rawCopy.size() < 3 ) {
            errorCode = 102;
            System.out.println("Error 102: Incorrect credentials.");
        } /*else if(rawCopy.get(0).length() < 2 || rawCopy.get(1).length() < 2 || rawCopy.get(rawCopy.size() - 1).length() < 8) {
            errorCode = 103;
            System.out.println("Error 103: Incorrect first or last name or email - note: break this out");
        }*/
        return errorCode;
    }
    private void assign(){
        int stringIndex = rawCopy.size() - 1;
        firstName = rawCopy.get(0);
        email = rawCopy.get(stringIndex);
        rawCopy.remove(0);
        stringIndex = rawCopy.size() - 1;
        rawCopy.remove(stringIndex);
        lastName = new ArrayList<>(rawCopy);
        //new Match(firstName, lastName, email);
    }

    private boolean validatedResults() {
        boolean results = false;
        if(match.getFirstNameMatches() && match.getLastNameMatches() && match.getEmailMatches()) {
            return true; }
        if(!match.getFirstNameMatches()) System.out.println("Incorrect first name.");
        else if(!match.getLastNameMatches()) System.out.println("Incorrect last name.");
        else if(!match.getEmailMatches()) System.out.println("Incorrect email.");
        return results;
    }

    public boolean run() {
        int errorCode = inputErrorChecks();
        if(errorCode == 0) {
            assign();
            match = new Match(firstName, lastName, email);
            System.out.println("matches: " + match.getFirstNameMatches() + " " + match.getLastNameMatches() + " " + match.getEmailMatches());
            return validatedResults();
        } else {
            //System.out.println("Input error code: " + errorCode);  //Keep this for debugging
            return false;
        }
    }
}
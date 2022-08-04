package tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Match {
    //private String firstName;
    //private List<String> lastName;
    //private String email;
    private boolean fn11;  // -'
    private boolean fn12;  // '-
    private boolean fn13;  // ''
    private boolean fn14;  // --
    private boolean fn2;   // first name
    private boolean em;    // email
    private boolean firstNameMatches;
    private boolean lastNameMatches;
    private boolean emailMatches;

    Match(String firstName, List<String> lastName, String email) {
        //this.firstName = firstName;
        //this.lastName = new ArrayList<>(lastName);
        //this.email = email;
        checkFirstName(firstName);
        checkLastName(lastName);
        checkEmail(email);
        printFinalPatternResults();
    }
    private void printPatternsAssigned(){
        System.out.println("fn11:" + fn11 + "  fn12:" + fn12 + "  fn13:" + fn13
                + "  fn14:" + fn14 + "  fn2:" + fn2);
    }
    private void printEmailPatternsAssigned(){
        System.out.println("email:" + em);
    }

    private void printFinalPatternResults() {
        System.out.println("First Name matches: " + firstNameMatches
                        + " Last Names match: " + lastNameMatches
                        + " Email matches: " + emailMatches);
    }
    private void setNamePattern(String name) {
        fn11 = Pattern.matches(".*[-]['].*", name);  // -'
        fn12 = Pattern.matches(".*['][-].*", name);  // '-
        fn13 = Pattern.matches(".*[']['].*", name);  // ''
        fn14 = Pattern.matches(".*[-][-].*", name);  // --
        fn2 = Pattern.matches("[A-Za-z'//-]*", name);    // first name
    }

    /*private void setLastPattern(String name) {
        fn11 = Pattern.matches(".*[-]['].*", name);  // -'
        fn12 = Pattern.matches(".*['][-].*", name);  // '-
        fn13 = Pattern.matches(".*[']['].*", name);  // ''
        fn14 = Pattern.matches(".*[-][-].*", name);  // --
        fn2 = Pattern.matches("[A-Za-z'//-]*", name);    // first name
    }*/

    private void setEmailPattern(String email) {
        em = Pattern.matches("(?i)[^@]+@[^@]+\\.[a-z]+", email); // email
    }

    private void checkFirstName(String name){
        setNamePattern(name);
        if(fn2) firstNameMatches = true;
        if(fn11) firstNameMatches = false;
        if(fn12) firstNameMatches = false;
        if(fn13) firstNameMatches = false;
        if(fn14) firstNameMatches = false;
        System.out.println("First Name Matched: " + firstNameMatches);
        printPatternsAssigned();
        //todo: if firstNameMatch is false; student cannot be added - fix this error
    }
//todo: reduce if's in ...checkFirtsName/checkLastName into one method - (?lastNameMatches/firstNameMatches?)
    private void checkLastName(List<String> names){
        int count = 0;
        int failCount = 0;
        for(String name : names) {
            setNamePattern(name);
            if(fn2) lastNameMatches = true;
            if(fn11) lastNameMatches = false;
            if(fn12) lastNameMatches = false;
            if(fn13) lastNameMatches = false;
            if(fn14) lastNameMatches = false;
            count++;
            if(!lastNameMatches) failCount++;
            System.out.printf("Last Name #%d %s Matched: %s\n", count, name, lastNameMatches);
            printPatternsAssigned();
        }
        if(failCount != 0) lastNameMatches = false;
    }

    private void checkEmail(String email){
        setEmailPattern(email);
        if(em) emailMatches = true;
        System.out.println("email Matched: " + emailMatches);
        printEmailPatternsAssigned();
    }
}

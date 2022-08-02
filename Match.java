package tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Match {
    //TODO: for last name loop through List and do all checks done for first name
    private String firstName;
    private List<String> lastName;
    private String email;
    private boolean fn11;  // -'
    private boolean fn12;  // '-
    private boolean fn13;  // ''
    private boolean fn14;  // --
    private boolean fn2;   // first name
    private boolean em;    // email
    boolean firstNameMatch;
    boolean lastNameMatch;
    boolean emailMatch;

    Match(String firstName, List<String> lastName, String email) {
        this.firstName = firstName;
        this.lastName = new ArrayList<>(lastName);
        this.email = email;
        System.out.println("First name: " + firstName + "  Last name: " + lastName + "  email: " + email);
        //setFirstNamePattern();
        //setEmailPattern();
        checkFirstName();
        checkEmail();
        printPatternsAssigned();
    }
    void printPatternsAssigned(){
        System.out.println("fn11:" + fn11 + "  fn12:" + fn12 + "  fn13:" + fn13
                + "  fn14:" + fn14 + "  fn2:" + fn2 + "  email:" + em);
    }
    private void setFirstNamePattern() {
        fn11 = Pattern.matches(".*[-]['].*",firstName);  // -'
        fn12 = Pattern.matches(".*['][-].*",firstName);  // '-
        fn13 = Pattern.matches(".*[']['].*",firstName);  // ''
        fn14 = Pattern.matches(".*[-][-].*",firstName);  // --
        fn2 = Pattern.matches("[A-Za-z'//-]*",firstName);    // first name
    }

    private void setEmailPattern() {
        em = Pattern.matches("(?i)[^@]+@[^@]+\\.[a-z]+", email); // email
    }

    void checkFirstName(){
        setFirstNamePattern();
        if(fn2) firstNameMatch = true;
        if(fn11) firstNameMatch = false;
        if(fn12) firstNameMatch = false;
        if(fn13) firstNameMatch = false;
        if(fn14) firstNameMatch = false;
        System.out.println("First Name Matched: " + firstNameMatch);
        //todo: if firstNameMatch is false; student cannot be added - fix this error
    }

    void checkLastName(){

    }

    void checkEmail(){
        setEmailPattern();
        if(em) emailMatch = true;
        System.out.println("email Matched: " + emailMatch);
    }
}

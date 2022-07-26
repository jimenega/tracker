package tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Match {
    //TODO: for last name loop through List and do all checks done for first name
    private String firstName;
    private List<String> lastName;
    private String email;
    private String emailPattern = "(?i)[^@]+@[^@]+\\.[a-z]+";
    private String fn_11Pattern = ".*[-]['].*";
    private String fn_12Pattern = ".*['][-].*";
    private String fn_13Pattern = ".*[']['].*";
    private String fn_14Pattern = ".*[-][-].*";
    private  String fn_3Pattern = "[^-']([A-Za-z'//-]*)[^-']";

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
        checkPattern();
    }

    private void checkPattern() {
        fn11 = Pattern.matches(fn_11Pattern,firstName);  // -'
        fn12 = Pattern.matches(fn_12Pattern,firstName);  // '-
        fn13 = Pattern.matches(fn_13Pattern,firstName);  // ''
        fn14 = Pattern.matches(fn_14Pattern,firstName);  // --
        fn2 = Pattern.matches(fn_3Pattern,firstName);    // first name
        em = Pattern.matches(emailPattern, email);       // email
        System.out.println("fn11:" + fn11
                            + "  fn12:" + fn12
                            + "  fn13:" + fn13
                            + "  fn14:" + fn14
                            + "  fn2:" + fn2
                            + "  email:" + em);
        checkFirstName();
        System.out.println("First Name Matched: " + firstNameMatch);
    }

    void checkFirstName(){
        if(fn2) firstNameMatch = true;
        if(fn11) firstNameMatch = false;
        if(fn12) firstNameMatch = false;
        if(fn13) firstNameMatch = false;
        if(fn14) firstNameMatch = false;
        //todo: if firstNameMatch is false; student cannot be added - fix this error
    }

    void checkLastName(){

    }

    void checkEmail(){

    }
}

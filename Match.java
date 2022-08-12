package tracker;
import java.util.List;
import java.util.regex.Pattern;

public class Match {
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
        checkFirstName(firstName);
        checkLastName(lastName);
        checkEmail(email);
    }

    public boolean getFirstNameMatches() {
        return firstNameMatches;
    }
    public boolean getLastNameMatches() {
        return lastNameMatches;
    }
    public boolean getEmailMatches() {
        return emailMatches;
    }
    private void setNamePattern(String name) {
        fn11 = Pattern.matches(".*[-]['].*", name);  // -'
        fn12 = Pattern.matches(".*['][-].*", name);  // '-
        fn13 = Pattern.matches(".*[']['].*", name);  // ''
        fn14 = Pattern.matches(".*[-][-].*", name);  // --
        fn2 = Pattern.matches("[A-Za-z'/-]*", name);    // first name // * note: removed one / as recommended by Ij
    }

    private void setEmailPattern(String email) {
        em = Pattern.matches("(?i)[^@]+@[^@]+\\.[a-z]+", email); // email
    }

    private void checkNamePattern(String name) {
        boolean result = false;
        if(fn2) result = true;
        if(fn11) result = false;
        if(fn12) result = false;
        if(fn13) result = false;
        if(fn14) result = false;
        //if(name == "first") firstNameMatches = setToo;
        if(name.equals("first")) firstNameMatches = result;
        //if(name == "last") lastNameMatches = setToo;
        if(name.equals("last")) lastNameMatches = result;
    }

    private void checkFirstName(String name){
        setNamePattern(name);
        checkNamePattern("first");
    }
    private void checkLastName(List<String> names){
        int failCount = 0;
        for(String name : names) {
            setNamePattern(name);
            checkNamePattern("last");
            if(!lastNameMatches) failCount++;
        }
        if(failCount != 0) lastNameMatches = false;
    }

    private void checkEmail(String email){
        setEmailPattern(email);
        if(em) emailMatches = true;
    }
}

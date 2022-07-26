package tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Match {
    //TODO: for last name loop through List and do all checks done for first name
    private String emailPattern = "(?i)[^@]+@[^@]+\\.[a-z]+";
    private String fn_1Pattern = ".*[-]['].*";
    private String fn_2Pattern = ".*['][-].*";
    private String fn_3Pattern = "[^-']([A-Za-z'//-]*)[^-']";

    private String firstName;
    private List<String> lastName;
    private String email;

    Match(String firstName, List<String> lastName, String email) {
        this.firstName = firstName;
        this.lastName = new ArrayList<>(lastName);
        this.email = email;
        System.out.println("First name: " + firstName + "  Last name: " + lastName + "  email: " + email);
        checkPattern();
    }

    private void checkPattern() {
        boolean fn1 = Pattern.matches(fn_1Pattern,firstName);  // swapped -'
        boolean fn2 = Pattern.matches(fn_2Pattern,firstName);  // swapped '-
        boolean fn3 = Pattern.matches(fn_3Pattern,firstName);  // remaining name
        boolean  em =  Pattern.matches(emailPattern, email);
        System.out.println("fn1:" + fn1
                            + " fn2:" + fn2
                            + " fn3:" + fn3
                            + " email:" + em);
    }
}

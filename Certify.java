package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Certify {
    private final List<String> rawCopy;
    private boolean matches;
    private int id, java, dsa, db, spring;

    public int getId() {
        return id;
    }

    public int getJava() {
        return java;
    }

    public int getDsa() {
        return dsa;
    }

    public int getDatabase() {
        return db;
    }

    public int getSpring() {
        return spring;
    }
    Certify(List<String> rawInput) {
        rawCopy = new ArrayList<>(rawInput);
        String rawCopyString = rawCopy.toString()
                .replaceAll("\\[", "")
                .replaceAll(",","")
                .replaceAll("]","");
        matches = Pattern.matches("[^-]\\d* \\d* \\d* \\d* \\d*", rawCopyString);
        //System.out.println("Certify::Certify::matches: " + matches);
    }

    private int inputErrorChecks(){
        int errorCode = 0;
        if(rawCopy.size() == 1 && !rawCopy.get(0).equalsIgnoreCase("back")) {
            errorCode = 101;
            System.out.println("Incorrect credentials.");
        } else if(rawCopy.size() != 5 ) {
            errorCode = 102;
            System.out.println("Incorrect credentials.");
        }
        return errorCode;
    }
    private void assign() {
        int ID = 0, JAVA = 1, DSA = 2, DB = 3, SPRING = 4;
        //System.out.println("Certify::assign: " + rawCopy);
        id = Integer.parseInt(rawCopy.get(ID));
        java = Integer.parseInt(rawCopy.get(JAVA));
        dsa = Integer.parseInt(rawCopy.get(DSA));
        db = Integer.parseInt(rawCopy.get(DB));
        spring = Integer.parseInt(rawCopy.get(SPRING));
        //System.out.println("Certify::assign - id " + id);
    }

    /*private boolean certifyResults() {
        return matches;
    }*/
    public boolean run() {
        int errorCode = inputErrorChecks();
        if(errorCode == 0 && matches) {
            assign();
            return true;
        } else {
            //System.out.println("Input error code: " + errorCode);  //Keep this for debugging
            return false;
        }
    }
}
//Pattern.matches("([^-]\\d*) \\d* \\d* \\d* \\d*","10000000 9 78 7 678"); //todo: this seems to work
//Pattern.matches("[^-]\\d* \\d* \\d* \\d* \\d*","10000000 9 78 7 678"); //todo: this seems to work

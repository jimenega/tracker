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
    }
    private int inputErrorChecks(){
        int errorCode = 0;
        if(rawCopy.size() == 1 && !rawCopy.get(0).equalsIgnoreCase("back")) {
            errorCode = 101;
            System.out.println("Incorrect credentials.");
        } else if(rawCopy.size() != 5 ) {
            errorCode = 102;
        }
        return errorCode;
    }
    private void assign() {
        int ID = 0, JAVA = 1, DSA = 2, DB = 3, SPRING = 4;
        id = Integer.parseInt(rawCopy.get(ID));
        java = Integer.parseInt(rawCopy.get(JAVA));
        dsa = Integer.parseInt(rawCopy.get(DSA));
        db = Integer.parseInt(rawCopy.get(DB));
        spring = Integer.parseInt(rawCopy.get(SPRING));
    }
    public boolean run() {
        int errorCode = inputErrorChecks();
         if(errorCode == 0 && matches) {
            assign();
            return true;
        } else {
            return false;
        }
    }
}
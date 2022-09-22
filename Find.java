package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Find implements Command {
    Store store;
    private final Scanner scanner = new Scanner(System.in);  //todo-note: this was added
    String name = "find";
    private List<String> rawCopy;
    private boolean matches;

    Find(){
        Interface.activeCommand = RESERVED.find;
        this.store = Store.getInstance();
    }
    public String getName() {
        return this.name;
    }
    /*private int inputErrorChecks(){
        int errorCode = 0;
        if(rawCopy.size() == 1 && !rawCopy.get(0).equalsIgnoreCase("back")) {
            errorCode = 101;
            System.out.println("Incorrect credentials.");
        } else if(rawCopy.size() != 1 ) {
            errorCode = 102;
            System.out.println("Incorrect credentials.");
        }
        return errorCode;
    }*/

    /*private boolean Checks(List<String> rawInput) {
        int errorCode = inputErrorChecks();
        if(errorCode == 0) {
            //assign();
            return true;
        } else {
            //System.out.println("Input error code: " + errorCode);  //Keep this for debugging
            return false;
        }
    }*/
    private int matchInput(List<String> rawInput) {
        //List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));
        rawCopy = new ArrayList<>(rawInput);
        String rawCopyString = rawCopy.toString()
                .replaceAll("\\[", "")
                .replaceAll("]","");
        matches = Pattern.matches("[^-]\\d*", rawCopyString);
        System.out.println("Find::execute: matches: " +  matches);
        System.out.println("Find::execute: rawCopy: " +  rawCopy);
        System.out.println("Find::execute: rawCopyString: " +  rawCopyString);
        int id = Integer.parseInt(rawCopy.get(0));
        return id;
    }

    public void console() {
        System.out.println("Enter an id and points or 'back' to return");
        while (true) {
            List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));

            if (rawInput.isEmpty() || rawInput.get(0).equals("")) {
                System.out.println("Incorrect points format. - getPoints()");
                continue;
            }
            if (rawInput.get(0).equalsIgnoreCase("back") && (rawInput.size() == 1)) {
                System.out.println("back from Find");
                new Back();
                break;
            }  else {
                // todo: checkInput here
                int id = matchInput(rawInput);
                System.out.println("Find::console");
                Student student = store.getStudent(id);
                if(student != null) {
                    System.out.println(id + " points:"
                            + " Java=" + student.getJava()
                            + " DSA=" + student.getDsa()
                            + " Databases=" + student.getDatabases()
                            + " Spring=" + student.getSpring());
                } else {
                    System.out.printf("Find::console  - No student is found for id=%d%n", id);
                }
            }
        }
    }
    public void execute() {
        System.out.println("Enter an id or 'back' to return:");
        console();
    }
}

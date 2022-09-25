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

    Find(){
        Interface.activeCommand = RESERVED.find;
        this.store = Store.getInstance();
    }
    public String getName() {
        return this.name;
    }

    private boolean inputChecks(List<String> rawInput) {
        boolean checksPass = false;
        if (rawInput.size() == 1) {
            checksPass = true;
        }
        return checksPass;
    }
    private int matchInput(List<String> rawInput) {
        List<String> rawCopy = new ArrayList<>(rawInput);
        int id = 0;
        String rawCopyString = rawCopy.toString()
                .replaceAll("\\[", "")
                .replaceAll("]","");
        boolean matches = Pattern.matches("[^-]\\d*", rawCopyString);
        //System.out.println("Find::execute: matches: " + matches);
        //System.out.println("Find::execute: rawCopy: " + rawCopy);
        //System.out.println("Find::execute: rawCopyString: " +  rawCopyString);
        if (matches) {
           id = Integer.parseInt(rawCopy.get(0));
        }
        return id;
    }

    public void console() {
        System.out.println("Enter an id or 'back' to return:");
        while (true) {
            List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));

            if (!inputChecks(rawInput)) {
                System.out.println("Incorrect format");
                continue;
            }
            if (rawInput.isEmpty() || rawInput.get(0).equals("")) {
                System.out.println("Incorrect points format. - getPoints()");
                continue;
            }
            if (rawInput.get(0).equalsIgnoreCase("back") && (rawInput.size() == 1)) {
                //System.out.println("back from Find");
                new Back();
                break;
            }  else {
                int id = matchInput(rawInput);
                Student student = store.getStudent(id);
                if(student != null) {
                    System.out.println(id + " points:"
                            + " Java=" + student.getJava()
                            + "; DSA=" + student.getDsa()
                            + "; Databases=" + student.getDatabases()
                            + "; Spring=" + student.getSpring());
                } else {
                    System.out.printf("No student is found for id=%d.%n", id);
                }
            }
        }
    }
    public void execute() {
        //System.out.println("Find::execute - Enter an id or 'back' to return:");
        console();
    }
}
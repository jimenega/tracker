package tracker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Find implements Command {
    private final Scanner scanner = new Scanner(System.in);  //todo-note: this was added
    String name = "find";
    Find(){
        Interface.activeCommand = RESERVED.find;
    }
    public String getName() {
        return this.name;
    }
    public void execute() {
        //Message.printBye_M();  //todo: find command execution goes here
        //Main.trackerON = false;
        //System.exit(1);
        System.out.println("find command");
        getStudentDetails();
    }

    public void getStudentDetails() {
        //final Scanner scanner = new Scanner(System.in);

        int nameCount = 0;
        System.out.println("Enter an id or 'back' to return:");
        while (true) {
            List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));
            if(rawInput.isEmpty()) {
                System.out.println("incorrect credentials: getStudentData()");
                continue;
            }
            if(rawInput.get(0).equalsIgnoreCase("back") && (rawInput.size() == 1)) {
                System.out.println("find command: getStudentDetails.");
                new Back();
                break;
            }  else {
                /*Validate validate = new Validate(rawInput);
                if (validate.run()) {
                    nameCount++;
                    System.out.println("The student has been added.");*/
                System.out.println("find command: getStudentDetails");
            }
        }
    }
}

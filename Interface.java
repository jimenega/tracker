package tracker;
import java.util.*;
public class Interface {
    static Command.RESERVED activeCommand = null;  //Last entered console command
    static int commandLevel = 0;
    private final Scanner scanner = new Scanner(System.in);
    List<String> rawInput;
    Queue<String> rawQueue = new LinkedList<>();
    List<String> normalized = new ArrayList<>();
    List<String> reserved = new ArrayList<>();
    Interface() {}
    void setUp() {
        //Create list reserved from RESERVED
        for (Command.RESERVED c : Command.RESERVED.values()) {
            reserved.add(String.valueOf(c));
        }
    }
    boolean isInput() {
        normalized.clear();
        rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));
        for(String in : rawInput) {
            if (!in.isBlank()) rawQueue.offer(in);
        }
        for(int i = 0; i < rawInput.size(); i++ ) {
            if (rawQueue.peek() != null)  normalized.add(rawQueue.poll().toLowerCase());
        }
        if( normalized.size() == 0) {
            Message.noInput_M();
            return false;
        }
        return true;
    }
    void checkInput() {
        boolean isCommand = new HashSet<>(reserved).containsAll(normalized);
        if (isCommand) {
            String command0 = normalized.get(0).toLowerCase();
            String command1 = null;
            if(normalized.size() == 2) command1 = normalized.get(1).toLowerCase();

            switch (command0) {
                case "students" :
                case "points" :
                    Message.unknownCommand_M();
                    break;
                case "exit" :
                    if(normalized.size() > 1) {
                        Message.unknownCommand_M();
                        break;
                    }
                    commandLevel = 0;
                    activeCommand = Command.RESERVED.exit;
                    new Exit().execute();
                    break;
                case "back" :
                    if(normalized.size() > 1) {
                        Message.unknownCommand_M();
                        break;
                    }
                    Interface.commandLevel = 0;
                    Interface.activeCommand = Command.RESERVED.back;
                    new Back().execute();
                    break;
                case "add" :
                    if(command1 == null) {
                        Message.unknownCommand_M();
                        break;
                    }
                    switch(command1) {
                        case "students":
                            Interface.commandLevel = 1;
                            Interface.activeCommand = Command.RESERVED.students;
                            new Add().control(command1);
                            break;
                        case "points" :
                            Interface.commandLevel = 1;
                            Interface.activeCommand = Command.RESERVED.points;
                            new Add().control(command1);
                            break;
                    }
            }
        }
        else Message.unknownCommand_M();
    }
    void verifyConsoleInput() {
        if(isInput()) checkInput();
    }
    void Console() {
        setUp();
        Message.printTitle_M();
        while (Main.trackerON) {
            verifyConsoleInput();
        }
    }
}
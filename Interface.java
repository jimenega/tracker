package tracker;
import java.util.*;
public class Interface {
    static Command.RESERVED activeCommand = null;  //Last entered console command
    static int commandLevel = 0;
    Scanner scanner = new Scanner(System.in);
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
    boolean getInput() {
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
            String command = normalized.get(0).toLowerCase();
            switch (command) {
                case "exit" :
                    commandLevel = 0;
                    activeCommand = Command.RESERVED.exit;
                    new Exit().execute();
                    break;
                case "back" :
                    Interface.commandLevel = 0;
                    Interface.activeCommand = Command.RESERVED.back;
                    new Back().execute();
                    break;
                case "add" :
                    Interface.commandLevel = 1;
                    Interface.activeCommand = Command.RESERVED.back;
                    new Add().execute();
                    break;
            }
            Message.printStatus();
        }
        else Message.unknownCommand_M();
    }
    void verifyConsoleInput() {
        if(getInput()) checkInput();
    }
    void Console() {
        setUp();
        Message.printTitle_M();
        while (Main.trackerON) {
            verifyConsoleInput();
            while (commandLevel > 0) {
                verifyConsoleInput();
            }
        }
    }
}

/*
switch (command) {
        case "exit" :
        Interface.commandLevel = 0;
        Interface.activeCommand = Command.RESERVED.exit;
        new Exit().execute();
        break;
        case "back" :
        Interface.commandLevel = 0;
        Interface.activeCommand = Command.RESERVED.back;
        new Back().execute();
        break;
        case "add" :
        Interface.commandLevel = 0;
        Interface.activeCommand = Command.RESERVED.back;
        new Add().execute();
        break;
        }*/

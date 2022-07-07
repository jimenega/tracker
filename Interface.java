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
        boolean isCommand = false;

        /*for(String n : normalized) {
            for (Command.RESERVED c : Command.RESERVED.values()) {
                //todo: try - if(RESERVED.values contains s
                if (n.toLowerCase().equals(c.name())) {
                    isCommand = true;
                } else {
                    isCommand = false;
                    break;
                }
            }
            if(!isCommand) break;
        }*/

       /* List<String> reserved = new ArrayList<>();
        for (Command.RESERVED c : Command.RESERVED.values()) {
            reserved.add(String.valueOf(c));
        }*/

        boolean b = new HashSet<>(reserved).containsAll(normalized);
        System.out.println("reserved: " + reserved + " normalized " + normalized + " b: " + b);
        if(b) isCommand = true;

        /*for(String n : normalized) {
            for (Command.RESERVED c : Command.RESERVED.values()) {
                if (n.toLowerCase().equals(c.name())) {
                    isCommand = true;
                } else {
                    isCommand = false;
                    break;
                }
            }
            if(!isCommand) break;
        }*/

        if (isCommand) {
            String command = normalized.get(0).toLowerCase();
            switch (command) {
                case "exit" :
                    commandLevel = 0;
                    activeCommand = Command.RESERVED.exit;
                    new Exit().execute();
                    break;
            }
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

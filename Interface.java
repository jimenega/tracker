package tracker;
import java.util.*;
public class Interface {
    Scanner scanner = new Scanner(System.in);
    static Command.RESERVED activeCommand = null;  //Last entered console command
    List<String> consoleString;
    static int commandLevel = 0;
    static int statusConsoleInput = 0;
    Interface() {}
    static boolean inputChecks(List<String> input) {
        if (input.get(0).isBlank()) {
            Message.noInput_M();
            return false;
        }
        else return true;
    }
    static boolean errorChecks(List<String> input) {
        boolean isCommand = false;
        for (Command.RESERVED c : Command.RESERVED.values()) {
            if (c.name().equals(input.get(0).toLowerCase())) {
                isCommand = true;
                break;
            }
        }
        if (isCommand) {
            String command = input.get(0).toLowerCase();
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
            }
            return true;
        }
        else {
            Message.unknownCommand_M();
            return false;
        }
    }
    static int verifyConsoleInput(List<String> input) {
        if(!inputChecks(input)) return -1;
        else if (!errorChecks(input)) return -2;
        return 0;
    }
    void Console() {
        Message.printTitle_M();
        while (Main.trackerON) {
            //Message.printStatus();
            consoleString = Arrays.asList(scanner.nextLine().split("\\s+"));
            statusConsoleInput = verifyConsoleInput(consoleString);
            while (commandLevel > 0) {
                //Message.printStatus();
                consoleString = Arrays.asList(scanner.nextLine().split("\\s+"));
                statusConsoleInput = verifyConsoleInput(consoleString);
            }
        }
    }
}

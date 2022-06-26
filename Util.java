package tracker;

import java.util.List;
public final class Util {

    // Find Command in Command.RESERVED - look for test in RESERVED
    public static boolean contains(String test) {
        for (Command.RESERVED c : Command.RESERVED.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    static boolean isCommand(String input) {
        if (contains(input.toLowerCase()))
            return true;
        else return false;
    }

    /*static Command.RESERVED isCommand(String input) {
        if (contains(input.toLowerCase()))
            return Command.RESERVED.valueOf(input.toLowerCase());
        else return null;
    }*/

    static boolean inputChecks(List<String> input) {
        if (input.get(0).isBlank()) {
            Message.noInput_M();
            return true;
        }
        else return false;
    }

    static boolean errorChecks(List<String> input) {
        if (!isCommand(input.get(0))) {
            Message.unknownCommand_M();
            return true;
        }
        else return false;
    }
//todo: maybe commandChecks could be combined in errorChecks ??
    static boolean commandChecks(List<String> input) {
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
            default:
                return false;
        }
        return true;
    }
//todo: experiment with removing statusConsoleInput ??? maybe
    static void verifyConsoleInput(List<String> input) {
        int statusConsoleInput = 0;
        if(inputChecks(input)) {statusConsoleInput = -1;}
        else if (errorChecks(input)) {statusConsoleInput = -2;}
        else if (commandChecks(input)) {statusConsoleInput = 1;}
        System.out.println("statusConsoleInput: " + statusConsoleInput);
    }
}

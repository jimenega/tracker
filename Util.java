package tracker;

import java.util.List;
public final class Util {

    static boolean isCommand(String input) {
        for (Command.RESERVED c : Command.RESERVED.values()) {
            if (c.name().equals(input.toLowerCase())) return true;
        }
        return false;
    }

    static boolean inputChecks(List<String> input) {
        if (input.get(0).isBlank()) {
            Message.noInput_M();
            return true;
        }
        else return false;
    }
//todo: incorporate isCommand into errorChecks ???
    static boolean errorChecks(List<String> input) {
        if (isCommand(input.get(0))) {
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
            return false;
        }
        else {
            Message.unknownCommand_M();
            return true;
        }
    }
//todo: See is what methods can be moved to class Interface ???
    static void verifyConsoleInput(List<String> input) {
        int statusConsoleInput = 0;
        if(inputChecks(input)) {statusConsoleInput = -1;}
        else if (errorChecks(input)) {statusConsoleInput = -2;}
        //else if (commandChecks(input)) {statusConsoleInput = 1;}
        System.out.println("statusConsoleInput: " + statusConsoleInput);
    }
}

package tracker;

public final class Message {
    private Message() {}

    static void printTitle_M() {
        System.out.println("Learning Progress Tracker");
    }

    static void noInput_M() {
        System.out.println("No input.");
    }

    static void printBye_M() {
        System.out.println("Bye!");
    }

    static void unknownCommand_M() {
        System.out.println("Error: unknown command!");
    }

    static void printStatus() {  //for testing only
        System.out.println("command Level: " + Interface.commandLevel);
        System.out.println("active command: " + Interface.activeCommand);
    }
}
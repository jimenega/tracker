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
    static void backCommand1_M() {
        System.out.println("Enter 'exit' to exit the program.");
    }
}
package tracker;
import java.util.*;
public class Interface {

    static Command.RESERVED activeCommand = null;
    static int commandLevel = 0;
    Interface() {}
    void Console() {
        Scanner scanner = new Scanner(System.in);
        Message.printTitle_M();

        while (Main.trackerON) {
            commandLevel = 0;
            activeCommand = null;
            Message.printStatus();
            List<String> consoleString = Arrays.asList(scanner.nextLine().split("\\s+"));
            Util.verifyConsoleInput(consoleString);
            while (commandLevel > 0) {
                Message.printStatus();
                consoleString = Arrays.asList(scanner.nextLine().split("\\s+"));
                Util.verifyConsoleInput(consoleString);
            }
        }
    }
}

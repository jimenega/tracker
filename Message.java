package tracker;

public final class Message {
    private Message() {}

    static String available_properties = "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]";

    static void printTitle() {
        System.out.println("Learning Progress Tracker");
    }

    static void supportMsg() {
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    static void requestMsg() {
        System.out.print("\nEnter a request:  ");
    }

    static void goodbyePrint() {
        String msg = "\nGoodbye!";
        System.out.println(msg);
    }

    static void errorPrintOne() {
        String err1 = "\nThe first parameter should be a natural number or zero.";
        System.out.println(err1);
    }

    static void errorPrintTwo() {
        String err1 = "\nThe second parameter should be a natural number.";
        System.out.println(err1);
    }

    static void errorPrintThree(String wrong) {
        System.out.printf("\nM3_The property [%s] is wrong.\n", wrong);
        System.out.println(available_properties);
    }

    static void errorPrintFour(String wrong1, String wrong2) {
        System.out.printf("\nM41The properties [%s, %s] are wrong.\n", wrong1, wrong2);
        System.out.println(available_properties);
    }

    static void errorPrintFour(String wrong) {
        System.out.printf("\nM42The properties %s are wrong.\n", wrong);
        System.out.println(available_properties);
    }

    static void errorPrintFive(String ex1, String ex2) {
        System.out.printf("\nM51The request contains mutually exclusive properties: [%s, %s]\n", ex1, ex2);
        System.out.println("There are no numbers with these properties.");
    }
}

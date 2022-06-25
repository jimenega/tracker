package tracker;

public class Main {
    static boolean trackerON;
    public static void main(String[] args) {
        trackerON = true;
        Interface tracker = new Interface();
        tracker.Console();
    }
}
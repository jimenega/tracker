package tracker;

import java.util.ArrayList;
import java.util.List;

public class Certify {
    private final List<String> rawCopy;
    Certify(List<String> rawInput) {
        rawCopy = new ArrayList<>(rawInput);
    }
    public boolean run() {
        System.out.println("Certify::rawCopy: " + rawCopy);
        int id = Integer.parseInt(rawCopy.get(0));
        int java = Integer.parseInt(rawCopy.get(1));
        int dsa = Integer.parseInt(rawCopy.get(2));
        int db = Integer.parseInt(rawCopy.get(3));
        int spring = Integer.parseInt(rawCopy.get(4));
        System.out.println("id " + id);
        System.out.println("id " + id + 1);
        return true;
    }
}

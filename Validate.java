package tracker;

import java.util.List;

public class Validate {
    List<String> rawInput;

    Validate(List<String> rawInput) {
        this.rawInput = rawInput;
        printRawInput(this.rawInput);
    }
    void printRawInput(List<String> rawInput) {
        System.out.println(rawInput);
    }
}

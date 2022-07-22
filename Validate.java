package tracker;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    List<String> rawInput;
    //int lastStringIndex;

    List<String> lname;
    String fname;
    String email;

    Validate(List<String> rawInput) {
        this.rawInput = rawInput;
        assign();
    }
        //todo:  check for entry size names > than 2
    void assign(){
        List<String> rawCopy = new ArrayList<>(this.rawInput);
        int stringIndex = rawCopy.size() - 1;
        fname = rawCopy.get(0);
        email = rawCopy.get(stringIndex);
        rawCopy.remove(0);
        stringIndex = rawCopy.size() - 1;
        rawCopy.remove(stringIndex);
        lname = new ArrayList<>(rawCopy);
        System.out.println("name: " + fname + " last name: " + lname + " email: " + email);
    }
}

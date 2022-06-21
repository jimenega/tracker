package tracker;
//import java.util.*;

public class Main {

    static boolean trackerON = false;
    enum RESERVED {exit, add, back}



    public static void main(String[] args) {
        trackerON = true;
        Message.printTitle();
        while (trackerON) {
            System.out.println("tracker is on");
            Command exit = new Exit();
            exit.getName();
            exit.execute();

            //new Exit().getName();
            //new Exit().exit();
            //trackerON = false;
        }
    }
}

//todo: add UI ??
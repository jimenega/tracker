package tracker;

public class Main {
    static boolean trackerON;
    public static void main(String[] args) {
        trackerON = true;
        Interface tracker = new Interface();
        tracker.Console();
    }
}

//todo: You can edit a language injection in your code using a dedicated editor.
//  For example, to edit a regular expression, start typing it, press Alt+Enter and choose Edit RegExp Fragment.
//  The regular expression opens in a separate tab in the editor, where you can type backslashes as is.
//  All changes are synchronized with the original regular expression, and escape characters are presented automatically.
//  When ready, press Escape to close the regular expression editor.
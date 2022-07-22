package tracker;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Dialog {
   private final Scanner scanner = new Scanner(System.in);
   Dialog(String id) {
   }
   public void getStudentData() {
      //boolean dialogOpen = true;
      int nameCount = 0;
      System.out.println("Enter student credentials or 'back' to return");
      while (true) {
         List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));
         if(rawInput.get(0).equalsIgnoreCase("back") && (rawInput.size() == 1)) {
            //dialogOpen = false;
            System.out.printf("Total %d students have been added\n", nameCount);
            new Back();
            break;
         }  // else validate input
         //System.out.println(rawInput);  //tmp message
         new Validate(rawInput);
         nameCount++;
         System.out.println("The student has been added.");
      }
   }
}
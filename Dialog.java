package tracker;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Dialog {
   private final Scanner scanner = new Scanner(System.in);
   Dialog(String id) {
   }
   public void getStudentData() {
      int nameCount = 0;
      System.out.println("Enter student credentials or 'back' to return:");
      while (true) {
         List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));
         if(rawInput.isEmpty()) {
            System.out.println("incorrect credentials: getStudentData()");
            continue;
         }
         if(rawInput.get(0).equalsIgnoreCase("back") && (rawInput.size() == 1)) {
            System.out.printf("Total %d students have been added.\n", nameCount);
            new Back();
            break;
         }  else {
            Validate validate = new Validate(rawInput);
            if (validate.run()) {
               nameCount++;
               System.out.println("Store this: "   + validate.getFirstName()
                       + " " +  validate.getLastName() + " " + validate.getEmail());
               System.out.println("The student has been added.");
            }
         }
      }
   }
}
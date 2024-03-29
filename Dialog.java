package tracker;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dialog {
   String title; //dialogue title
   Store store;
   int nameCount;
   private final Scanner scanner = new Scanner(System.in);
   Dialog(String id) {
      this.title = id;
      this.store = Store.getInstance();  //Create Store Singleton
   }
   private void storeStudent(String name1, List<String> name2, String email) {
      Student student = new Student();  //create new student record
      student.setFirstName(name1);
      student.setLastName(name2);
      student.setEmail(email);
      if (store.tryStoreStudent(student)) nameCount++;
   }
   public void getStudent() {
      nameCount = 0;
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
               storeStudent(validate.getFirstName(), validate.getLastName(), validate.getEmail());
            }
         }
      }
   }
   public void getPoints() {
      nameCount = 0;
      System.out.println("Enter an id and points or 'back' to return:");
      while (true) {
         List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));
         boolean matches  = rawInput.get(0).matches("[^-]\\d*");
         boolean idExist;
         if (rawInput.isEmpty() || rawInput.get(0).equals("")) {
            System.out.println("Incorrect points format. - getPoints()");
            continue;
         }
         if (rawInput.get(0).equalsIgnoreCase("back") && (rawInput.size() == 1)) {
            new Back();
            break;
         }  else {
            if (matches) {
               idExist = store.isIdExist(Integer.parseInt(rawInput.get(0)));
               if (!idExist) {
                  System.out.printf("No student is found for id=%s.%n", rawInput.get(0));
                  continue;
               }
            } else {
               System.out.printf("No student is found for id=%s.%n", rawInput.get(0));
               continue;
            }
            Certify certify = new Certify(rawInput);
            if (certify.run()) {
               if (store.tryStorePoints(certify)) {
                  System.out.println("Points updated.");
               }
            }
         }
      }
   }
}
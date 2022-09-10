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

   private void storeData(String name1, List<String> name2, String email) {
      //nameCount++;
      //store.getConnection();
      Student student = new Student();  //create new student record
      student.setFirstName(name1);
      student.setLastName(name2);
      student.setEmail(email);
      if (store.tryStoreStudent(student)) nameCount++;
      //System.out.println("The student has been added. - REMOVE ME - Dialog");
      //Dialog dialog = this;
   }
   public void getStudentData() {
      nameCount = 0;
      System.out.println("Enter student credentials or 'back' to return");
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
               storeData(validate.getFirstName(), validate.getLastName(), validate.getEmail());
            }
         }
      }
   }
}
package tracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private static Store dbObject;
    private int buffer;

    private Student student;

    Map<Long, List<Student>> map = new HashMap<>();
    private Store() {
    }
    public static Store getInstance() {

        // create object if it's not already created
        if (dbObject == null) {
            dbObject = new Store();
        }
        // returns the singleton object
        return dbObject;
    }
    public void getConnection() {
        System.out.println("You are now connected to the store.");
    }

    public void incrementBuffer() {
        buffer++;
        System.out.println("buffer: " + buffer);
    }

    public void tryStoreStudent(Student student) {
        this.student = student;
        System.out.println(this.student.getFirstName() + " " + this.student.getLastName() +" " + this.student.getEmail());
        System.out.println(student.getFirstName() + " " + student.getLastName() +" " + student.getEmail());

    }
}


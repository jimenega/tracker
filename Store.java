package tracker;

import java.util.*;

public class Store {
    private static Store dbObject;
    private int id = 10000;  // student id
    private Student currentStudent;
    private Map<Integer, Student> dbMap = new HashMap<>();
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

    private void idIncrement() {
        id++;
        //System.out.println("Next Student id: " + id);
    }

    private boolean isDuplicateEmail() {
        boolean duplicate = false;
        for (Student s : dbMap.values()) {
            if (currentStudent.getEmail().equals(s.getEmail())) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }
    public boolean tryStoreStudent(Student student) {
        currentStudent = student;
        boolean isStudentStored;
        //System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName() +" " + currentStudent.getEmail());
        System.out.println(student.getFirstName() + " " + student.getLastName() +" " + student.getEmail());
        if (isDuplicateEmail()) {
            System.out.println("This email is already taken.");
            isStudentStored = false;
        } else {
            dbMap.put(id,currentStudent);
            idIncrement();
            System.out.println("The student has been added.");
            isStudentStored = true;
        }
        return isStudentStored;
    }

    public boolean tryList() {
        return dbMap.keySet().isEmpty();
    }

    public void printList() {
        for (Integer i : dbMap.keySet()) {
            System.out.println(i);
        }
    }
}

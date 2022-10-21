package tracker;

import java.util.*;
public class Store {
    private static Store dbObject;
    private int id = 10000;  // student id
    private Student currentStudent;
    private Map<Integer, Student> dbMap = new HashMap<>();
    private Store() {
    }

    public Set<Integer> getKeySet() {
        return dbMap.keySet();
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
    public boolean tryStorePoints(Certify certify) {
        int currentId = certify.getId();
        boolean pointsStored;
        if (isIdExist(currentId)) {
            Student student = dbMap.get(currentId);
            student.setJava(student.getJava() + certify.getJava());
            student.setDsa(student.getDsa() + certify.getDsa());
            student.setDatabase(student.getDatabases() + certify.getDatabase());
            student.setSpring(student.getSpring() + certify.getSpring());
            pointsStored = true;
        } else {
            System.out.printf("No student is found for id:%d.%n", currentId);
            pointsStored = false;
        }
        return pointsStored;
    }
    public boolean isIdExist(int id) {
        return dbMap.containsKey(id);
    }
    public Student getStudent(int id) {
        if (isIdExist(id))
            return dbMap.get(id);
        else return null;
    }
}

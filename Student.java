package tracker;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private int java;
    private int dsa;
    private int database;
    private int spring;
    //new: completed & notified - use to store notification state
    private final List<Boolean>  completed = new ArrayList<>();
    private final List<Boolean> notified = new ArrayList<>();
    Student() {
        initializeCompletedNotified();
    }
    private void initializeCompletedNotified() {
        Boolean java = false;
        Boolean dsa = false;
        Boolean databases = false;
        Boolean spring = false;
        completed.add(java);
        completed.add(dsa);
        completed.add(databases);
        completed.add(spring);
        notified.add(java);
        notified.add(dsa);
        notified.add(databases);
        notified.add(spring);
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(List<String> lastNameList) {
        // set to String from List
        this.lastName = lastNameList.toString().replaceAll("\\p{P}","");
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getJava() {
        return java;
    }
    public void setJava(int java) {
        this.java = java;
    }
    public int getDsa() {
        return dsa;
    }
    public void setDsa(int dsa) {
        this.dsa = dsa;
    }
    public int getDatabases() {
        return database;
    }
    public void setDatabase(int database) {
        this.database = database;
    }
    public int getSpring() {
        return spring;
    }
    public void setSpring(int spring) {
        this.spring = spring;
    }
    //new: return completed
    public List<Boolean> getCompleted() {
        return completed;
    }
    public List<Boolean> getNotified() {
        return notified;
    }
}

package tracker;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String email;
    private int java;
    private int dsa;
    private int databases;
    private int spring;

    Student() {
        //generate student id here
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
        this.lastName = lastNameList.toString();
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
        return databases;
    }

    public void setDatabases(int databases) {
        this.databases = databases;
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }
}

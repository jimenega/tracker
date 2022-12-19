package tracker;

import java.util.*;

public class Notify implements Command{
    String name = "notify";
    Store store;
    private enum languages {Java, DSA, Databases, Spring}
    int Java = 0, DSA = 1, Databases = 2, Spring = 3;
    List<Boolean> completed;
    List<Boolean> notified;
    public String getName() {
        return this.name;
    }
    private final Set<Integer> keySet;
    private final Map<Integer, List<Integer>> pointsMap = new HashMap<>();
    Notify(){
        Interface.activeCommand = RESERVED.statistics;
        this.store = Store.getInstance();
        //this.pointSubmissionList = store.getPointSubmissionList();

        this.keySet = store.getKeySet();
        initializePointsMap();
    }
    private void initializePointsMap() {
        for (Integer studentId : keySet) {
            pointsMap.put(studentId, new ArrayList<>());
        }
        for (Integer studentId : keySet) {
            pointsMap.get(studentId).add(store.getStudent(studentId).getJava());
            pointsMap.get(studentId).add(store.getStudent(studentId).getDsa());
            pointsMap.get(studentId).add(store.getStudent(studentId).getDatabases());
            pointsMap.get(studentId).add(store.getStudent(studentId).getSpring());
        }
    }

    /*private void message() {
        //Write message template here
        System.out.println("Notify - send letter now!");
        String wholeName = null;
        String email = null;
        System.out.println("pointsMap: " + pointsMap);
        System.out.println("keySet: " + keySet);
        for(int k : keySet) {
            wholeName = store.getStudent(k).getFirstName() + " " + store.getStudent(k).getLastName();
            email = store.getStudent(k).getEmail();
            System.out.println(wholeName + " " + email);
        }
        System.out.println(wholeName);
        StringBuilder letter = new StringBuilder("To: ");
        letter.append(email).append("\n")
                .append("Re: Your Learning Progress\n")
                .append("Hello, ").append(wholeName)
                .append("!")
                .append("You have accomplished 0ur " + "COURSE goes here");
        System.out.println(letter);
    }*/

    private void checkCompleted(List<Integer> value) {
        // Initiate checks on all students that have completed courses and set them completed.
        int JAVA_REQUIRED = 600, DSA_REQUIRED = 400, DATABASES_REQUIRED = 480, SPRING_REQUIRED = 550;

        if(value.get(Java) >= JAVA_REQUIRED) {
            completed.set(Java, true);
        }
        if(value.get(DSA) >= DSA_REQUIRED) {
            completed.set(DSA, true);
        }
        if(value.get(Databases) >= DATABASES_REQUIRED) {
            completed.set(Databases, true);

        }
        if(value.get(Spring) >= SPRING_REQUIRED) {
            completed.set(Spring, true);
        }
    }
    private void processNotify(int studentId, String course) {
        // Once notification of completion has been sent, set the appropriate class for the student as notified.
        // This will prevent repeated notifications for the same class.
        //System.out.println("id " + id + "  course " + course + "  setTo " + setTo);
        //store.getStudent(id).getCompleted().set(course, setTo);    //completed.set(id, setTo);
        //System.out.println("completed: " + completed);
        //message();
        System.out.println("Notify - send letter now!");
        String wholeName;
        String email;
        //System.out.println("pointsMap: " + pointsMap);
        //System.out.println("keySet: " + keySet);
        /*for(int k : keySet) {
            wholeName = store.getStudent(k).getFirstName() + " " + store.getStudent(k).getLastName();
            email = store.getStudent(k).getEmail();
            System.out.println(wholeName + " " + email);
        }*/
        wholeName = store.getStudent(studentId).getFirstName() + " " + store.getStudent(studentId).getLastName();
        email = store.getStudent(studentId).getEmail();
        System.out.println(wholeName + " " + email);
        System.out.println(wholeName);
        StringBuilder letter = new StringBuilder("To: ");
        letter.append(email).append("\n")
                .append("Re: Your Learning Progress\n")
                .append("Hello, ").append(wholeName)
                .append("!")
                .append("You have accomplished 0ur " + course);
        System.out.println(letter);

    }

    public void console() {
        boolean student_notified = false;
        int notified_count = 0;
        System.out.println("Notify - all graduates");
        for (Map.Entry<Integer, List<Integer>> entry : pointsMap.entrySet()) {
            System.out.println("*** check COMPLETED ***");
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            completed =  store.getStudent(entry.getKey()).getCompleted();
            //notified =  store.getStudent(entry.getKey()).getNotified();
            checkCompleted(entry.getValue());
            System.out.println("completed: " + completed);
        }

        for (int key : keySet) {
            System.out.println("*** NOTIFY and SET NOTIFY TO TRUE ***");
            completed = store.getStudent(key).getCompleted();
            notified = store.getStudent(key).getNotified();
            if(completed.get(Java).equals(true) && notified.get(Java).equals(false)) {
                processNotify(key, languages.Java.name());
                notified.set(Java, true);
                student_notified = true;
                System.out.println("notify " + notified);
            }
            if(completed.get(DSA).equals(true) && notified.get(DSA).equals(false)) {
                processNotify(key, languages.DSA.name());
                notified.set(DSA, true);
                student_notified = true;
                System.out.println("notify " + notified);
            }
            if(completed.get(Databases).equals(true) && notified.get(Databases).equals(false)) {
                processNotify(key, languages.Databases.name());
                notified.set(Databases, true);
                student_notified = true;
                System.out.println("notify " + notified);
            }
            if(completed.get(Spring).equals(true) && notified.get(Spring).equals(false)) {
                processNotify(key, languages.Spring.name());
                notified.set(Spring, true);
                student_notified = true;
                System.out.println("notify " + notified);
            }
            if(student_notified) notified_count++;
        }
        System.out.printf("Total %d students have been notified.\n", notified_count);
    }
    public void execute() {
        console();
    }
}

/*for (Integer grade : values) {
            if(values.get(Java) >= 600) processNotify(id, Java, true );
        }*/
//if(value.get(Java) >= JAVA_REQUIRED) processNotify(id, Java, true );
//private final Map<Integer, List<Integer>> pointSubmissionList;
//Set<Map.Entry<Integer, List<Integer>>> me = pointsMap.entrySet();




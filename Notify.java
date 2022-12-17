package tracker;

import java.util.*;

public class Notify implements Command{
    String name = "notify";
    Store store;

    private enum languages {Java, DSA, Databases, Spring}
    List<Boolean> completed;
    //List<Boolean> notified;
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

    private void message() {
        //Write message template here
        String wholeName;
        String email;
        System.out.println("pointsMap: " + pointsMap);
        System.out.println("keySet: " + keySet);
        for(int k : keySet) {
            wholeName = store.getStudent(k).getFirstName() + " " + store.getStudent(k).getLastName();
            email = store.getStudent(k).getEmail();
            System.out.println(wholeName + " " + email);
        }
    }

    private void checkCompleted(List<Integer> value) {
        // Initiate checks on all students that have completed courses and set them completed.
        int java = 0, DSA = 1, Databases = 2, Spring = 3;
        int JAVA_REQUIRED = 600, DSA_REQUIRED = 400, DATABASES_REQUIRED = 480, SPRING_REQUIRED = 550;

        if(value.get(java) >= JAVA_REQUIRED) {
            completed.set(java, true);
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
    private void processNotify(int id, int course, Boolean setTo) {
        // Once notification of completion has been sent, set the appropriate class for the student as notified.
        // This will prevent repeated notifications for the same class.
        System.out.println("id " + id + "  course " + course + "  setTo " + setTo);

        //store.getStudent(id).getCompleted().set(course, setTo);    //completed.set(id, setTo);
        //System.out.println("completed: " + completed);
    }

    public void console() {
        System.out.println("Notify - all graduates");
        //Set<Map.Entry<Integer, List<Integer>>> me = pointsMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : pointsMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            completed =  store.getStudent(entry.getKey()).getCompleted();

            System.out.println("completed: " + completed);
            //List<Boolean> notified =  store.getStudent(id.getKey()).getNotified();
            //System.out.println("notified: " + notified);
            checkCompleted(entry.getValue());
            System.out.println("completed: " + completed);

        }
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

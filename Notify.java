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
        String wholeName;
        String email;
        wholeName = store.getStudent(studentId).getFirstName() + " " + store.getStudent(studentId).getLastName();
        email = store.getStudent(studentId).getEmail();
        String letter = "To: " + email + "\n" +
                "Re: Your Learning Progress\n" +
                "Hello, " + wholeName + "!" + " You have accomplished our " + course + " course!";
        System.out.println(letter);
    }

    public void console() {
        Set<Integer> student_notified_set = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : pointsMap.entrySet()) {
            completed =  store.getStudent(entry.getKey()).getCompleted();
            checkCompleted(entry.getValue());
        }

        for (int key : keySet) {
            completed = store.getStudent(key).getCompleted();
            notified = store.getStudent(key).getNotified();
            if(completed.get(Java).equals(true) && notified.get(Java).equals(false)) {
                processNotify(key, languages.Java.name());
                notified.set(Java, true);
                student_notified_set.add(key);
            }
            if(completed.get(DSA).equals(true) && notified.get(DSA).equals(false)) {
                processNotify(key, languages.DSA.name());
                notified.set(DSA, true);
                student_notified_set.add(key);

            }
            if(completed.get(Databases).equals(true) && notified.get(Databases).equals(false)) {
                processNotify(key, languages.Databases.name());
                notified.set(Databases, true);
                student_notified_set.add(key);

            }
            if(completed.get(Spring).equals(true) && notified.get(Spring).equals(false)) {
                processNotify(key, languages.Spring.name());
                notified.set(Spring, true);
                student_notified_set.add(key);

            }
        }
        System.out.printf("Total %d students have been notified.\n", student_notified_set.size());
    }
    public void execute() {
        console();
    }
}



package tracker;

import java.util.*;

public class Notify implements Command{
    Store store;
    int JAVA_REQUIRED = 600;
    int DSA_REQUIRED = 400;
    int DATABASES_REQUIRED = 480;
    int SPRING_REQUIRED = 550;

    public String getName() {
        return this.name;
    }

    Set<Integer> keySet;
    private final Map<Integer, List<Integer>> pointsMap = new HashMap<>();
    //private final Map<Integer, List<Integer>> pointSubmissionList;
    String name = "notify";
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

    private void message(String name, String email) {

    }

    public void console() {
        String wholeName;
        String email;
        System.out.println("Notify - all graduates");
        System.out.println("pointsMap: " + pointsMap);
        System.out.println("keySet: " + keySet);
        for(int k : keySet) {
            wholeName = store.getStudent(k).getFirstName() + " " + store.getStudent(k).getLastName();
            email = store.getStudent(k).getEmail();
            System.out.println(wholeName + " " + email);
        }

        //Set<Map.Entry<Integer, List<Integer>>> me = pointsMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> id : pointsMap.entrySet()) {
            System.out.println("key: " + id.getKey() + " value: " + id.getValue());
            List<Boolean> completed =  store.getStudent(id.getKey()).getCompleted();
            System.out.println("completed: " + completed);
            List<Boolean> notified =  store.getStudent(id.getKey()).getNotified();
            System.out.println("notified: " + notified);
        }
    }
    public void execute() {
        console();
    }
}

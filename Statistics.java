package tracker;

import java.util.*;
public class Statistics implements Command {
    Store store;
    List<String> courses = List.of("java","dsa", "databases", "spring");
    private final Map<Integer, List<Integer>> pointsMap = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    String name = "statistics";
    Statistics(){
        Interface.activeCommand = RESERVED.statistics;
        this.store = Store.getInstance();
        initializePointsMap();
    }
    public String getName() {
        return this.name;
    }
    private void initializePointsMap() {
        Set<Integer> keySet = store.getKeySet();
        System.out.println(keySet.toString());
        for (Integer studentId : keySet) {
            pointsMap.put(studentId, new ArrayList<>());
        }
        for (Integer studentId : keySet) {
            pointsMap.get(studentId).add(store.getStudent(studentId).getJava());
            pointsMap.get(studentId).add(store.getStudent(studentId).getDsa());
            pointsMap.get(studentId).add(store.getStudent(studentId).getDatabases());
            pointsMap.get(studentId).add(store.getStudent(studentId).getSpring());
        }
        System.out.println(pointsMap.values());
    }
    private boolean validateCourse(List<String> rawInput) {
        return courses.contains(rawInput.get(0).toLowerCase());
    }
    private boolean inputChecks(List<String> rawInput) {
        return rawInput.size() == 1;
    }
    public void console() {
        Calculations calculations = new Calculations(pointsMap);
        System.out.println("Type the name of a course to see details or 'back' to quit:");
        calculations.printCategories();
        while (true) {
            List<String> rawInput = Arrays.asList(scanner.nextLine().split("\\s+"));

            if (!inputChecks(rawInput)) {
                System.out.println("Unknown course");
                continue;
            }
            if (rawInput.isEmpty() || rawInput.get(0).equals("")) {
                System.out.println("Statistics::console is Empty");
                continue;
            }
            if (rawInput.get(0).equalsIgnoreCase("back") && (rawInput.size() == 1)) {
                new Back();
                break;
            }  else {
                if (!validateCourse(rawInput)) {
                    System.out.println("Unknown course");
                    //continue;
                } else {
                    calculations.printCourseDetails(rawInput.get(0));
                }
            }
        }
    }
    public void execute() {
        console();
    }
}
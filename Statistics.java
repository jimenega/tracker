package tracker;

//import java.util.ArrayList;
import java.util.*;

//import java.util.regex.Pattern;
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

    /*private void printCategories() {
        System.out.println("Most popular: " + "n/a");
        System.out.println("Least popular: " + "n/a");
        System.out.println("Highest activity: " + "n/a");
        System.out.println("Lowest activity: " + "n/a");
        System.out.println("Easiest course: " + "n/a");
        System.out.println("Hardest course: " + "n/a");
    }*/

    /*private void printCourseDetails() {
        System.out.println("id" + "   " + "points" + "   " + "completed");
    }*/

    private boolean validateCourse(List<String> rawInput) {
        return courses.contains(rawInput.get(0).toLowerCase());
    }
    private boolean inputChecks(List<String> rawInput) {
        return rawInput.size() == 1;
    }
    /*private int matchInput(List<String> rawInput) {
        List<String> rawCopy = new ArrayList<>(rawInput);
        int id = 0;
        String rawCopyString = rawCopy.toString()
                .replaceAll("\\[", "")
                .replaceAll("]","");
        boolean matches = Pattern.matches("[^-]\\d*", rawCopyString);
        if (matches) {
            id = Integer.parseInt(rawCopy.get(0));
        }
        return id;
    }*/
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
                /*int id = matchInput(rawInput);
                Student student = store.getStudent(id);
                if(student != null) {
                    System.out.println(id + " points:"
                            + " Java=" + student.getJava()
                            + "; DSA=" + student.getDsa()
                            + "; Databases=" + student.getDatabases()
                            + "; Spring=" + student.getSpring());*/
                if (!validateCourse(rawInput)) {
                    System.out.println("Unknown course");
                    //continue;
                } else {
                    //printCourseDetails();
                    //initializePointsMap();
                    //calculations = new Calculations(pointsMap);
                    calculations.printCourseDetails(rawInput.get(0));

                }
            }
        }
    }
    public void execute() {
        console();
    }
}
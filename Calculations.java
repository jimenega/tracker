package tracker;

import java.util.List;
import java.util.Map;
public class Calculations {
    int Java = 0; int DSA = 1; int Databases = 2; int Spring = 3;
    enum languages {Java, DSA, Databases, Spring}
    private final int JAVA_REQUIRED = 600;
    private final int DSA_REQUIRED = 400;
    private final int DATABASES_REQUIRED = 480;
    private final int SPRING_REQUIRED = 550;
    private int JAVA_ENROLLED;
    private int DSA_ENROLLED;
    private int DATABASES_ENROLLED;
    private int SPRING_ENROLLED;
    private int JAVA_SUBMISSIONS;
    private int DSA_SUBMISSIONS;
    private int DATABASES_SUBMISSIONS;
    private int SPRING_SUBMISSIONS;
    private int JAVA_AVERAGE;
    private int DSA_AVERAGE;
    private int DATABASES_AVERAGE;
    private int SPRING_AVERAGE;
    private final Map<Integer, List<Integer>> pointsMap;
    Map<Integer, List<Integer>> pointsSubmissionList;
    public Calculations(Map<Integer, List<Integer>> pointsMap, Map<Integer, List<Integer>> pointsSubmissionList) {
        this.pointsMap = pointsMap;
        this.pointsSubmissionList = pointsSubmissionList;
        initializeEnrolled();
    }
    protected void printCourseDetails(String language) {
        if ("java".equalsIgnoreCase(language)) System.out.println("Java");
        if ("dsa".equalsIgnoreCase(language)) System.out.println("DSA");
        if ("databases".equalsIgnoreCase(language)) System.out.println("Databases");
        if ("spring".equalsIgnoreCase(language)) System.out.println("Spring");
        System.out.println("id" + "   " + "points" + "   " + "completed");
        System.out.println("Enrolled: " + JAVA_ENROLLED + " " + DSA_ENROLLED +
                            " " + DATABASES_ENROLLED + " " + SPRING_ENROLLED);
    }
    protected void printCategories() {
        System.out.println("Most popular: " + "n/a");
        System.out.println("Least popular: " + "n/a");
        System.out.println("Highest activity: " + "n/a");
        System.out.println("Lowest activity: " + "n/a");
        System.out.println("Easiest course: " + "n/a");
        System.out.println("Hardest course: " + "n/a");
    }
    private void initializeEnrolled() {
        for (languages language : languages.values()) {
            for (Integer studentId : pointsMap.keySet()) {
                if (language.equals(languages.Java) && !pointsMap.get(studentId).get(Java).equals(0)) {
                    JAVA_ENROLLED++;
                }
                if (language.equals(languages.DSA) && !pointsMap.get(studentId).get(DSA).equals(0)) {
                    DSA_ENROLLED++;
                }
                if (language.equals(languages.Databases) && !pointsMap.get(studentId).get(Databases).equals(0)) {
                    DATABASES_ENROLLED++;
                }
                if (language.equals(languages.Spring) && !pointsMap.get(studentId).get(Spring).equals(0)) {
                    SPRING_ENROLLED++;
                }
            }
        }
    }
    private void submissions() {

    }
    private void popular() {

    }
    private void activity() {

    }
    private void effort() {
    }

    protected void topLearner() {
        //todo:  Working here
        /*for (Integer i : pointsMap.keySet()) {
            System.out.println(i + " " + pointsMap.get(i).get(Java));
        }*/
        for (Integer i : pointsSubmissionList.keySet()) {
            System.out.println("points submission List for: " + i + " " + pointsSubmissionList.get(i));
        }
    }
}

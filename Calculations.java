package tracker;

import java.util.List;
import java.util.Map;

public class Calculations {
    int Java = 0; int DSA = 1; int Database = 2; int Spring = 3;
    enum languages {Java, DSA, Database, Spring}

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
    public Calculations(Map<Integer, List<Integer>> pointsMap) {
        this.pointsMap = pointsMap;
        System.out.println("Calculations follow:");
        System.out.println(pointsMap.toString());

        //todo: EXPERIMENTAL
        for (languages language : languages.values()) {
            enrolled(language);
        }
        System.out.println("JAVA_ENROLLED count: " + JAVA_ENROLLED);
        System.out.println("DSA_ENROLLED count: " + DSA_ENROLLED);
        System.out.println("DATABASES_ENROLLED count: " + DATABASES_ENROLLED);
        System.out.println("SPRING_ENROLLED count: " + SPRING_ENROLLED);
    }
    private void enrolled(languages language) {  //todo: impacted - Experimental
        for (Integer studentId : pointsMap.keySet()) {
            if ( language.equals(languages.Java) && !pointsMap.get(studentId).get(Java).equals(0)) {
                JAVA_ENROLLED++;
            }

            if (language.equals(languages.DSA) && !pointsMap.get(studentId).get(DSA).equals(0)) {
                DSA_ENROLLED++;
            }

            if (language.equals(languages.Database) && !pointsMap.get(studentId).get(Database).equals(0)) {
                DATABASES_ENROLLED++;
            }

            if (language.equals(languages.Spring) && !pointsMap.get(studentId).get(Spring).equals(0)) {
                SPRING_ENROLLED++;
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

    private void topLearner() {

    }
}

package tracker;
import java.math.BigDecimal;
import java.util.*;
import java.math.*;
import java.util.List;

public class Calculations {
    private final int Java = 0;
    private final int DSA = 1;
    private final int Databases = 2;
    private final int Spring = 3;
    private enum languages {Java, DSA, Databases, Spring}
    private int JAVA_ENROLLED;
    private int DSA_ENROLLED;
    private int DATABASES_ENROLLED;
    private int SPRING_ENROLLED;
    private int JAVA_SUBMISSIONS;
    private int DSA_SUBMISSIONS;
    private int DATABASES_SUBMISSIONS;
    private int SPRING_SUBMISSIONS;
    private int JAVA_TOTAL_POINTS;
    private int DSA_TOTAL_POINTS;
    private int DATABASES_TOTAL_POINTS;
    private int SPRING_TOTAL_POINTS;
    private BigDecimal JAVA_AVERAGE = BigDecimal.ZERO;
    private BigDecimal DSA_AVERAGE = BigDecimal.ZERO;
    private BigDecimal DATABASES_AVERAGE = BigDecimal.ZERO;
    private BigDecimal SPRING_AVERAGE = BigDecimal.ZERO;
    private final Map<Integer, List<Integer>> pointSubmissionList;
    private final Map<Integer, List<Integer>> pointsMap;

    protected Calculations(Map<Integer, List<Integer>> pointsMap, Map<Integer, List<Integer>> pointSubmissionList) {
        this.pointSubmissionList = pointSubmissionList;
        this.pointsMap = pointsMap;
        boolean category = false;
        if(pointSubmissionList.size() != 0) {
            initializeEnrolled();
            initializeSubmissions();
            initializeCourseAverage();
            category = true;
        }
        categoriesPrint(category);
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

    private void initializeSubmissions() {
        for (Integer number : pointSubmissionList.keySet()) {
            if (!pointSubmissionList.get(number).get(0).equals(0)) JAVA_SUBMISSIONS++;
            if (!pointSubmissionList.get(number).get(1).equals(0)) DSA_SUBMISSIONS++;
            if (!pointSubmissionList.get(number).get(2).equals(0)) DATABASES_SUBMISSIONS++;
            if (!pointSubmissionList.get(number).get(3).equals(0)) SPRING_SUBMISSIONS++;
        }
    }

    private void initializeCourseAverage() {
        for (Integer student_id : pointsMap.keySet()) {
            JAVA_TOTAL_POINTS += pointsMap.get(student_id).get(Java);
            DSA_TOTAL_POINTS += pointsMap.get(student_id).get(DSA);
            DATABASES_TOTAL_POINTS += pointsMap.get(student_id).get(Databases);
            SPRING_TOTAL_POINTS += pointsMap.get(student_id).get(Spring);
        }
        if(JAVA_SUBMISSIONS != 0)
            JAVA_AVERAGE = BigDecimal.valueOf(JAVA_TOTAL_POINTS / ((double) JAVA_SUBMISSIONS)).setScale(1, RoundingMode.HALF_UP);
        if(DSA_SUBMISSIONS != 0)
            DSA_AVERAGE = BigDecimal.valueOf(DSA_TOTAL_POINTS / ((double) DSA_SUBMISSIONS)).setScale(1, RoundingMode.HALF_UP);
        if(DATABASES_SUBMISSIONS != 0)
            DATABASES_AVERAGE = BigDecimal.valueOf(DATABASES_TOTAL_POINTS / ((double) DATABASES_SUBMISSIONS)).setScale(1, RoundingMode.HALF_UP);
        if(SPRING_SUBMISSIONS != 0)
            SPRING_AVERAGE = BigDecimal.valueOf(SPRING_TOTAL_POINTS / ((double) SPRING_SUBMISSIONS)).setScale(1, RoundingMode.HALF_UP);
    }

    private void topLearnersCalc(int languageIndex, int requiredPoints) {
        List<Results> resultsList = new ArrayList<>();
        System.out.println("id" + "   " + "points" + "   " + "completed");
        for (Integer studentId : pointsMap.keySet()) {
            Double numerator = Double.valueOf(pointsMap.get(studentId).get(languageIndex));
            final BigDecimal classAverage = BigDecimal.valueOf(numerator / requiredPoints * 100).setScale(1, RoundingMode.HALF_UP);
            Results result = new Results(studentId, pointsMap.get(studentId).get(languageIndex), classAverage.doubleValue());
            if (numerator != 0) {
                resultsList.add(result);
            }
        }
        Comparator<Results> comparator = Comparator.comparing(Results::getPoints).reversed().thenComparing(Results::getId);
        resultsList.sort(comparator);
        for (Results result : resultsList) {
            System.out.println(result.toString());
        }
    }

    protected void topLearners(String language) {  //protected
        int languageIndex;
        int requiredPoints;
        language  = language.toLowerCase();
        int JAVA_REQUIRED = 600;
        int DSA_REQUIRED = 400;
        int DATABASES_REQUIRED = 480;
        int SPRING_REQUIRED = 550;
        switch (language) {
            case  "java" :
                requiredPoints = JAVA_REQUIRED;
                languageIndex = languages.Java.ordinal();
                System.out.println(languages.Java);
                topLearnersCalc(languageIndex, requiredPoints);
                break;
            case  "dsa" :
                requiredPoints = DSA_REQUIRED;
                languageIndex = languages.DSA.ordinal();
                System.out.println(languages.DSA);
                topLearnersCalc(languageIndex, requiredPoints);
                break;
            case  "databases" :
                requiredPoints = DATABASES_REQUIRED;
                languageIndex = languages.Databases.ordinal();
                System.out.println(languages.Databases);
                topLearnersCalc(languageIndex, requiredPoints);
                break;
            case  "spring" :
                requiredPoints = SPRING_REQUIRED;
                languageIndex = languages.Spring.ordinal();
                System.out.println(languages.Spring);
                topLearnersCalc(languageIndex, requiredPoints);
                break;
            default:
                System.out.println("Unknown course." +"\n");
        }
    }

    private List<List<languages>> popularity() {
        return getLists(JAVA_ENROLLED, DSA_ENROLLED, DATABASES_ENROLLED, SPRING_ENROLLED);
    }

    private List<List<languages>> activity() {
        return getLists(JAVA_SUBMISSIONS, DSA_SUBMISSIONS, DATABASES_SUBMISSIONS, SPRING_SUBMISSIONS);
    }

    private List<List<languages>> getLists(int java_value, int dsa_value, int databases_value, int spring_value) {
        List<Integer> course_list = new ArrayList<>(List.of(java_value, dsa_value, databases_value, spring_value));
        List<languages> high_list = new ArrayList<>();
        List<languages> low_list = new ArrayList<>();
        int value_max = course_list.get(0);
        int value_min = course_list.get(course_list.size() - 1);
        for (int value : course_list) {
                value_max = Math.max(value, value_max);
                value_min = Math.min(value, value_min);
        }
        if(java_value == value_max) high_list.add(languages.Java);
        if(dsa_value == value_max) high_list.add(languages.DSA);
        if(databases_value == value_max) high_list.add(languages.Databases);
        if(spring_value == value_max) high_list.add(languages.Spring);
        if(java_value == value_min) low_list.add(languages.Java);
        if(dsa_value == value_min) low_list.add(languages.DSA);
        if(databases_value == value_min) low_list.add(languages.Databases);
        if(spring_value == value_min) low_list.add(languages.Spring);
        return List.of(high_list, low_list);
    }

    private List<List<languages>> complexity() {
        TreeMap<languages, BigDecimal> course_average_map = new TreeMap<>();
        List<BigDecimal> course_level_list = new ArrayList<>(List.of(JAVA_AVERAGE, DSA_AVERAGE, DATABASES_AVERAGE, SPRING_AVERAGE));
        List<languages> easiest_course_list = new ArrayList<>();
        List<languages> hardest_course_list = new ArrayList<>();
        for ( languages language : languages.values()) {
            course_average_map.put(language, course_level_list.get(language.ordinal()));
        }
        BigDecimal bd_max = course_average_map.firstEntry().getValue();
        BigDecimal bd_min = course_average_map.lastEntry().getValue();
        for (BigDecimal value : course_average_map.values()) {
            if(!Objects.equals(value, BigDecimal.ZERO)) {
                bd_max = bd_max.max(value);
                bd_min = bd_min.min(value);
            }
        }
        complexityAddToList(course_average_map, easiest_course_list, bd_max);
        complexityAddToList(course_average_map, hardest_course_list, bd_min);
        return List.of(easiest_course_list, hardest_course_list);
    }

    private void complexityAddToList(TreeMap<languages, BigDecimal> course_average_map, List<languages> course_list, BigDecimal value) {
        if(JAVA_SUBMISSIONS != 0 && course_average_map.get(languages.Java).equals(value)) course_list.add(languages.Java);
        if(DSA_SUBMISSIONS != 0 && course_average_map.get(languages.DSA).equals(value)) course_list.add(languages.DSA);
        if(DATABASES_SUBMISSIONS != 0 && course_average_map.get(languages.Databases).equals(value)) course_list.add(languages.Databases);
        if(SPRING_SUBMISSIONS != 0 && course_average_map.get(languages.Spring).equals(value)) course_list.add(languages.Spring);
    }

    private void categoriesPrint(boolean category) {  //protected ?
        List<List<languages>> popularity = popularity();
        List<List<languages>> activity = activity();
        List<List<languages>> complexity = complexity();
        System.out.println("Type the name of a course to see details or 'back' to quit:");
        if (category) {
            System.out.println("Most popular: "     + popularity.get(0).toString().replace("[","")
                    .replace("]", ""));
            System.out.println("Least popular: "    + popularity.get(1).toString().replace("[","")
                    .replace("]", ""));
            System.out.println("Highest activity: " + activity.get(0).toString().replace("[","")
                    .replace("]", ""));
            System.out.println("Lowest activity: "  + activity.get(1).toString().replace("[","")
                    .replace("]", ""));
            System.out.println("Easiest course: "   + complexity.get(0).toString().replace("[","")
                    .replace("]", ""));
            System.out.println("Hardest course: "   + complexity.get(1).toString().replace("[","")
                    .replace("]", ""));
        } else {
            System.out.println("Most popular: n/a");
            System.out.println("Least popular: n/a");
            System.out.println("Highest activity: n/a");
            System.out.println("Lowest activity: n/a");
            System.out.println("Easiest course: n/a");
            System.out.println("Hardest course: n/a");
        }
    }
}
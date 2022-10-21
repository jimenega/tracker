package tracker;

import java.util.List;
import java.util.Map;

public class Calculations {

    private final Map<Integer, List<Integer>> pointsMap;

    public Calculations(Map<Integer, List<Integer>> pointsMap) {
        this.pointsMap = pointsMap;
        System.out.println("Calculations follow:");
        System.out.println(pointsMap.toString());
    }
}

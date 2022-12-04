package tracker;

public class Results {
    private final int id;
    private final int points;
    private final double average;
    public int getId() {
        return id;
    }
    public int getPoints() {
        return points;
    }
    public Results(int id, int points, double average) {
        this.id = id;
        this.points = points;
        this.average = average;
    }
    @Override
    public String toString() {
        return id + "  " + points + "      " + average + "%";
    }
}

package tracker;

public interface Command {
    enum RESERVED {exit, add, back, students, points, list, find, statistics}
    void execute();
    String getName();

}

package tracker;

public interface Command {
    enum RESERVED {exit, add, back, students, points}
    void execute();
    String getName();

}

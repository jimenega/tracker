package tracker;

public interface Command {
    enum RESERVED {exit, add, back, student}
    void execute();
    String getName();

}

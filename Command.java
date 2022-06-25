package tracker;

public interface Command {
    enum RESERVED {exit, add, back}
    void execute();
    String getName();

}

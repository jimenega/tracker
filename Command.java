package tracker;

public interface Command {
    enum RESERVED {exit}
    void execute();
    String getName();

}

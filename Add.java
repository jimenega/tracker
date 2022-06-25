package tracker;

public class Add implements Command{
    String name = "add";
    Add(){
        Interface.activeCommand = RESERVED.add;
    }
    public String getName() {
        return this.name;
    }
    public void execute() {
        Message.tmpAddMessage();
        Interface.commandLevel = 1;
    }
}

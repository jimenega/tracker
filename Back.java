package tracker;

public class Back implements Command {
    String name = "back";
    Back(){
        Interface.activeCommand = RESERVED.back;
    }
    public String getName() {
        return this.name;
    }
    public void execute() {
        Message.backCommand1_M();
        Interface.commandLevel = 0;
    }
}

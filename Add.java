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

    void control(String cmd1) {
        if(cmd1.equals("students")) studentsCtrl();
        else if(cmd1.equals("points")) pointsCtrl();
    }

    void studentsCtrl() {
        System.out.println("Enter student credentials or 'back' to return");
    }

    void pointsCtrl() {
        System.out.println("Enter an id and points or 'back' to return");
    }
}

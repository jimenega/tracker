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
        Interface.commandLevel = 1;
    }
    void control(String cmd1) {
        if(cmd1.equals("students")) studentsCtrl();
        else if(cmd1.equals("points")) pointsCtrl();
    }
    void studentsCtrl() {
        Dialog studentDialog = new Dialog("students");
        studentDialog.getStudent();
    }
    void pointsCtrl() {
        Dialog pointsDialog = new Dialog("points");
        pointsDialog.getPoints();
    }
}
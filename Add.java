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
        //todo: add new class Dialog - box to handle students.
        //      Do the same for points
        //      Then, add class Patterns
        //      to check student data using match/regex.
        //      Consider a class Store for future data storage/database.
        //      Configure studentDialog here: add regex checker obj ? add store for data ?
        //new Dialog("students").getData();
        Dialog studentDialog = new Dialog("students");
        studentDialog.getStudentData();
        //studentDialog = null;
    }

    void pointsCtrl() {
        System.out.println("Enter an id and points or 'back' to return");
    }
}

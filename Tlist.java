package tracker;
public class Tlist implements Command {
    String name = "list";
    Tlist(){
        Interface.activeCommand = RESERVED.list;
    }
    public String getName() {
        return this.name;
    }
    public void execute() {
        //Message.printBye_M();
        //Main.trackerON = false;
        //System.exit(1);
        //todo:  List STUDENTS: if no students then: print: No students found
        System.out.println("No students found");
    }
}

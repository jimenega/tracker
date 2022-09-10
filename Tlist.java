package tracker;
public class Tlist implements Command {
    String name = "list";
    Store store;
    Tlist(){
        Interface.activeCommand = RESERVED.list;
        this.store = Store.getInstance();
    }
    public String getName() {
        return this.name;
    }
    public void execute() {
        //List Students: if no students then: print: No students found.
        boolean isListEmpty = store.tryList();
        if(isListEmpty) {
            System.out.println("No students found.");
        } else {
            System.out.println("Students:");
            store.printList();
        }
    }
}

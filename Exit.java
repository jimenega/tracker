package tracker;
class Exit implements Command{
    String name = "exit";
    Exit(){
        Interface.activeCommand = RESERVED.exit;
    }
    public String getName() {
        return this.name;
    }
    public void execute() {
        Message.printBye_M();
        Main.trackerON = false;
        System.exit(1);
    }
}

package tracker;

class Exit implements Command{
    String name = "exit";

    Exit(){
        System.out.println("Command name: " + this.name);
    }

    public String getName() {
        return this.name;
    }

    public void execute() {
        System.out.println("Bye!");
        Main.trackerON = false;
    }
}

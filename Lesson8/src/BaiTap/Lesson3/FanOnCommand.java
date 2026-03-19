package BaiTap.Lesson3;

public class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        System.out.print("Undo: ");
        fan.off();
    }
}
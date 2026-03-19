package BaiTap.Lesson3;

public class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.off();
    }

    public void undo() {
        System.out.print("Undo: ");
        fan.on();
    }
}

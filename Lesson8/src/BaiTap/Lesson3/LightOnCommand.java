package BaiTap.Lesson3;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        System.out.print("Undo: ");
        light.off();
    }
}
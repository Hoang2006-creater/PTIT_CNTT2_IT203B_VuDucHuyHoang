public class Command {

    public static void main(String[] args) {

        Light light = new Light();

        LightCommand on = new TurnOnLight(light);
        LightCommand off = new TurnOffLight(light);

        RemoteLight remote = new RemoteLight();

        remote.setLightCommand(on);
        remote.pressButton();

        remote.setLightCommand(off);
        remote.pressButton();

        remote.undoButton();
    }
}

class Light {

    public void turnOn() {
        System.out.println("Den da bat");
    }

    public void turnOff() {
        System.out.println("Den da tat");
    }
}

// Command Interface
interface LightCommand {

    void excute(); // Thực thi

    void undo(); // Hoàn tác
}

// Concrete Command
class TurnOnLight implements LightCommand {

    private Light light;

    public TurnOnLight(Light light) {
        this.light = light;
    }

    public void excute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}

// Concrete Command
class TurnOffLight implements LightCommand {

    private Light light;

    public TurnOffLight(Light light) {
        this.light = light;
    }

    public void excute() {
        light.turnOff();
    }

    public void undo() {
        light.turnOn();
    }
}

// Invoker
class RemoteLight {

    private LightCommand lightCommand;

    public void setLightCommand(LightCommand lightCommand) {
        this.lightCommand = lightCommand;
    }

    public void pressButton() {
        lightCommand.excute();
    }

    public void undoButton() {
        lightCommand.undo();
    }
}
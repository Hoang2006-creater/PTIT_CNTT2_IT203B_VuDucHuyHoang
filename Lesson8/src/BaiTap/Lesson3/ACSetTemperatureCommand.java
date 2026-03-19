package BaiTap.Lesson3;

public class ACSetTemperatureCommand implements Command {
    private AirConditioner ac;
    private int newTemp;
    private int prevTemp;

    public ACSetTemperatureCommand(AirConditioner ac, int newTemp) {
        this.ac = ac;
        this.newTemp = newTemp;
    }

    public void execute() {
        prevTemp = ac.getTemperature(); // lưu lại
        ac.setTemperature(newTemp);
    }

    public void undo() {
        System.out.print("Undo: ");
        ac.setTemperature(prevTemp);
    }
}
package BaiTap.Lesson5;

import BaiTap.Lesson4.Observer;

public class AirConditioner implements Observer {
    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            System.out.println("Điều hòa: Nhiệt độ = " + this.temperature + " (vẫn giữ)");
        }
    }

    public int getStatus() {
        return temperature;
    }
}
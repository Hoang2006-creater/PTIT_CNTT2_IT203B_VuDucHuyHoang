package BaiTap.Lesson5;

import BaiTap.Lesson4.Observer;

public class Fan implements Observer {
    private String speed = "Tắt";

    public void low() {
        speed = "Thấp";
        System.out.println("Quạt: Chạy tốc độ thấp");
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            speed = "Mạnh";
            System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
        }
    }

    public String getStatus() {
        return speed;
    }
}
package BaiTap.Lesson5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Thiết bị
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // Sensor
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach((Observer) fan);
        sensor.attach((Observer) ac);

        // Commands
        Command sleepMode = new SleepModeCommand(Arrays.asList(
                new LightOffCommand(light),
                new ACSetCommand(ac),
                new FanLowCommand(fan)
        ));

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kích hoạt chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ");
            System.out.println("3. Xem trạng thái");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sleepMode.execute();
                    break;

                case 2:
                    System.out.print("Nhập nhiệt độ: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 3:
                    System.out.println("Đèn: " + light.getStatus());
                    System.out.println("Quạt: " + fan.getStatus());
                    System.out.println("Điều hòa: " + ac.getStatus());
                    break;

                case 0:
                    return;
            }
        }
    }
}
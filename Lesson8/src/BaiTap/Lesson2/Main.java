package BaiTap.Lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor adapter = new ThermometerAdapter(oldThermometer);

        SmartHomeFacade smartHome = new SmartHomeFacade(adapter);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    smartHome.getCurrentTemperature();
                    break;
                case 2:
                    smartHome.leaveHome();
                    break;
                case 3:
                    smartHome.sleepMode();
                    break;
                case 0:
                    System.out.println("Thoát...");
                    return;
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}
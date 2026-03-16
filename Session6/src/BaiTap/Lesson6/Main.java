package BaiTap.Lesson6;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static SimulationManager manager = new SimulationManager();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MENU =====");

            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Tiếp tục mô phỏng");
            System.out.println("4. Thêm vé vào phòng");
            System.out.println("5. Xem thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> start();

                case 2 -> manager.stop();

                case 3 -> System.out.println("Đã tiếp tục hoạt động.");

                case 4 -> System.out.println("Chức năng demo.");

                case 5 -> StatisticsService.showStats(manager.getRooms());

                case 6 -> System.out.println("Đang quét deadlock...");

                case 7 -> {
                    System.out.println("Đang dừng hệ thống...");
                    System.exit(0);
                }
            }
        }
    }

    static void start() {

        System.out.print("Số phòng: ");
        int rooms = sc.nextInt();

        System.out.print("Số vé/phòng: ");
        int tickets = sc.nextInt();

        System.out.print("Số quầy: ");
        int counters = sc.nextInt();

        manager.start(rooms, tickets, counters);
    }
}
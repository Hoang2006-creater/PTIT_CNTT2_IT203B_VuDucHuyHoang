package BaiTap.Lesson6;

import java.util.List;

public class StatisticsService {

    public static void showStats(List<Room> rooms) {

        System.out.println("\n=== THỐNG KÊ HIỆN TẠI ===");

        int total = 0;

        for (Room room : rooms) {

            System.out.println(
                    room.getName()
                            + ": Đã bán "
                            + room.getSoldTickets()
                            + "/"
                            + room.getTotalTickets()
            );

            total += room.getSoldTickets();
        }

        System.out.println("Tổng doanh thu: " + total * 250000 + " VNĐ");
    }
}
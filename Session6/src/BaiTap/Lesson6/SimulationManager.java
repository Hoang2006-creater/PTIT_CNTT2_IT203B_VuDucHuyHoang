package BaiTap.Lesson6;

import java.util.*;
import java.util.concurrent.*;

public class SimulationManager {

    private List<Room> rooms = new ArrayList<>();

    private ExecutorService counters;

    private boolean paused = false;

    public void start(int roomCount, int ticketsPerRoom, int counterCount) {

        rooms.clear();

        for (int i = 1; i <= roomCount; i++) {

            rooms.add(new Room("Phòng " + (char)(64+i), ticketsPerRoom));
        }

        counters = Executors.newFixedThreadPool(counterCount);

        for (int i = 1; i <= counterCount; i++) {

            counters.submit(new TicketCounter(rooms));
        }

        new Thread(new DeadlockDetector()).start();

        System.out.println(
                "Đã khởi tạo hệ thống với "
                        + roomCount + " phòng, "
                        + (roomCount*ticketsPerRoom)
                        + " vé, "
                        + counterCount + " quầy"
        );
    }

    public void stop() {

        if (counters != null) {

            counters.shutdownNow();
        }

        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
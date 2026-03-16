package BaiTap.Lesson6;

import java.util.List;

public class TicketCounter implements Runnable {

    private List<Room> rooms;
    private boolean running = true;

    public TicketCounter(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void stop() {
        running = false;
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + " bắt đầu bán vé...");

        while (running) {

            for (Room room : rooms) {

                room.sellTicket();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
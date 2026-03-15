package BaiTap.Lesson4;

import java.util.*;

class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int ticketCounter = 1;

    public TicketPool(String roomName, int initialTickets) {

        this.roomName = roomName;

        for (int i = 0; i < initialTickets; i++) {
            addTicketInternal();
        }
    }

    private void addTicketInternal() {

        String id = roomName + "-" + String.format("%03d", ticketCounter++);
        tickets.add(new Ticket(id, roomName));
    }

    public synchronized Ticket sellTicket() {

        while (true) {

            for (Ticket t : tickets) {

                if (!t.isSold()) {

                    t.setSold(true);
                    return t;
                }
            }

            try {

                System.out.println(Thread.currentThread().getName()
                        + ": Hết vé phòng " + roomName + ", đang chờ...");

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {
            addTicketInternal();
        }

        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);

        notifyAll();
    }
}

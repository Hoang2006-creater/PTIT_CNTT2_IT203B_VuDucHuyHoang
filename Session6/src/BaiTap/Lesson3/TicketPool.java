package BaiTap.Lesson3;

import java.util.*;

class TicketPool {

    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int total) {

        this.roomName = roomName;

        for (int i = 1; i <= total; i++) {
            tickets.add(new Ticket(roomName + "-" + i, roomName));
        }
    }

    public Ticket getAvailableTicket() {

        for (Ticket t : tickets) {
            if (!t.isSold) {
                t.isSold = true;
                return t;
            }
        }

        return null;
    }

    public void returnTicket(Ticket ticket) {
        ticket.isSold = false;
    }
}

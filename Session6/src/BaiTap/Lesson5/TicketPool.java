package BaiTap.Lesson5;

import java.util.*;

class TicketPool {

    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {

            tickets.add(new Ticket(
                    roomName + "-" + String.format("%03d", i),
                    roomName));
        }
    }

    public synchronized Ticket holdTicket(boolean vip, String counter) {

        for (Ticket t : tickets) {

            if (!t.isSold && !t.isHeld) {

                t.isHeld = true;
                t.isVIP = vip;
                t.holdExpiryTime = System.currentTimeMillis() + 5000;

                System.out.println(counter + ": Đã giữ vé "
                        + t.ticketId +
                        (vip ? " (VIP)" : "") +
                        ". Thanh toán trong 5s");

                return t;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket ticket, String counter) {

        if (ticket != null && ticket.isHeld) {

            ticket.isHeld = false;
            ticket.isSold = true;

            System.out.println(counter +
                    ": Thanh toán thành công vé " +
                    ticket.ticketId);
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld && now > t.holdExpiryTime) {

                t.isHeld = false;

                System.out.println(
                        "TimeoutManager: Vé "
                                + t.ticketId +
                                " hết hạn giữ, đã trả lại kho");
            }
        }
    }
}
package BaiTap.Lesson3;

class BookingCounter implements Runnable {

    String name;
    TicketPool firstPool;
    TicketPool secondPool;

    public BookingCounter(String name, TicketPool first, TicketPool second) {
        this.name = name;
        this.firstPool = first;
        this.secondPool = second;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (firstPool) {

                Ticket t1 = firstPool.getAvailableTicket();

                if (t1 == null) {
                    System.out.println(name + ": Hết vé phòng " + firstPool.roomName);
                    return;
                }

                System.out.println(name + ": Đã lấy vé " + t1.ticketId);

                try { Thread.sleep(500); } catch (Exception e) {}

                synchronized (secondPool) {

                    Ticket t2 = secondPool.getAvailableTicket();

                    if (t2 == null) {

                        firstPool.returnTicket(t1);

                        System.out.println(name + ": Bán combo thất bại");

                    } else {

                        System.out.println(name + " bán combo thành công: "
                                + t1.ticketId + " & " + t2.ticketId);
                    }
                }
            }
        }
    }
}

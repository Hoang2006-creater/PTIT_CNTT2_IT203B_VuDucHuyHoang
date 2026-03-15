package BaiTap.Lesson4;

class TicketSupplier implements Runnable {

    private TicketPool roomA;
    private TicketPool roomB;

    public TicketSupplier(TicketPool roomA, TicketPool roomB) {
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {

        try {

            while (true) {

                Thread.sleep(3000);

                roomA.addTickets(3);
                roomB.addTickets(3);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
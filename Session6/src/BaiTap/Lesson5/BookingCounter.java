package BaiTap.Lesson5;

import java.util.*;

class BookingCounter implements Runnable {

    String name;
    List<TicketPool> pools;

    Random random = new Random();

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            TicketPool pool = pools.get(
                    random.nextInt(pools.size()));

            boolean vip = random.nextInt(4) == 0;

            Ticket ticket = pool.holdTicket(vip, name);

            if (ticket != null) {

                try {

                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                }

                pool.sellHeldTicket(ticket, name);

            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

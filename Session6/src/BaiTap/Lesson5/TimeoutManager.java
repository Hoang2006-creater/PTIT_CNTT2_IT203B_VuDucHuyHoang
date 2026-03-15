package BaiTap.Lesson5;

import java.util.*;

class TimeoutManager implements Runnable {

    List<TicketPool> pools;

    public TimeoutManager(List<TicketPool> pools) {
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            for (TicketPool pool : pools) {

                pool.releaseExpiredTickets();
            }

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {
            }
        }
    }
}

package BaiTap.Lesson6;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector implements Runnable {

    public void run() {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        while (true) {

            long[] ids = bean.findDeadlockedThreads();

            if (ids != null) {
                System.out.println("⚠ Phát hiện deadlock!");
            } else {
                System.out.println("Không phát hiện deadlock.");
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
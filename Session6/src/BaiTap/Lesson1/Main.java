package BaiTap.Lesson1;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        TicketCounter counter1 = new TicketCounter("Quầy 1", roomA, roomB);
        TicketCounter counter2 = new TicketCounter("Quầy 2", roomA, roomB);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);

        TicketSupplier supplier =
                new TicketSupplier(roomA, roomB, 3, 3000, 3);

        Thread supplierThread = new Thread(supplier);

        t1.start();
        t2.start();
        supplierThread.start();

        supplierThread.join();

        Thread.sleep(10000);

        System.out.println("Kết thúc chương trình");
        System.out.println("Quầy 1 bán được: " + counter1.getSoldCount() + " vé");
        System.out.println("Quầy 2 bán được: " + counter2.getSoldCount() + " vé");

        System.exit(0);
    }
}

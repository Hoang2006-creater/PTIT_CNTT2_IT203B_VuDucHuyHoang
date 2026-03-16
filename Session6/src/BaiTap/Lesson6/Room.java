package BaiTap.Lesson6;

public class Room {

    private String name;
    private int totalTickets;
    private int soldTickets = 0;

    public Room(String name, int totalTickets) {
        this.name = name;
        this.totalTickets = totalTickets;
    }

    public synchronized boolean sellTicket() {

        if (soldTickets < totalTickets) {

            soldTickets++;

            System.out.println(Thread.currentThread().getName()
                    + " bán vé phòng " + name
                    + " (" + soldTickets + "/" + totalTickets + ")");

            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}

package BaiTap.Lesson1;
// Quay ban ve
 class TicketCounter implements Runnable {
    private String couterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;

    public TicketCounter(String couterName, TicketPool roomA, TicketPool roomB) {
        this.couterName = couterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run() {
    while(true){
        Ticket ticket = roomA.sellTicket();
        if(ticket == null){
            ticket=roomB.sellTicket();
        }
        if(ticket!= null){
            soldCount++;
            System.out.println(couterName+"Da ban ve"+ticket.getTicketId());
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else {
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
    }
        }
    }
}

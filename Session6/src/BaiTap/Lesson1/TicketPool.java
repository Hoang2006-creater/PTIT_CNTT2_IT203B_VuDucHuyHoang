package BaiTap.Lesson1;

import java.util.LinkedList;
import java.util.Queue;
// Kho ve
public class TicketPool {
    private Queue<Ticket> tickets = new LinkedList<>();
    private String roomName;
    private int ticketCounter = 1;

    public TicketPool(String roomName,int intitialTickets) {
        this.roomName=roomName;

        for(int i =0;i<intitialTickets;i++){
            addTicket();
        }
    }
    private void addTicket(){
        String id = roomName+" "+String.format("%03d",ticketCounter++);
        tickets.add(new Ticket(id,roomName));
    }
    public synchronized Ticket sellTicket(){
        if(!tickets.isEmpty()){
            return tickets.poll();
        }
        return null;
    }
    public synchronized void addTickets(int count){
        for(int i = 0;i<count;i++){
            addTicket();
        }
        System.out.println("Nha cung cap da them: "+count+"Ve vao phong");
    }

}

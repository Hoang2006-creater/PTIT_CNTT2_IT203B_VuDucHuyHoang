package BaiTap.Lesson3;

class Ticket {

    String ticketId;
    String roomName;
    boolean isSold = false;

    public Ticket(String id, String room) {
        this.ticketId = id;
        this.roomName = room;
    }
}
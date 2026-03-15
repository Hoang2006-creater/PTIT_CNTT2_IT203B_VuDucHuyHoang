package BaiTap.Lesson1;

class Ticket {
    private String ticketId;
    private String roomName;

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getRoomName() {
        return roomName;
    }
}

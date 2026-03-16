package Lesson5v6;

public class EmailNotification implements NotificationService {

    public void send(String message) {
        System.out.println("Đã gửi email: " + message);
    }
}
package Lesson5v6;

public class PrintInvoice implements NotificationService {

    public void send(String message) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}
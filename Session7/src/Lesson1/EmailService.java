package Lesson1;

public class EmailService {

    public void sendEmail(Customer customer, String message) {
        System.out.println("Đã gửi email đến " + customer.getEmail() + ": " + message);
    }
}
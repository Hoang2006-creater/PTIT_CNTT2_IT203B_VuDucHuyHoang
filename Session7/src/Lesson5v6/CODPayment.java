package Lesson5v6;

public class CODPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Xử lý thanh toán COD: " + amount + " - Thành công");
    }
}
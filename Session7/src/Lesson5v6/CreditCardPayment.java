package Lesson5v6;

public class CreditCardPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount + " - Thành công");
    }
}
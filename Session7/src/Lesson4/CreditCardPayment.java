package Lesson4;

public class CreditCardPayment implements CardPayable {
    @Override
    public void processCredirCard(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount + " - Thành công");
    }
}

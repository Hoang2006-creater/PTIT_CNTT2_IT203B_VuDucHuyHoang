package Lesson5v6;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void processOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {

        double total = InvoiceGenerator.generate(order);

        double finalAmount = discount.applyDiscount(total);

        System.out.println("Cần thanh toán: " + finalAmount);

        payment.pay(finalAmount);

        order.setFinalAmount(finalAmount);

        repository.save(order);

        notification.send("Đơn hàng " + order.getId() + " đã được tạo");
    }
}
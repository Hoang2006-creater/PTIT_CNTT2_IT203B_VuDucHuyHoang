package Lesson5v6;

public class MobileFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new HolidayDiscount(); // 15%
    }

    public PaymentMethod createPayment() {
        return new MomoPayment();
    }

    public NotificationService createNotification() {
        return new PushNotification();
    }
}

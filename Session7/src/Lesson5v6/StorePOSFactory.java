package Lesson5v6;

public class StorePOSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new PercentageDiscount(5);
    }

    public PaymentMethod createPayment() {
        return new CODPayment();
    }

    public NotificationService createNotification() {
        return new PrintInvoice();
    }
}
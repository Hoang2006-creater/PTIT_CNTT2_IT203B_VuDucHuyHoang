package BaiTap.Lesson6;

import java.util.*;


interface DiscountStrategy {
    double applyDiscount(double amount);
}

interface PaymentMethod {
    void pay(double amount);
}

interface NotificationService {
    void notifyUser(String message);
}


interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();
    PaymentMethod createPaymentMethod();
    NotificationService createNotificationService();
}


class WebsiteDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        double discount = amount * 0.10;
        System.out.println("Áp dụng giảm giá 10%: " + discount);
        return amount - discount;
    }
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount);
    }
}

class EmailNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Gửi email: " + message);
    }
}

class WebsiteFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }

    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}

class FirstTimeDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        double discount = amount * 0.15;
        System.out.println("Áp dụng giảm giá 15% (lần đầu): " + discount);
        return amount - discount;
    }
}

class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount);
    }
}

class PushNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}

class MobileAppFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}


class MemberDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        double discount = amount * 0.05;
        System.out.println("Áp dụng giảm giá 5% (thành viên): " + discount);
        return amount - discount;
    }
}

class CODPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán khi nhận hàng (COD): " + amount);
    }
}

class PrintReceipt implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}

class POSFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}


class KioskDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        double discount = amount * 0.08;
        System.out.println("Áp dụng giảm giá 8% (Kiosk): " + discount);
        return amount - discount;
    }
}

class QRPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán QR: " + amount);
    }
}

class SMSNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Gửi SMS: " + message);
    }
}

class KioskFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new KioskDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new QRPayment();
    }

    public NotificationService createNotificationService() {
        return new SMSNotification();
    }
}


class OrderService {
    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void processOrder(String product, double price, int quantity) {
        double total = price * quantity;
        System.out.println("Sản phẩm: " + product + " | Tổng: " + total);

        double finalAmount = discount.applyDiscount(total);
        payment.pay(finalAmount);
        notification.notifyUser("Đơn hàng thành công");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CHỌN KÊNH =====");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");
        System.out.println("4. Kiosk (mới)");
        System.out.print("Chọn: ");

        int choice = sc.nextInt();
        sc.nextLine();

        SalesChannelFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                System.out.println("Bạn đã chọn kênh Website");
                break;
            case 2:
                factory = new MobileAppFactory();
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;
            case 3:
                factory = new POSFactory();
                System.out.println("Bạn đã chọn kênh POS");
                break;
            case 4:
                factory = new KioskFactory();
                System.out.println("Bạn đã chọn kênh Kiosk");
                break;
            default:
                System.out.println("Sai lựa chọn!");
                return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String product = sc.nextLine();

        System.out.print("Nhập giá: ");
        double price = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int quantity = sc.nextInt();

        OrderService orderService = new OrderService(factory);
        orderService.processOrder(product, price, quantity);
    }
}


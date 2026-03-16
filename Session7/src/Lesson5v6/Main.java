package Lesson5v6;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    static OrderRepository repo = new FileOrderRepository();
    static NotificationService notify = new EmailNotification();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tổng doanh thu");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addProduct();
                case 2 -> addCustomer();
                case 3 -> createOrder();
                case 4 -> showOrders();
                case 5 -> revenue();
                case 0 -> System.exit(0);

            }
        }
    }

    static void addProduct() {

        System.out.print("Mã: ");
        String id = sc.nextLine();

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Danh mục: ");
        String category = sc.nextLine();

        products.add(new Product(id, name, price, category));

        System.out.println("Đã thêm sản phẩm " + id);
    }

    static void addCustomer() {

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("ĐT: ");
        String phone = sc.nextLine();

        customers.add(new Customer(name, email, phone));

        System.out.println("Đã thêm khách hàng");
    }

    static void createOrder() {

        if (customers.isEmpty() || products.isEmpty()) {
            System.out.println("Chưa có khách hàng hoặc sản phẩm");
            return;
        }

        Customer customer = customers.get(0);
        Product product = products.get(0);

        Order order = new Order("ORD" + (repo.findAll().size()+1), customer);

        order.addItem(new OrderItem(product,1));

        DiscountStrategy discount = new PercentageDiscount(10);

        PaymentMethod payment = new CreditCardPayment();

        OrderService service = new OrderService(repo, notify);

        service.processOrder(order, discount, payment);
    }

    static void showOrders() {

        for (Order o : repo.findAll()) {

            System.out.println(
                    o.getId() + " - "
                            + o.getCustomer().getName()
                            + " - "
                            + o.getFinalAmount()
            );
        }
    }

    static void revenue() {

        double total = 0;

        for (Order o : repo.findAll()) {
            total += o.getFinalAmount();
        }

        System.out.println("Tổng doanh thu: " + total);
    }
}
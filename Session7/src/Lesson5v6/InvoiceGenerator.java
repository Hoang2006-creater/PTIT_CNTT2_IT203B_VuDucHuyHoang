package Lesson5v6;

public class InvoiceGenerator {

    public static double generate(Order order) {

        double total = 0;

        System.out.println(" HÓA ĐƠN ");
        System.out.println("Khách: " + order.getCustomer().getName());

        for (OrderItem item : order.getItems()) {

            double sub = item.getSubtotal();

            System.out.println(
                    item.getProduct().getName()
                            + " - Số lượng: " + item.getQuantity()
                            + " - Thành tiền: " + sub
            );

            total += sub;
        }

        System.out.println("Tổng tiền: " + total);

        return total;
    }
}

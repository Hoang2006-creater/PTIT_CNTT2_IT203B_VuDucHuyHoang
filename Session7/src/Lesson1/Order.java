package Lesson1;

import java.util.Map;


public class Order {

    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items;
    private double total;

    public Order(String orderId, Customer customer, Map<Product, Integer> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}

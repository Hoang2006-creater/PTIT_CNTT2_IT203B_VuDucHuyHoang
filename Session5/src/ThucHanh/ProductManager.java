package ThucHanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductManager {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product p) throws InvalidProductException {

        boolean exists = products.stream()
                .anyMatch(pr -> Objects.equals(pr.getId(), p.getId()));

        if (exists) {
            throw new InvalidProductException("ID đã tồn tại!");
        }

        products.add(p);
    }

    public void showProducts() {

        if (products.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }

        System.out.printf("%-5s %-15s %-10s %-10s %-15s\n",
                "ID", "Name", "Price", "Qty", "Category");

        products.forEach(p ->
                System.out.printf("%-5d %-15s %-10.2f %-10d %-15s\n",
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getQuantity(),
                        p.getCategory())
        );
    }

    // UPDATE
    public void updateQuantity(int id, int newQuantity)
            throws InvalidProductException {

        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (product.isPresent()) {
            product.get().setQuantity(newQuantity);
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm!");
        }
    }

    public void removeOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }
}
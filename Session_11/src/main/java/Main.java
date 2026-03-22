import entity.Product;
import impl.ProductRepositoryImpl;
import repository.ProductRepository;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductRepository repo = new ProductRepositoryImpl();

        //  1. GET ALL
        System.out.println(" DANH SÁCH SẢN PHẨM ");
        List<Product> products = repo.getProducts();
        for (Product product : products) {
            System.out.println(product);
        }

        // ===== 2. ADD =====
        System.out.println("\n=== THÊM SẢN PHẨM ===");
        Product newProduct = new Product();
        newProduct.setProName("Laptop Dell");
        newProduct.setProducer("Dell");
        newProduct.setYearMaking(2024);
        newProduct.setExpriryDate(Date.valueOf("2026-12-31"));
        newProduct.setPrice(1500.0);

        boolean addResult = repo.addProduct(newProduct);
        System.out.println("Thêm thành công: " + addResult);

        // ===== 3. UPDATE =====
        System.out.println("\n CẬP NHẬT SẢN PHẨM ID = 1 ");
        Product updateProduct = new Product();
        updateProduct.setProName("Laptop HP");
        updateProduct.setProducer("HP");
        updateProduct.setYearMaking(2025);
        updateProduct.setExpriryDate(Date.valueOf("2027-01-01"));
        updateProduct.setPrice(2000.0);

        boolean updateResult = repo.updateProduct(1, updateProduct);
        System.out.println("Cập nhật thành công: " + updateResult);

        // ===== 4. DELETE =====
        System.out.println("\n=== XOÁ SẢN PHẨM ID = 2 ===");
        boolean deleteResult = repo.deleteProduct(2);
        System.out.println("Xoá thành công: " + deleteResult);

        // ===== 5. GET LẠI =====
        System.out.println("\n=== DANH SÁCH SAU KHI THAO TÁC ===");
        List<Product> newList = repo.getProducts();
        for (Product product : newList) {
            System.out.println(product);
        }
    }
}
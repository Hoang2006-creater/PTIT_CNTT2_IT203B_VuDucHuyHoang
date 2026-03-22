package repository;

import entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getProducts();
    boolean addProduct(Product product);
    boolean updateProduct(Integer proId,Product product);
    boolean deleteProduct(Integer proId);
}

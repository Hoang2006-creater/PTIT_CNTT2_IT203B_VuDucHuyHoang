package ThucHanh;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();
    void addProduct(Product p);
    boolean updateProduct(Product p);
    boolean deleteProduct(String id);
}

package ThucHanh;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService{
    private static final List<Product> list = new ArrayList<>();
    static {
        list.add(new Product("ID101","Dien thoai Iphone",1000,2,"Dien Thoai"));
        list.add(new Product("ID102","Dien thoai Iphone",1000,2,"Dien Thoai" ));
        list.add(new Product("ID103","Dien thoai Iphone",1000,2,"Dien Thoai"));
    }
    @Override
    public List<Product> findAllProduct(){
        return list;
    }
    @Override
    public void addProduct(Product p ){
        list.add(p);
    }
    @Override
    public boolean updateProduct(Product newProduct) {
        for(Product p :list){
            if (p.getId().equalsIgnoreCase(newProduct.getId())){
                p.setQuantity(newProduct.getQuantity());
                return true;
            }
        }
        return false;
    }


    public boolean deleteProduct(String id ) {
        return list.removeIf(p->p.getId().equalsIgnoreCase(id));
    }
}


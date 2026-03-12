package ThucHanh;

import java.util.Date;
import java.util.Scanner;

public class Main {
        private static final IProductService productService = new ProductServiceImpl();
        public static void showProductMenu (Scanner sc ){
            while (true) {
                System.out.println("""
                        +--------------------MENU-------------------+
                        |1.  Thêm mới sản phẩm                      |
                        |2.  Hiển thị danh sách sản phẩm            |          |
                        |3. Cập nhật số lượng sản phẩm              |
                        |4. Xóa sản phẩm                            |
                        |5. Thoát                                   |
                        +-------------------------------------------+
                        """);
                System.out.println("Nhap lua chon");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
        }
    }
    private static void addProduct(Scanner sc){
        System.out.println("Nhap id");
        String id = sc.nextLine();

        System.out.println("Nhap ten san pham");
        String name = sc.nextLine();

        System.out.println("Nhap gia: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.println("Nhap so luong");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap danh muc: ");
        String category = sc.nextLine();

        Product p = new Product(id,name,price,quantity,category);
        productService.findAll().add(p);
    }
    private static void showListProduct()  List<Product> list = productService.findAll();

        if(list.isEmpty()){
        System.err.println("Khong co san pham nao");
        return;
    }
        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                "-".repeat(6),
                "-".repeat(27),
                "-".repeat(12),
                "-".repeat(7),
                "-".repeat(12),
                "-".repeat(22)
        );
        System.out.printf("| %-4s | %-25s | %-10s | %-5s | %-10s |\n",
                "ID", "Name", "Price", "Quantity", "Category"
                );
        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                "-".repeat(6),
                "-".repeat(27),
                "-".repeat(12),
                "-".repeat(7),
                "-".repeat(12),
                "-".repeat(22)
        );
        for(Product p :list){
        System.out.print(p);
    }
        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                "-".repeat(6),
                "-".repeat(27),
                "-".repeat(12),
                "-".repeat(7),
                "-".repeat(12),
                "-".repeat(22)
        );
}
}


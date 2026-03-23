package BaiTap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lesson1 {
    //Khi dùng Statement thì nó chỉ nối chuỗi chu không truyền vào tham số nên khi ví dụ mã độc được trèn thẳng vào thì sẽ gây hiển thị hết thông tin
    // PreparedStatement thì khác khi sẽ biên dịch trước các câu lệnh với placeholder và dữ liệu đầu vào chỉ là tham số
//    String sql = "Select * from doctors where code = ? and pass = ?";
//    PreparedStatement pstmt = conn.prepareStatement(sql);
//    ResultSet resultSet = pstmt.executeQuery();
}

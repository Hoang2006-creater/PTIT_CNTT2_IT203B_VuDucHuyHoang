package BaiTap;

import java.sql.PreparedStatement;

public class Lesson2 {
    // Vì preparedStatement k chuyền số thành chuỗi như Statemnt thay vào đó nó gửi giá trị số nguyên bản đến database
    // sau đó database sẽ tự hiểu đúng kiểu dữ liệu như double và int
    double temp = 37.5;
//    String sql = "Update Vitals set temperature = ?";
//    PreparedStatement pstmt = conn.PrepareStatement(sql);
//    pstmt.setDouble(1,temp);
//    pstmt.excuteUpdate();
}

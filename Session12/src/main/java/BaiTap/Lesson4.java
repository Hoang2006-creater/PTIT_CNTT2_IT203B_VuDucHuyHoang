package BaiTap;

public class Lesson4 {
    // Trong đoạn mã,mỗi vòng lặp tạo mới một Statemnt vaf gửi câu lệnh SQL khác nhau.Khiến database phải chạy lại 1000 cu lệnh và sinh ra execution plan 1.000 lần
    // Giải pháp là dùng prepareStatement
//    String sql = "INSERT INTO Results(data) VALUES(?)";
//    PreparedStatement pstmt = conn.prepareStatement(sql);
//
//            for (TestResult tr : list) {
//        pstmt.setString(1, tr.getData());
//        pstmt.executeUpdate();
//    }

}

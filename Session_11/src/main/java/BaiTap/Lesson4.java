package BaiTap;

public class Lesson4 {
    // Khi nối chuỗi thì cậu lệnh là SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
    // Vì trong đó điều kiện với mệnh đề where là 1 =1 luôn đúng nên trả về toàn bộ dữ liệu nạn nhân
    // Giải pháp là dùng replace để lọc dữ liệu đầu vào thay thế kí tự đặc biệt thành khoảng trống
//    String patientName = inputName;
//    patientName = patientName.replace("'", "");
//    patientName = patientName.replace("--", "");
//    patientName = patientName.replace(";", "");
//
//    String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
//
//    ResultSet rs = stmt.executeQuery(sql);
//}
}
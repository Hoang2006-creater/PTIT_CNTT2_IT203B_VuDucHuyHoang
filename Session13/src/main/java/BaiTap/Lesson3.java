package BaiTap;

public class Lesson3 {
    // Input: maBenhNhan (int): mã bệnh nhân, tienVienPhi (double): số tiền cần thanh toán
    // Output Thành công:
    //“Xuất viện và thanh toán thành công”
    //Thất bại:
    // Thông báo lỗi cụ thể
    //Đề xuất giải pháp
    //Sử dụng Transaction trong JDBC
    import java.sql.*;

    public class HospitalService {

        public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
            Connection conn = null;

            try {
                conn = DatabaseManager.getConnection();

                conn.setAutoCommit(false);

                String sqlGetBalance = "SELECT balance FROM Patient WHERE id = ?";
                PreparedStatement psGet = conn.prepareStatement(sqlGetBalance);
                psGet.setInt(1, maBenhNhan);

                ResultSet rs = psGet.executeQuery();

                if (!rs.next()) {
                    throw new Exception("Bệnh nhân không tồn tại!");
                }

                double balance = rs.getDouble("balance");


                if (balance < tienVienPhi) {
                    throw new Exception("Không đủ tiền để thanh toán!");
                }


                String sqlUpdateBalance =
                        "UPDATE Patient SET balance = balance - ? WHERE id = ?";
                PreparedStatement ps1 = conn.prepareStatement(sqlUpdateBalance);
                ps1.setDouble(1, tienVienPhi);
                ps1.setInt(2, maBenhNhan);

                int row1 = ps1.executeUpdate();

                if (row1 == 0) {
                    throw new Exception("Không trừ được tiền (bệnh nhân không tồn tại)");
                }

                String sqlUpdateBed =
                        "UPDATE Bed SET status = 'AVAILABLE' WHERE patient_id = ?";
                PreparedStatement ps2 = conn.prepareStatement(sqlUpdateBed);
                ps2.setInt(1, maBenhNhan);

                int row2 = ps2.executeUpdate();
                if (row2 == 0) {
                    throw new Exception("Không cập nhật được giường bệnh!");
                }

                String sqlUpdatePatient =
                        "UPDATE Patient SET status = 'DISCHARGED' WHERE id = ?";
                PreparedStatement ps3 = conn.prepareStatement(sqlUpdatePatient);
                ps3.setInt(1, maBenhNhan);

                int row3 = ps3.executeUpdate();


                if (row3 == 0) {
                    throw new Exception("Không cập nhật được trạng thái bệnh nhân!");
                }
                conn.commit();
                System.out.println("Xuất viện và thanh toán thành công!");

            } catch (Exception e) {

                try {
                    if (conn != null) {

                        conn.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Lỗi: " + e.getMessage());

            } finally {
                try {
                    if (conn != null) {
                        conn.setAutoCommit(true);
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package BaiTap.Lesson5;

import java.sql.*;

public class BenhNhanController {

    public void tiepNhanBenhNhan(String ten, int tuoi, int maGiuong, double soTien) {
        Connection conn = null;

        try {
            conn = DatabaseHelper.getConnection();
            conn.setAutoCommit(false);

            String checkBed = "SELECT status FROM Giuong WHERE id = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkBed);
            psCheck.setInt(1, maGiuong);

            ResultSet rs = psCheck.executeQuery();

            if (!rs.next() || !"AVAILABLE".equals(rs.getString("status"))) {
                throw new Exception("Giường không khả dụng!");
            }

            String insertBN = "INSERT INTO BenhNhan(ten, tuoi, maGiuong) VALUES (?, ?, ?)";
            PreparedStatement ps1 = conn.prepareStatement(insertBN, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, ten);
            ps1.setInt(2, tuoi);
            ps1.setInt(3, maGiuong);

            ps1.executeUpdate();

            ResultSet generatedKeys = ps1.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new Exception("Không tạo được bệnh nhân!");
            }

            int maBN = generatedKeys.getInt(1);

            String updateBed = "UPDATE Giuong SET status = 'OCCUPIED' WHERE id = ?";
            PreparedStatement ps2 = conn.prepareStatement(updateBed);
            ps2.setInt(1, maGiuong);

            if (ps2.executeUpdate() == 0) {
                throw new Exception("Không cập nhật được giường!");
            }

            String insertFinance = "INSERT INTO TaiChinh(maBenhNhan, soTien) VALUES (?, ?)";
            PreparedStatement ps3 = conn.prepareStatement(insertFinance);
            ps3.setInt(1, maBN);
            ps3.setDouble(2, soTien);

            if (ps3.executeUpdate() == 0) {
                throw new Exception("Không ghi được tài chính!");
            }

            conn.commit();
            System.out.println("Tiếp nhận bệnh nhân thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
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
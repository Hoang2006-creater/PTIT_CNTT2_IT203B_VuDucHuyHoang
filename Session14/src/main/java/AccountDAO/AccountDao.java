package AccountDAO;
package BaiTap.Lesson5.db;

import java.sql.*;

public class AccountDao {

    public static void transfer(String fromId, String toId, double amount) {

        Connection conn = null;
        PreparedStatement psCheck = null;
        CallableStatement cs = null;
        PreparedStatement psResult = null;
        ResultSet rs = null;

        try {
            conn = Utility.getConnection();

            if (conn == null) {
                throw new SQLException("Không kết nối được DB");
            }

            conn.setAutoCommit(false);

            String checkSql = "SELECT Balance FROM Accounts WHERE AccountId = ?";
            psCheck = conn.prepareStatement(checkSql);
            psCheck.setString(1, fromId);

            rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new Exception("Tài khoản gửi không tồn tại");
            }

            double balance = rs.getDouble("Balance");

            if (balance < amount) {
                throw new Exception("Không đủ tiền");
            }
}
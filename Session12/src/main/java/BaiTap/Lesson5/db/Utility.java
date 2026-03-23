package BaiTap.Lesson5.db;

import java.sql.*;

public class Utility {

    private static final String URL = "jdbc:mysql://localhost:3306/db_connect_demo";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối DB: " + e.getMessage());
            return null;
        }
    }

    public static void closeAll(Connection con, Statement stmt, ResultSet rs) {

        // 1. Đóng ResultSet
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng ResultSet");
            }
        }

        // 2. Đóng Statement
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng Statement");
            }
        }

        // 3. Đóng Connection
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng Connection");
            }
        }
    }

    public static void main(String[] args) {
        Connection con = getConnection();
        if (con != null) {
            System.out.println("✔ Kết nối thành công!");
        }
    }
}
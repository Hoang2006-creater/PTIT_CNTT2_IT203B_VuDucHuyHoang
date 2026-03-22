package BaiTap;

import java.sql.*;

public class Lesson1 {
    // Câu 1: - Vì gây nên rò rỉ tài nguyên khi mà kết nối liên tục
    // Gây giảm hiệu năng hệ thống do tốn thời gian xử lý nhiều kết nói mới
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital_DB";
    private static final String USER = "admin";
    private static final String PASSWORD = "med123";

    // Lấy kết nối
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //  Đóng tài nguyên
    public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


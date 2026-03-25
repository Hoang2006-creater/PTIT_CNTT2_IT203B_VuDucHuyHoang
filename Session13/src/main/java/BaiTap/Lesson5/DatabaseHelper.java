package BaiTap.Lesson5;

import java.sql.*;

public class DatabaseHelper {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital",
                "root",
                "1234"
        );
    }
}
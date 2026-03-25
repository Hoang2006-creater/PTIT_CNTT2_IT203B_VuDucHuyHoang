package AccountDAO;

import db.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    public void getAllAccount(){
        String sql = "select AccountId, FullName,Balance from Accounts";
        try (Connection con = Utility.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("Danh sach tai khoan");
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

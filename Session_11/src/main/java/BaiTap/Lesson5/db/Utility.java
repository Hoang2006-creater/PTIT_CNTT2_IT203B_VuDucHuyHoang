package db;

import java.sql.*;

public class Utility {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db","root","1234");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    public static void closeAll(Connection con , Statement stmt, ResultSet rs){
        if(con!= null){
            try{
                con.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        if(stmt !=null){
            try {
                stmt.close();
            }catch (SQLException e){
                throw  new RuntimeException(e);
            }
        }
        if(rs !=null){
            try {
                rs.close();
            }catch (SQLException e){
                throw  new RuntimeException(e);
            }
        }
    }
}

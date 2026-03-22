package impl;

import db.Utility;
import entity.Product;
import repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = Utility.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM products";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product product = new Product();
                product.setProId(rs.getInt("product_id"));
                product.setProName(rs.getString("product_name"));
                product.setProducer(rs.getString("producer"));
                product.setYearMaking(rs.getInt("year_making"));
                product.setExpriryDate(rs.getDate("expire_date"));
                product.setPrice(rs.getDouble("price"));

                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utility.closeAll(con, stmt, rs);
        }

        return products;
    }

    @Override
    public boolean addProduct(Product product) {
        boolean result = false;
        Connection con = null;
        Statement stmt = null;

        try {
            con = Utility.getConnection();
            stmt = con.createStatement();

            String sql = "INSERT INTO products(product_name, producer, year_making, expire_date, price) VALUES (";
            sql += "'" + product.getProName() + "',";
            sql += "'" + product.getProducer() + "',";
            sql += product.getYearMaking() + ",";
            sql += "'" + new Date(product.getExpriryDate().getTime()) + "',";
            sql += product.getPrice() + ")";

            int rows = stmt.executeUpdate(sql);
            if (rows > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utility.closeAll(con, stmt, null);
        }

        return result;
    }

    @Override
    public boolean updateProduct(Integer proId, Product product) {
        boolean result = false;
        Connection con = null;
        Statement stmt = null;

        try {
            con = Utility.getConnection();
            stmt = con.createStatement();

            String sql = "UPDATE products SET ";
            sql += "product_name='" + product.getProName() + "',";
            sql += "producer='" + product.getProducer() + "',";
            sql += "year_making=" + product.getYearMaking() + ",";
            sql += "expire_date='" + new Date(product.getExpriryDate().getTime()) + "',";
            sql += "price=" + product.getPrice();
            sql += " WHERE product_id=" + proId;

            int rows = stmt.executeUpdate(sql);
            if (rows > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utility.closeAll(con, stmt, null);
        }

        return result;
    }

    @Override
    public boolean deleteProduct(Integer proId) {
        boolean result = false;
        Connection con = null;
        Statement stmt = null;

        try {
            con = Utility.getConnection();
            stmt = con.createStatement();

            String sql = "DELETE FROM products WHERE product_id=" + proId;

            int rows = stmt.executeUpdate(sql);
            if (rows > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utility.closeAll(con, stmt, null);
        }

        return result;
    }
}
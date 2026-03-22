package BaiTap.Lesson5.impl;

import BaiTap.Lesson5.Entity.Doctor;
import BaiTap.Lesson5.Repository.DoctorRepository;
import db.Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {

    @Override
    public List<Doctor> getAll() {
        List<Doctor> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = Utility.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Doctors");

            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialty(rs.getString("specialty"));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.closeAll(con, stmt, rs);
        }

        return list;
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        boolean result = false;
        Connection con = null;
        Statement stmt = null;

        try {
            con = Utility.getConnection();
            stmt = con.createStatement();

            String sql = "INSERT INTO Doctors VALUES (";
            sql += doctor.getId() + ",";
            sql += "'" + doctor.getName() + "',";
            sql += "'" + doctor.getSpecialty() + "')";

            int rows = stmt.executeUpdate(sql);
            if (rows > 0){
                result = true;
            }

        } catch (Exception e) {
            System.out.println(" Lỗi: Trùng ID hoặc dữ liệu sai!");
        } finally {
            Utility.closeAll(con, stmt, null);
        }

        return result;
    }

    @Override
    public void countBySpecialty() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = Utility.getConnection();
            stmt = con.createStatement();

            String sql = "SELECT specialty, COUNT(*) as total FROM Doctors GROUP BY specialty";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getString("specialty") + " - " + rs.getInt("total")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.closeAll(con, stmt, rs);
        }
    }
}

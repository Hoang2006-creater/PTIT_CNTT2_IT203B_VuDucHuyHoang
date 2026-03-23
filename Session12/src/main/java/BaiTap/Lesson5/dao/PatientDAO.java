package BaiTap.Lesson5.dao;


import BaiTap.Lesson5.db.Utility;

import java.sql.*;
import java.util.Scanner;

public class PatientDAO {
    // Lấy ra danh sách bệnh nhân
    public void getAllPatients() {
        String sql = "select id, name, age, department from patients";
        try (Connection con = Utility.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("Danh sách bệnh nhân");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");
                System.out.println(id + " | " + name + " | " + age + " | " + department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thêm bệnh nhân
    public void addPatient(Scanner sc) {
        String sql = "insert into patients(name, age, department, admission_date) VALUES (?, ?, ?, ?)";

        try (Connection con = Utility.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Tên: ");
            String name = sc.nextLine();

            System.out.print("Tuổi: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Khoa: ");
            String dept = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, dept);
            ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));

            ps.executeUpdate();
            System.out.println("Thêm thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật bệnh án
    public void updateMedicalRecord(Scanner sc) {
        String sql = "update patients set medical_record = ? WHERE id = ?";

        try (Connection con = Utility.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Bệnh án: ");
            String record = sc.nextLine();

            ps.setString(1, record);
            ps.setInt(2, id);

            int result = ps.executeUpdate();

            if (result > 0)
                System.out.println("Thành công");
            else
                System.out.println("Không tìm thấy");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xuất viện tính phí
    public void discharge(Scanner sc) {
        String sql = "{call calculate_discharge_fee(?, ?)}";

        try (Connection con = Utility.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());

            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DOUBLE);

            cs.execute();

            double fee = cs.getDouble(2);

            System.out.println("Viện phí: " + fee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
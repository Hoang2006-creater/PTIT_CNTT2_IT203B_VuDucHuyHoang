package BaiTap.Lesson5.Main;
import BaiTap.Lesson5.Entity.Doctor;
import BaiTap.Lesson5.Repository.DoctorRepository;
import BaiTap.Lesson5.impl.DoctorRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorRepository repo = new DoctorRepositoryImpl();

        while (true) {
            System.out.println("\n MENU ");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    List<Doctor> list = repo.getAll();
                    list.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập chuyên khoa: ");
                    String sp = sc.nextLine();

                    boolean result = repo.addDoctor(new Doctor(id, name, sp));
                    System.out.println(result ? "Thành công" : "Thất bại");
                    break;

                case 3:
                    repo.countBySpecialty();
                    break;

                case 4:
                    System.out.println("Thoát");
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}
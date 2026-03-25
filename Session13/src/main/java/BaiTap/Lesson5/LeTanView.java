package BaiTap.Lesson5;

import java.util.Scanner;

public class LeTanView {
    private static final Scanner sc = new Scanner(System.in);
    private static final BenhNhanController controller = new BenhNhanController();

    public void start() {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("1. Xem giường trống");
            System.out.println("2. Tiếp nhận bệnh nhân");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.println("Chức năng chưa triển khai demo");
                    break;
                case 2:
                    tiepNhan();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void tiepNhan() {
        System.out.print("Tên: ");
        String ten = sc.nextLine();

        System.out.print("Tuổi: ");
        int tuoi = getIntInput();

        System.out.print("Mã giường: ");
        int maGiuong = getIntInput();

        System.out.print("Tiền tạm ứng: ");
        double tien = getDoubleInput();

        controller.tiepNhanBenhNhan(ten, tuoi, maGiuong, tien);
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Nhập lại số hợp lệ: ");
            }
        }
    }

    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Nhập lại số hợp lệ: ");
            }
        }
    }
}
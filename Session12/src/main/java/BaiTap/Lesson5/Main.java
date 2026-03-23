package BaiTap.Lesson5;
import BaiTap.Lesson5.dao.PatientDAO;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Thêm bệnh nhân");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & tính phí");
            System.out.println("5. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    dao.getAllPatients();
                    break;
                case 2:
                    dao.addPatient(sc);
                    break;
                case 3:
                    dao.updateMedicalRecord(sc);
                    break;
                case 4:
                    dao.discharge(sc);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
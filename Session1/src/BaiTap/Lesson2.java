package BaiTap;

import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Moi ban nhap trong so nhom");
        int soNhom = sc.nextInt();

        System.out.println("Moi ban nhap tong so nguoi");
        int soNguoi = sc.nextInt();

        try{
            int result = soNguoi/soNhom;
            System.out.println("Moi nguoi co"+result);
        }catch (ArithmeticException e){
            System.out.println("Khong the chia cho 0");
        }
    }
}

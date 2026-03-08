package BaiTap;

import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Moi ban nhap nam sinh");
            int namSinh = Integer.parseInt(sc.nextLine()) ;
        }catch (NumberFormatException e){
        System.out.println("Nhap sai dinh dang");
        }finally {
            System.out.println("Thuc hien don dep tai nguyen trong finally");
            sc.close();
        }
    }
}

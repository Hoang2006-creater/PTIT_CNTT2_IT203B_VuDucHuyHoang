package MyCheckedExexption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example {
    // Tạo ra phương thức nhập và trả về các giá trị gồm
    //1. Số nguyên(int.byte,short,long)
    //2. sô thực(double,float)
    //3. ký tự và chuỗi
    //4.Boolean
    // Lưu ý:Xử lý hết lỗi ngoại lệ sinh ra khi nhập, nếu không đúng thì nhập lại
    static Scanner sc = new Scanner(System.in);

    public static int intInput (){
        while(true){
            try{
                System.out.println("Moi ban nhap vao so nguyen");
                int a = Integer.parseInt(sc.nextLine());
                return a;
            }catch (NumberFormatException e){
                System.err.println("Sai dinh dang hay nhap so nguyen");
            }
        }
    }
    public static double doubleInput (){
        while(true){
            try{
                System.out.println("Moi ban nhap vao so nguyen");
                double d = Double.parseDouble(sc.nextLine());
                return d;
            }catch (InputMismatchException e){
                System.err.println("Sai dinh dang hay nhap so thuc");
            }
        }
    }
    public static String StringInput(){
                System.out.println("Moi ban nhap vao 1 chuoi ");
                String s = sc.nextLine();
                return s;
        }
    public static char CharInput(){
        while(true){
            System.out.println("Moi ban nhap 1 ky tu");
            String c = sc.nextLine();
            if(c.length()==1){
                return c.charAt(0);
            }else{
                System.out.println("Chi nhap 1 ky tu");
            }
        }
    }
    public static boolean booleanInput(){
        while(true){
            try{
                System.out.println("Moi ban nhap true/false");
                boolean b = sc.nextBoolean();
                return b;
            }catch (InputMismatchException e) {
                System.out.println("Sai dinh dang ");
                sc.close();
            }
        }
    }
    private static Scanner input(){
        return new Scanner(System.in);
    }

}

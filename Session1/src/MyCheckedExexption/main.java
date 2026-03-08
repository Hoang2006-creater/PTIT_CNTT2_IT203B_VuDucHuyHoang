package MyCheckedExexption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
            int a = Example.intInput();
            String s = Example.StringInput();
            boolean b = Example.booleanInput();
            char c = Example.CharInput();
            double d = Example.doubleInput();

                System.out.println("So nguyen: " + a);
                System.out.println("So thuc: " + d);
                System.out.println("Chuoi: " + s);
                System.out.println("Ky tu: " + c);
                System.out.println("Boolean: " + b);

    }
}

package baiTap.Lesson2;

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = password -> password.length()>=8;
            String password = "12345678";
            String pass = "123";
            System.out.println(validator.isValid(pass));
            System.out.println(validator.isValid(password));
        }
    }


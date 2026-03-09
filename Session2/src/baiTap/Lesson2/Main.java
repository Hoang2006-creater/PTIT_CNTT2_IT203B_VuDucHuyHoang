package baiTap.Lesson2;

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = password -> password.length()>=8;
            String password = "1234567";
            System.out.println(validator.isValid(password));
        }
    }


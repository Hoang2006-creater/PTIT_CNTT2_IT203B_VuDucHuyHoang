package BaiTap;

public class CheckAge {
     public static boolean checkRegistrationAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuoi khong the am");
        }
        return age >= 18;
    }
}

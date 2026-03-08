package BaiTap;

public class Lesson5 {
    public static void main(String[] args) {
        User user= new User();
        try {
            user.setAge(-5);
        } catch (InvalidAgeExeption e) {
            System.out.println("Loi"+e.getMessage());
            e.printStackTrace();
        }
    }
}

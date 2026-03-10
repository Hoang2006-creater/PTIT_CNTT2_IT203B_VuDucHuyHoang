package BaiTap.Lesson3;

import java.util.Optional;

public class Main {
    public record User(String username,String email){}
    public static void main(String[] args) {
        UserReposity repo = new UserReposity();
        Optional<User> user = repo.findUserByUserName("alice");
        if(user.isPresent()){
            System.out.println("Welcome"+user.get().username());
        }else
            System.out.println("Gueset login");
    }
}

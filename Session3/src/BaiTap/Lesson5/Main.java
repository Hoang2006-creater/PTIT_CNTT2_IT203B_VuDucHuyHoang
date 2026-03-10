package BaiTap.Lesson5;

import java.util.Comparator;
import java.util.List;

public class Main {
    private record User(String username){}

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alex"),
                new User("alexander"),
                new User("ben"),
                new User("Benjamin"),
                new User("charlotte"),
                new User("anna")
        );
        users.stream()
                //
                .sorted(Comparator.comparingInt((User u)->u.username().length()).reversed())
                .limit(3)
                // Bien doi du lieu tu doi tuong thanh chuoi
                .map(User::username)
                .forEach(System.out::println);
    }
}

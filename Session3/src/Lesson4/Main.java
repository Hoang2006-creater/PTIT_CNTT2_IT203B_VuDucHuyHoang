package Lesson4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private record User (String username){
    }
    public static void main(String[] args) {
        List<User> users = List.of(new User("Hoang"),new User("Hoang"),
                new User("Huy"),new User("Vu"));

        Set<String> seen = new HashSet<>();

        List<User> uniqueUsers = users.stream()
                .filter(user -> seen.add(user.username()))
                .toList();
            uniqueUsers.forEach(System.out::println);
    }
}

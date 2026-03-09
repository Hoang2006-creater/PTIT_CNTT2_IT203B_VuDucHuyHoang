package baiTap.Lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Hoang"));
        users.add(new User("Huy"));
        users.add(new User("vu"));
        Function<User,String> getUserName=User::getUserName;
        for(User user:users){
            System.out.println(getUserName.apply(user));
        }
        users.stream()
                .map(User::getUserName)
                .forEach(System.out::println);
        Supplier<User> createUser=User::new;
        User newUser = createUser.get();

        System.out.println("User moi: " + newUser.getUserName());
    }
}

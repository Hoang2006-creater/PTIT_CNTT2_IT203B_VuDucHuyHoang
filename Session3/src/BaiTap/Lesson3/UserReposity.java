package BaiTap.Lesson3;

import java.util.List;
import java.util.Optional;

public class UserReposity {
    private static List<Main.User> users = List.of(new Main.User("alice","alice@gmail.com"),new Main.User("Bob","bob@gmail.com"));

    Optional<Main.User> findUserByUserName(String username){
        return users.stream().filter(user -> user.username().equalsIgnoreCase(username))
                .findFirst();
    }
}

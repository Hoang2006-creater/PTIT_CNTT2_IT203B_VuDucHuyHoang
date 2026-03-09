package baiTap.Lesson4;

public class User {
    private String userName;

    public User(){
        this.userName= "defalulUserName";
    }
    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

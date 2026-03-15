package BaiTap;
// Bài 3
public class UserProcessor {
    public String processEmail(String email){
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("Invalid email format");
        }
        String[] part = email.split("@");

        if(part.length !=2 || part[1].isEmpty()){
            throw new IllegalArgumentException("Invalid email domain");
        }
        return email.toLowerCase();
    }
}

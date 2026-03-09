package baiTap.Lesson3;

public interface Authenticatable {

    String getPassword();

    default boolean isAuthenticated(){
        String password = getPassword();
            if(!password.isEmpty()){
                System.out.println("Chuoi khong rong");
                return true;
            }
            System.out.println("Chuoi rong");
            return false;
    }
    static String encrypt(String rawPassword){
        return "ENC" +rawPassword;
    }
}

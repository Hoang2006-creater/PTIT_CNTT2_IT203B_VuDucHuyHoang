package BaiTap;

public class User {
    private int age;

    public void setAge(int age) throws InvalidAgeExeption {
        if(age <0){
            throw new InvalidAgeExeption("Tuoi khong the am");
        }
        this.age=age;
    }
}

package trenLop;

public interface IColorable {
    String RED ="abcxyz";
    void printColor(String color);

    default void draw(){// Khong bat buoc lop con phai ghi de
        System.out.println("To mau!!!");
    }
    static void erae(){//Thuoc ve interface
        //Khong the ke thua
    }
    private void toStr(){
        //
    }
}

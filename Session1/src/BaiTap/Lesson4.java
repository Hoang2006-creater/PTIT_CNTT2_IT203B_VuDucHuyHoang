package BaiTap;

import java.io.IOException;

public class Lesson4 {
    public static void saveToFile() throws IOException{
        throw new IOException("Loi khi lu du lieu vao file");
    }
    public static void processUserData() throws IOException{
        saveToFile();
    }
    public static void main(String[] args) {
        try{
            processUserData();
        }catch (IOException e){
            System.out.println("da xat ra loi"+e.getMessage());
        }
        System.out.println("Chuong trinh van tiep tuc chay");
    }
}

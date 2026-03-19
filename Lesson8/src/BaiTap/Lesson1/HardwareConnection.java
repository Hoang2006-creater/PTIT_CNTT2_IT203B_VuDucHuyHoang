package BaiTap.Lesson1;

public class HardwareConnection {
    private static HardwareConnection instane;
    private HardwareConnection(){

    }
    public static HardwareConnection getInstance(){
        if(instane== null){
            instane=new HardwareConnection();
            instane.connect();
        }
        return instane;
    }

    private void connect() {
        System.out.println("HardwareConnection: Da ket noi phan cung");
    }
    public void disconect(){
        System.out.println("HardwareConnection: Da ngat ket noi");
    }
}

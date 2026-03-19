package BaiTap.Lesson5;

public class Light {
    private boolean isOn = true;

    public void off() {
        isOn = false;
        System.out.println("Đèn: Tắt");
    }

    public String getStatus() {
        return isOn ? "Bật" : "Tắt";
    }
}
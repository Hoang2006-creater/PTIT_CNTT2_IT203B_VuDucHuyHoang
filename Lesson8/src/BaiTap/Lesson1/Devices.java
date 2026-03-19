package BaiTap.Lesson1;

class Light implements Device{

    @Override
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn: Tắt.");
    }
}
class Fan implements Device{

    @Override
    public void turnOn() {
        System.out.println("Quạt: Quay.");

    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Dừng.");
    }
}
class AirConditioner implements Device{

    @Override
    public void turnOn() {
        System.out.println("Điều hòa: Bật.");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }
}

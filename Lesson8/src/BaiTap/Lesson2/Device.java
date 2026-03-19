package BaiTap.Lesson2;

class Light {
    public void off() {
        System.out.println("FACADE: Tắt đèn");
    }
}

class Fan {
    public void off() {
        System.out.println("FACADE: Tắt quạt");
    }

    public void lowSpeed() {
        System.out.println("FACADE: Quạt chạy tốc độ thấp");
    }
}

class AirConditioner {
    public void off() {
        System.out.println("FACADE: Tắt điều hòa");
    }

    public void setTemperature(int temp) {
        System.out.println("FACADE: Điều hòa set " + temp + "°C");
    }
}
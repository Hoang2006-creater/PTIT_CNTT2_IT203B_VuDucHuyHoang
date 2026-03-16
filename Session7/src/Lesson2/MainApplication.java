package Lesson2;

public class MainApplication {

    public static void main(String[] args) {

        double total = 1000000;

        OrderCalculator c1 =
                new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + c1.calculate(total));

        OrderCalculator c2 =
                new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + c2.calculate(total));

        OrderCalculator c3 =
                new OrderCalculator(new NoDiscount());
        System.out.println("Số tiền sau giảm: " + c3.calculate(total));
    }
}

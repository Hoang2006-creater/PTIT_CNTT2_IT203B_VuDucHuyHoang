package Lesson4;

public interface CODPayable extends PaymentMethod  {
    void processCOD(double amount);

    @Override
    default void pay(double amount){
        processCOD(amount);
    }
}

package Lesson3;

public interface CODPayable extends PaymentMethod {
    void processCOD(double amount);
}
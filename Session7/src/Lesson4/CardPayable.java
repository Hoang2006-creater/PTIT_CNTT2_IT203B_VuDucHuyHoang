package Lesson4;

public interface CardPayable extends PaymentMethod {
    void processCredirCard(double amount);

    @Override
    default void pay(double amount){
        processCredirCard(amount);
    }
}

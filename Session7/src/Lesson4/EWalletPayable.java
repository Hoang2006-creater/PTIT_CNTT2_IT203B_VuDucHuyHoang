package Lesson4;

public interface EWalletPayable extends PaymentMethod {
    void processMomo(double amount);

    @Override
    default void pay(double amount){
        processMomo(amount);
    }
}

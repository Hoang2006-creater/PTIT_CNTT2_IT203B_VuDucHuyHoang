package Lesson3;

public class MainApplication {

    public static void main(String[] args) {

        PaymentProcessor processor;

        // COD
        processor = new PaymentProcessor(new CODPayment());
        processor.process(500000);

        // Credit Card
        processor = new PaymentProcessor(new CreditCardPayment());
        processor.process(1000000);

        // MoMo
        processor = new PaymentProcessor(new MomoPayment());
        processor.process(750000);

        // Kiểm tra LSP
        PaymentMethod payment = new CreditCardPayment();
        payment = new MomoPayment();

        processor = new PaymentProcessor(payment);
        processor.process(200000);
    }
}
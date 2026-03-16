package Lesson4;

public class MomoPayment implements EWalletPayable {

    @Override
    public void processMomo(double amount) {
        System.out.println("Xu ly thanh toan MoMO: "+amount+" - Thanh cong");
    }
}

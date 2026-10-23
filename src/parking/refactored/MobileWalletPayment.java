package parking.refactored;

public class MobileWalletPayment implements RefundablePayment {
    private String walletId;
    public MobileWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public String name(){
        return "MOBILEWALLET";
    }
    @Override
    public void pay(double amount){
        System.out.println("[Wallet] " + walletId + " paid " + amount + " MAD");
    }
    @Override
    public void refund(double amount){
        System.out.println("[Wallet] " + walletId + " refunded " + amount + " MAD");
    }
}

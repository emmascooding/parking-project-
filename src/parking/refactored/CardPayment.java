package parking.refactored;

public class CardPayment implements RefundablePayment{
    private final String lastFourDigits;

    public CardPayment(String lastFourDigits){
        this.lastFourDigits=lastFourDigits;
    }
    @Override
    public String name(){
        return "CARD";
    }
    @Override
    public void pay(double amount){
        System.out.println("[Card ****" + lastFourDigits + "] paid " + amount + " MAD");
    }
    @Override
    public void refund(double amount){
        System.out.println("[CARD ****" + lastFourDigits + "] refunded " + amount + " MAD");
    }
}

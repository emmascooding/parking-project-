package parking.parkingbefore;

public interface PaymentMethod {
    String name();
    void pay(double amount);
    void refund(double amount);
}

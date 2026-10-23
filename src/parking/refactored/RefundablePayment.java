package parking.refactored;

// This interface can only be implemented by classes of payment methods that accept refund so as to eliminate the UnsupportedoperationException
public interface RefundablePayment extends PaymentMethod{
    void refund(double amount);
}

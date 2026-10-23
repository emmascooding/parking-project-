package parking.refactored;

import java.util.List;
public interface ReceiptFormatter {
    String formatReceipt(Vehicle vehicle, int hours, double amount, PaymentMethod method);
    String formatDailyReport(List<String> receipts, double total);
}

package parking.refactored;

import java.util.List;

// this class creates a CSV file without modifying the class ParkingService
public class CsvReceiptFormatter implements ReceiptFormatter {

    @Override
    public String formatReceipt(Vehicle vehicle, int hours, double amount, PaymentMethod method) {

        return vehicle.getPlate() + "," + vehicle.getType() + "," + hours + "," + amount + "," + method.name();
    }

    @Override
    public String formatDailyReport(List<String> receipts, double total) {
        StringBuilder sb = new StringBuilder("Plate,Type,Hours,Amount,Payment\n");
        for (String receipt : receipts) {
            sb.append(receipt).append("\n");
        }
        sb.append(",,,").append(total).append(",TOTAL");
        return sb.toString();
    }
}

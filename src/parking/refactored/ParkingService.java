package parking.refactored;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//the central class of the diagram
public class ParkingService {
    private final Map<String, VehicleTariff> tariffs = new HashMap<>();
    private final ParkingLog log;
    private final ReceiptFormatter formatter;
    private final List<String> receipts = new ArrayList<>();
    private double total = 0.0;

    public ParkingService(List<VehicleTariff> tariffs, ParkingLog log, ReceiptFormatter formatter){
        for (VehicleTariff tariff : tariffs){
            this.tariffs.put(tariff.vehicleType(), tariff);
        }
        this.log = log;
        this.formatter = formatter;
    }
    public double fee(Vehicle vehicle, int hours){
        VehicleTariff tariff = tariffs.get(vehicle.getType());
        if (tariff == null){
            throw new IllegalArgumentException("Unknown vehicle type: " + vehicle.getType());
        }
        return tariff.fee(hours);
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method){
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total+=amount;
        String receipt = formatter.formatReceipt(vehicle, hours, amount, method);
        receipts.add(receipt);
        log.log(receipt);
    }
    public void cancel(Vehicle vehicle, int hours, RefundablePayment method){
        double amount = fee(vehicle, hours);
        method.refund(amount);
        total-=amount;
    }
    public void cancelCashAtDesk(Vehicle vehicle, int hours, CashPayment method){
        double amount = fee(vehicle, hours);
        System.out.println("Refund " + amount + " MAD at the desk for " + vehicle.getPlate());
        total-=amount;
    }
    public String dailyReport(){
        return formatter.formatDailyReport(receipts, total);
    }
}

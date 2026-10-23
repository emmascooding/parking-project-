package parking.refactored;

import java.util.List;

public class ParkingServiceTest {
    private static void check(String description, double expected, double actual) {
        if (Math.abs(expected - actual) > 0.0001) {
            throw new AssertionError(description + ": expected " + expected + ", got " + actual);
        }
        System.out.println(description + ": OK");
    }

    public static void main(String[] args) {
        InMemoryParkingLog log = new InMemoryParkingLog();
        ParkingService service = new ParkingService(List.of(new CarTariff(), new MotorbikeTariff(), new TruckTariff()), log, new TextReceiptFormatter());

        Vehicle car = new Vehicle("12345-A-6", "CAR");
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK");

        check("Car fee", 15.0, service.fee(car, 3));
        check("Motorbike fee", 4.0, service.fee(bike, 2));
        check("Truck fee", 60.0, service.fee(truck, 4));

        CardPayment card = new CardPayment("4242");
        CashPayment cash = new CashPayment();

        service.checkout(car, 3, card);
        service.checkout(bike, 2, cash);
        service.checkout(truck, 4, card);

        service.cancelCashAtDesk(bike, 2, cash);
        service.cancel(truck, 4, card);

        String report = service.dailyReport();

        if (!report.contains("Total: 15.0 MAD")) {
            throw new AssertionError("Incorrect daily total");
        }

        if (log.getEntries().size() != 3) {
            throw new AssertionError("Expected 3 log entries");
        }

        System.out.println("Daily total: 15.0 MAD: OK");
        System.out.println("In-memory log: OK");
        System.out.println("All tests passed.");
    }
}

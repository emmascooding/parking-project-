package parking.refactored;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<VehicleTariff> tariffs = List.of(new CarTariff(), new MotorbikeTariff(), new TruckTariff(), new BusTariff());

        ParkingService service = new ParkingService(tariffs, new FileParkingLog("parking.log"), new TextReceiptFormatter());

        Vehicle car = new Vehicle("12345-A-6", "CAR");
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK");
        Vehicle bus = new Vehicle("22220-A-7", "BUS");

        CardPayment card = new CardPayment("4242");
        CashPayment cash = new CashPayment();
        MobileWalletPayment wallet = new MobileWalletPayment("123455");

        service.checkout(car, 3, card);
        service.checkout(bike, 2, cash);
        service.checkout(truck, 4, card);
        service.checkout(bus, 5, wallet);

        service.cancelCashAtDesk(bike, 2, cash);
        service.cancel(truck, 4, card);

        System.out.println(service.dailyReport());
    }
}
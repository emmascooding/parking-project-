package parking.refactored;

// interface for vehicle tariff to implement in each vehicle type in order to prevent the use of switch case
public interface VehicleTariff {
    String vehicleType();
    double fee(int hours);
}

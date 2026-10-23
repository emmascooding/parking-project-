package parking.refactored;

public class TruckTariff implements VehicleTariff{
    @Override
    public String vehicleType(){
        return "TRUCK";
    }
    @Override
    public double fee(int hours){
        return hours*15.0;
    }
}

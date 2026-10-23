package parking.refactored;

public class BusTariff implements VehicleTariff{
    @Override
    public String vehicleType(){
        return "BUS";
    }
    @Override
    public double fee(int hours){
        return hours*15.0;
    }
}

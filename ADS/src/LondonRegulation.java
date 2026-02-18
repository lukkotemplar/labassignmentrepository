public class LondonRegulation implements CityRegulation {
    private static final double CONGESTION_CHARGE = 2.50;
    public void validateUnlock(Vehicle vehicle) {

    }
    public double applyFinalCharges(double basePrice) {
        return basePrice + CONGESTION_CHARGE;
    }
    public void validateZone(Vehicle vehicle) {

    }
}

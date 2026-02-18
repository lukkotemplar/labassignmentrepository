public class RomeRegulation implements CityRegulation {

    @Override
    public void validateUnlock(Vehicle vehicle) {}

    @Override
    public double applyFinalCharges(double basePrice) {
        return basePrice;
    }

    @Override
    public void validateZone(Vehicle vehicle) {
        if (ZoneService.isRestricted(vehicle.getLatitude(), vehicle.getLongitude())) {
            throw new IllegalStateException("Restricted zone in Rome.");
        }
    }
}
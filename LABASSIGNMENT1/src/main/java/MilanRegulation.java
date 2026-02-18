public class MilanRegulation implements CityRegulation {

    @Override
    public void validateUnlock(Vehicle vehicle) {
        if (vehicle.getType() == VehicleType.MOPED && !HelmetSensor.isHelmetPresent()) {
            throw new IllegalStateException("Helmet required in Milan.");
        }
    }

    @Override
    public double applyFinalCharges(double basePrice) {
        return basePrice;
    }

    @Override
    public void validateZone(Vehicle vehicle) {
        // No restriction
    }
}
public interface CityRegulation {
    void validateUnlock(Vehicle vehicle);
    double applyFinalCharges(double basePrice);
    void validateZone(Vehicle vehicle);
}
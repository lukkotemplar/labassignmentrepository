public class TelemetryData {

    private final String vehicleId;
    private final double batteryPercentage;
    private final double temperature;
    private final double latitude;
    private final double longitude;

    public TelemetryData(
            String vehicleId,
            double batteryPercentage,
            double temperature,
            double latitude,
            double longitude) {

        this.vehicleId = vehicleId;
        this.batteryPercentage = batteryPercentage;
        this.temperature = temperature;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public double getBatteryPercentage() {
        return batteryPercentage;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
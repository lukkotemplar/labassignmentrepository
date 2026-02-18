public class Vehicle {
    private final String id;
    private final VehicleType type;
    private VehicleState state;
    private double batteryPercentage;
    private double temperature;
    private double latitude;
    private double longitude;
    private double price = 3.5;
    private CityRegulation zone;
    private final CityRegulation[] zones = {new LondonRegulation(), new MilanRegulation(), new RomeRegulation()};

    public Vehicle(String id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.state = VehicleState.AVAILABLE;
        this.zone = zones[(int) (Math.random()+2)];
    }

    public synchronized VehicleState getState() {
        return state;
    }

    public synchronized void setState(VehicleState newState) {
        this.state = newState;
    }

    public synchronized void updateTelemetry(double battery, double temperature, double latitude, double longitude) {
        this.batteryPercentage = battery;
        this.temperature = temperature;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public synchronized double getBatteryPercentage() {
        return this.batteryPercentage;
    }

    public synchronized double getTemperature() {
        return temperature;
    }

    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public CityRegulation getZone() {
        return zone;
    }

    public double getPrice() {
        return price;
    }
}

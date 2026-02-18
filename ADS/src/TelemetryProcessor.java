public class TelemetryProcessor extends Thread {
    private final SmartMoveCentralController controller;
    private volatile boolean running = true;

    public TelemetryProcessor(SmartMoveCentralController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while (running) {
            TelemetryData data = TelemetryQueue.take();
            Vehicle vehicle = controller.getVehicle(data.getVehicleId());
            synchronized (vehicle) {
                vehicle.updateTelemetry(data.getBatteryPercentage(), data.getTemperature(), data.getLatitude(), data.getLongitude());
                if (vehicle.getTemperature() > 60) {
                    controller.changeState(vehicle, VehicleState.EMERGENCY_LOCK);
                }
                if (vehicle.getBatteryPercentage() < 5) {
                    controller.changeState(vehicle, VehicleState.MAINTENANCE);
                }
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

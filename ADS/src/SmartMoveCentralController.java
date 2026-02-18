import java.util.HashMap;
import java.util.Map;

public class SmartMoveCentralController {
    private final Map<String, Vehicle> vehicles;
    private final AuditService auditService;
    public SmartMoveCentralController() {
        this.auditService = new AuditService();
        this.vehicles = new HashMap<>();
    }

    public synchronized void registerVehicle(Vehicle vehicle) {
        CityRegulation city = vehicle.getZone();
        city.validateUnlock(vehicle);
        city.validateZone(vehicle);
        vehicles.put(vehicle.getId(), vehicle);
    }

    public Vehicle getVehicle(String id) {
        synchronized (this) {
            return vehicles.get(id);
        }
    }

    public synchronized void changeState(Vehicle vehicle, VehicleState newState) {

        synchronized (vehicle) {
            validateTransition(vehicle, newState);
            vehicle.setState(newState);
            auditService.logStateChange(vehicle.getId(), newState);
            ManualJSONPersistence.saveVehicles(vehicles, "vehicles.json");

        }
    }

    private void validateTransition(Vehicle vehicle, VehicleState next) {

        VehicleState current = vehicle.getState();

        if (current == VehicleState.AVAILABLE && next == VehicleState.IN_USE) {
            return;
        }

        if (next == VehicleState.MAINTENANCE &&
                (vehicle.getBatteryPercentage() < 5 ||
                        vehicle.getTemperature() > 60)) {
            return;
        }

        if (next == VehicleState.EMERGENCY_LOCK) {
            return;
        }

        throw new IllegalStateException("Invalid state transition");
    }
}

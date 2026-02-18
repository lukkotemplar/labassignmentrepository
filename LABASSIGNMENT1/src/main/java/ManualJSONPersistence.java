import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ManualJSONPersistence {

    public static void saveVehicles(Map<String, Vehicle> vehicles, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("{\n");
            int count = 0;
            int size = vehicles.size();
            for (Vehicle v : vehicles.values()) {
                writer.write("  \"" + v.getId() + "\": {\n");
                writer.write("    \"type\": \"" + v.getType() + "\",\n");
                writer.write("    \"state\": \"" + v.getState() + "\",\n");
                writer.write("    \"battery\": " + v.getBatteryPercentage() + ",\n");
                writer.write("    \"temperature\": " + v.getTemperature() + ",\n");
                writer.write("    \"latitude\": " + v.getLatitude() + ",\n");
                writer.write("    \"longitude\": " + v.getLongitude() + ",\n");
                writer.write("    \"price\": " + v.getPrice() + "\n");
                writer.write("  }" + (++count < size ? "," : "") + "\n");
            }
            writer.write("}\n");
        } catch (IOException e) {
            System.err.println("Error saving vehicles JSON: " + e.getMessage());
        }
    }
}
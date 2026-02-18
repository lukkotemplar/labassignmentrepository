import java.io.FileWriter;
import java.io.IOException;

public class AuditService {
    private long sequenceId = 0;
    private String previousChecksum = "0";

    public synchronized void logStateChange(String vehicleId, VehicleState state) {
        sequenceId++;
        String entry = sequenceId + "," + vehicleId + "," + state;
        String checksum = Integer.toHexString((entry + previousChecksum).hashCode());
        try (FileWriter writer = new FileWriter("audit_log.csv", true)) {
            writer.write(entry+","+checksum+"\n");
            previousChecksum = checksum;
        } catch (IOException e) {
            throw new RuntimeException(
                    "Audit write failed. Rollback required."
            );
        }
    }
}

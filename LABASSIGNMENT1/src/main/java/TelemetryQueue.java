import java.util.LinkedList;
import java.util.Queue;

public class TelemetryQueue {

    private static final Queue<TelemetryData> queue = new LinkedList<>();

    // Productor añade datos
    public static synchronized void put(TelemetryData data) {
        queue.add(data);
        TelemetryQueue.class.notifyAll(); // Despierta a los consumidores
    }

    // Consumidor obtiene datos
    public static synchronized TelemetryData take() {
        while (queue.isEmpty()) {
            try {
                TelemetryQueue.class.wait(); // Espera a que haya datos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return queue.poll();
    }
}
public class Main {
    public static void main(String[] args) {
        SmartMoveCentralController controller = new SmartMoveCentralController();
        for (int i = 0; i < 10; i++) {
            Vehicle v = new Vehicle("V-" + i, VehicleType.MOPED);
            controller.registerVehicle(v);
        }
        TelemetryProcessor processor = new TelemetryProcessor(controller);
        processor.start();
        for (int i = 0; i < 10; i++) {
            TelemetryQueue.put(new TelemetryData(
                    "V-" + i,
                    Math.random() * 100,
                    Math.random() * 70,
                    41.39 + Math.random()*0.01,
                    12.48 + Math.random()*0.01
            ));
        }

        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        processor.shutdown();
    }
}
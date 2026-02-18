public class ZoneService {
    private static final double MIN_LATITUDE = 41.890;
    private static final double MAX_LATITUDE = 41.900;
    private static final double MIN_LONGITUDE = 12.480;
    private static final double MAX_LONGITUDE = 12.490;

    public static boolean isRestricted(double latitude, double longitude) {
        return latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE &&
                longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE;
    }
}
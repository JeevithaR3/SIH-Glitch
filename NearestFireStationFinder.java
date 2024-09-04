
import java.util.List;

public class NearestFireStationFinder {
    private List<FireStation> fireStations;

    public NearestFireStationFinder(List<FireStation> fireStations) {
        this.fireStations = fireStations;
    }

    public FireStation findNearestFireStation(double userLatitude, double userLongitude) {
        FireStation nearestFireStation = null;
        double minDistance = Double.MAX_VALUE;

        for (FireStation fireStation : fireStations) {
            double distance = calculateDistance(userLatitude, userLongitude, fireStation.getLatitude(),
                    fireStation.getLongitude());
            if (distance < minDistance) {
                minDistance = distance;
                nearestFireStation = fireStation;
            }
        }

        return nearestFireStation;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Haversine formula to calculate distance between two points on a sphere
        // (Earth)
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6371 * c; // 6371 is the Earth's radius in kilometers
        return distance;
    }
}
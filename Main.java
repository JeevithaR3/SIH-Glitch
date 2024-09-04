import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FireStation> fireStations = new ArrayList<>();
        fireStations.add(new FireStation("Fire Station 1", 37.7749, -122.4194));
        fireStations.add(new FireStation("Fire Station 2", 37.7859, -122.4364));
        fireStations.add(new FireStation("Fire Station 3", 37.7963, -122.4575));

        NearestFireStationFinder finder = new NearestFireStationFinder(fireStations);
        double userLatitude = 37.7823;
        double userLongitude = -122.4294;

        FireStation nearestFireStation = finder.findNearestFireStation(userLatitude, userLongitude);
        System.out.println("Nearest Fire Station: " + nearestFireStation.getName());
    }
}
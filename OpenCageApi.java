import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class OpenCageApi {
    private static final String API_KEY = "YOUR_OPENCAGE_API_KEY";
    private static final String API_ENDPOINT = "https://api.opencagedata.com/geocode/v1/json";

    public static void main(String[] args) throws IOException, InterruptedException {
        String address = "375 Albert Rd, Woodstock, Cape Town, 7915, South Africa";
        String response = sendGetRequest(address);
        JSONObject jsonObject = new JSONObject(response);
        double latitude = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
                .getDouble("lat");
        double longitude = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
                .getDouble("lng");
        System.out.println("Latitude: " + latitude + ", Longitude: " + longitude);
    }

    private static String sendGetRequest(String address) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_ENDPOINT + "?q=" + address + "&key=" + API_KEY))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
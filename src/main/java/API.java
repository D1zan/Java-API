import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public static Covid getCovidData(String iso, String region, String province) throws IOException, InterruptedException {
        String url = "https://covid-api.com/api/reports?date=2020-03-14&q="
                + region + "%20" + province + "&iso=" + iso + "&region_name=" + region + "&region_province=" + province;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject data = json.getAsJsonArray("data").get(0).getAsJsonObject();
        JsonObject regionObj = data.getAsJsonObject("region"); // <-- fix here

        String date = data.get("date").getAsString();
        String country = regionObj.get("country").getAsString();
        String state = regionObj.has("province") ? regionObj.get("province").getAsString() : "";
        String ISO = regionObj.get("iso").getAsString();
        String regionName = regionObj.get("name").getAsString();
        String providence = state; // just use the province again
        int deaths = data.get("deaths").getAsInt();
        int recoveries = data.get("recovered").getAsInt();
        double fatality = data.get("fatality_rate").getAsDouble();

        return new Covid(date, country, state, ISO, regionName, providence, deaths, recoveries, fatality);
    }
}
//https://covid-api.com/api/reports?date=2020-03-14&q=China%20Beijing&iso=CHN&region_name=China&region_province=Beijing  (API DO NOT DELETE PLZ)

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//https://covid-api.com/api/reports?date=2020-03-14&q=China%20Beijing&iso=CHN&region_name=China&region_province=Beijing  (API DO NOT DELETE PLZ)
public class API {
    public static String getCovid() {
        String url = "https://covid-api.com/api/reports?date=2020-03-14&q" + Country + "20"+ State + "&iso"+ ISO + "&region_name"+ regionName+"&region_province" + Providence;;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            int newConfirmed = json.getAsJsonObject("Global").get("NewConfirmed").getAsInt();

            return "New Confirmed Cases" + newConfirmed;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public static void main (String[] args) {
        System.out.println(getCovid());

    }

}
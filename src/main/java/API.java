import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
    public class API {
        public static Covid getCovidData(String iso, String region, String province)
                throws IOException, InterruptedException {
                    String url = "https://covid-api.com/api/reports?date=2020-03-14&q=" + province + "%20&iso=" + iso + "&region_name=" + region + "&region_province=" + province;
                    System.out.println(url);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder() .uri(URI.create(url)) .build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
                    JsonObject data = json.getAsJsonArray("data").get(0).getAsJsonObject();


            String date = data.get("date").getAsString();
            String country = data.get("region").getAsString();
            String state = data.get("region_province").getAsString();
            String ISO = data.get("iso").getAsString();
            String regionName = data.get("region").getAsString();
            String providence = data.get("region_province").getAsString();
            int deaths = data.get("deaths").getAsInt();
            int recoveries = data.get("recovered").getAsInt();
            double fatality = data.get("fatality_rate").getAsDouble();
            return new Covid(date, country, state, ISO, regionName, providence, deaths, recoveries, fatality);
            //covid object
        }
    }



//https://covid-api.com/api/reports?date=2020-03-14&q=China%20Beijing&iso=CHN&region_name=China&region_province=Beijing
//https://covid-api.com/api/reports?date=2020-03-14&q=brazil%20brasilia&iso=br&region_name=brazil&region_province=brasilia(API DO NOT DELETE PLZ)
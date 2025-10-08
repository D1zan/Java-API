import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//Import everything. GSON is Google's JSON package. Make sure you check your pom file !
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Covid Web. \nHere you can ask questions about covid, to keep you informed...");
        System.out.println("Please Enter a date(year-month-day): ");
        int covidDate = scan.nextInt();

        String url = "https://api.covid19api.com/v1/covid-data?date=" + date;
        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }

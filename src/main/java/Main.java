import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//Import everything. GSON is Google's JSON package. Make sure you check your pom file !
public class Main { public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean web = true; while(web) {
        //Initial text
        System.out.println("Welcome to the Covid Web. \nHere you can ask questions about covid, to keep you informed...");
        System.out.println("Now we will need a little more research from you. \nI will give you a list of countries and from there we will pick your region of information");
        System.out.println("Pick a country: China, Russia, Brazil: ");
        String country = scan.next();
        String iso = "";
        if (country.equalsIgnoreCase("Russia"))
        { System.out.println("What is the ISO code (hint: RU):");
            iso = scan.next();
        } else if (country.equalsIgnoreCase("China"))
        { System.out.println("What is the ISO code (hint: CHN):");
            iso = scan.next();
        } else if (country.equalsIgnoreCase("Brazil"))
        { System.out.println("What is the ISO code (hint: BR):");
            iso = scan.next();
        } else
        {   System.out.println("Invalid country. Try again!");
            continue; }
        System.out.println("Provide province/state (Brasilia, Beijing, Moscow): ");
        String province = scan.next();
        province = province.toLowerCase();
            try { System.out.println("Here's all the info:");
                Covid result = API.getCovidData(iso,country,province);
                System.out.println("\n--- COVID RESULTS ---");
                System.out.println("Date: " + result.getDate());
                System.out.println("Country: " + result.getCountry());
                System.out.println("Region: " + result.getProvidence());
                System.out.println("Deaths: " + result.getDeaths());
                System.out.println("Recovered: " + result.getRecoveries());
                System.out.println("Fatality Rate: " + result.getFatality()); }
        catch (Exception e) { System.out.println("Error fetching API data: " + e.getMessage()); }
            System.out.println("Would you like to ask a new question?");
            String userInput = scan.next();
            if (userInput.equals("No") || userInput.equalsIgnoreCase("no"))
            { web = false;
            }
        }
    }
    }
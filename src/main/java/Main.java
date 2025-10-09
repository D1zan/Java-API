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

        boolean web = true;
        while(web) {
            //Initial Page
            System.out.println("Welcome to the Covid Web. \nHere you can ask questions about covid, to keep you informed...");
            System.out.println("Please Enter a date(year-month-day): ");
            String covidDate = scan.next();
            //Asking for Date


            //Breaking the while loop
            System.out.println("Would you like to ask a new question?");
            String userInput = scan.next();
            if (userInput.equals("No") || userInput.equalsIgnoreCase("no")) { web  = false;}
            else {web = true;}
        }
    }
}

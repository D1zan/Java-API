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
            System.out.println("Now we will need a little more research from you. \nI will give you a list of countries and from there we will pick your region of information");
            System.out.println("Please Pick a Country => China,  Russia,  Brazil:");
            String useriNput = scan.next();

            if (useriNput.equalsIgnoreCase("Russia")) {
                System.out.println("Now please provide the ISO Code to Russia (hint: RU): ");
                String userInput = scan.next();
            } else if (useriNput.equalsIgnoreCase("China")) {
                System.out.println("Now please provide the ISO code to China (hint: CHN): ");
                String userInput = scan.next();
            } else if (useriNput.equalsIgnoreCase("Brazil")){
                System.out.println("Now please provide the ISO code to Brazil (hint: Br): ");
                String userInput = scan.next();
            } else {
                System.out.println("It seems like you didn't type in any of the suggested countries...Please try again!");
                continue;
            }

            System.out.println("Great, now I need the capital state from the Country of your choice: ");
            String userInput = scan.next();

            if


















            //Breaking the while loop
            System.out.println("Would you like to ask a new question?");
            String userInput = scan.next();
            if (userInput.equals("No") || userInput.equalsIgnoreCase("no")) { web  = false;}
        }
    }
}

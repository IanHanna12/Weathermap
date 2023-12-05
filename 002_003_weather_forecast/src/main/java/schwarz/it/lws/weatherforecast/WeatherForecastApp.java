package schwarz.it.lws.weatherforecast;

import schwarz.it.lws.weatherforecast.Controller.HttpController;
import schwarz.it.lws.weatherforecast.Controller.UserInputController;
import schwarz.it.lws.weatherforecast.View.UserInputDisplay;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.util.Scanner;

public class WeatherForecastApp {
    private static final boolean FOREVER = true;

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

       while (FOREVER) {
           UserInputDisplay userInputDisplay = new UserInputDisplay();
              userInputDisplay.handleUserInput();
            String city = UserInputController.getInput();

// start httpHandler
            HttpController httpController = new HttpController();
           httpController.getWeather();
// end httpHandler
           System.out.println("Gewünschten Ort eingeben (x-beenden):");

            ;}
        }
    }


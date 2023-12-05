package schwarz.it.lws.weatherforecast;

import schwarz.it.lws.weatherforecast.Controller.HttpController;
import schwarz.it.lws.weatherforecast.Controller.UserInputController;
import schwarz.it.lws.weatherforecast.View.DisplayWeather;
import schwarz.it.lws.weatherforecast.View.UserInputHandler;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.util.Scanner;

public class WeatherForecastApp {
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&lang=de&units=metric&appid=%s";
    private static final String WEATHER_API_KEY = "9fcc0cf708bd50422dbe7fa9c6013c68";
    private static final boolean FOREVER = true;

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

       while (FOREVER) {
           UserInputHandler userInputHandler = new UserInputHandler();
              userInputHandler.handleUserInput();
            String city = UserInputController.getInput();

// start httpHandler
            HttpController httpController = new HttpController();
           httpController.getWeather();
// end httpHandler
          // display  the weather --> data eintragen
           DisplayWeather.displayweather(city, currentWeather, currentTemperature, minTemperature, maxTemperature, humidity, dateTimeSunrise, dateTimeSunset);
            }
        }
    }


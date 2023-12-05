package schwarz.it.lws.weatherforecast;

import org.json.JSONObject;
import schwarz.it.lws.weatherforecast.Controller.UserInputController;
import schwarz.it.lws.weatherforecast.View.UserInputHandler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
           
            String url = String.format(WEATHER_URL, city, WEATHER_API_KEY).replace(" ", "+");
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() != 200) {
                    System.out.printf("Ort nicht gefunden: %s\n", city);
                    continue;
                }
                JSONObject weather = new JSONObject(response.body());
                city = weather.getString("name");
                String currentWeather = weather.getJSONArray("weather").getJSONObject(0).getString("description");
                Float currentTemperature = weather.getJSONObject("main").getFloat("temp");
                Float minTemperature = weather.getJSONObject("main").getFloat("temp_min");
                Float maxTemperature = weather.getJSONObject("main").getFloat("temp_max");
                int humidity = weather.getJSONObject("main").getInt("humidity");
                long sunrise = weather.getJSONObject("sys").getLong("sunrise");
                LocalDateTime dateTimeSunrise = LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(sunrise),
                        ZoneId.of("Europe/Berlin"));
                long sunset = weather.getJSONObject("sys").getLong("sunset");
                LocalDateTime dateTimeSunset = LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(sunset),
                        ZoneId.of("Europe/Berlin"));
                DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
                System.out.println("- - - - - - - - - - - -  - - - - - - - - - - - - - - - - ");
                System.out.printf("Das Wetter in %s\n", city);
                System.out.printf("\t%s bei %3.1f °C\n", currentWeather, currentTemperature);
                System.out.printf("\tmin Temperatur %3.1f °C\n", minTemperature);
                System.out.printf("\tmax Temperatur %3.1f °C\n", maxTemperature);
                System.out.printf("\tLuftfeuchtigkeit %d %%\n", humidity);
                System.out.printf("\tSonnenaufgang %s Uhr\n", dateTimeSunrise.format(timeFormat));
                System.out.printf("\tSonnenuntergang %s Uhr\n", dateTimeSunset.format(timeFormat));
                System.out.println();
                System.out.println();

            } catch (IOException | InterruptedException ex) {
                System.out.println("Can't connect to Weather Server");
            }
        }
    }
}

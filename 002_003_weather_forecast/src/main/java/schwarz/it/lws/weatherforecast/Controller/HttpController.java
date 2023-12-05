package schwarz.it.lws.weatherforecast.Controller;

import org.json.JSONObject;
import schwarz.it.lws.weatherforecast.View.DisplayWeather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class HttpController {
    HttpClient client = HttpClient.newHttpClient();


    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&lang=de&units=metric&appid=%s";
    private static final String WEATHER_API_KEY = "9fcc0cf708bd50422dbe7fa9c6013c68";

    String city = UserInputController.getInput();


    public void getWeather() {
        String url = String.format(WEATHER_URL, city, WEATHER_API_KEY).replace(" ", "+");
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (response.statusCode() != 200) {
            System.out.printf("Ort nicht gefunden: %s\n", city);
            return;
        }
        JSONObject weather = new JSONObject(response.body());
        city = weather.getString("name");

        // DisplayWeather for displaying the weather Datainformation
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


        DisplayWeather.displayweather(city, currentWeather, currentTemperature, minTemperature, maxTemperature, humidity, dateTimeSunrise, dateTimeSunset);
    }


}


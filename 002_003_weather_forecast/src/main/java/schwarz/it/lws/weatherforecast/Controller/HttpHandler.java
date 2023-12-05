package schwarz.it.lws.weatherforecast.Controller;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class HttpHandler {
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&lang=de&units=metric&appid=%s";
    private static final String WEATHER_API_KEY = "9fcc0cf708bd50422dbe7fa9c6013c68";

    String city = UserInputController.getInput();
    HttpClient client = HttpClient.newHttpClient();

    String url = String.format(WEATHER_URL, city, WEATHER_API_KEY).replace(" ", "+");
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();


    JSONObject weather = new JSONObject(response.body());
     city  = weather.getString("name");
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

}

}

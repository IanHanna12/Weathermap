package schwarz.it.lws.weatherforecast;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class OpenWeatherMapWeatherForecastClient implements WeatherForecastClient {
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&lang=de&units=metric&appid=%s";
    private static final String WEATHER_API_KEY = "9fcc0cf708bd50422dbe7fa9c6013c68";
    private final WeatherForecastView view;

    // constructor
    public OpenWeatherMapWeatherForecastClient(WeatherForecastView view) {
        this.view = view;
    }

    @Override
    public void getWeatherData(String city) {
        String url = String.format(WEATHER_URL, city, WEATHER_API_KEY).replace(" ", "+");
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JSONObject weather = new JSONObject(response.body());
                view.show(weather);
            } else {
                view.showErrorMessage("Can't get weather data");
            }

        } catch (IOException | InterruptedException e) {
            view.showErrorMessage("Failed to connect to server");
        }
    }
}

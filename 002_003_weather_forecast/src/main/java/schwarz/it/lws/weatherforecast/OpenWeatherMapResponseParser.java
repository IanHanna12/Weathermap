package schwarz.it.lws.weatherforecast;

import org.json.JSONObject;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class OpenWeatherMapResponseParser implements WeatherResponseParser {

    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String parseCity(JSONObject weatherData) {
        return weatherData.getString("name");
    }

    @Override
    public String parseCurrentWeather(JSONObject weatherData) {
        return weatherData.getJSONArray("weather").getJSONObject(0).getString("description");
    }

    @Override
    public Float parseCurrentTemperature(JSONObject weatherData) {
        return weatherData.getJSONObject("main").getFloat("temp");
    }

    @Override
    public Float parseMinTemperature(JSONObject weatherData) {
        return weatherData.getJSONObject("main").getFloat("temp_min");
    }

    @Override
    public Float parseMaxTemperature(JSONObject weatherData) {
        return weatherData.getJSONObject("main").getFloat("temp_max");
    }

    @Override
    public Integer parseHumidity(JSONObject weatherData) {
        return weatherData.getJSONObject("main").getInt("humidity");
    }

    @Override
    public String parseSunriseTime(JSONObject weatherData) {
        long sunrise = weatherData.getJSONObject("sys").getLong("sunrise");
        LocalDateTime dateTimeSunrise = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(sunrise),
                ZoneId.of("Europe/Berlin"));
        return dateTimeSunrise.format(timeFormat);
    }

    @Override
    public String parseSunsetTime(JSONObject weatherData) {
        long sunset = weatherData.getJSONObject("sys").getLong("sunset");
        LocalDateTime dateTimeSunset = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(sunset),
                ZoneId.of("Europe/Berlin"));
        return dateTimeSunset.format(timeFormat);
    }
}

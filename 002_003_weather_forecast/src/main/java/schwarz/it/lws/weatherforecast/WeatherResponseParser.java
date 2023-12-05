package schwarz.it.lws.weatherforecast;

import org.json.JSONObject;
public interface WeatherResponseParser {
    String parseCity(JSONObject weatherData);
    String parseCurrentWeather(JSONObject weatherData);

    Float parseCurrentTemperature(JSONObject weatherData) ;
    Float parseMinTemperature(JSONObject weatherData) ;
    Float parseMaxTemperature(JSONObject weatherData) ;

    Integer parseHumidity(JSONObject weatherData) ;
    String parseSunriseTime(JSONObject weatherData) ;
    String parseSunsetTime(JSONObject weatherData) ;
}

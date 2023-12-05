package schwarz.it.lws.weatherforecast;

import org.json.JSONObject;

public class WeatherForecastView {

    private WeatherResponseParser weatherForecastParse;

    public WeatherForecastView(WeatherResponseParser weatherForecastParse) {
        this.weatherForecastParse = weatherForecastParse;
    }

    public void show(JSONObject weather) {
        String city = weatherForecastParse.parseCity(weather);
        String currentWeather = weatherForecastParse.parseCurrentWeather(weather);
        Float currentTemperature = weatherForecastParse.parseCurrentTemperature(weather);
        Float minTemperature = weatherForecastParse.parseMinTemperature(weather);
        Float maxTemperature = weatherForecastParse.parseMaxTemperature(weather);
        int humidity = weatherForecastParse.parseHumidity(weather);
        String sunrise = weatherForecastParse.parseSunriseTime(weather);
        String sunset = weatherForecastParse.parseSunsetTime(weather);

        System.out.println("- - - - - - - - - - - -  - - - - - - - - - - - - - - - - ");
        System.out.printf("Das Wetter in %s\n", city);
        System.out.printf("\t%s bei %3.1f °C\n", currentWeather, currentTemperature);
        System.out.printf("\tmin Temperatur %3.1f °C\n", minTemperature);
        System.out.printf("\tmax Temperatur %3.1f °C\n", maxTemperature);
        System.out.printf("\tLuftfeuchtigkeit %d %%\n", humidity);
        System.out.printf("\tSonnenaufgang %s Uhr\n", sunrise);
        System.out.printf("\tSonnenuntergang %s Uhr\n", sunset);
        System.out.println();
        System.out.println();
    }

    public void showErrorMessage(String city) {
        System.out.println("Failed to get weather data");
    }
}

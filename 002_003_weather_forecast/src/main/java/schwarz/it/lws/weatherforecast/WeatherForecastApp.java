package schwarz.it.lws.weatherforecast;

public class WeatherForecastApp {

    public static void main(String[] args) {
        WeatherResponseParser weatherResponseParser = new OpenWeatherMapResponseParser();

        WeatherForecastView weatherForecastView = new WeatherForecastView(weatherResponseParser);

        WeatherForecastClient weatherForecastClient = new OpenWeatherMapWeatherForecastClient(weatherForecastView);

        WeatherForecastConsole weatherForecastConsole = new WeatherForecastConsole(weatherForecastClient);

        weatherForecastConsole.run();
    }
}


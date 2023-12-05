package schwarz.it.lws.weatherforecast.View;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DisplayWeather {
    public static void displayweather(String city, String currentWeather, double currentTemperature, double minTemperature, double maxTemperature, int humidity, LocalDateTime dateTimeSunrise, LocalDateTime dateTimeSunset) {
        DisplayWeather.displayweather(city, currentWeather, currentTemperature, minTemperature, maxTemperature, humidity, dateTimeSunrise, dateTimeSunset);
        System.out.println("Weather:");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("- - - - - - - - - - - -  - - - - - - - - - - - - - - - - ");
        System.out.printf("Das Wetter in %s\n", city);
        System.out.printf("\t%s bei %3.1f °C\n", currentWeather, currentTemperature);
        System.out.printf("\tmin Temperatur %3.1f °C\n", minTemperature);
        System.out.printf("\tmax Temperatur %3.1f °C\n", maxTemperature);
        System.out.printf("\tLuftfeuchtigkeit %d %%\n", humidity);
        System.out.printf("\tSonnenaufgang %s Uhr\n", dateTimeSunrise.format(timeFormat));
        System.out.printf("\tSonnenuntergang %s Uhr\n", dateTimeSunset.format(timeFormat));
        System.out.println("- - - - - - - - - - - -  - - - - - - - - - - - - - - - - ");
    }

    public static void displayweather() {

    }
}
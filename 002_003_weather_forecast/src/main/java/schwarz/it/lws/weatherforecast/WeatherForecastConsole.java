package schwarz.it.lws.weatherforecast;

public class WeatherForecastConsole {
    private static final boolean FOREVER = true;
    WeatherForecastClient weatherForecastClient;
    private final java.util.Scanner scanner = new java.util.Scanner(System.in);

    // constructor injection
    public WeatherForecastConsole(WeatherForecastClient weatherForecastClient) {
        this.weatherForecastClient = weatherForecastClient;
    }

    public void run() {
        while (FOREVER) {
            System.out.println("- - - - Weather Forecast - - - - - - - - - - - - - - - - ");
            System.out.print("Gewünschten Ort eingeben (x-beenden):");
            String city = scanner.nextLine();

            if (city.equals("exit") || city.equals("x")) {
                System.out.println("Bye Bye ...");
                break;
            }
            weatherForecastClient.getWeatherData(city);
        }
    }
}

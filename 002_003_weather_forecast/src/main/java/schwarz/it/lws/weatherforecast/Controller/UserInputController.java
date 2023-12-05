package schwarz.it.lws.weatherforecast.Controller;

import java.util.Scanner;

public class UserInputController {
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            String city = scanner.nextLine();
            return city;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}

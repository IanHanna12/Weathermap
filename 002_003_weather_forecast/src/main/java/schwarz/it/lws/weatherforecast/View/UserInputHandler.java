package schwarz.it.lws.weatherforecast.View;

import java.util.Scanner;

public class UserInputHandler {
    public void handleUserInput() {
        while (true) {
            System.out.println("- - - - Weather Forecast - - - - - - - - - - - - - - - - ");
            System.out.print("Gewünschten Ort eingeben (x-beenden):");
            Scanner scanner = new Scanner(System.in);
            String city = scanner.nextLine();

            if (city.equals("exit") || city.equals("x")) {
                System.out.println("Bye Bye ...");
                break;
            }

        }

    }

}

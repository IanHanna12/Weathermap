package schwarz.it.lws.weatherforecast.View;

import schwarz.it.lws.weatherforecast.Controller.HttpController;

import java.util.Scanner;

public class UserInputDisplay {
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

            if (city != "exit" && city != "x") {
                HttpController httpController = new HttpController();
                httpController.getWeather();
            }else{
                    System.out.println("Error: " + city + " ist kein gültiger Ort!");
                }

            }

        }

    }



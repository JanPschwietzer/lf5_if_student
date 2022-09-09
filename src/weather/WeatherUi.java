package weather;


import java.util.Scanner;

public class WeatherUi {

    public static void main(String[] args) {

        Weather wt = new Weather();
        Scanner scanner = new Scanner(System.in);
        double input = 0.0;

        System.out.print("Geben Sie die Temperatur ein: ");
        try {
            input = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Geben Sie eine Zahl ein!");
            return;
        }

        wt.setWeather(input);

        System.out.println(wt.evaluateWeather());
    }


}

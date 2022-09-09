package deathValley;

import java.util.Scanner;

public class TankUi {

    public static void main(String[] args) {

        Tank tank = new Tank();
        Scanner scan = new Scanner(System.in);
        int[] num = {0,0,0};

        for (int i = 0; i < num.length; i++) {
            System.out.print("Geben Sie eine Zahl ein: ");
            try {
                num[i] = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Fehler.");
                break;
            }
        }


        if (tank.enoughGas(num[0],num[1],num[2])) {
            System.out.println("Weiterfahren...");
        } else {
            System.out.println("Tanken!");
        }
    }
}

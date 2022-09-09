package discount2;

import java.util.Scanner;

public class DiscountUi {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Discount disc = new Discount();

        int preis = 0;

        System.out.print("Wie lautet der Preis? ");
        try {
            preis = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Keine Zahl!");
        }

        System.out.println(disc.calcPorto(preis));
    }

}

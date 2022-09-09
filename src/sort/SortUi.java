package sort;

import java.util.Scanner;

public class SortUi {

    public static void main(String[] args) {

        Sort sort = new Sort();
        Scanner scan = new Scanner(System.in);
        double[] num = {0.0,0.0,0.0};

        for (int i = 0; i < num.length; i++) {
            System.out.print("Geben Sie eine Zahl ein: ");
            try {
                num[i] = Double.parseDouble(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Fehler.");
                break;
            }
        }


        sort.sort(num[0],num[1],num[2]);
    }
}

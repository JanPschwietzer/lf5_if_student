package dateValidation;

public class DateValidator {

    public boolean validateDate(int day, int month, int year) {

        int[] monateMit31Tagen = {1, 3, 5, 7, 8,10,12};
        int[] monateMit30Tagen = {4, 6, 7, 9,11, 2, 2};

        boolean schaltjahr = year % 4 == 0 && year % 100 != 0;


        //Schaltjahr Sonderfall
        if (year % 4 == 0 && year % 400 == 0 && year % 100 == 0) {
            schaltjahr = true;
        }
        //Tag-Monat ungültig Sonderfall
        if (day == 0 || month == 0) {
            return false;
        }
        //Februar Sonderfall
        if (month == 2) {
            if (schaltjahr) {
                return day <= 29;
            }
            return day <= 28;
        }


        // Tag check
        for (int j : monateMit31Tagen) {
            if (j == month && day <= 31) {
                return true;
            }
        }
        for (int k: monateMit30Tagen) {
            if (k == month && day <= 30) {
                return true;
            }
        }

        return false;
    }
}
